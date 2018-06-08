package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/18.
 */

public class PaymentJson {
    private String OrderNo;
    private int UserID;
    private double TotalMoney;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }
}
