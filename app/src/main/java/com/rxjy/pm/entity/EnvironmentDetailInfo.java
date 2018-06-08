package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public class EnvironmentDetailInfo {


    private int StatusCode;
    private String StatusMsg;

    private List<EnvironmentDetail> Body;

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

    public List<EnvironmentDetail> getBody() {
        return Body;
    }

    public void setBody(List<EnvironmentDetail> Body) {
        this.Body = Body;
    }

    public static class EnvironmentDetail {
        private int StepId;
        private int ProcessId;
        private String StepName;
        private String StepDesc;
        private int StepPhotoID;
        private String StepPhotoUrl;
        private String PhotoUrl;
        private int CheckState;
        private int XjId;

        public int getCheckState() {
            return CheckState;
        }

        public void setCheckState(int checkState) {
            CheckState = checkState;
        }

        public int getXjId() {
            return XjId;
        }

        public void setXjId(int xjId) {
            XjId = xjId;
        }

        public int getStepId() {
            return StepId;
        }

        public void setStepId(int StepId) {
            this.StepId = StepId;
        }

        public int getProcessId() {
            return ProcessId;
        }

        public void setProcessId(int ProcessId) {
            this.ProcessId = ProcessId;
        }

        public String getStepName() {
            return StepName;
        }

        public void setStepName(String StepName) {
            this.StepName = StepName;
        }

        public String getStepDesc() {
            return StepDesc;
        }

        public void setStepDesc(String StepDesc) {
            this.StepDesc = StepDesc;
        }

        public int getStepPhotoID() {
            return StepPhotoID;
        }

        public void setStepPhotoID(int StepPhotoID) {
            this.StepPhotoID = StepPhotoID;
        }

        public String getStepPhotoUrl() {
            return StepPhotoUrl;
        }

        public void setStepPhotoUrl(String StepPhotoUrl) {
            this.StepPhotoUrl = StepPhotoUrl;
        }

        public String getPhotoUrl() {
            return PhotoUrl;
        }

        public void setPhotoUrl(String PhotoUrl) {
            this.PhotoUrl = PhotoUrl;
        }
    }
}
