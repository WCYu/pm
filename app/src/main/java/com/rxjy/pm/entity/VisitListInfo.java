package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/27.
 */

public class VisitListInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<VisitInfo> Body;

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

    public List<VisitInfo> getBody() {
        return Body;
    }

    public void setBody(List<VisitInfo> Body) {
        this.Body = Body;
    }

    public static class VisitInfo {

        private int ID;
        private String logcontent;
        private String createtime;
        private int logtype;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getLogcontent() {
            return logcontent;
        }

        public void setLogcontent(String logcontent) {
            this.logcontent = logcontent;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getLogtype() {
            return logtype;
        }

        public void setLogtype(int logtype) {
            this.logtype = logtype;
        }
    }
}
