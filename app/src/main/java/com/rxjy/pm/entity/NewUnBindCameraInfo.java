package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 解亚鑫 on 2018/5/24.
 */

public class NewUnBindCameraInfo implements Serializable {

    /**
     * body : [{"camerano":"0005","imei":"0005","position":"keting","status":0,"uploadsstatus":0},{"camerano":"0466","imei":"867282050070466","position":"keting","status":0,"uploadsstatus":0}]
     * statusCode : 10000
     * statusMsg : success
     * total : 0
     */

    private String statusCode;
    private String statusMsg;
    private int total;
    private List<BodyBean> body;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable{
        /**
         * camerano : 0005
         * imei : 0005
         * position : keting
         * status : 0
         * uploadsstatus : 0
         */

        private String camerano;
        private String imei;
        private String position;
        private int status;
        private int uploadsstatus;

        public String getCamerano() {
            return camerano;
        }

        public void setCamerano(String camerano) {
            this.camerano = camerano;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUploadsstatus() {
            return uploadsstatus;
        }

        public void setUploadsstatus(int uploadsstatus) {
            this.uploadsstatus = uploadsstatus;
        }
    }
}
