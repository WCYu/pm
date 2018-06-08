package com.rxjy.pm.entity;

/**
 * Created by 阿禹 on 2018/6/5.
 */

public class LoginBean {

    /**
     * StatusCode : 0
     * StatusMsg : 登陆成功！
     * Body : {"cardNo":"g00000025","account":"13132103766","Token":"1C8DAC38BDDD2FFD6278C2D88EC1DA12","appId":"6d02b96b-df66-4ca9-9499-0963dae83440"}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * cardNo : g00000025
         * account : 13132103766
         * Token : 1C8DAC38BDDD2FFD6278C2D88EC1DA12
         * appId : 6d02b96b-df66-4ca9-9499-0963dae83440
         */

        private String cardNo;
        private String account;
        private String Token;
        private String appId;

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }
    }
}
