package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class ProMoneyInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<ProMoney> Body;

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

    public List<ProMoney> getBody() {
        return Body;
    }

    public void setBody(List<ProMoney> Body) {
        this.Body = Body;
    }

    public static class ProMoney {
        private double actual_publish_money;
        private double RenGongMoney;
        private String proname;
        private String orderno;

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public double getActual_publish_money() {
            return actual_publish_money;
        }

        public void setActual_publish_money(int actual_publish_money) {
            this.actual_publish_money = actual_publish_money;
        }

        public double getRenGongMoney() {
            return RenGongMoney;
        }

        public void setRenGongMoney(int RenGongMoney) {
            this.RenGongMoney = RenGongMoney;
        }

        public String getProname() {
            return proname;
        }

        public void setProname(String proname) {
            this.proname = proname;
        }
    }
}
