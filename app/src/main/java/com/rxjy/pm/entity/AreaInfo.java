package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/11/20.
 */

public class AreaInfo {

    /**
     * StatusCode : 1
     * StatusMsg :
     * Body : [{"point_id":16741,"orderid":1442,"orderno":"12-196391","attr_id":91046,"title":null,"direction":0,"x":128.67,"y":92,"reamrk":null,"camera_id":0,"camera_code":null,"createtime":"2017-07-12T18:27:31.843","isdelete":0,"aeraname":"大门","areano":null,"point_type":1,"point_angle":"transform: rotate(358deg);","point_name":"摄像头","ID":0},{"point_id":16742,"orderid":1442,"orderno":"12-196391","attr_id":91046,"title":null,"direction":0,"x":206.67,"y":350,"reamrk":null,"camera_id":0,"camera_code":null,"createtime":"2017-07-12T18:27:31.85","isdelete":0,"aeraname":"卧室","areano":null,"point_type":1,"point_angle":"transform: rotate(223deg);","point_name":"摄像头","ID":0},{"point_id":16743,"orderid":1442,"orderno":"12-196391","attr_id":91046,"title":null,"direction":0,"x":471.33,"y":404,"reamrk":null,"camera_id":0,"camera_code":null,"createtime":"2017-07-12T18:27:31.86","isdelete":0,"aeraname":"厨房","areano":null,"point_type":1,"point_angle":"transform: rotate(194deg);","point_name":"摄像头","ID":0}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<Area> Body;

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

    public List<Area> getBody() {
        return Body;
    }

    public void setBody(List<Area> Body) {
        this.Body = Body;
    }

    public static class Area {
        /**
         * point_id : 16741
         * orderid : 1442
         * orderno : 12-196391
         * attr_id : 91046
         * title : null
         * direction : 0
         * x : 128.67
         * y : 92
         * reamrk : null
         * camera_id : 0
         * camera_code : null
         * createtime : 2017-07-12T18:27:31.843
         * isdelete : 0
         * aeraname : 大门
         * areano : null
         * point_type : 1
         * point_angle : transform: rotate(358deg);
         * point_name : 摄像头
         * ID : 0
         */

        private String aeraname;

        public String getAeraname() {
            return aeraname;
        }

        public void setAeraname(String aeraname) {
            this.aeraname = aeraname;
        }
    }
}
