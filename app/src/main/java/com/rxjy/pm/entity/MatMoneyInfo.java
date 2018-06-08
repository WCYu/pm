package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/10.
 */

public class MatMoneyInfo {

    private int StatusCode;
    private String StatusMsg;
    private MatMoney Body;

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

    public MatMoney getBody() {
        return Body;
    }

    public void setBody(MatMoney Body) {
        this.Body = Body;
    }

    public static class MatMoney {

        private double PlanMoney;
        private double TotalMoney;
        private double MaxMoney;
        private double DisMoney;
        private int DisCount;

        public double getPlanMoney() {
            return PlanMoney;
        }

        public void setPlanMoney(double PlanMoney) {
            this.PlanMoney = PlanMoney;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public double getMaxMoney() {
            return MaxMoney;
        }

        public void setMaxMoney(double MaxMoney) {
            this.MaxMoney = MaxMoney;
        }

        public double getDisMoney() {
            return DisMoney;
        }

        public void setDisMoney(double DisMoney) {
            this.DisMoney = DisMoney;
        }

        public int getDisCount() {
            return DisCount;
        }

        public void setDisCount(int DisCount) {
            this.DisCount = DisCount;
        }
    }
}
