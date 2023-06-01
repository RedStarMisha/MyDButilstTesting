package ru.get.db_date_handler.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
