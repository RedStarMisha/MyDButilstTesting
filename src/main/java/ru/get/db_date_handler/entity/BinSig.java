package ru.get.db_date_handler.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinSig {
    private String PVID;
    private String NaryCatNr;
    private short binValueNr;
    private short numBits;
    /**
     * Описание сигнала
     */
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
