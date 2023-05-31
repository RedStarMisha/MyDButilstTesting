package ru.get.db_date_handler.entity;

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

    public String getPVID() {
        return PVID;
    }

    public void setPVID(String PVID) {
        this.PVID = PVID;
    }

    public String getNaryCatNr() {
        return NaryCatNr;
    }

    public void setNaryCatNr(String naryCatNr) {
        NaryCatNr = naryCatNr;
    }

    public short getBinValueNr() {
        return binValueNr;
    }

    public void setBinValueNr(short binValueNr) {
        this.binValueNr = binValueNr;
    }

    public short getNumBits() {
        return numBits;
    }

    public void setNumBits(short numBits) {
        this.numBits = numBits;
    }

    public String getPVDescription() {
        return PVDescription;
    }

    public void setPVDescription(String PVDescription) {
        this.PVDescription = PVDescription;
    }

    public int getCategoryNr() {
        return CategoryNr;
    }

    public void setCategoryNr(int categoryNr) {
        CategoryNr = categoryNr;
    }

    public int getPVCategories() {
        return PVCategories;
    }

    public void setPVCategories(int PVCategories) {
        this.PVCategories = PVCategories;
    }

    public int getPVNr() {
        return PVNr;
    }

    public void setPVNr(int PVNr) {
        this.PVNr = PVNr;
    }

    public String getPARENTSTATIONID() {
        return PARENTSTATIONID;
    }

    public void setPARENTSTATIONID(String PARENTSTATIONID) {
        this.PARENTSTATIONID = PARENTSTATIONID;
    }

    public String getSTATIONID() {
        return STATIONID;
    }

    public void setSTATIONID(String STATIONID) {
        this.STATIONID = STATIONID;
    }

    public String getPLC_ITEMID() {
        return PLC_ITEMID;
    }

    public void setPLC_ITEMID(String PLC_ITEMID) {
        this.PLC_ITEMID = PLC_ITEMID;
    }

    public String getCATEGORYTEXT() {
        return CATEGORYTEXT;
    }

    public void setCATEGORYTEXT(String CATEGORYTEXT) {
        this.CATEGORYTEXT = CATEGORYTEXT;
    }

    public String getProcCatNr() {
        return procCatNr;
    }

    public void setProcCatNr(String procCatNr) {
        this.procCatNr = procCatNr;
    }

    public short getAlarmProcessing() {
        return AlarmProcessing;
    }

    public void setAlarmProcessing(short alarmProcessing) {
        AlarmProcessing = alarmProcessing;
    }

    @Override
    public String toString() {
        return "BinSig{" +
                "PVID='" + PVID + '\'' +
                ", binValueNr=" + binValueNr +
                ", PVDescription='" + PVDescription + '\'' +
                '}';
    }
}
