package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class CraftDetailInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<CraftDetail> Body;

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

    public List<CraftDetail> getBody() {
        return Body;
    }

    public void setBody(List<CraftDetail> Body) {
        this.Body = Body;
    }

    public static class CraftDetail {
        private int craft_id;
        private int craft_photo_id;
        private String craft_name;
        private String sup_require;
        private String standard_url;
        private String url;
        private String craft_desc;
        private int craft_result;
        private String createtime;

        public int getCraft_id() {
            return craft_id;
        }

        public void setCraft_id(int craft_id) {
            this.craft_id = craft_id;
        }

        public int getCraft_photo_id() {
            return craft_photo_id;
        }

        public void setCraft_photo_id(int craft_photo_id) {
            this.craft_photo_id = craft_photo_id;
        }

        public String getCraft_name() {
            return craft_name;
        }

        public void setCraft_name(String craft_name) {
            this.craft_name = craft_name;
        }

        public String getSup_require() {
            return sup_require;
        }

        public void setSup_require(String sup_require) {
            this.sup_require = sup_require;
        }

        public String getStandard_url() {
            return standard_url;
        }

        public void setStandard_url(String standard_url) {
            this.standard_url = standard_url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCraft_desc() {
            return craft_desc;
        }

        public void setCraft_desc(String craft_desc) {
            this.craft_desc = craft_desc;
        }

        public int getCraft_result() {
            return craft_result;
        }

        public void setCraft_result(int craft_result) {
            this.craft_result = craft_result;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
    }
}
