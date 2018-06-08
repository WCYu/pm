package com.rxjy.pm.entity;

/**
 * Created by Administrator on 2017/6/8.
 */
public class CameraAbnormalJson {

    private JsonDataBean jsonData;

    public JsonDataBean getJsonData() {
        return jsonData;
    }

    public void setJsonData(JsonDataBean jsonData) {
        this.jsonData = jsonData;
    }

    public static class JsonDataBean {
        private String apiKey;
        private String apiSign;
        private String timeStamp;
        private String SubItemId;
        private String ENumber;

        public String getENumber() {
            return ENumber;
        }

        public void setENumber(String ENumber) {
            this.ENumber = ENumber;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getApiSign() {
            return apiSign;
        }

        public void setApiSign(String apiSign) {
            this.apiSign = apiSign;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getSubItemId() {
            return SubItemId;
        }

        public void setSubItemId(String SubItemId) {
            this.SubItemId = SubItemId;
        }
    }

}
