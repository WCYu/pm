package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/5/8.
 */

public class ProListBean {

    /**
     * aqi_ItemName : 施工垃圾人工清运（不含外运）
     * aqi_ItemUnit : 平方米
     * aqi_QuantityNew : 140.0
     * F_AREA_KEY : a5b8ea63-bcf8-46d2-ae91-6c5bb52a5927
     * Flag : 0
     * orderno : 31-99897
     * aqi_CostPrice : 1.988
     * aqi_CostTotalPrice : 278.32
     * aqi_OtherKey : 259ded31-351b-40ed-a632-0b1a7e1ae26a
     * m_level : 0
     */

    private String aqi_ItemName;
    private String aqi_ItemUnit;
    private double aqi_QuantityNew;
    private String F_AREA_KEY;
    private String Flag;
    private String orderno;
    private double aqi_CostPrice;
    private double aqi_CostTotalPrice;
    private String aqi_OtherKey;
    private int m_level;

    public String getAqi_ItemName() {
        return aqi_ItemName;
    }

    public void setAqi_ItemName(String aqi_ItemName) {
        this.aqi_ItemName = aqi_ItemName;
    }

    public String getAqi_ItemUnit() {
        return aqi_ItemUnit;
    }

    public void setAqi_ItemUnit(String aqi_ItemUnit) {
        this.aqi_ItemUnit = aqi_ItemUnit;
    }

    public double getAqi_QuantityNew() {
        return aqi_QuantityNew;
    }

    public void setAqi_QuantityNew(double aqi_QuantityNew) {
        this.aqi_QuantityNew = aqi_QuantityNew;
    }

    public String getF_AREA_KEY() {
        return F_AREA_KEY;
    }

    public void setF_AREA_KEY(String F_AREA_KEY) {
        this.F_AREA_KEY = F_AREA_KEY;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public double getAqi_CostPrice() {
        return aqi_CostPrice;
    }

    public void setAqi_CostPrice(double aqi_CostPrice) {
        this.aqi_CostPrice = aqi_CostPrice;
    }

    public double getAqi_CostTotalPrice() {
        return aqi_CostTotalPrice;
    }

    public void setAqi_CostTotalPrice(double aqi_CostTotalPrice) {
        this.aqi_CostTotalPrice = aqi_CostTotalPrice;
    }

    public String getAqi_OtherKey() {
        return aqi_OtherKey;
    }

    public void setAqi_OtherKey(String aqi_OtherKey) {
        this.aqi_OtherKey = aqi_OtherKey;
    }

    public int getM_level() {
        return m_level;
    }

    public void setM_level(int m_level) {
        this.m_level = m_level;
    }
}
