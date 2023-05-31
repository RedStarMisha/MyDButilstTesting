package ru.get.db_date_handler.repositories;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import ru.get.db_date_handler.DBConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class RepositoryBase<T> implements Repository<T> {
    protected final QueryRunner runner = new QueryRunner();
    protected final DBConnection dbConnection;
    protected ResultSetHandler<T> beanHandler;
    protected ResultSetHandler<Map<String, T>> mapHandler;
    protected ResultSetHandler<List<Map<String, T>>> mapListHandler;
    protected ResultSetHandler<List<T>> listHandler;

    public RepositoryBase(DBConnection connection, ResultSetHandler<T> beanHandler,
                          ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        dbConnection = connection;
    }
    public RepositoryBase(DBConnection connection, ResultSetHandler<T> beanHandler,
                          ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler,
                          ResultSetHandler<List<Map<String, T>>> mapListHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        this.mapListHandler = mapListHandler;
        dbConnection = connection;
    }
    public RepositoryBase(DBConnection connection) {
        dbConnection = connection;
    }

    @Override
    public T execute(String sql) {
        return execute(sql, beanHandler);
    }

    @Override
    public Map<String, T> executeMap(String sql) {
        return execute(sql, mapHandler);
    }

    @Override
    public List<T> executeList(String sql) {
        return execute(sql, listHandler);
    }

    public List<Map<String, T>> executeMapList(String sql) {
        try {
            if (mapListHandler == null) {
                throw new Exception("mapListHandler не задан");
            }
            return execute(sql, mapListHandler);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    protected  <T> T execute(String sql, ResultSetHandler<T> handler) {
        try {
            return runner.query(dbConnection.getConnection(), sql, handler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected  <T> T executeClosable(String sql, ResultSetHandler<T> handler) {
        T result = execute(sql, handler);
        dbConnection.closeConnection();
        return result;
    }
}
