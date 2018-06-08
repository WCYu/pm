package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/27.
 */

public class EvaluateJson {

    private String OrderID;
    private int EvaluateStar;
    private String EvaluateReamrk;
    private int UserID;
    private List<Integer> MarkItems;

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public int getEvaluateStar() {
        return EvaluateStar;
    }

    public void setEvaluateStar(int evaluateStar) {
        EvaluateStar = evaluateStar;
    }

    public String getEvaluateReamrk() {
        return EvaluateReamrk;
    }

    public void setEvaluateReamrk(String evaluateReamrk) {
        EvaluateReamrk = evaluateReamrk;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public List<Integer> getMarkItems() {
        return MarkItems;
    }

    public void setMarkItems(List<Integer> markItems) {
        MarkItems = markItems;
    }
}
