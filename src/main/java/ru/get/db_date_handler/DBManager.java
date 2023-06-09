package ru.get.db_date_handler;

import ru.get.db_date_handler.columbtofiled.ColumnToField;
import ru.get.db_date_handler.repositories.*;

import java.util.Properties;

/**
 * БД менеджер. Инициализирует соединение с БД, позвращает репозитории для получения Entity из БД
 */
public class DBManager {
    private static DBConnection connection;
    private static ColumnToField columnToField;

    /**
     * Задать класс отвечающий за связывание имени колоники в БД с именем поля entity
     * @param columnToField
     */
    public static void matchColumnToField(ColumnToField columnToField) {
        DBManager.columnToField = columnToField;
    }

    /**
     * Инициализация всех Repository из Properties файла
     * @param properties Properties файл с параметрами для подключения к БД
     */
    public static void initDB(Properties properties) {
        String conn = (String) properties.remove("portaldb.Connection");
        String ip = (String) properties.remove("portaldb.IP");
        String dbName = (String) properties.remove("portaldb.Name");
        connection = new DBConnection(conn + "://" + ip + "/" + dbName, properties);
    }

    /**
     * Инициадизация всех Repository по url
     * @param url для подключения к БД
     */
    public static void initDB(String url) {
        connection = new DBConnection(url);
    }

    /**
     * Инициадизация всех Repository по url и Properties файлу
     * @param url для кодключения к БД
     * @param properties
     */
    public static void initDB(String url, Properties properties) {
        connection = new DBConnection(url, properties);
    }

    public static void closeConnection() {
        connection.closeConnection();
    }

    /**
     * Вернуть Repository предназначенного для получения данных из БД представленных Entity
     * @param clazz класс Entity
     * @return репозиторий для получения Entity из БД
     * @param <T>
     */
    public static <T>RepositoryBase<T> getRepository(Class<T> clazz) {
        return new EntityRepository<>(connection, clazz, columnToField.getMatching(clazz));
    }
    /**
     * Вернуть Repository предназначенного для получения данных из БД представленных классом Object
     * @return
     */
    public static RepositoryPrimitive getRepository() {
        return new RepositoryPrimitive(connection);
    }
}
