package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/13.
 */

public class ShopCartProInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<ShopCartPro> Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public List<ShopCartPro> getBody() {
        return Body;
    }

    public void setBody(List<ShopCartPro> Body) {
        this.Body = Body;
    }

    public static class ShopCartPro {

        private String OrderNo;
        private String ProName;
        private String ProAddr;
        private int ProType;
        private double TotalMoney;
        private double MatCount;

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

        public String getProAddr() {
            return ProAddr;
        }

        public void setProAddr(String ProAddr) {
            this.ProAddr = ProAddr;
        }

        public int getProType() {
            return ProType;
        }

        public void setProType(int ProType) {
            this.ProType = ProType;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public double getMatCount() {
            return MatCount;
        }

        public void setMatCount(double MatCount) {
            this.MatCount = MatCount;
        }
    }
}
