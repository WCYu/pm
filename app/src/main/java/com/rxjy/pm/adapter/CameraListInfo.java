package com.rxjy.pm.adapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/11/9.
 */

public class CameraListInfo {

    /**
     * StatusCode : 1
     * StatusMsg :
     * Body : [{"ProjectID":"12-193162","ENumber":"0324","DataStatusToBinding":1,"UploadTime":"","pte_AreaName":"会议室及茶水间","pti_ImgSrc":"","sc_ImgSrc":"http://img9.rxjy.com:9120/image/0194wKgBtFlUbFOACePXAAc6CVyHL3g925.png","standard_ImgSrc":"http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg","CarmeaState":1},{"ProjectID":"12-193162","ENumber":"0325","DataStatusToBinding":1,"UploadTime":"","pte_AreaName":"工位区、设备间及东侧走廊","pti_ImgSrc":"","sc_ImgSrc":"http://img9.rxjy.com:9120/image/0194wKgBtFlUbYuAdMDxAAWtUAZDY3k242.png","standard_ImgSrc":"http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg","CarmeaState":1},{"ProjectID":"12-193162","ENumber":"0326","DataStatusToBinding":1,"UploadTime":"","pte_AreaName":"CEO总裁办公室","pti_ImgSrc":"","sc_ImgSrc":"http://img9.rxjy.com:9120/image/0194wKgBtFlUcF-AclBAAAarLKbVPn8184.png","standard_ImgSrc":"http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg","CarmeaState":1},{"ProjectID":"12-193162","ENumber":"0330","DataStatusToBinding":1,"UploadTime":"","pte_AreaName":"2人事及大厅走廊","pti_ImgSrc":"","sc_ImgSrc":"http://img9.rxjy.com:9120/image/0194wKgBtFlUa8iADzeJAAYc9eWmY08901.png","standard_ImgSrc":"http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg","CarmeaState":1}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<CameraInfo> Body;

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

    public List<CameraInfo> getBody() {
        return Body;
    }

    public void setBody(List<CameraInfo> Body) {
        this.Body = Body;
    }

    public static class CameraInfo implements Serializable {
        /**
         * ProjectID : 12-193162
         * ENumber : 0324
         * DataStatusToBinding : 1
         * UploadTime :
         * pte_AreaName : 会议室及茶水间
         * pti_ImgSrc :
         * sc_ImgSrc : http://img9.rxjy.com:9120/image/0194wKgBtFlUbFOACePXAAc6CVyHL3g925.png
         * standard_ImgSrc : http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg
         * CarmeaState : 1
         */

        private String ProjectID;
        private String ENumber;
        private int DataStatusToBinding;
        private String UploadTime;
        private String pte_AreaName;
        private String pti_ImgSrc;
        private String sc_ImgSrc;
        private String standard_ImgSrc;
        private int CarmeaState;

        public String getProjectID() {
            return ProjectID;
        }

        public void setProjectID(String ProjectID) {
            this.ProjectID = ProjectID;
        }

        public String getENumber() {
            return ENumber;
        }

        public void setENumber(String ENumber) {
            this.ENumber = ENumber;
        }

        public int getDataStatusToBinding() {
            return DataStatusToBinding;
        }

        public void setDataStatusToBinding(int DataStatusToBinding) {
            this.DataStatusToBinding = DataStatusToBinding;
        }

        public String getUploadTime() {
            return UploadTime;
        }

        public void setUploadTime(String UploadTime) {
            this.UploadTime = UploadTime;
        }

        public String getPte_AreaName() {
            return pte_AreaName;
        }

        public void setPte_AreaName(String pte_AreaName) {
            this.pte_AreaName = pte_AreaName;
        }

        public String getPti_ImgSrc() {
            return pti_ImgSrc;
        }

        public void setPti_ImgSrc(String pti_ImgSrc) {
            this.pti_ImgSrc = pti_ImgSrc;
        }

        public String getSc_ImgSrc() {
            return sc_ImgSrc;
        }

        public void setSc_ImgSrc(String sc_ImgSrc) {
            this.sc_ImgSrc = sc_ImgSrc;
        }

        public String getStandard_ImgSrc() {
            return standard_ImgSrc;
        }

        public void setStandard_ImgSrc(String standard_ImgSrc) {
            this.standard_ImgSrc = standard_ImgSrc;
        }

        public int getCarmeaState() {
            return CarmeaState;
        }

        public void setCarmeaState(int CarmeaState) {
            this.CarmeaState = CarmeaState;
        }
    }
}
