package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/17.
 */

public class UpdCheckedJson {

    private String OrderNo;
    private String MatID;
    private Integer UserID;
    private int IsChecked;

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

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public int getIsChecked() {
        return IsChecked;
    }

    public void setIsChecked(int isChecked) {
        IsChecked = isChecked;
    }
}
