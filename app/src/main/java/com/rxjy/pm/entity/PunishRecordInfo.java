package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/7/11.
 */

public class PunishRecordInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<PunishRecord> Body;

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

    public List<PunishRecord> getBody() {
        return Body;
    }

    public void setBody(List<PunishRecord> Body) {
        this.Body = Body;
    }

    public static class PunishRecord implements Serializable {
        private String Number;
        private double FineMoney;
        private String FineTime;
        private String FineRemark;
        private String ProName;
        private List<String> FineImageItems;

        public String getProName() {
            return ProName;
        }

        public void setProName(String proName) {
            ProName = proName;
        }

        public List<String> getFineImageItems() {
            return FineImageItems;
        }

        public void setFineImageItems(List<String> fineImageItems) {
            FineImageItems = fineImageItems;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public double getFineMoney() {
            return FineMoney;
        }

        public void setFineMoney(double FineMoney) {
            this.FineMoney = FineMoney;
        }

        public String getFineTime() {
            return FineTime;
        }

        public void setFineTime(String FineTime) {
            this.FineTime = FineTime;
        }

        public String getFineRemark() {
            return FineRemark;
        }

        public void setFineRemark(String FineRemark) {
            this.FineRemark = FineRemark;
        }

    }
}
