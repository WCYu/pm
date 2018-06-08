package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersProInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<OrdersPro> Body;

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

    public List<OrdersPro> getBody() {
        return Body;
    }

    public void setBody(List<OrdersPro> Body) {
        this.Body = Body;
    }

    public static class OrdersPro implements Serializable {

        private String OrderNo;
        private String ProName;
        private String ProAddr;
        private String BeginTime;
        private String EndTime;
        private int Count;

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getProName() {
            return ProName;
        }

        public void setProName(String ProName) {
            this.ProName = ProName;
        }

        public String getProAddr() {
            return ProAddr;
        }

        public void setProAddr(String ProAddr) {
            this.ProAddr = ProAddr;
        }

        public String getBeginTime() {
            return BeginTime;
        }

        public void setBeginTime(String BeginTime) {
            this.BeginTime = BeginTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }
    }
}
