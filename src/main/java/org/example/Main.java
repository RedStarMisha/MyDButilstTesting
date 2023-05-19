package org.example;

import org.example.entity.AnaSig;
import org.example.entity.BinSig;

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
        DBManager.initDB(PropUtil.getDBProperties());
        getPrimitive();
        getBinSignal();
    }

    private static void getPrimitive() {
        String UserID = "ADMINISTRATOR";

        String sql = "SELECT g.GROUPID, g.CATEGORYMAP FROM pls_usergroups g JOIN pls_users u ON g.GROUPNR=u.GROUPNR WHERE u.USERID='" + UserID + "'";

        String GroupID = (String) DBManager.getPrimitiveDao().getValByColumn (sql, "GROUPID");
        int CategoryMap =(Integer) DBManager.getPrimitiveDao().getValByColumn (sql,"CATEGORYMAP");
        System.out.println(GroupID + " " + CategoryMap);
    }

    private static void getBinSignal() {
        String desc_field = "PVDESCRIPTION";

        String sql = "SELECT `PVID` AS `PVId`, `NARYCATNR` AS NaryCatNr, `BINVALUENR` AS bin_value_nr, `NUMBITS` AS num_bits, `" + desc_field + "` AS `desc`,"
                + "`pls_bin_conf`.`CATEGORYNR` AS CategoryNr, `PVCATEGORIES` AS PVCategories, `pls_bin_conf`.`PVNR` AS pvnr, "
                + "`pls_station`.`PARENTSTATIONID` AS parent_sys, `pls_station`.`STATIONID` AS sys, `pls_bin_conf`.`PLC_ITEMID` AS plc_itemid, `pls_bin_conf`.`STATIONID` AS sigsys, "
                + "`pls_bin_conf`.`CATEGORYTEXT` AS categorytext, `pls_bin_conf`.`PROCCATNR` AS proccatnr, `pls_proc_categories`.`ALARMPROCESSING` AS AlarmProcessing "
                + "FROM `pls_bin_conf` LEFT OUTER JOIN `pls_station` ON `pls_station`.`STATIONNR`=`pls_bin_conf`.`STATIONNR` "
                + "LEFT OUTER JOIN `pls_proc_categories` ON `pls_proc_categories`.`CATEGORYNR` = `pls_bin_conf`.`PROCCATNR` "
                + "ORDER BY `pls_station`.`STATIONID` LIMIT 20;";

        Map<String, BinSig> binSigMap = DBManager.getbSigRepository().executeMap(sql);
    }

    /**
     * Демонстрация работы с локальной БД
     */
    private static void doWithLocalDB() {
        String db = "jdbc:h2:mem:;INIT=runscript from 'src/main/java/schema.sql'";
        DBManager.initDB(db);
        String sql3 = "SELECT PVID AS PVId, PVDESCRIPTION AS desc, DIMSTRING as unit" +
                " FROM db";
        Map<String, AnaSig> map = DBManager.getaSigRepository().executeMap(sql3);
        System.out.println(map);
        List<AnaSig> list = DBManager.getaSigRepository().executeList(sql3);
        System.out.println(list);
    }
}