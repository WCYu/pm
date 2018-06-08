package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/9/17.
 */

public class ProMoneyDetailInfo {

    private int StatusCode;
    private String StatusMsg;
    private ProMoneyDetail Body;

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

    public ProMoneyDetail getBody() {
        return Body;
    }

    public void setBody(ProMoneyDetail Body) {
        this.Body = Body;
    }

    public static class ProMoneyDetail {

        private double totalmoney;
        private double totalmoneyc;
        private double totalmoneyr;
        private List<ProMoney> list;

        public double getTotalmoney() {
            return totalmoney;
        }

        public void setTotalmoney(double totalmoney) {
            this.totalmoney = totalmoney;
        }

        public double getTotalmoneyc() {
            return totalmoneyc;
        }

        public void setTotalmoneyc(double totalmoneyc) {
            this.totalmoneyc = totalmoneyc;
        }

        public double getTotalmoneyr() {
            return totalmoneyr;
        }

        public void setTotalmoneyr(double totalmoneyr) {
            this.totalmoneyr = totalmoneyr;
        }

        public List<ProMoney> getList() {
            return list;
        }

        public void setList(List<ProMoney> list) {
            this.list = list;
        }

        public static class ProMoney {

            private String moneytype;
            private String moneystate;
            private double money;
            private String time;

            public String getMoneytype() {
                return moneytype;
            }

            public void setMoneytype(String moneytype) {
                this.moneytype = moneytype;
            }

            public String getMoneystate() {
                return moneystate;
            }

            public void setMoneystate(String moneystate) {
                this.moneystate = moneystate;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
