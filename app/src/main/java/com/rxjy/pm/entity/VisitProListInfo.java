package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/26.
 */

public class VisitProListInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<VisitProList> Body;

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

    public List<VisitProList> getBody() {
        return Body;
    }

    public void setBody(List<VisitProList> Body) {
        this.Body = Body;
    }

    public static class VisitProList {

        private String orderno;
        private String proname;
        private int showtag;
        private String lasttime;

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getProname() {
            return proname;
        }

        public void setProname(String proname) {
            this.proname = proname;
        }

        public int getShowtag() {
            return showtag;
        }

        public void setShowtag(int showtag) {
            this.showtag = showtag;
        }

        public String getLasttime() {
            return lasttime;
        }

        public void setLasttime(String lasttime) {
            this.lasttime = lasttime;
        }
    }
}
