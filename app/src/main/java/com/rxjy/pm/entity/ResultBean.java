package com.rxjy.pm.entity;

/**
 * Created by hjh on 2018/2/24.
 */

public class ResultBean {

    private int StatusCode;
    private String StatusMsg;

    public ResultBean() {super();
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

    @Override
    public String toString() {
        return "ResultBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                '}';
    }
}
