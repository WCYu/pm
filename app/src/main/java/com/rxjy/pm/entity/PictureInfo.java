package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/4/26.
 */

public class PictureInfo {

    /**
     * StatusCode : 1
     * StatusMsg : success
     * Body : ["http://imgtest.rxjy.com/Engine/25-68496/2018041015369136770889624973.jpeg","http://imgtest.rxjy.com/Engine/25-68496/2018041015363173539101536302.jpg","http://imgtest.rxjy.com/Engine/25-68496/201804101536734437708624593.jpg","http://imgtest.rxjy.com/Engine/25-68496/2018041015363607109983958154.png"]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<String> Body;

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

    public List<String> getBody() {
        return Body;
    }

    public void setBody(List<String> Body) {
        this.Body = Body;
    }
}
