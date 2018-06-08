package com.rxjy.pm.entity;

/**
 * Created by hjh on 2018/2/26.
 */

public class IconBean {

    private int StatusCode;
    private String StatusMsg;
    private String Body;

    public IconBean() {super();
    }

    @Override
    public String toString() {
        return "IconBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body='" + Body + '\'' +
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

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
