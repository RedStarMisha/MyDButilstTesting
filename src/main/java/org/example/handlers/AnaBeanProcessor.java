package org.example.handlers;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.ColumnHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class AnaBeanProcessor extends BeanProcessor {
    public AnaBeanProcessor(Map<String, String> columnToPropertyOverrides) {
        super(columnToPropertyOverrides);
    }

    @Override
    protected Object processColumn(ResultSet rs, int index, Class<?> propType) throws SQLException {
        Object retval = rs.getObject(index);
        if (!propType.isPrimitive() && retval == null) {
            return null;
        } else {
            ServiceLoader<ColumnHandler> columnHandlers = ServiceLoader.load(ColumnHandler.class);
            Iterator var5 = columnHandlers.iterator();

            while(var5.hasNext()) {
                ColumnHandler handler = (ColumnHandler)var5.next();
                if (handler.match(propType)) {
                    retval = handler.apply(rs, index);
                    break;
                }
            }

            return retval;
        }
    }
}
