package org.example.repositories;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.Properties;

/**
 * Репозиторий для работы с ячейками БД
 */
public class PrimitiveRepository extends RepositoryBase<Object> {
    public PrimitiveRepository(String url, Properties dbProperties) {
        super(url, dbProperties,
                new ScalarHandler<>(),
                new MapHandler(),
                new ColumnListHandler<>());
    }
    public PrimitiveRepository(String url) {
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
