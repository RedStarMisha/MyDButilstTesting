package ru.get.db_date_handler.columbtofiled;

import java.util.HashMap;
import java.util.Map;

public abstract class ColumnToField {
    protected static final Map<Class, Map<String, String>> matcher = new HashMap<>();
    public static Map<String, String> getMatching(Class clazz) {
        return matcher.get(clazz);
    }
}
