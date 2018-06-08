package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/11.
 */

public class UpdMatJson {
    private String OrderNo;
    private String MatID;
    private int UserID;
    private double Count;
    private int IsChecked;

    public UpdMatJson() {
    }

    public UpdMatJson(String orderNo, String matID, int userID, double count, int isChecked) {        OrderNo = orderNo;
        MatID = matID;
        UserID = userID;
        Count = count;
        IsChecked = isChecked;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getMatID() {
        return MatID;
    }

    public void setMatID(String matID) {
        MatID = matID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public double getCount() {
        return Count;
    }

    public void setCount(double count) {
        Count = count;
    }

    public int getIsChecked() {
        return IsChecked;
    }

    public void setIsChecked(int isChecked) {
        IsChecked = isChecked;
    }
}
