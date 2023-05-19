package org.example.handlers.rowprocessors;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.example.handlers.processfactory.BeanProccessType;
import org.example.handlers.processfactory.BeanProcessFactory;

import java.util.HashMap;
import java.util.Map;

public class BinSigRowProcessor extends BasicRowProcessor {

    public BinSigRowProcessor() {
        super(BeanProcessFactory.makeProcessor(BeanProccessType.STANDART, setColumnsToFieldsPair()));
    }

    public BinSigRowProcessor(BeanProccessType type) {
        super(BeanProcessFactory.makeProcessor(type, setColumnsToFieldsPair()));
    }

    /**
     * Метод для задания соответствия имени колонки БД имени поля класса
     * @return
     */
    private static Map<String, String> setColumnsToFieldsPair() {
        Map<String, String> pair = new HashMap<>();
        pair.put("PVId", "PVID");
        pair.put("NaryCatNr", "NaryCatNr");
        pair.put("bin_value_nr", "binValueNr");
        pair.put("num_bits", "numBits");
        pair.put("desc", "PVDescription");
        pair.put("CategoryNr", "CategoryNr");
        pair.put("PVCategories", "PVCategories");
        pair.put("pvnr", "PVNr");
        pair.put("parent_sys", "PARENTSTATIONID");
        pair.put("sys", "STATIONID");
        pair.put("PLC_ITEMID", "PLC_ITEMID");
        pair.put("categorytext", "CATEGORYTEXT");
        pair.put("proccatnr", "procCatNr");
        pair.put("AlarmProcessing", "AlarmProcessing");
        return pair;
    }
}
