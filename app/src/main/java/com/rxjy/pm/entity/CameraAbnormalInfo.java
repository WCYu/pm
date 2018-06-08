package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
public class CameraAbnormalInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<CameraAbnormal> Body;

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

    public List<CameraAbnormal> getBody() {
        return Body;
    }

    public void setBody(List<CameraAbnormal> Body) {
        this.Body = Body;
    }

    public static class CameraAbnormal {
        private String ProjectID;
        private String ENumber;
        private String ea_StartTime;
        private String ea_EndTime;
        private String AddTime;

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

        public String getEa_StartTime() {
            return ea_StartTime;
        }

        public void setEa_StartTime(String ea_StartTime) {
            this.ea_StartTime = ea_StartTime;
        }

        public String getEa_EndTime() {
            return ea_EndTime;
        }

        public void setEa_EndTime(String ea_EndTime) {
            this.ea_EndTime = ea_EndTime;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }
    }
}
