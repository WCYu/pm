package com.rxjy.pm.entity;

/**
 * Created by 解亚鑫 on 2018/5/25.
 */

public class DebugCameraInfo {

    /**
     * body : null
     * statusCode : 1
     * statusMsg : success
     * total : 0
     */

    private Object body;
    private String statusCode;
    private String statusMsg;
    private int total;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
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
