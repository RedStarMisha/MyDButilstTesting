package ru.get;

import ru.get.db_date_handler.DBManager;
import ru.get.db_date_handler.PropUtil;
import ru.get.db_date_handler.columbtofiled.ColumnToFieldFactory;
import ru.get.db_date_handler.entity.BinSig;
import ru.get.db_date_handler.repositories.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        doWithVoronejDB();
//        doWithLocalDB();
    }

    /**
     *  Демонстрация подключения к БД на 10.222.60.10
     */
    private static void doWithVoronejDB() {
        PropUtil.load("src/main/java/JPortal_ekp.config");
        PropUtil.addProp("characterEncoding", "UTF-8");
        DBManager.initDB(PropUtil.getDBProperties());
        DBManager.matchColumnToField(new ColumnToFieldFactory());
        getPrimitive();
        getBinSignal();
    }

    private static void getPrimitive() {
        String UserID = "ADMINISTRATOR";

//        String sql = "SELECT g.GROUPID, g.CATEGORYMAP FROM pls_usergroups g JOIN pls_users u ON g.GROUPNR=u.GROUPNR WHERE u.USERID='" + UserID + "'";
        String sql = "SELECT g.GROUPID, g.CATEGORYMAP FROM pls_usergroups g JOIN pls_users u ON g.GROUPNR=u.GROUPNR WHERE u.GROUPID <> 'ADMINISTRATORS'";

        String GroupID = (String) DBManager.getRepository().getValByColumn (sql, "GROUPID");
        int CategoryMap =(Integer) DBManager.getRepository().getValByColumn (sql,"CATEGORYMAP");
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
        Repository<BinSig> rep = DBManager.getRepository(BinSig.class);
        Map<String, BinSig> binSigMap = rep.executeMap(sql);
        int i=0;
        for (Map.Entry<String, BinSig> entry : binSigMap.entrySet()) {
            System.out.println("key - " + entry.getKey());
            i++;
            if (i == 20) {
                break;
            }
        }
        i=0;
        List<BinSig> binSigList = rep.executeList(sql);
        for (BinSig sig : binSigList) {
            System.out.println(sig);
            i++;
            if (i == 20) {
                break;
            }
        }
    }

    /**
     * Демонстрация работы с локальной БД
     */
    private static void doWithLocalDB() {
//        String db = "jdbc:h2:mem:;INIT=runscript from 'src/main/java/schema.sql'";
//        DBManager.initDB(db);
//        String sql3 = "SELECT PVID AS PVId, PVDESCRIPTION AS desc, DIMSTRING as unit" +
//                " FROM db";
//        Map<String, AnaSig> map = DBManager.getaSigRepository().executeMap(sql3);
//        System.out.println(map);
//        List<AnaSig> list = DBManager.getaSigRepository().executeList(sql3);
//        System.out.println(list);
    }
}