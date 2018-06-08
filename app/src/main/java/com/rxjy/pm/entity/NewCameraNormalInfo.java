package com.rxjy.pm.entity;

/**
 * Created by 解亚鑫 on 2018/5/24.
 */

public class NewCameraNormalInfo {

    /**
     * body : {"imgUrl":"http://img9.rxjy.com:9120/image/0267wKgB8Fr71QWAccB5AAKMZrrVlZs762.jpg","camerano":"6203","imei":"865166021426203","position":"keting"}
     * statusCode : 10000
     * statusMsg : success
     * total : 0
     */

    private BodyBean body;
    private String statusCode;
    private String statusMsg;
    private int total;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

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

    public static class BodyBean {
        /**
         * imgUrl : http://img9.rxjy.com:9120/image/0267wKgB8Fr71QWAccB5AAKMZrrVlZs762.jpg
         * camerano : 6203
         * imei : 865166021426203
         * position : keting
         */

        private String imgUrl;
        private String camerano;
        private String imei;
        private String position;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

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
    }
}
