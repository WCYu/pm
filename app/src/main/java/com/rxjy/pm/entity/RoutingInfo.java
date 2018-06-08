package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
public class RoutingInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<Routing> Body;

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

    public List<Routing> getBody() {
        return Body;
    }

    public void setBody(List<Routing> Body) {
        this.Body = Body;
    }

    public static class Routing {
        private int xj_id;
        private int xj_type;
        private String xj_time;
        private String xj_shouldfinishtime;

        public String getXj_time()
        {
            return xj_time;
        }

        public void setXj_time(String xj_time)
        {
            this.xj_time = xj_time;
        }

        public String getXj_shouldfinishtime()
        {
            return xj_shouldfinishtime;
        }

        public void setXj_shouldfinishtime(String xj_shouldfinishtime)
        {
            this.xj_shouldfinishtime = xj_shouldfinishtime;
        }

        public int getXj_id() {
            return xj_id;
        }

        public void setXj_id(int xj_id) {
            this.xj_id = xj_id;
        }

        public int getXj_type() {
            return xj_type;
        }

        public void setXj_type(int xj_type) {
            this.xj_type = xj_type;
        }
    }
}
