package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class CraftInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<Craft> Body;

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

    public List<Craft> getBody() {
        return Body;
    }

    public void setBody(List<Craft> Body) {
        this.Body = Body;
    }

    public static class Craft {
        private int craft_id;
        private String craft_name;
        private int NoCount;
        private int Status;

        public int getCraft_id() {
            return craft_id;
        }

        public void setCraft_id(int craft_id) {
            this.craft_id = craft_id;
        }

        public String getCraft_name() {
            return craft_name;
        }

        public void setCraft_name(String craft_name) {
            this.craft_name = craft_name;
        }

        public int getNoCount() {
            return NoCount;
        }

        public void setNoCount(int NoCount) {
            this.NoCount = NoCount;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }
    }
}
