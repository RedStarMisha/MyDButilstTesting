package ru.get.db_date_handler.entity;

import lombok.Getter;
import lombok.Setter;
import ru.get.db_date_handler.annotation.ColumnName;

@Getter
@Setter
public class BinSig {
    @ColumnName(key = "pvid")
    private String PVID;
    @ColumnName(key = "NaryCatNr")
    private String NaryCatNr;
    @ColumnName(key = "bin_value")
    private short binValueNr;
    private short numBits;
    /**
     * Описание сигнала
     */
    @ColumnName(key = "desc")
    private String PVDescription = "ddd";
    private int CategoryNr;
    private int PVCategories;
    private int PVNr;
    private String PARENTSTATIONID;
    private String STATIONID;
    private String PLC_ITEMID;
    private String CATEGORYTEXT;
    private String procCatNr;
    private short AlarmProcessing;

    @Override
    public String toString() {
        return "BinSig{" +
                "PVID='" + PVID + '\'' +
                ", binValueNr=" + binValueNr +
                ", PVDescription='" + PVDescription + '\'' +
                '}';
    }
}
