package ru.get.db_date_handler;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс коннектор к БД
 */
public class DBConnection {
    private Properties dbProperties;
    private final String url;
    private Connection connection;

    public DBConnection(String url, Properties dbProperties) {
        this.dbProperties = dbProperties;
        this.url = url;
    }

    public DBConnection(String url) {
        this.url = url;
    }

    public Connection openConnection() {
        try {
            connection = dbProperties == null ? DriverManager.getConnection(url) :
                    DriverManager.getConnection(url, dbProperties);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection != null ? connection : openConnection();
    }

    public void closeConnection() {
        try {
            DbUtils.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
