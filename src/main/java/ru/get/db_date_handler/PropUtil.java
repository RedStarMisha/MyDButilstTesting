package ru.get.db_date_handler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropUtil {
    private static Properties properties = new Properties();

    /**
     * Загрузить Properties из XML файла
     * @param name
     * @return
     */
    public static Properties load(String name) {
        try {
            properties.loadFromXML(new FileInputStream(name));
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Добавить свойство в Properties файл
     * @param key ключ
     * @param value значение
     */
    public static Properties addProp(String key, String value) {
        properties.setProperty(key, value);
        return properties;
    }

    /**
     * Получить Properties-файл для подключения к БД из общего на проект.
     * Файл содержит все необходимые данные в том числе IP, имя БД, имя юзера, пароль, соединение, кодировку
     * @return Properties файл с данными для подлкючения к БД
     */
    public static Properties getDBProperties() {
        Properties properties1 = new Properties();
        try {
            addToBDProperties("portaldb.IP", properties1);
            addToBDProperties("portaldb.Name", properties1);
            addToBDProperties("portaldb.User", properties1, "user");
            addToBDProperties("portaldb.Password", properties1, "password");
            addToBDProperties("portaldb.Connection", properties1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        properties1.setProperty("characterEncoding", "UTF-8");
        return properties1;
    }
    /**
     * Добавить свойство в Properties файл для БД с ключом как есть
     * @param key ключ в Properties фале на проект
     * @param properties1 Properties файл для подключения к БД
     * @throws Exception
     */
    private static void addToBDProperties(String key, Properties properties1) throws Exception {
        properties1.setProperty(key, Optional.ofNullable(properties.getProperty(key)).orElseThrow(Exception::new));
    }

    /**
     * Добавить свойство в Properties файл для БД с новым именем ключа из общего на проект
     * @param key ключ в Properties фале на проект
     * @param properties1 Properties файл для подключения к БД
     * @param newName новое имя для ключа в Properties файле для подключения к БД
     * @throws Exception
     */
    private static void addToBDProperties(String key, Properties properties1, String newName) throws Exception {
        properties1.setProperty(newName, Optional.ofNullable(properties.getProperty(key)).orElseThrow(Exception::new));
    }
}
