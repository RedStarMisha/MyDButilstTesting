package org.example.repositories;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.example.DBConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class RepositoryBase<T> implements Repository<T> {
    private QueryRunner runner = new QueryRunner();
    private final DBConnection dbConnection;
    private final ResultSetHandler<T> beanHandler;
    private final ResultSetHandler<Map<String, T>> mapHandler;
    private final ResultSetHandler<List<T>> listHandler;

    public RepositoryBase(String url, Properties dbProperties, ResultSetHandler<T> beanHandler,
                          ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        dbConnection = new DBConnection(url, dbProperties);
    }

    public RepositoryBase(String url, ResultSetHandler<T> beanHandler,
                          ResultSetHandler<Map<String, T>> mapHandler, ResultSetHandler<List<T>> listHandler) {
        this.beanHandler = beanHandler;
        this.mapHandler = mapHandler;
        this.listHandler = listHandler;
        dbConnection = new DBConnection(url);
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

    private <T> T execute(String sql, ResultSetHandler<T> handler) {
        try {
            return runner.query(dbConnection.openConnection(), sql, handler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
