package org.example.handlers;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;

import java.util.HashMap;
import java.util.Map;

public class AnaSigRowProcessor extends BasicRowProcessor {

    public AnaSigRowProcessor() {
        super(new BeanProcessor(setColumnsToFieldsPair()));
    }

    /**
     * Метод для задания соответствия имени колонки БД именю поля класса
     * @return
     */
    private static Map<String, String> setColumnsToFieldsPair() {
        Map<String, String> pair = new HashMap<>();
        pair.put("PVID", "PVID");
        pair.put("DESC", "PVDescription");
        pair.put( "unit", "DimString");
        pair.put( "rnd_digits", "RoundDigits");
        pair.put( "min", "RangeLow");
        pair.put("max", "RangeHigh");
        pair.put( "BOUND_LOW1", "BoundsLow1");
        pair.put("BOUND_LOW2", "BoundsLow2");
        pair.put("BOUND_LOW3", "BoundsLow3");
        pair.put( "BOUND_HIGH1", "BoundsHigh1");
        pair.put( "BOUND_HIGH2", "BOUND_HIGH2");
        pair.put("BOUND_HIGH3", "BOUND_HIGH3");
        pair.put("parent_sys", "PARENTSTATIONID");
        pair.put("sys", "STATIONID");
        pair.put("deadband", "DeadBand");
        pair.put("pvnr", "PVNr");
        pair.put("PVCATEGORIES", "PVCategories");
        pair.put("PLC_ITEMID", "PLC_ITEMID");
        //pair.put("sigsys", "StationId");
        pair.put("categorytext", "CATEGORYTEXT");
        pair.put("CategoryNr", "CategoryNr");
        return pair;
    }
}