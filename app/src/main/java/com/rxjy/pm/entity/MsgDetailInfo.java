package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgDetailInfo {

    private int StatusCode;
    private String StatusMsg;
    private MsgDetail Body;

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

    public MsgDetail getBody() {
        return Body;
    }

    public void setBody(MsgDetail Body) {
        this.Body = Body;
    }

    public static class MsgDetail {

        private int ts_id;
        private String ts_msg_title;
        private String ts_msg_content;
        private int ts_important;
        private String ts_post_time;
        private String ts_receive_time;

        public int getTs_id() {
            return ts_id;
        }

        public void setTs_id(int ts_id) {
            this.ts_id = ts_id;
        }

        public String getTs_msg_title() {
            return ts_msg_title;
        }

        public void setTs_msg_title(String ts_msg_title) {
            this.ts_msg_title = ts_msg_title;
        }

        public String getTs_msg_content() {
            return ts_msg_content;
        }

        public void setTs_msg_content(String ts_msg_content) {
            this.ts_msg_content = ts_msg_content;
        }

        public int getTs_important() {
            return ts_important;
        }

        public void setTs_important(int ts_important) {
            this.ts_important = ts_important;
        }

        public String getTs_post_time() {
            return ts_post_time;
        }

        public void setTs_post_time(String ts_post_time) {
            this.ts_post_time = ts_post_time;
        }

        public String getTs_receive_time() {
            return ts_receive_time;
        }

        public void setTs_receive_time(String ts_receive_time) {
            this.ts_receive_time = ts_receive_time;
        }
    }
}
