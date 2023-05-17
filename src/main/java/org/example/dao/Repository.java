package org.example.dao;

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
     * В другом случае будет получена строка из БД в виде пар: название колонки - значение колонки
     * @param sql
     * @return
     */
    Map<String, T> executeMap(String sql);

    /**
     * Получить список объектов
     * @param sql
     * @return
     */
    List<T> executeList(String sql);
}
