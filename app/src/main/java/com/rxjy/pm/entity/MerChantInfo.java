package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/13.
 */

public class MerChantInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<Merchant> Body;

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

    public List<Merchant> getBody() {
        return Body;
    }

    public void setBody(List<Merchant> Body) {
        this.Body = Body;
    }

    public static class Merchant {

        private int UserID;
        private String UserName;
        private String UserPhone;
        private int EvaluateStar;
        private String WorkTime;
        private double MatPrice;
        private int IsNew;
        private int isChecked;

        public int getIsChecked() {
            return isChecked;
        }

        public void setIsChecked(int isChecked) {
            this.isChecked = isChecked;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserPhone() {
            return UserPhone;
        }

        public void setUserPhone(String UserPhone) {
            this.UserPhone = UserPhone;
        }

        public int getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(int EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public String getWorkTime() {
            return WorkTime;
        }

        public void setWorkTime(String WorkTime) {
            this.WorkTime = WorkTime;
        }

        public double getMatPrice() {
            return MatPrice;
        }

        public void setMatPrice(double MatPrice) {
            this.MatPrice = MatPrice;
        }

        public int getIsNew() {
            return IsNew;
        }

        public void setIsNew(int IsNew) {
            this.IsNew = IsNew;
        }
    }
}
