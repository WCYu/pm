package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */
public class DisbursementListInfo {
    private int StatusCode;
    private String StatusMsg;

    private List<DisbursementList> Body;

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

    public List<DisbursementList> getBody() {
        return Body;
    }

    public void setBody(List<DisbursementList> body) {
        Body = body;
    }

    public static class DisbursementList {
        private int branch_id;
        private double money;
        private int branch_state;

        public int getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(int branch_id) {
            this.branch_id = branch_id;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getBranch_state() {
            return branch_state;
        }

        public void setBranch_state(int branch_state) {
            this.branch_state = branch_state;
        }
    }
}
