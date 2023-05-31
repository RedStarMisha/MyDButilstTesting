package ru.get.db_date_handler.columbtofiled;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика для получения Map<String, String> которая содержит соответствие названия колонки в таблице
 * БД(key) названию поля класса Entity(value)
 */
public abstract class ColumnToField {
    protected static final Map<Class, Map<String, String>> matcher = new HashMap<>();

    /**
     * Метод возвращающий Map<String, String> которая содержит информацию о соответствии
     * названия колонки в таблице БД(key) названию поля класса Entity(value)
     * @param clazz класс Entity
     * @return Map<String, String> если существует для запрашиваемого класса или null
     */
    public static Map<String, String> getMatching(Class clazz) {
        return matcher.get(clazz);
    }
}
