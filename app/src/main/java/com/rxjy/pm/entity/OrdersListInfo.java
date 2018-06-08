package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */
public class OrdersListInfo {
    private int StatusCode;
    private String StatusMsg;

    private List<OrdersList> Body;

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

    public List<OrdersList> getBody() {
        return Body;
    }

    public void setBody(List<OrdersList> Body) {
        this.Body = Body;
    }

    public static class OrdersList {
        private String OrderID;
        private String OrderNumber;
        private String UserName;
        private String UserPhone;
        private int OrderState;
        private String OrderTime;
        private double TotalMoney;
        private String UserPhoto;

        public String getUserPhoto() {
            return UserPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            UserPhoto = userPhoto;
        }

        public String getOrderID() {
            return OrderID;
        }

        public void setOrderID(String OrderID) {
            this.OrderID = OrderID;
        }

        public String getOrderNumber() {
            return OrderNumber;
        }

        public void setOrderNumber(String OrderNumber) {
            this.OrderNumber = OrderNumber;
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

        public int getOrderState() {
            return OrderState;
        }

        public void setOrderState(int OrderState) {
            this.OrderState = OrderState;
        }

        public String getOrderTime() {
            return OrderTime;
        }

        public void setOrderTime(String OrderTime) {
            this.OrderTime = OrderTime;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }
    }
}
