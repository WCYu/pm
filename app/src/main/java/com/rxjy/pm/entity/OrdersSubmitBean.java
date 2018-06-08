package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/4/9.
 */

public class OrdersSubmitBean {

    /**
     * StatusCode : 1
     * StatusMsg : ok
     * Body :
     */

    private int StatusCode;
    private String StatusMsg;
    private String Body;

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

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }
}
