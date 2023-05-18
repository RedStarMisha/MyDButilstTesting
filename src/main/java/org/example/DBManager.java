package org.example;

import org.example.repositories.ASigRepository;
import org.example.repositories.PrimitiveRepository;

import java.util.Properties;

public class DBManager {
    private static PrimitiveRepository primitiveDao;
    private static ASigRepository aSigDao;

    /**
     * Инициализация всех Repository из Properties файла
     * @param properties Properties файл с параметрами для подключения к БД
     */
    public static void initDB(Properties properties) {
        String connection = (String) properties.remove("portaldb.Connection");
        String ip = (String) properties.remove("portaldb.IP");
        String dbName = (String) properties.remove("portaldb.Name");
        primitiveDao = new PrimitiveRepository(connection + "://" + ip + "/" + dbName, properties);
        aSigDao = new ASigRepository(connection + "://" + ip + "/" + dbName, properties);
    }

    /**
     * Инициадизация всех Repository по url
     * @param url для подключения к БД
     */
    public static void initDB(String url) {
        primitiveDao = new PrimitiveRepository(url);
        aSigDao = new ASigRepository(url);
    }

    /**
     * Инициадизация всех Repository по url и Properties файлу
     * @param url для кодключения к БД
     * @param properties
     */
    public static void initDB(String url, Properties properties) {
        primitiveDao = new PrimitiveRepository(url, properties);
        aSigDao = new ASigRepository(url, properties);
    }


    /**
     * Вернуть Repository предназначенного для получения данных из БД представленных классом Object
     * @return
     */
    public static PrimitiveRepository getPrimitiveDao() {
        return primitiveDao;
    }

    /**
     * Вернуть Repository предназначенного для получения данных из БД представленных классом AnaSig
     * @return
     */
    public static ASigRepository getaSigDao() {
        return aSigDao;
    }

}
