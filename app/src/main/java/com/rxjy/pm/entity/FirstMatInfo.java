package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/10.
 */

public class FirstMatInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<FirstMat> Body;

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

    public List<FirstMat> getBody() {
        return Body;
    }

    public void setBody(List<FirstMat> Body) {
        this.Body = Body;
    }

    public static class FirstMat {

        private String TreeID;
        private String TreeName;
        private int isChecked;

        public int getIsChecked() {
            return isChecked;
        }

        public void setIsChecked(int isChecked) {
            this.isChecked = isChecked;
        }

        public String getTreeID() {
            return TreeID;
        }

        public void setTreeID(String TreeID) {
            this.TreeID = TreeID;
        }

        public String getTreeName() {
            return TreeName;
        }

        public void setTreeName(String TreeName) {
            this.TreeName = TreeName;
        }
    }
}
