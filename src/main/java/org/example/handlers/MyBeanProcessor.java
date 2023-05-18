package org.example.handlers;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.PropertyHandler;
import org.example.annotation.Default;
import org.example.annotation.DefaultType;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * BeanProcessor позволяющий сохранять default значения полей
 */
public class MyBeanProcessor extends BeanProcessor {
    private static final Map<Class<?>, Object> primitiveDefaults = new HashMap();
    private static final ServiceLoader<PropertyHandler> propertyHandlers = ServiceLoader.load(PropertyHandler.class);

    public MyBeanProcessor(Map<String, String> columnToPropertyOverrides) {
        super(columnToPropertyOverrides);
    }

    @Override
    public <T> T populateBean(ResultSet rs, T bean) throws SQLException {
        PropertyDescriptor[] props = this.propertyDescriptors(bean.getClass());
        ResultSetMetaData rsmd = rs.getMetaData();
        int[] columnToProperty = this.mapColumnsToProperties(rsmd, props);
        return this.populateBean(rs, bean, props, columnToProperty);
    }
    @Override
    public <T> List<T> toBeanList(ResultSet rs, Class<? extends T> type) throws SQLException {
        List<T> results = new ArrayList();
        if (!rs.next()) {
            return results;
        } else {
            PropertyDescriptor[] props = this.propertyDescriptors(type);
            ResultSetMetaData rsmd = rs.getMetaData();
            int[] columnToProperty = this.mapColumnsToProperties(rsmd, props);

            do {
                results.add(this.createBean(rs, type, props, columnToProperty));
            } while(rs.next());

            return results;
        }
    }

    protected  <T> T createBean(ResultSet rs, Class<T> type, PropertyDescriptor[] props, int[] columnToProperty) throws SQLException {
        T bean = this.newInstance(type);
        return this.populateBean(rs, bean, props, columnToProperty);
    }

    private PropertyDescriptor[] propertyDescriptors(Class<?> c) throws SQLException {
        BeanInfo beanInfo = null;

        try {
            beanInfo = Introspector.getBeanInfo(c);
        } catch (IntrospectionException var4) {
            throw new SQLException("Bean introspection failed: " + var4.getMessage());
        }

        return beanInfo.getPropertyDescriptors();
    }

    protected  <T> T populateBean(ResultSet rs, T bean, PropertyDescriptor[] props, int[] columnToProperty) throws SQLException {
        for(int i = 1; i < columnToProperty.length; ++i) {
            if (columnToProperty[i] != -1) {
                PropertyDescriptor prop = props[columnToProperty[i]];
                Class<?> propType = prop.getPropertyType();
                Object value = null;
                if (propType != null) {
                    value = this.processColumn(rs, i, propType);
                    if (value == null && propType.isPrimitive()) {
                        value = primitiveDefaults.get(propType);
                    }
                }

                this.callSetter(bean, prop, value);
            }
        }
        return bean;
    }

    private void callSetter(Object target, PropertyDescriptor prop, Object value) throws SQLException {
        Method setter = this.getWriteMethod(target, prop, value);
        DefaultType type = checkForAnnotation(target, prop.getName());
        if (setter != null && setter.getParameterTypes().length == 1 && checkDefaultCondition(type, value)) {
            try {
                Class<?> firstParam = setter.getParameterTypes()[0];
                Iterator var6 = propertyHandlers.iterator();

                while(var6.hasNext()) {
                    PropertyHandler handler = (PropertyHandler)var6.next();
                    if (handler.match(firstParam, value)) {
                        value = handler.apply(firstParam, value);
                        break;
                    }
                }

                if (this.isCompatibleType(value, firstParam)) {
                    setter.invoke(target, value);
                } else {
                    throw new SQLException("Cannot set " + prop.getName() + ": incompatible types, cannot convert " + value.getClass().getName() + " to " + firstParam.getName());
                }
            } catch (IllegalArgumentException var8) {
                throw new SQLException("Cannot set " + prop.getName() + ": " + var8.getMessage());
            } catch (IllegalAccessException var9) {
                throw new SQLException("Cannot set " + prop.getName() + ": " + var9.getMessage());
            } catch (InvocationTargetException var10) {
                throw new SQLException("Cannot set " + prop.getName() + ": " + var10.getMessage());
            }
        }
    }

    private boolean isCompatibleType(Object value, Class<?> type) {
        return value == null || type.isInstance(value) || this.matchesPrimitive(type, value.getClass());
    }

    private boolean matchesPrimitive(Class<?> targetType, Class<?> valueType) {
        if (!targetType.isPrimitive()) {
            return false;
        } else {
            try {
                Field typeField = valueType.getField("TYPE");
                Object primitiveValueType = typeField.get(valueType);
                if (targetType == primitiveValueType) {
                    return true;
                }
            } catch (NoSuchFieldException var5) {
            } catch (IllegalAccessException var6) {
            }

            return false;
        }
    }

    private DefaultType checkForAnnotation(Object target, String filedName) {
        try {
            Field field = target.getClass().getDeclaredField(filedName);
            boolean isAnnotated = field.isAnnotationPresent(Default.class);
            if (isAnnotated) {
                return field.getAnnotation(Default.class).key();
            }
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private boolean checkDefaultCondition(DefaultType type, Object value) {
        return type == null || (type == DefaultType.IFNULL && value != null);
    }

    static {
        primitiveDefaults.put(Integer.TYPE, 0);
        primitiveDefaults.put(Short.TYPE, Short.valueOf((short)0));
        primitiveDefaults.put(Byte.TYPE, (byte)0);
        primitiveDefaults.put(Float.TYPE, 0.0F);
        primitiveDefaults.put(Double.TYPE, 0.0);
        primitiveDefaults.put(Long.TYPE, 0L);
        primitiveDefaults.put(Boolean.TYPE, Boolean.FALSE);
        primitiveDefaults.put(Character.TYPE, '\u0000');
    }
}
