package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/4/9.
 */

public class OrdersBean {

    /**
     * StatusCode : 1
     * StatusMsg : ok
     * Body : {"staterecord_id":413,"uid":390,"staterecord_type":0,"staterecord_remark":null,"staterecord_time":"2018-04-04","staterecord_endtime":"0001-01-01"}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * staterecord_id : 413
         * uid : 390
         * staterecord_type : 0
         * staterecord_remark : null
         * staterecord_time : 2018-04-04
         * staterecord_endtime : 0001-01-01
         */

        private int staterecord_id;
        private int uid;
        private int staterecord_type;
        private Object staterecord_remark;
        private String staterecord_time;
        private String staterecord_endtime;

        public int getStaterecord_id() {
            return staterecord_id;
        }

        public void setStaterecord_id(int staterecord_id) {
            this.staterecord_id = staterecord_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getStaterecord_type() {
            return staterecord_type;
        }

        public void setStaterecord_type(int staterecord_type) {
            this.staterecord_type = staterecord_type;
        }

        public Object getStaterecord_remark() {
            return staterecord_remark;
        }

        public void setStaterecord_remark(Object staterecord_remark) {
            this.staterecord_remark = staterecord_remark;
        }

        public String getStaterecord_time() {
            return staterecord_time;
        }

        public void setStaterecord_time(String staterecord_time) {
            this.staterecord_time = staterecord_time;
        }

        public String getStaterecord_endtime() {
            return staterecord_endtime;
        }

        public void setStaterecord_endtime(String staterecord_endtime) {
            this.staterecord_endtime = staterecord_endtime;
        }
    }
}
