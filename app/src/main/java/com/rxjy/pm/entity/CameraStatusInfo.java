package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/11/9.
 */

public class CameraStatusInfo {

    /**
     * StatusCode : 2
     * StatusMsg : Error
     * Body : -1
     */

    private int StatusCode;
    private String StatusMsg;
    private int Body;

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

    public int getBody() {
        return Body;
    }

    public void setBody(int Body) {
        this.Body = Body;
    }
}
