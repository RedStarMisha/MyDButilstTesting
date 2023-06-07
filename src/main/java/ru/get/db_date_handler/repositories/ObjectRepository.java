package ru.get.db_date_handler.repositories;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.get.db_date_handler.DBConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Репозиторий для работы с ячейками БД
 */
public class ObjectRepository extends RepositoryBase<Object> {
    public ObjectRepository(DBConnection connection) {
        super(connection,
                new ScalarHandler<>(),
                new MapHandler(),
                new ColumnListHandler<>(),
                new MapListHandler());
    }

    @Override
    public List<Map<String, Object>> executeMapList(String sql) {
        return super.executeMapList(sql);
    }
}
