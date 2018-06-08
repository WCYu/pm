package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/11.
 */

public class UpdMatInfo {

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"TotalMoney":29597,"MatCount":2,"UserMoney":29597}
     */

    private int StatusCode;
    private String StatusMsg;
    private UpdMat Body;

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

    public UpdMat getBody() {
        return Body;
    }

    public void setBody(UpdMat Body) {
        this.Body = Body;
    }

    public static class UpdMat {
        /**
         * TotalMoney : 29597.0
         * MatCount : 2
         * UserMoney : 29597.0
         */

        private double TotalMoney;
        private int MatCount;
        private double UserMoney;

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public int getMatCount() {
            return MatCount;
        }

        public void setMatCount(int MatCount) {
            this.MatCount = MatCount;
        }

        public double getUserMoney() {
            return UserMoney;
        }

        public void setUserMoney(double UserMoney) {
            this.UserMoney = UserMoney;
        }
    }
}
