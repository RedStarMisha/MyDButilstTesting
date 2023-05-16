package org.example;

import org.example.dao.ASigDAOimpl;
import org.example.dao.PrimitiveDAO;

import java.util.Properties;

public class DBManager {
    private static PrimitiveDAO primitiveDao;
    private static ASigDAOimpl aSigDao;

    /**
     * Инициализация всех DAO из Properties файла
     * @param properties Properties файл с параметрами для подключения к БД
     */
    public static void initFromProperties(Properties properties) {
        String connection = (String) properties.remove("portaldb.Connection");
        String ip = (String) properties.remove("portaldb.IP");
        String dbName = (String) properties.remove("portaldb.Name");
        primitiveDao = new PrimitiveDAO(properties, connection + "://" + ip + "/" + dbName);
        aSigDao = new ASigDAOimpl(properties, connection + "://" + ip + "/" + dbName);
    }

    /**
     * Инициадизация всех DAO по url
     * @param url для подключения к БД
     */
    public static void initLocalDB(String url) {
        primitiveDao = new PrimitiveDAO(url);
        aSigDao = new ASigDAOimpl(url);
    }


    /**
     * Вернуть DAO предназначенного для получения данных из БД представленных классом Object
     * @return
     */
    public static PrimitiveDAO getPrimitiveDao() {
        return primitiveDao;
    }

    /**
     * Вернуть DAO предназначенного для получения данных из БД представленных классом AnaSig
     * @return
     */
    public static ASigDAOimpl getaSigDao() {
        return aSigDao;
    }

}
