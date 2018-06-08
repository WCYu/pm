package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/4/26.
 */

public class ProInfo {


    /**
     * StatusCode : 1
     * StatusMsg : success
     * Body : {"contract_type":"餐饮","proarea":121,"construction_period":188,"construction_time":"2018-03-09","ProbablyAddr":"-","PushMoney":3333,"Proaddr":"是的电风扇","LastPushMoney":"-","PushStatus":2,"nightwork_fee":"否","proname":"富商大贾个餐饮装修工程","RejectMoney":500,"ReturnedMoney":800}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * contract_type : 餐饮
         * proarea : 121.0
         * construction_period : 188
         * construction_time : 2018-03-09
         * ProbablyAddr : -
         * PushMoney : 3333.0
         * Proaddr : 是的电风扇
         * LastPushMoney : -
         * PushStatus : 2
         * nightwork_fee : 否
         * proname : 富商大贾个餐饮装修工程
         * RejectMoney : 500
         * ReturnedMoney : 800
         */

        private String contract_type;
        private double proarea;
        private int construction_period;
        private String construction_time;
        private String ProbablyAddr;
        private double PushMoney;
        private String Proaddr;
        private String LastPushMoney;
        private int PushStatus;
        private String nightwork_fee;
        private String proname;
        private int RejectMoney;
        private int ReturnedMoney;

        public String getContract_type() {
            return contract_type;
        }

        public void setContract_type(String contract_type) {
            this.contract_type = contract_type;
        }

        public double getProarea() {
            return proarea;
        }

        public void setProarea(double proarea) {
            this.proarea = proarea;
        }

        public int getConstruction_period() {
            return construction_period;
        }

        public void setConstruction_period(int construction_period) {
            this.construction_period = construction_period;
        }

        public String getConstruction_time() {
            return construction_time;
        }

        public void setConstruction_time(String construction_time) {
            this.construction_time = construction_time;
        }

        public String getProbablyAddr() {
            return ProbablyAddr;
        }

        public void setProbablyAddr(String ProbablyAddr) {
            this.ProbablyAddr = ProbablyAddr;
        }

        public double getPushMoney() {
            return PushMoney;
        }

        public void setPushMoney(double PushMoney) {
            this.PushMoney = PushMoney;
        }

        public String getProaddr() {
            return Proaddr;
        }

        public void setProaddr(String Proaddr) {
            this.Proaddr = Proaddr;
        }

        public String getLastPushMoney() {
            return LastPushMoney;
        }

        public void setLastPushMoney(String LastPushMoney) {
            this.LastPushMoney = LastPushMoney;
        }

        public int getPushStatus() {
            return PushStatus;
        }

        public void setPushStatus(int PushStatus) {
            this.PushStatus = PushStatus;
        }

        public String getNightwork_fee() {
            return nightwork_fee;
        }

        public void setNightwork_fee(String nightwork_fee) {
            this.nightwork_fee = nightwork_fee;
        }

        public String getProname() {
            return proname;
        }

        public void setProname(String proname) {
            this.proname = proname;
        }

        public int getRejectMoney() {
            return RejectMoney;
        }

        public void setRejectMoney(int RejectMoney) {
            this.RejectMoney = RejectMoney;
        }

        public int getReturnedMoney() {
            return ReturnedMoney;
        }

        public void setReturnedMoney(int ReturnedMoney) {
            this.ReturnedMoney = ReturnedMoney;
        }
    }
}
