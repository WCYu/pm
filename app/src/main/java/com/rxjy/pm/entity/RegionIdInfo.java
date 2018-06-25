package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/6/23.
 */

public class RegionIdInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : [{"regionId":11,"regionName":"R6","regionFlag":"0","regionCode":"R6","regionAreaCode":"0101","createDate":"2013-11-08T00:51:07.357","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":12,"regionName":"北京","regionFlag":"0","regionCode":"BJ","regionAreaCode":"0100","createDate":"2013-11-08T00:51:07.357","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":15,"regionName":"南京","regionFlag":"0","regionCode":"NJ","regionAreaCode":"0250","createDate":"2013-11-08T00:51:07.357","LargeArea":3,"LargeAreaName":"中南区","isJoin":0},{"regionId":16,"regionName":"合肥","regionFlag":"0","regionCode":"HF","regionAreaCode":"0551","createDate":"2013-11-08T00:51:07.357","LargeArea":3,"LargeAreaName":"中南区","isJoin":0},{"regionId":18,"regionName":"武汉","regionFlag":"0","regionCode":"WH","regionAreaCode":"0270","createDate":"2013-11-08T00:51:07.357","LargeArea":3,"LargeAreaName":"中南区","isJoin":0},{"regionId":19,"regionName":"天津","regionFlag":"0","regionCode":"TJ","regionAreaCode":"0220","createDate":"2013-11-08T00:51:07.357","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":20,"regionName":"郑州","regionFlag":"0","regionCode":"ZZ","regionAreaCode":"0371","createDate":"2013-11-08T00:51:07.357","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":21,"regionName":"重庆","regionFlag":"0","regionCode":"CQ","regionAreaCode":"0230","createDate":"2013-11-08T00:51:07.357","LargeArea":4,"LargeAreaName":"西南区","isJoin":0},{"regionId":22,"regionName":"成都","regionFlag":"0","regionCode":"CD","regionAreaCode":"0280","createDate":"2013-11-08T00:51:07.357","LargeArea":4,"LargeAreaName":"西南区","isJoin":0},{"regionId":25,"regionName":"西安","regionFlag":"0","regionCode":"XA","regionAreaCode":"0290","createDate":"2013-11-08T00:51:07.357","LargeArea":4,"LargeAreaName":"西南区","isJoin":0},{"regionId":26,"regionName":"杭州","regionFlag":"0","regionCode":"HZ","regionAreaCode":"0571","createDate":"2013-11-08T00:51:07.357","LargeArea":3,"LargeAreaName":"中南区","isJoin":0},{"regionId":30,"regionName":"济南","regionFlag":"0","regionCode":"JN","regionAreaCode":"0531","createDate":"2013-11-08T00:51:07.357","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":31,"regionName":"石家庄","regionFlag":"0","regionCode":"SJZ","regionAreaCode":"0311","createDate":"2013-11-12T06:42:00.65","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":36,"regionName":"宁波","regionFlag":"0","regionCode":"NB","regionAreaCode":"0574","createDate":"2013-11-08T00:51:07.357","LargeArea":2,"LargeAreaName":"华东区","isJoin":0},{"regionId":38,"regionName":"上海","regionFlag":"0","regionCode":"SH","regionAreaCode":"0210","createDate":"2013-12-12T03:45:22.36","LargeArea":2,"LargeAreaName":"华东区","isJoin":0},{"regionId":49,"regionName":"望京","regionFlag":"0","regionCode":"WJ","regionAreaCode":"0109","createDate":"2015-10-22T12:02:19.393","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":55,"regionName":"CBD","regionFlag":"0","regionCode":"CBD","regionAreaCode":"0113","createDate":"2016-05-12T10:09:34.607","LargeArea":1,"LargeAreaName":"华北区","isJoin":0},{"regionId":60,"regionName":"汉口","regionFlag":"0","regionCode":"HK","regionAreaCode":"0271","createDate":"2018-02-06T14:36:32.11","LargeArea":3,"LargeAreaName":"中南区","isJoin":1},{"regionId":61,"regionName":"湖北","regionFlag":"0","regionCode":"WCH","regionAreaCode":"0272","createDate":"2018-02-06T14:38:01.017","LargeArea":3,"LargeAreaName":"中南区","isJoin":1},{"regionId":62,"regionName":"江苏","regionFlag":"0","regionCode":"NJ2","regionAreaCode":"0251","createDate":"2018-02-06T14:39:37.433","LargeArea":3,"LargeAreaName":"中南区","isJoin":1},{"regionId":65,"regionName":"雁塔","regionFlag":"0","regionCode":"XA2","regionAreaCode":"0291","createDate":"2018-02-06T14:40:29.897","LargeArea":4,"LargeAreaName":"西南区","isJoin":1},{"regionId":68,"regionName":"唐山","regionFlag":"0","regionCode":"TS","regionAreaCode":"0315","createDate":"2018-05-09T19:23:48.06","LargeArea":1,"LargeAreaName":"华北区","isJoin":1},{"regionId":69,"regionName":"朝阳","regionFlag":"0","regionCode":"CY","regionAreaCode":"0120","createDate":"2018-05-09T19:26:19.37","LargeArea":1,"LargeAreaName":"华北区","isJoin":1},{"regionId":70,"regionName":"普陀","regionFlag":"0","regionCode":"PT","regionAreaCode":"0121","createDate":"2018-05-09T19:27:23.523","LargeArea":2,"LargeAreaName":"华东区","isJoin":1},{"regionId":71,"regionName":"温特斯","regionFlag":"0","regionCode":"WTS","regionAreaCode":"0122","createDate":"2018-05-21T15:21:08.297","LargeArea":1,"LargeAreaName":"华北区","isJoin":0}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * regionId : 11
         * regionName : R6
         * regionFlag : 0
         * regionCode : R6
         * regionAreaCode : 0101
         * createDate : 2013-11-08T00:51:07.357
         * LargeArea : 1
         * LargeAreaName : 华北区
         * isJoin : 0
         */

        private int regionId;
        private String regionName;
        private String regionFlag;
        private String regionCode;
        private String regionAreaCode;
        private String createDate;
        private int LargeArea;
        private String LargeAreaName;
        private int isJoin;

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public String getRegionFlag() {
            return regionFlag;
        }

        public void setRegionFlag(String regionFlag) {
            this.regionFlag = regionFlag;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        public String getRegionAreaCode() {
            return regionAreaCode;
        }

        public void setRegionAreaCode(String regionAreaCode) {
            this.regionAreaCode = regionAreaCode;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getLargeArea() {
            return LargeArea;
        }

        public void setLargeArea(int LargeArea) {
            this.LargeArea = LargeArea;
        }

        public String getLargeAreaName() {
            return LargeAreaName;
        }

        public void setLargeAreaName(String LargeAreaName) {
            this.LargeAreaName = LargeAreaName;
        }

        public int getIsJoin() {
            return isJoin;
        }

        public void setIsJoin(int isJoin) {
            this.isJoin = isJoin;
        }
    }
}
