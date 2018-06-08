package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/12.
 */

public class HotWordInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<HotWord> Body;

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

    public List<HotWord> getBody() {
        return Body;
    }

    public void setBody(List<HotWord> Body) {
        this.Body = Body;
    }

    public static class HotWord {

        private String Title;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }
    }
}
