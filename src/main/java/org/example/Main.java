package org.example;

import org.example.entity.AnaSig;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {



        doWithVoronejDB();
        doWithLocalDB();
    }

    /**
     *  Демонстрация подключения к БД на 10.222.60.10
     */
    private static void doWithVoronejDB() {
        PropUtil.load("src/main/java/JPortal_ekp.config");
        PropUtil.addProp("characterEncoding", "UTF-8");
        DBManager.initFromProperties(PropUtil.getDBProperties());
        String UserID = "ADMINISTRATOR";

        String sql = "SELECT g.GROUPID, g.CATEGORYMAP FROM pls_usergroups g JOIN pls_users u ON g.GROUPNR=u.GROUPNR WHERE u.USERID='" + UserID + "'";

        String GroupID = (String) DBManager.getPrimitiveDao().getValByColumn (sql, "GROUPID");
        int CategoryMap =(Integer) DBManager.getPrimitiveDao().getValByColumn (sql,"CATEGORYMAP");

        System.out.println(GroupID + " " + CategoryMap);
    }

    /**
     * Демонстрация работы с локальной БД
     */
    private static void doWithLocalDB() {
        String db = "jdbc:h2:mem:;INIT=runscript from 'src/main/java/schema.sql'";
        DBManager.initLocalDB(db);
        String sql3 = "SELECT PVID AS PVId, PVDESCRIPTION AS desc, DIMSTRING as unit" +
                " FROM db";
        List<AnaSig> list = DBManager.getaSigDao().executeList(sql3);
        Map<String, AnaSig> map = DBManager.getaSigDao().executeMap(sql3);
        System.out.println(map);
        System.out.println(list);
    }
}