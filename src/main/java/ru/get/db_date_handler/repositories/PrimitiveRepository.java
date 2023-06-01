package ru.get.db_date_handler.repositories;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.get.db_date_handler.DBConnection;


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
    private Object getValByColumn(String sql, String columnName) {
        return executeMap(sql).get(columnName);
    }

    public int getInt(String sql, String columnName) {
        int val = 0;
        try {
            val =(int) getValByColumn(sql, columnName);
        } catch (Exception e) {
            System.err.println("Значение колонки " + columnName + " не является Int");
        }
        return val;
    }

    public String getString(String sql, String columnName) {
        String val = "";
        try {
            val = (String) getValByColumn(sql, columnName);
        } catch (Exception e) {
            System.err.println("Тип значение колонки " + columnName + " не является String");
        }
        return val;
    }
    public double getDouble(String sql, String columnName) {
        double val = 0;
        try {
            val = (double) getValByColumn(sql, columnName);
        } catch (Exception e) {
            System.err.println("Тип значение колонки " + columnName + " не является Double");
        }
        return val;
    }
}
