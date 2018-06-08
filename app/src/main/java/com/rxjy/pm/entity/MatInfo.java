package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/10/10.
 */

public class MatInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<Mat> Body;

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

    public List<Mat> getBody() {
        return Body;
    }

    public void setBody(List<Mat> Body) {
        this.Body = Body;
    }

    public static class Mat implements Serializable {

        private String MatID;
        private String MID;
        private String BrandName;
        private String MatName;
        private String MatSpec;
        private String UnitName;
        private double Total;
        private double Already;
        private int UserID;
        private String UserName;
        private double MatPrice;
        private double BuyCount;
        private String PhotoUrl;

        public String getMatID() {
            return MatID;
        }

        public void setMatID(String MatID) {
            this.MatID = MatID;
        }

        public String getMID() {
            return MID;
        }

        public void setMID(String MID) {
            this.MID = MID;
        }

        public String getBrandName() {
            return BrandName;
        }

        public void setBrandName(String BrandName) {
            this.BrandName = BrandName;
        }

        public String getMatName() {
            return MatName;
        }

        public void setMatName(String MatName) {
            this.MatName = MatName;
        }

        public String getMatSpec() {
            return MatSpec;
        }

        public void setMatSpec(String MatSpec) {
            this.MatSpec = MatSpec;
        }

        public String getUnitName() {
            return UnitName;
        }

        public void setUnitName(String UnitName) {
            this.UnitName = UnitName;
        }

        public double getTotal() {
            return Total;
        }

        public void setTotal(double Total) {
            this.Total = Total;
        }

        public double getAlready() {
            return Already;
        }

        public void setAlready(double Already) {
            this.Already = Already;
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

        public double getMatPrice() {
            return MatPrice;
        }

        public void setMatPrice(double MatPrice) {
            this.MatPrice = MatPrice;
        }

        public double getBuyCount() {
            return BuyCount;
        }

        public void setBuyCount(double BuyCount) {
            this.BuyCount = BuyCount;
        }

        public String getPhotoUrl() {
            return PhotoUrl;
        }

        public void setPhotoUrl(String PhotoUrl) {
            this.PhotoUrl = PhotoUrl;
        }
    }
}
