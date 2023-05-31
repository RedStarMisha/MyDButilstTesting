package ru.get.db_date_handler.repositories;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.get.db_date_handler.DBConnection;

import java.util.List;
import java.util.Map;

/**
 * Репозиторий для работы с ячейками БД
 */
public class PrimitiveRepository extends RepositoryBase<Object> {
    public PrimitiveRepository(DBConnection connection) {
        super(connection,
                new ScalarHandler<>(),
                new MapHandler(),
                new ColumnListHandler<>(),
                new MapListHandler());
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
