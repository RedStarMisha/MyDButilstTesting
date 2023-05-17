package org.example;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private Properties dbProperties;
    private String url;
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
            connection = dbProperties == null ? DriverManager.getConnection(url) : DriverManager.getConnection(url, dbProperties);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            DbUtils.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
