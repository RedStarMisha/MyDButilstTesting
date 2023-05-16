package org.example.entity;

public class AnaSig {
    private String PVID;
    /**
     * Описание сигнала
     */
    private String PVDescription;
    /**
     * Единицы измерения
     */
    private String DimString;
    /**
     * Количество знаков после запятой
     */
    private byte RoundDigits;
    /**
     * Нижний предел измерения датчика
     */
    private float RangeLow;
    /**
     * Верхний предел измерения датчика
     */
    private float RangeHigh;


    //Массив  уставок (0 - технологическая, 1 - предупредительная, 2 - аварийная)
    private double BoundsLow1;
    private double BoundsLow2;
    private double BoundsLow3;
    private double BoundsHigh1;
    private double BoundsHigh2;
    private double BoundsHigh3;

    private String PARENTSTATIONID;
    private String STATIONID;
    private float DeadBand = (float) 0.0;
    private static int PVNr;

    private int PVCategories;

    private String PLC_ITEMID;
    private String CATEGORYTEXT;

    private int CategoryNr;
//    private String StationId;

    public String getPVID() {
        return PVID;
    }

    public void setPVID(String PVID) {
        this.PVID = PVID;
    }

    public String getPVDescription() {
        return PVDescription;
    }

    public void setPVDescription(String PVDescription) {
        this.PVDescription = PVDescription;
    }

    public String getDimString() {
        return DimString;
    }

    public void setDimString(String dimString) {
        DimString = dimString;
    }

    public byte getRoundDigits() {
        return RoundDigits;
    }

    public void setRoundDigits(byte roundDigits) {
        RoundDigits = roundDigits;
    }

    public float getRangeLow() {
        return RangeLow;
    }

    public void setRangeLow(float rangeLow) {
        RangeLow = rangeLow;
    }

    public float getRangeHigh() {
        return RangeHigh;
    }

    public void setRangeHigh(float rangeHigh) {
        RangeHigh = rangeHigh;
    }

    public double getBoundsLow1() {
        return BoundsLow1;
    }

    public void setBoundsLow1(double boundsLow1) {
        BoundsLow1 = boundsLow1;
    }

    public double getBoundsLow2() {
        return BoundsLow2;
    }

    public void setBoundsLow2(double boundsLow2) {
        BoundsLow2 = boundsLow2;
    }

    public double getBoundsLow3() {
        return BoundsLow3;
    }

    public void setBoundsLow3(double boundsLow3) {
        BoundsLow3 = boundsLow3;
    }

    public double getBoundsHigh1() {
        return BoundsHigh1;
    }

    public void setBoundsHigh1(double boundsHigh1) {
        BoundsHigh1 = boundsHigh1;
    }

    public double getBoundsHigh2() {
        return BoundsHigh2;
    }

    public void setBoundsHigh2(double boundsHigh2) {
        BoundsHigh2 = boundsHigh2;
    }

    public double getBoundsHigh3() {
        return BoundsHigh3;
    }

    public void setBoundsHigh3(double boundsHigh3) {
        BoundsHigh3 = boundsHigh3;
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

    public float getDeadBand() {
        return DeadBand;
    }

    public void setDeadBand(float deadBand) {
        DeadBand = deadBand;
    }

    public static int getPVNr() {
        return PVNr;
    }

    public static void setPVNr(int PVNr) {
        AnaSig.PVNr = PVNr;
    }

    public int getPVCategories() {
        return PVCategories;
    }

    public void setPVCategories(int PVCategories) {
        this.PVCategories = PVCategories;
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

    public int getCategoryNr() {
        return CategoryNr;
    }

    public void setCategoryNr(int categoryNr) {
        CategoryNr = categoryNr;
    }

    @Override
    public String toString() {
        return "AnaSig{" +
                "PVID='" + PVID + '\'' +
                ", PVDescription='" + PVDescription + '\'' +
                ", DimString='" + DimString + '\'' +
                ", RoundDigits=" + RoundDigits +
                ", RangeLow=" + RangeLow +
                ", RangeHigh=" + RangeHigh +
                ", BoundsLow1=" + BoundsLow1 +
                ", BoundsLow2=" + BoundsLow2 +
                ", BoundsLow3=" + BoundsLow3 +
                ", BoundsHigh1=" + BoundsHigh1 +
                ", BoundsHigh2=" + BoundsHigh2 +
                ", BoundsHigh3=" + BoundsHigh3 +
                ", PARENTSTATIONID='" + PARENTSTATIONID + '\'' +
                ", STATIONID='" + STATIONID + '\'' +
                ", DeadBand=" + DeadBand +
                ", PVCategories=" + PVCategories +
                ", PLC_ITEMID='" + PLC_ITEMID + '\'' +
                ", CATEGORYTEXT='" + CATEGORYTEXT + '\'' +
                ", CategoryNr=" + CategoryNr +
                '}';
    }
}
