package ru.get.db_date_handler.repositories;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import ru.get.db_date_handler.DBConnection;
import ru.get.db_date_handler.handlers.MyBeanProcessor;

import java.util.Map;

public class EntityRepository<T> extends RepositoryBase<T> {

    public EntityRepository(DBConnection connection, Class<T> clazz, Map<String, String> columnToFiled) {
        super(connection);
        RowProcessor rowProcessor = new BasicRowProcessor(new MyBeanProcessor(columnToFiled));
        beanHandler = new BeanHandler<>(clazz, rowProcessor);
        mapHandler = new BeanMapHandler<>(clazz, rowProcessor);
        listHandler = new BeanListHandler<>(clazz, rowProcessor);
    }

}