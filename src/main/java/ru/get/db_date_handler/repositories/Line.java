package ru.get.db_date_handler.repositories;

import com.sun.jdi.InvalidTypeException;

import java.util.Map;
import java.util.Optional;

public class Line {
    private Map<String, Object> line;
    public Line(Map<String, Object> line) {
        this.line = line;
    }

    public String getString(String name) {
        Object res = line.get(name);
        if (res instanceof String d) {
            return d;
        }
        try {
            throw new InvalidTypeException("String");
        } catch (InvalidTypeException e) {
            System.err.println("ERROR: Переменная имеет отличный тип данных от " + e.getMessage());
        }
        return null;
    }
    public int getInt(String name) {
        Object res = line.get(name);
        if (res instanceof Integer d) {
            return d;
        }
        try {
            throw new InvalidTypeException("Integer");
        } catch (InvalidTypeException e) {
            System.err.println("ERROR: Переменная имеет отличный тип данных от " + e.getMessage());
        }
        return 0;
    }
    public double getDouble(String name) {
        Object res = line.get(name);
        if (res instanceof Double d) {
            return d;
        }
        try {
            throw new InvalidTypeException("Double");
        } catch (InvalidTypeException e) {
            System.err.println("ERROR: Переменная имеет отличный тип данных от " + e.getMessage());
        }
        return 0;
    }

}
