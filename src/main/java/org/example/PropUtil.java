package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropUtil {
    private static Properties properties = new Properties();

    public static Properties load(String name) {
        try {
            properties.loadFromXML(new FileInputStream(name));
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties addProp(String key, String value) {
        properties.setProperty(key, value);
        return properties;
    }

    public static Properties getDBProperties() {
        Properties properties1 = new Properties();
        try {
            addToBDProperties("portaldb.IP", properties1);
            addToBDProperties("portaldb.Name", properties1);
            addToBDProperties("portaldb.User", properties1, "user");
            addToBDProperties("portaldb.Password", properties1, "password");
            addToBDProperties("portaldb.Connection", properties1);
//            addToBDProperties("portaldb.Driver", properties1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        properties1.setProperty("characterEncoding", "UTF-8");
        return properties1;
    }

    private static void addToBDProperties(String key, Properties properties1) throws Exception {
        properties1.setProperty(key, Optional.ofNullable(properties.getProperty(key)).orElseThrow(Exception::new));
    }
    private static void addToBDProperties(String key, Properties properties1, String newName) throws Exception {
        properties1.setProperty(newName, Optional.ofNullable(properties.getProperty(key)).orElseThrow(Exception::new));
    }
}
