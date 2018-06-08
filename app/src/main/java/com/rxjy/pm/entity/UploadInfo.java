package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2018/1/30.
 */

public class UploadInfo implements Serializable{

    /**
     * StatusCode : 1
     * StatusMsg : 查询成功
     * Body : {"Uid":405,"Name":"叶栋梁","IdCard":"34292119811220441X","IsSubmit":true,"PhotoList":[{"Title":"证件照","ModelId":1000,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com:9110/Engine/201605100001/2016060517055285536.jpg"},{"Title":"艺术照","ModelId":1001,"CheckState":0,"PhotoUrl":""},{"Title":"身份证正面照","ModelId":4,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517142256790.jpg"},{"Title":"身份证反面照","ModelId":8,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517142311790.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517173760987.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517182322349.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517186624749.jpg"},{"Title":"体检报告","ModelId":19,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517197004404.jpg"}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private Upload Body;

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

    public Upload getBody() {
        return Body;
    }

    public void setBody(Upload Body) {
        this.Body = Body;
    }

    public static class Upload implements Serializable{
        /**
         * Uid : 405
         * Name : 叶栋梁
         * IdCard : 34292119811220441X
         * IsSubmit : true
         * PhotoList : [{"Title":"证件照","ModelId":1000,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com:9110/Engine/201605100001/2016060517055285536.jpg"},{"Title":"艺术照","ModelId":1001,"CheckState":0,"PhotoUrl":""},{"Title":"身份证正面照","ModelId":4,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517142256790.jpg"},{"Title":"身份证反面照","ModelId":8,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517142311790.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517173760987.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517182322349.jpg"},{"Title":"合作意向书","ModelId":17,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517186624749.jpg"},{"Title":"体检报告","ModelId":19,"CheckState":0,"PhotoUrl":"http://img0.rxjy.com/Engine/201605100001/2016060517197004404.jpg"}]
         */

        private int Uid;
        private String Name;
        private String IdCard;
        private String BankCard;
        private String BankCardMaster;
        private String BankType;
        private int BankTypeKey;
        private String BankAddress;
        private String EmergencyName;
        private String EmergencyRelation;
        private int EmergencyRelationKey;
        private String Mobile;
        private int WorkerNum;
        private boolean IsSubmit;
        private List<PhotoInfo> PhotoList;

        public int getBankTypeKey() {
            return BankTypeKey;
        }

        public void setBankTypeKey(int bankTypeKey) {
            BankTypeKey = bankTypeKey;
        }

        public int getEmergencyRelationKey() {
            return EmergencyRelationKey;
        }

        public void setEmergencyRelationKey(int emergencyRelationKey) {
            EmergencyRelationKey = emergencyRelationKey;
        }

        public int getUid() {
            return Uid;
        }

        public void setUid(int Uid) {
            this.Uid = Uid;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getIdCard() {
            return IdCard;
        }

        public void setIdCard(String IdCard) {
            this.IdCard = IdCard;
        }

        public String getBankCard() {
            return BankCard;
        }

        public void setBankCard(String bankCard) {
            BankCard = bankCard;
        }

        public String getBankCardMaster() {
            return BankCardMaster;
        }

        public void setBankCardMaster(String bankCardMaster) {
            BankCardMaster = bankCardMaster;
        }

        public String getBankType() {
            return BankType;
        }

        public void setBankType(String bankType) {
            BankType = bankType;
        }

        public String getBankAddress() {
            return BankAddress;
        }

        public void setBankAddress(String bankAddress) {
            BankAddress = bankAddress;
        }

        public String getEmergencyName() {
            return EmergencyName;
        }

        public void setEmergencyName(String emergencyName) {
            EmergencyName = emergencyName;
        }

        public String getEmergencyRelation() {
            return EmergencyRelation;
        }

        public void setEmergencyRelation(String emergencyRelation) {
            EmergencyRelation = emergencyRelation;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String mobile) {
            Mobile = mobile;
        }

        public int getWorkerNum() {
            return WorkerNum;
        }

        public void setWorkerNum(int workerNum) {
            WorkerNum = workerNum;
        }

        public boolean isIsSubmit() {
            return IsSubmit;
        }

        public void setIsSubmit(boolean IsSubmit) {
            this.IsSubmit = IsSubmit;
        }

        public List<PhotoInfo> getPhotoList() {
            return PhotoList;
        }

        public void setPhotoList(List<PhotoInfo> PhotoList) {
            this.PhotoList = PhotoList;
        }

        public static class PhotoInfo implements Serializable{
            /**
             * Title : 证件照
             * ModelId : 1000
             * CheckState : 0
             * PhotoUrl : http://img0.rxjy.com:9110/Engine/201605100001/2016060517055285536.jpg
             */

            private String Title;
            private int ModelId;
            private int CheckState;
            private String PhotoUrl;
            private String AttrId;

            public PhotoInfo() {super();
            }

            @Override
            public String toString() {
                return "PhotoInfo{" +
                        "Title='" + Title + '\'' +
                        ", ModelId=" + ModelId +
                        ", CheckState=" + CheckState +
                        ", PhotoUrl='" + PhotoUrl + '\'' +
                        ", AttrId='" + AttrId + '\'' +
                        '}';
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String title) {
                Title = title;
            }

            public int getModelId() {
                return ModelId;
            }

            public void setModelId(int modelId) {
                ModelId = modelId;
            }

            public int getCheckState() {
                return CheckState;
            }

            public void setCheckState(int checkState) {
                CheckState = checkState;
            }

            public String getPhotoUrl() {
                return PhotoUrl;
            }

            public void setPhotoUrl(String photoUrl) {
                PhotoUrl = photoUrl;
            }

            public String getAttrId() {
                return AttrId;
            }

            public void setAttrId(String attrId) {
                AttrId = attrId;
            }
        }
    }
}
