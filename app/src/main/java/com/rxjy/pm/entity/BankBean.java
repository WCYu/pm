package com.rxjy.pm.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/2/24.
 */

public class BankBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BankItem> Body;

    public BankBean() {
        super();
    }

    @Override
    public String toString() {
        return "BankBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public ArrayList<BankItem> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BankItem> body) {
        Body = body;
    }

    public class BankItem{
        private String Key;
        private String Value;

        public BankItem() {
            super();
        }

        @Override
        public String toString() {
            return "BankItem{" +
                    "Key='" + Key + '\'' +
                    ", Value='" + Value + '\'' +
                    '}';
        }

        public String getKey() {
            return Key;
        }

        public void setKey(String key) {
            Key = key;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String value) {
            Value = value;
        }
    }

}
