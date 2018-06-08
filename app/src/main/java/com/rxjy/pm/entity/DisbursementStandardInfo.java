package com.rxjy.pm.entity;

/**
 * Created by Administrator on 2017/4/28.
 */
public class DisbursementStandardInfo {

    private int StatusCode;
    private String StatusMsg;

    private DisbursementStandard Body;

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

    public DisbursementStandard getBody() {
        return Body;
    }

    public void setBody(DisbursementStandard Body) {
        this.Body = Body;
    }

    public static class DisbursementStandard {
        private int statu;

        public int getStatu() {
            return statu;
        }

        public void setStatu(int statu) {
            this.statu = statu;
        }
    }
}
