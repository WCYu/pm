package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/6/22.
 */

public class WorkerPhotoInfo {

    /**
     * body : [{"photoId":"","realLocation":"","attrModelid":"4","state":"","photoname":"身份证正面"},{"photoId":"","realLocation":"","attrModelid":"8","state":"","photoname":"身份证反面"},{"photoId":"","realLocation":"","attrModelid":"9","state":"","photoname":"银行卡正面"},{"photoId":"","realLocation":"","attrModelid":"36","state":"","photoname":"证件照"},{"photoId":"","realLocation":"","attrModelid":"14","state":"","photoname":"资质证书"}]
     * statusCode : 1
     * statusMsg : Success
     */

    private int statusCode;
    private String statusMsg;
    private List<BodyBean> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * photoId :
         * realLocation :
         * attrModelid : 4
         * state :
         * photoname : 身份证正面
         */

        private String photoId;
        private String realLocation;
        private String attrModelid;
        private String state;
        private String photoname;

        public String getPhotoId() {
            return photoId;
        }

        public void setPhotoId(String photoId) {
            this.photoId = photoId;
        }

        public String getRealLocation() {
            return realLocation;
        }

        public void setRealLocation(String realLocation) {
            this.realLocation = realLocation;
        }

        public String getAttrModelid() {
            return attrModelid;
        }

        public void setAttrModelid(String attrModelid) {
            this.attrModelid = attrModelid;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPhotoname() {
            return photoname;
        }

        public void setPhotoname(String photoname) {
            this.photoname = photoname;
        }
    }
}
