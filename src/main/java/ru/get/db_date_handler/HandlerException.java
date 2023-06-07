package ru.get.db_date_handler;

public class HandlerException extends Exception {
    public HandlerException(String message) {
        super("Ошибка с обработчиком результатов " + message);
    }
}
