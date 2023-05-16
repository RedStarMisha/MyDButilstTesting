package org.example.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.example.DBConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class DAOabstr<T> implements DAO<T> {
    private QueryRunner runner = new QueryRunner();
    private final DBConnection dbConnection;
    private final ResultSetHandler<T> beanHandler;
    private final ResultSetHandler<Map<String, T>> mapHandler;
    private final ResultSetHandler<List<T>> listHandler;

    public DAOabstr(Properties dbProperties, String url, ResultSetHandler<T> beanHandler,
                    ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        dbConnection = new DBConnection(dbProperties, url);
    }

    public DAOabstr(String url, ResultSetHandler<T> beanHandler,
                    ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        dbConnection = new DBConnection(url);
    }

    @Override
    public T execute(String sql) {
        try {
            return runner.query(dbConnection.openConnection(), sql, beanHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection();
        }
    }

    @Override
    public Map<String, T> executeMap(String sql) {
        try {
            return runner.query(dbConnection.openConnection(), sql, mapHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection();
        }
    }

    @Override
    public List<T> executeList(String sql) {
        try {
            return runner.query(dbConnection.openConnection(), sql, listHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection();
        }
    }
}
