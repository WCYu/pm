package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/6/22.
 */

public class BackInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 查询成功！
     * Body : [{"dicid":1255,"dic_type_code":15,"pcode":"0","diccode":"1","dicname":"工商银行","dicisdelete":false,"createtime":"2016-05-13T16:25:08.25","ID":0},{"dicid":1256,"dic_type_code":15,"pcode":"0","diccode":"2","dicname":"建设银行","dicisdelete":false,"createtime":"2016-05-13T16:25:22.58","ID":0},{"dicid":1257,"dic_type_code":15,"pcode":"0","diccode":"3","dicname":"农业银行","dicisdelete":false,"createtime":"2016-05-13T16:25:40.577","ID":0},{"dicid":1258,"dic_type_code":15,"pcode":"0","diccode":"4","dicname":"中国银行","dicisdelete":false,"createtime":"2016-05-13T16:25:46.763","ID":0},{"dicid":1259,"dic_type_code":15,"pcode":"0","diccode":"5","dicname":"邮政储蓄","dicisdelete":false,"createtime":"2016-05-13T16:25:59.617","ID":0},{"dicid":1278,"dic_type_code":15,"pcode":"0","diccode":"6","dicname":"光大银行","dicisdelete":false,"createtime":"2016-05-23T17:47:39.983","ID":0},{"dicid":1279,"dic_type_code":15,"pcode":"0","diccode":"7","dicname":"广发银行","dicisdelete":false,"createtime":"2016-05-23T17:47:55.693","ID":0},{"dicid":1280,"dic_type_code":15,"pcode":"0","diccode":"8","dicname":"浦发银行","dicisdelete":false,"createtime":"2016-05-23T17:48:14.587","ID":0},{"dicid":1281,"dic_type_code":15,"pcode":"0","diccode":"9","dicname":"北京银行","dicisdelete":false,"createtime":"2016-05-23T17:48:32.507","ID":0},{"dicid":1282,"dic_type_code":15,"pcode":"0","diccode":"10","dicname":"民生银行","dicisdelete":false,"createtime":"2016-05-23T17:49:05.393","ID":0},{"dicid":1335,"dic_type_code":15,"pcode":"0","diccode":"11","dicname":"招商银行","dicisdelete":false,"createtime":"2016-05-23T17:49:05.393","ID":0},{"dicid":1336,"dic_type_code":15,"pcode":"0","diccode":"12","dicname":"交通银行","dicisdelete":false,"createtime":"2016-05-30T14:26:37.96","ID":0},{"dicid":1337,"dic_type_code":15,"pcode":"0","diccode":"13","dicname":"华夏银行","dicisdelete":false,"createtime":"2016-05-30T14:30:27.06","ID":0},{"dicid":1519,"dic_type_code":15,"pcode":"0","diccode":"14","dicname":"兴业银行","dicisdelete":false,"createtime":"2016-11-25T15:07:50.71","ID":0},{"dicid":1520,"dic_type_code":15,"pcode":"0","diccode":"15","dicname":"中信银行","dicisdelete":false,"createtime":"2016-11-29T08:36:58","ID":0},{"dicid":1558,"dic_type_code":15,"pcode":"0","diccode":"16","dicname":"其它","dicisdelete":false,"createtime":"2017-07-03T16:40:08.957","ID":0}]
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
         * dicid : 1255
         * dic_type_code : 15
         * pcode : 0
         * diccode : 1
         * dicname : 工商银行
         * dicisdelete : false
         * createtime : 2016-05-13T16:25:08.25
         * ID : 0
         */

        private int dicid;
        private int dic_type_code;
        private String pcode;
        private String diccode;
        private String dicname;
        private boolean dicisdelete;
        private String createtime;
        private int ID;

        public int getDicid() {
            return dicid;
        }

        public void setDicid(int dicid) {
            this.dicid = dicid;
        }

        public int getDic_type_code() {
            return dic_type_code;
        }

        public void setDic_type_code(int dic_type_code) {
            this.dic_type_code = dic_type_code;
        }

        public String getPcode() {
            return pcode;
        }

        public void setPcode(String pcode) {
            this.pcode = pcode;
        }

        public String getDiccode() {
            return diccode;
        }

        public void setDiccode(String diccode) {
            this.diccode = diccode;
        }

        public String getDicname() {
            return dicname;
        }

        public void setDicname(String dicname) {
            this.dicname = dicname;
        }

        public boolean isDicisdelete() {
            return dicisdelete;
        }

        public void setDicisdelete(boolean dicisdelete) {
            this.dicisdelete = dicisdelete;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}
