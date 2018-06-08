package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/8/2.
 */

public class MsgTypeInfo {

    private int StatusCode;
    private String StatusMsg;
    private MsgType Body;

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

    public MsgType getBody() {
        return Body;
    }

    public void setBody(MsgType Body) {
        this.Body = Body;
    }

    public static class MsgType {

        private int Count;
        private java.util.List<MsgInfo> List;

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        public List<MsgInfo> getList() {
            return List;
        }

        public void setList(List<MsgInfo> List) {
            this.List = List;
        }

        public static class MsgInfo {
            /**
             * ts_msg_type : 1
             * ts_msg_typename : 培训通知
             * PostLastTime : 2017/10/24 15:14:49
             * LookNoCount : 9
             */

            private int ts_msg_type;
            private String ts_msg_typename;
            private String PostLastTime;
            private int LookNoCount;

            public int getTs_msg_type() {
                return ts_msg_type;
            }

            public void setTs_msg_type(int ts_msg_type) {
                this.ts_msg_type = ts_msg_type;
            }

            public String getTs_msg_typename() {
                return ts_msg_typename;
            }

            public void setTs_msg_typename(String ts_msg_typename) {
                this.ts_msg_typename = ts_msg_typename;
            }

            public String getPostLastTime() {
                return PostLastTime;
            }

            public void setPostLastTime(String PostLastTime) {
                this.PostLastTime = PostLastTime;
            }

            public int getLookNoCount() {
                return LookNoCount;
            }

            public void setLookNoCount(int LookNoCount) {
                this.LookNoCount = LookNoCount;
            }
        }
    }
}
