package ru.get.db_date_handler.handlers;

import org.apache.commons.dbutils.BasicRowProcessor;
import ru.get.db_date_handler.handlers.MyBeanProcessor;

import java.util.Map;

public class MyRowProcessor extends BasicRowProcessor {
    public MyRowProcessor() {
        super(new MyBeanProcessor());
    }

    public MyRowProcessor(Map<String, String> columnToField) {
        super(new MyBeanProcessor(columnToField));
    }
}
