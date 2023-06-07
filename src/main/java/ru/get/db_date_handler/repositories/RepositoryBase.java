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

    /**
     * Получить единичный объект
     * @param sql
     * @return
     */
    public T execute(String sql) throws SQLException {
        return execute(sql, beanHandler);
    }

    /**
     * Получить Map<String, T> обектов. В случае если T - сущность, то результаты будут представлены в виде пар: id в БД - сущность.
     * В другом случае будет получена строка из БД в виде пар: название колонки - значение колонки. Если результатом запроса
     * к БД будет более чем одна строка, то вернется Map<String, T> из первой, где key - имя колонки
     * @param sql запрос в БД
     * @return Map<String, T> для сущностей в формате id - entity, в остальных случаях в формате columnName - value
     */
    public Map<String, T> executeMap(String sql) throws SQLException {
        return execute(sql, mapHandler);
    }

    /**
     * Получить список объектов
     * @param sql
     * @return
     */
    public List<T> executeList(String sql) throws SQLException {
        return execute(sql, listHandler);
    }

    protected List<Map<String, T>> executeMapList(String sql) {
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

    /**
     * Выполнить sql запрос к КБ и оставить соединение открытым
     * @param sql запрос к БД
     * @param handler обработчик результатов запроса
     * @return
     * @param <T>
     */
    protected  <T> T execute(String sql, ResultSetHandler<T> handler) throws SQLException {
        return runner.query(dbConnection.getConnection(), sql, handler);
    }

    /**
     * Выполнить sql запрос к КБ и после этого закрыть соединение
     * @param sql запрос к БД
     * @param handler обработчик результатов запроса
     * @return
     * @param <T>
     */
    protected  <T> T executeClosable(String sql, ResultSetHandler<T> handler) throws SQLException {
        T result = execute(sql, handler);
        dbConnection.closeConnection();
        return result;
    }
}
