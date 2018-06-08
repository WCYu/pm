package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/4/26.
 */

public class RefusalBean {


    /**
     * StatusCode : 1
     * StatusMsg : success
     * Body : null
     */

    private int StatusCode;
    private String StatusMsg;
    private Object Body;

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

    public Object getBody() {
        return Body;
    }

    public void setBody(Object Body) {
        this.Body = Body;
    }
}
