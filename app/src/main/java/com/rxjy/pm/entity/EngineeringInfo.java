package com.rxjy.pm.entity;

import java.io.Serializable;

/**
 * Created by asus on 2018/4/27.
 */

public class EngineeringInfo implements Serializable {


    /**
     * F_KEY : a5b8ea63-bcf8-46d2-ae91-6c5bb52a5927
     * F_AREA_NAME : 序工工程
     * F_SORT : 0
     * F_TOTAL : 1411.2
     */

    private String F_KEY;
    private String F_AREA_NAME;
    private int F_SORT;
    private double F_TOTAL;

    public String getF_KEY() {
        return F_KEY;
    }

    public void setF_KEY(String F_KEY) {
        this.F_KEY = F_KEY;
    }

    public String getF_AREA_NAME() {
        return F_AREA_NAME;
    }

    public void setF_AREA_NAME(String F_AREA_NAME) {
        this.F_AREA_NAME = F_AREA_NAME;
    }

    public int getF_SORT() {
        return F_SORT;
    }

    public void setF_SORT(int F_SORT) {
        this.F_SORT = F_SORT;
    }

    public double getF_TOTAL() {
        return F_TOTAL;
    }

    public void setF_TOTAL(double F_TOTAL) {
        this.F_TOTAL = F_TOTAL;
    }
}
