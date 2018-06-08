package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/26.
 */

public class EvaluateMarkInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<StarInfo> Body;

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

    public List<StarInfo> getBody() {
        return Body;
    }

    public void setBody(List<StarInfo> Body) {
        this.Body = Body;
    }

    public static class StarInfo {

        private String StarNum;
        private List<MarkInfo> Items;

        public String getStarNum() {
            return StarNum;
        }

        public void setStarNum(String StarNum) {
            this.StarNum = StarNum;
        }

        public List<MarkInfo> getItems() {
            return Items;
        }

        public void setItems(List<MarkInfo> Items) {
            this.Items = Items;
        }

        public static class MarkInfo {

            private int MarkID;
            private String MarkTitle;
            private int isChecked;

            public int getIsChecked() {
                return isChecked;
            }

            public void setIsChecked(int isChecked) {
                this.isChecked = isChecked;
            }

            public int getMarkID() {
                return MarkID;
            }

            public void setMarkID(int MarkID) {
                this.MarkID = MarkID;
            }

            public String getMarkTitle() {
                return MarkTitle;
            }

            public void setMarkTitle(String MarkTitle) {
                this.MarkTitle = MarkTitle;
            }
        }
    }
}
