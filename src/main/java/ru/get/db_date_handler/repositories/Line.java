package ru.get.db_date_handler.repositories;

import java.util.Map;
import java.util.Optional;

public class Line {
    private Map<String, Object> line;
    public Line(Map<String, Object> line) {
        this.line = line;
    }

    public String getString(String name) {
        Object res = line.get(name);
        return res != null ? (String) res : null;
    }
    public int getInt(String name) {
        Object res = line.get(name);
        return res != null ? (int) res : null;
    }
    public double getDouble(String name) {
        Object res = line.get(name);
        return res != null ? (double) res : null;
    }

}
