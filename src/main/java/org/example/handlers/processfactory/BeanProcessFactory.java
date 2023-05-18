package org.example.handlers.processfactory;

import org.apache.commons.dbutils.BeanProcessor;
import org.example.handlers.MyBeanProcessor;

import java.util.Map;

public class BeanProcessFactory {
    public static BeanProcessor makeProcessor(BeanProccessType type, Map<String, String> pair) {
        switch (type){
            case STANDART -> new BeanProcessor(pair);
            case SAVE_DEFAULT -> new MyBeanProcessor(pair);
        }
        return null;
    }
}
