package com.rxjy.pm.entity;

/**
 * Created by 解亚鑫 on 2018/5/25.
 */

public class DebugCameraImageURLInfo {

    /**
     * body : http://img9.rxjy.com:9120/image/0F8EwKgBtFsDqkqAByVWAAKsy17_L1w673.jpg
     * statusCode : 10000
     * statusMsg : success
     * total : 0
     */

    private String body;
    private String statusCode;
    private String statusMsg;
    private int total;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
