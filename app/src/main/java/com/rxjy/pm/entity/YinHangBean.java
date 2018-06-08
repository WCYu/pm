package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by 阿禹 on 2018/6/7.
 */

public class YinHangBean {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : [{"Key":"工商银行","Value":"1"},{"Key":"建设银行","Value":"2"},{"Key":"农业银行","Value":"3"},{"Key":"中国银行","Value":"4"},{"Key":"邮政储蓄","Value":"5"},{"Key":"光大银行","Value":"6"},{"Key":"广发银行","Value":"7"},{"Key":"浦发银行","Value":"8"},{"Key":"北京银行","Value":"9"},{"Key":"民生银行","Value":"10"},{"Key":"招商银行","Value":"11"},{"Key":"交通银行","Value":"12"},{"Key":"华夏银行","Value":"13"},{"Key":"兴业银行","Value":"14"},{"Key":"中信银行","Value":"15"},{"Key":"其它","Value":"16"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * Key : 工商银行
         * Value : 1
         */

        private String Key;
        private String Value;

        public String getKey() {
            return Key;
        }

        public void setKey(String Key) {
            this.Key = Key;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }
    }
}
