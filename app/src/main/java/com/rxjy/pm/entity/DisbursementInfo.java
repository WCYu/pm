package com.rxjy.pm.entity;

/**
 * Created by Administrator on 2017/4/28.
 */
public class DisbursementInfo {

    private int StatusCode;
    private String StatusMsg;

    private Disbursement Body;

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

    public Disbursement getBody() {
        return Body;
    }

    public void setBody(Disbursement Body) {
        this.Body = Body;
    }

    public static class Disbursement {
        private int moneyStatus;
        private double keMoney;
        private double faMoney;
        private String faIds;

        public int getMoneyStatus() {
            return moneyStatus;
        }

        public void setMoneyStatus(int moneyStatus) {
            this.moneyStatus = moneyStatus;
        }

        public double getKeMoney() {
            return keMoney;
        }

        public void setKeMoney(double keMoney) {
            this.keMoney = keMoney;
        }

        public double getFaMoney() {
            return faMoney;
        }

        public void setFaMoney(double faMoney) {
            this.faMoney = faMoney;
        }

        public String getFaIds() {
            return faIds;
        }

        public void setFaIds(String faIds) {
            this.faIds = faIds;
        }
    }
}
