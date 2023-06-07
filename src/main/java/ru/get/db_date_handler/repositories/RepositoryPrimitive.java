package ru.get.db_date_handler.repositories;

import ru.get.db_date_handler.DBConnection;

import java.sql.SQLException;
import java.util.List;

public class RepositoryPrimitive {
    private ObjectRepository repository;

    public RepositoryPrimitive(DBConnection connection) {
        this.repository = new ObjectRepository(connection);
    }

    public List<Line> executeList(String sql) throws SQLException {
        return repository.executeMapList(sql).stream().map(Line::new).toList();
    }
    public Line executeLine(String sql) throws SQLException {
        return new Line(repository.executeMap(sql));
    }

    public String executeString(String sql) throws SQLException {
        return (String) repository.execute(sql);
    }
    public int executeInt(String sql) throws SQLException {
        return (int) repository.execute(sql);
    }
    public double executeDouble(String sql) throws SQLException {
        return (double) repository.execute(sql);
    }
}
