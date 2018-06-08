package com.rxjy.pm.entity;

/**
 * Created by Administrator on 2017/6/6.
 */
public class CameraImageInfo {

    private int StatusCode;
    private String StatusMsg;

    private CameraImage Body;

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

    public CameraImage getBody() {
        return Body;
    }

    public void setBody(CameraImage Body) {
        this.Body = Body;
    }

    public static class CameraImage {
        private String ProjectID;
        private String ENumber;
        private String pti_ImgSrc;
        private String pti_SaveFileName;
        private String UploadTime;

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

        public String getPti_ImgSrc() {
            return pti_ImgSrc;
        }

        public void setPti_ImgSrc(String pti_ImgSrc) {
            this.pti_ImgSrc = pti_ImgSrc;
        }

        public String getPti_SaveFileName() {
            return pti_SaveFileName;
        }

        public void setPti_SaveFileName(String pti_SaveFileName) {
            this.pti_SaveFileName = pti_SaveFileName;
        }

        public String getUploadTime() {
            return UploadTime;
        }

        public void setUploadTime(String UploadTime) {
            this.UploadTime = UploadTime;
        }
    }
}
