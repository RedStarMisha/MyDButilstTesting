package ru.get.db_date_handler.repositories;

import java.util.List;
import java.util.Map;

public interface Repository<T> {
    /**
     * Получить единичный объект
     * @param sql
     * @return
     */
    T execute(String sql);

    /**
     * Получить Map<String, T> обектов. В случае если T - сущность, то результаты будут представлены в виде пар: id в БД - сущность.
     * В другом случае будет получена строка из БД в виде пар: название колонки - значение колонки. Если результатом запроса
     * к БД будет более чем одна строка, то вернется Map<String, T> из первой, где key - имя колонки
     * @param sql запрос в БД
     * @return Map<String, T> для сущностей в формате id - entity, в остальных случаях в формате columnName - value
     */
    Map<String, T> executeMap(String sql);

    /**
     * Получить список объектов
     * @param sql
     * @return
     */
    List<T> executeList(String sql);
}
