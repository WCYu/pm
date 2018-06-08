package com.rxjy.pm.entity;

/**
 * Created by AAA on 2018/3/7.
 */

public class AddNewProjectInfo {

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : 状态更新成功！
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
