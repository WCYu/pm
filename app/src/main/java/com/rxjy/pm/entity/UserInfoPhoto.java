package com.rxjy.pm.entity;

/**
 * Created by AAA on 2018/3/27.
 */

public class UserInfoPhoto {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : http://img9.rxjy.com:80/image/0C8FwKgBtFqvLkyAAz5ZAADsdRSjPow092.jpg
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
