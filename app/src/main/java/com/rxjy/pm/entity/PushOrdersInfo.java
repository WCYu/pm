package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/25.
 */

public class PushOrdersInfo {

    /**
     * OrderID : c062bf8b-5ad0-4839-98e7-0b94be03a59a
     * OrderNo : 11-176977
     * ProName : 北京世纪诺言文化传播中心办公装饰工程
     */

    private String OrderID;
    private String OrderNo;
    private String ProName;
    private String ProAddr;
    private int OrderState;

    public String getProAddr() {
        return ProAddr;
    }

    public void setProAddr(String proAddr) {
        ProAddr = proAddr;
    }

    public int getOrderState() {
        return OrderState;
    }

    public void setOrderState(int orderState) {
        OrderState = orderState;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String ProName) {
        this.ProName = ProName;
    }
}
