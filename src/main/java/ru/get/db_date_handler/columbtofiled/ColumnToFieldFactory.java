package ru.get.db_date_handler.columbtofiled;

import ru.get.db_date_handler.entity.AnaSig;
import ru.get.db_date_handler.entity.BinSig;

import java.util.HashMap;
import java.util.Map;

public class ColumnToFieldFactory extends ColumnToField {

    static {
        matcher.put(AnaSig.class, setMatchingAnaSig());
        matcher.put(BinSig.class, setMatchingBinSig());
    }

    private static Map<String, String> setMatchingAnaSig() {
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
        pair.put("categorytext", "CATEGORYTEXT");
        pair.put("CategoryNr", "CategoryNr");
        return pair;
    }

    private static Map<String, String> setMatchingBinSig() {
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
