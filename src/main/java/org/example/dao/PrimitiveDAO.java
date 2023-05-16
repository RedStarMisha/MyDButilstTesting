package org.example.dao;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.Properties;

public class PrimitiveDAO extends DAOabstr<Object> {
    public PrimitiveDAO(String url, Properties dbProperties) {
        super(dbProperties, url,
                new ScalarHandler<>(),
                new MapHandler(),
                new ColumnListHandler<>());
    }
    public PrimitiveDAO(String url) {
        super(url, new ScalarHandler<>(), new MapHandler(), new ColumnListHandler<>());
    }


    /**
     * Получить значение по имени колонки
     * @param sql sql запрос
     * @param columnName имя колонки по которой будет извлекаться значение строки
     * @return значение искомой ячейки
     */
    public Object getValByColumn(String sql, String columnName) {
        return executeMap(sql).get(columnName);
    }
}
