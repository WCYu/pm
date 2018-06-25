package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/6/22.
 */

public class WorkerInfo {


    /**
     * body : [{"name":"开户姓名","verifyState":"","value":"","type":"1"},{"name":"身份证号","verifyState":"","value":"412828197209075151","type":"2"},{"name":"银行账户","verifyState":"","value":"6228480636308827568","type":"3"},{"name":"开户银行","verifyState":"","value":"农业银行","type":"4"},{"name":"工人姓名","verifyState":"","value":"余小海","type":"5"},{"name":"性别","verifyState":"","value":"1","type":"6"},{"name":"工种","verifyState":"","value":"油工","type":"7"},{"name":"地区","verifyState":"","value":"石家庄","type":"8"},{"name":"电话","verifyState":"","value":"13111561900","type":"9"},{"name":"录入时间","verifyState":"","value":"1900-01-01 00:00:00.0","type":"10"}]
     * statusCode : 1
     * statusMsg : Success
     */

    private int statusCode;
    private String statusMsg;
    private List<BodyBean> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * name : 开户姓名
         * verifyState :
         * value :
         * type : 1
         */

        private String name;
        private String verifyState;
        private String value;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVerifyState() {
            return verifyState;
        }

        public void setVerifyState(String verifyState) {
            this.verifyState = verifyState;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}


