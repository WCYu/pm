package com.rxjy.pm.entity;

/**
 * Created by 阿禹 on 2018/6/5.
 */

public class RuZhiInfoBean {

    /**
     * statusMsg : success
     * statusCode : 1
     * body : {"userInfo":{"isNewRecord":true,"overProjectNum":"1","temporaryDesc":"","officialDesc":"","intentionStatus":1,"intentionTime":"2017-04-26 13:55:41","switchStatus":0,"idcard":"513026197602101799","depositCash":12000,"stageState":2,"msgstate":2,"userState":"1","sex":1,"userName":"张雪帮","inductionArea":11,"mobile":"13911185610","inductionDate":1493136000000,"approvedesc":"","bankAccount":"6212260200106103225","bankType":1,"bankName":"工商银行","nameCheckstate":0,"idcardCheckstate":0,"bankAmountCheckstate":0,"bankTypeCheckstate":0,"photoCheckstate":0,"photoArtCheckstate":0},"yajing":12000,"photos":{"bankCardFace":{"arrInfoid":"15272;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsqABb11AAoiGfHFetY315.jpg","status":"0","attrModelId":"9","photoName":"银行卡正面","updateUserName":";","updatetimes":"1493186141760;"},"art":{"arrInfoid":"1335","url":"http://img9.rxjy.com:9120/image/0005wKgBtFkkVGiAQCyhAADzM0JSlHI851.jpg","status":"0","attrModelId":"41","photoName":"艺术照","updateUserName":";","updatetimes":"1495553511363;"},"relieve":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"解除协议","updateUserName":"","updatetimes":""},"bankCardIdentity":{"arrInfoid":"15273;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMs2ASflxAAoGEuQLouc314.jpg","status":"0","attrModelId":"11","photoName":"银行卡反面","updateUserName":";","updatetimes":"1493186141760;"},"cooperationWill":{"arrInfoid":"15259;15260;15261;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMxiAWTlnAAcEK0-Fq84020.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMxyASZYyAAdlro9TZS0811.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMx-AeFSoAAVEFrFEQu0995.jpg;","status":"0;0;0;","attrModelId":"17","photoName":"合作意向书","updateUserName":";;;","updatetimes":"1493186141653;1493186141683;1493186141700;"},"IDCardIdentity":{"arrInfoid":"15271;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMseAdapnAAoKJZ0TDy8404.jpg","status":"0","attrModelId":"8","photoName":"身份证反面","updateUserName":";","updatetimes":"1493186141747;"},"sincerity":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"诚信协议","updateUserName":"","updatetimes":""},"quality":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"质量协议","updateUserName":"","updatetimes":""},"security":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"安全协议","updateUserName":"","updatetimes":""},"visualize":{"arrInfoid":"1335;","url":"http://img9.rxjy.com:9120/image/0150wKgB8FkANGmAT6WwAABasK7lR7k220.jpg","status":"0","attrModelId":"40","photoName":"形象照","updateUserName":";","updatetimes":"1495553511363;"},"examination":{"arrInfoid":"15262;15263;15264;15265;","url":"http://img9.rxjy.com/image/0150wKgB8FkANCGALZMdAAbMFmrmUr4604.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCSAN13kAAZIOQ4ioTw853.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCeATmysAAa9B5LvbS0750.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCqAb7VrAAafYe8mVF8326.jpg;","status":"0;0;0;0;","attrModelId":"19","photoName":"体检报告","updateUserName":";;;;","updatetimes":"1493186141700;1493186141700;1493186141713;1493186141713;"},"IDCardFace":{"arrInfoid":"15270;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsOAGV8pAAnA-W0l7Ng538.jpg","status":"0","attrModelId":"4","photoName":"身份证正面","updateUserName":";","updatetimes":"1493186141747;"},"cooperation":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"合作协议","updateUserName":"","updatetimes":""}}}
     */

    private String statusMsg;
    private int statusCode;
    private BodyBean body;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * userInfo : {"isNewRecord":true,"overProjectNum":"1","temporaryDesc":"","officialDesc":"","intentionStatus":1,"intentionTime":"2017-04-26 13:55:41","switchStatus":0,"idcard":"513026197602101799","depositCash":12000,"stageState":2,"msgstate":2,"userState":"1","sex":1,"userName":"张雪帮","inductionArea":11,"mobile":"13911185610","inductionDate":1493136000000,"approvedesc":"","bankAccount":"6212260200106103225","bankType":1,"bankName":"工商银行","nameCheckstate":0,"idcardCheckstate":0,"bankAmountCheckstate":0,"bankTypeCheckstate":0,"photoCheckstate":0,"photoArtCheckstate":0}
         * yajing : 12000.0
         * photos : {"bankCardFace":{"arrInfoid":"15272;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsqABb11AAoiGfHFetY315.jpg","status":"0","attrModelId":"9","photoName":"银行卡正面","updateUserName":";","updatetimes":"1493186141760;"},"art":{"arrInfoid":"1335","url":"http://img9.rxjy.com:9120/image/0005wKgBtFkkVGiAQCyhAADzM0JSlHI851.jpg","status":"0","attrModelId":"41","photoName":"艺术照","updateUserName":";","updatetimes":"1495553511363;"},"relieve":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"解除协议","updateUserName":"","updatetimes":""},"bankCardIdentity":{"arrInfoid":"15273;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMs2ASflxAAoGEuQLouc314.jpg","status":"0","attrModelId":"11","photoName":"银行卡反面","updateUserName":";","updatetimes":"1493186141760;"},"cooperationWill":{"arrInfoid":"15259;15260;15261;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMxiAWTlnAAcEK0-Fq84020.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMxyASZYyAAdlro9TZS0811.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMx-AeFSoAAVEFrFEQu0995.jpg;","status":"0;0;0;","attrModelId":"17","photoName":"合作意向书","updateUserName":";;;","updatetimes":"1493186141653;1493186141683;1493186141700;"},"IDCardIdentity":{"arrInfoid":"15271;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMseAdapnAAoKJZ0TDy8404.jpg","status":"0","attrModelId":"8","photoName":"身份证反面","updateUserName":";","updatetimes":"1493186141747;"},"sincerity":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"诚信协议","updateUserName":"","updatetimes":""},"quality":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"质量协议","updateUserName":"","updatetimes":""},"security":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"安全协议","updateUserName":"","updatetimes":""},"visualize":{"arrInfoid":"1335;","url":"http://img9.rxjy.com:9120/image/0150wKgB8FkANGmAT6WwAABasK7lR7k220.jpg","status":"0","attrModelId":"40","photoName":"形象照","updateUserName":";","updatetimes":"1495553511363;"},"examination":{"arrInfoid":"15262;15263;15264;15265;","url":"http://img9.rxjy.com/image/0150wKgB8FkANCGALZMdAAbMFmrmUr4604.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCSAN13kAAZIOQ4ioTw853.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCeATmysAAa9B5LvbS0750.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCqAb7VrAAafYe8mVF8326.jpg;","status":"0;0;0;0;","attrModelId":"19","photoName":"体检报告","updateUserName":";;;;","updatetimes":"1493186141700;1493186141700;1493186141713;1493186141713;"},"IDCardFace":{"arrInfoid":"15270;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsOAGV8pAAnA-W0l7Ng538.jpg","status":"0","attrModelId":"4","photoName":"身份证正面","updateUserName":";","updatetimes":"1493186141747;"},"cooperation":{"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"合作协议","updateUserName":"","updatetimes":""}}
         */

        private UserInfoBean userInfo;
        private double yajing;
        private PhotosBean photos;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public double getYajing() {
            return yajing;
        }

        public void setYajing(double yajing) {
            this.yajing = yajing;
        }

        public PhotosBean getPhotos() {
            return photos;
        }

        public void setPhotos(PhotosBean photos) {
            this.photos = photos;
        }

        public static class UserInfoBean {
            /**
             * isNewRecord : true
             * overProjectNum : 1
             * temporaryDesc :
             * officialDesc :
             * intentionStatus : 1
             * intentionTime : 2017-04-26 13:55:41
             * switchStatus : 0
             * idcard : 513026197602101799
             * depositCash : 12000
             * stageState : 2
             * msgstate : 2
             * userState : 1
             * sex : 1
             * userName : 张雪帮
             * inductionArea : 11
             * mobile : 13911185610
             * inductionDate : 1493136000000
             * approvedesc :
             * bankAccount : 6212260200106103225
             * bankType : 1
             * bankName : 工商银行
             * nameCheckstate : 0
             * idcardCheckstate : 0
             * bankAmountCheckstate : 0
             * bankTypeCheckstate : 0
             * photoCheckstate : 0
             * photoArtCheckstate : 0
             */

            private boolean isNewRecord;
            private String overProjectNum;
            private String temporaryDesc;
            private String officialDesc;
            private int intentionStatus;
            private String intentionTime;
            private int switchStatus;
            private String idcard;
            private int depositCash;
            private int stageState;
            private int msgstate;
            private String userState;
            private int sex;
            private String userName;
            private int inductionArea;
            private String mobile;
            private long inductionDate;
            private String approvedesc;
            private String bankAccount;
            private int bankType;
            private String bankName;
            private int nameCheckstate;
            private int idcardCheckstate;
            private int bankAmountCheckstate;
            private int bankTypeCheckstate;
            private int photoCheckstate;
            private int photoArtCheckstate;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getOverProjectNum() {
                return overProjectNum;
            }

            public void setOverProjectNum(String overProjectNum) {
                this.overProjectNum = overProjectNum;
            }

            public String getTemporaryDesc() {
                return temporaryDesc;
            }

            public void setTemporaryDesc(String temporaryDesc) {
                this.temporaryDesc = temporaryDesc;
            }

            public String getOfficialDesc() {
                return officialDesc;
            }

            public void setOfficialDesc(String officialDesc) {
                this.officialDesc = officialDesc;
            }

            public int getIntentionStatus() {
                return intentionStatus;
            }

            public void setIntentionStatus(int intentionStatus) {
                this.intentionStatus = intentionStatus;
            }

            public String getIntentionTime() {
                return intentionTime;
            }

            public void setIntentionTime(String intentionTime) {
                this.intentionTime = intentionTime;
            }

            public int getSwitchStatus() {
                return switchStatus;
            }

            public void setSwitchStatus(int switchStatus) {
                this.switchStatus = switchStatus;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public int getDepositCash() {
                return depositCash;
            }

            public void setDepositCash(int depositCash) {
                this.depositCash = depositCash;
            }

            public int getStageState() {
                return stageState;
            }

            public void setStageState(int stageState) {
                this.stageState = stageState;
            }

            public int getMsgstate() {
                return msgstate;
            }

            public void setMsgstate(int msgstate) {
                this.msgstate = msgstate;
            }

            public String getUserState() {
                return userState;
            }

            public void setUserState(String userState) {
                this.userState = userState;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getInductionArea() {
                return inductionArea;
            }

            public void setInductionArea(int inductionArea) {
                this.inductionArea = inductionArea;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public long getInductionDate() {
                return inductionDate;
            }

            public void setInductionDate(long inductionDate) {
                this.inductionDate = inductionDate;
            }

            public String getApprovedesc() {
                return approvedesc;
            }

            public void setApprovedesc(String approvedesc) {
                this.approvedesc = approvedesc;
            }

            public String getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(String bankAccount) {
                this.bankAccount = bankAccount;
            }

            public int getBankType() {
                return bankType;
            }

            public void setBankType(int bankType) {
                this.bankType = bankType;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public int getNameCheckstate() {
                return nameCheckstate;
            }

            public void setNameCheckstate(int nameCheckstate) {
                this.nameCheckstate = nameCheckstate;
            }

            public int getIdcardCheckstate() {
                return idcardCheckstate;
            }

            public void setIdcardCheckstate(int idcardCheckstate) {
                this.idcardCheckstate = idcardCheckstate;
            }

            public int getBankAmountCheckstate() {
                return bankAmountCheckstate;
            }

            public void setBankAmountCheckstate(int bankAmountCheckstate) {
                this.bankAmountCheckstate = bankAmountCheckstate;
            }

            public int getBankTypeCheckstate() {
                return bankTypeCheckstate;
            }

            public void setBankTypeCheckstate(int bankTypeCheckstate) {
                this.bankTypeCheckstate = bankTypeCheckstate;
            }

            public int getPhotoCheckstate() {
                return photoCheckstate;
            }

            public void setPhotoCheckstate(int photoCheckstate) {
                this.photoCheckstate = photoCheckstate;
            }

            public int getPhotoArtCheckstate() {
                return photoArtCheckstate;
            }

            public void setPhotoArtCheckstate(int photoArtCheckstate) {
                this.photoArtCheckstate = photoArtCheckstate;
            }
        }

        public static class PhotosBean {
            /**
             * bankCardFace : {"arrInfoid":"15272;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsqABb11AAoiGfHFetY315.jpg","status":"0","attrModelId":"9","photoName":"银行卡正面","updateUserName":";","updatetimes":"1493186141760;"}
             * art : {"arrInfoid":"1335","url":"http://img9.rxjy.com:9120/image/0005wKgBtFkkVGiAQCyhAADzM0JSlHI851.jpg","status":"0","attrModelId":"41","photoName":"艺术照","updateUserName":";","updatetimes":"1495553511363;"}
             * relieve : {"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"解除协议","updateUserName":"","updatetimes":""}
             * bankCardIdentity : {"arrInfoid":"15273;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMs2ASflxAAoGEuQLouc314.jpg","status":"0","attrModelId":"11","photoName":"银行卡反面","updateUserName":";","updatetimes":"1493186141760;"}
             * cooperationWill : {"arrInfoid":"15259;15260;15261;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMxiAWTlnAAcEK0-Fq84020.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMxyASZYyAAdlro9TZS0811.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMx-AeFSoAAVEFrFEQu0995.jpg;","status":"0;0;0;","attrModelId":"17","photoName":"合作意向书","updateUserName":";;;","updatetimes":"1493186141653;1493186141683;1493186141700;"}
             * IDCardIdentity : {"arrInfoid":"15271;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMseAdapnAAoKJZ0TDy8404.jpg","status":"0","attrModelId":"8","photoName":"身份证反面","updateUserName":";","updatetimes":"1493186141747;"}
             * sincerity : {"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"诚信协议","updateUserName":"","updatetimes":""}
             * quality : {"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"质量协议","updateUserName":"","updatetimes":""}
             * security : {"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"安全协议","updateUserName":"","updatetimes":""}
             * visualize : {"arrInfoid":"1335;","url":"http://img9.rxjy.com:9120/image/0150wKgB8FkANGmAT6WwAABasK7lR7k220.jpg","status":"0","attrModelId":"40","photoName":"形象照","updateUserName":";","updatetimes":"1495553511363;"}
             * examination : {"arrInfoid":"15262;15263;15264;15265;","url":"http://img9.rxjy.com/image/0150wKgB8FkANCGALZMdAAbMFmrmUr4604.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCSAN13kAAZIOQ4ioTw853.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCeATmysAAa9B5LvbS0750.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCqAb7VrAAafYe8mVF8326.jpg;","status":"0;0;0;0;","attrModelId":"19","photoName":"体检报告","updateUserName":";;;;","updatetimes":"1493186141700;1493186141700;1493186141713;1493186141713;"}
             * IDCardFace : {"arrInfoid":"15270;","url":"http://img9.rxjy.com/image/0150wKgB8FkAMsOAGV8pAAnA-W0l7Ng538.jpg","status":"0","attrModelId":"4","photoName":"身份证正面","updateUserName":";","updatetimes":"1493186141747;"}
             * cooperation : {"arrInfoid":"","url":"","status":"","attrModelId":"","photoName":"合作协议","updateUserName":"","updatetimes":""}
             */

            private BankCardFaceBean bankCardFace;
            private ArtBean art;
            private RelieveBean relieve;
            private BankCardIdentityBean bankCardIdentity;
            private CooperationWillBean cooperationWill;
            private IDCardIdentityBean IDCardIdentity;
            private SincerityBean sincerity;
            private QualityBean quality;
            private SecurityBean security;
            private VisualizeBean visualize;
            private ExaminationBean examination;
            private IDCardFaceBean IDCardFace;
            private CooperationBean cooperation;

            public BankCardFaceBean getBankCardFace() {
                return bankCardFace;
            }

            public void setBankCardFace(BankCardFaceBean bankCardFace) {
                this.bankCardFace = bankCardFace;
            }

            public ArtBean getArt() {
                return art;
            }

            public void setArt(ArtBean art) {
                this.art = art;
            }

            public RelieveBean getRelieve() {
                return relieve;
            }

            public void setRelieve(RelieveBean relieve) {
                this.relieve = relieve;
            }

            public BankCardIdentityBean getBankCardIdentity() {
                return bankCardIdentity;
            }

            public void setBankCardIdentity(BankCardIdentityBean bankCardIdentity) {
                this.bankCardIdentity = bankCardIdentity;
            }

            public CooperationWillBean getCooperationWill() {
                return cooperationWill;
            }

            public void setCooperationWill(CooperationWillBean cooperationWill) {
                this.cooperationWill = cooperationWill;
            }

            public IDCardIdentityBean getIDCardIdentity() {
                return IDCardIdentity;
            }

            public void setIDCardIdentity(IDCardIdentityBean IDCardIdentity) {
                this.IDCardIdentity = IDCardIdentity;
            }

            public SincerityBean getSincerity() {
                return sincerity;
            }

            public void setSincerity(SincerityBean sincerity) {
                this.sincerity = sincerity;
            }

            public QualityBean getQuality() {
                return quality;
            }

            public void setQuality(QualityBean quality) {
                this.quality = quality;
            }

            public SecurityBean getSecurity() {
                return security;
            }

            public void setSecurity(SecurityBean security) {
                this.security = security;
            }

            public VisualizeBean getVisualize() {
                return visualize;
            }

            public void setVisualize(VisualizeBean visualize) {
                this.visualize = visualize;
            }

            public ExaminationBean getExamination() {
                return examination;
            }

            public void setExamination(ExaminationBean examination) {
                this.examination = examination;
            }

            public IDCardFaceBean getIDCardFace() {
                return IDCardFace;
            }

            public void setIDCardFace(IDCardFaceBean IDCardFace) {
                this.IDCardFace = IDCardFace;
            }

            public CooperationBean getCooperation() {
                return cooperation;
            }

            public void setCooperation(CooperationBean cooperation) {
                this.cooperation = cooperation;
            }

            public static class BankCardFaceBean {
                /**
                 * arrInfoid : 15272;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkAMsqABb11AAoiGfHFetY315.jpg
                 * status : 0
                 * attrModelId : 9
                 * photoName : 银行卡正面
                 * updateUserName : ;
                 * updatetimes : 1493186141760;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class ArtBean {
                /**
                 * arrInfoid : 1335
                 * url : http://img9.rxjy.com:9120/image/0005wKgBtFkkVGiAQCyhAADzM0JSlHI851.jpg
                 * status : 0
                 * attrModelId : 41
                 * photoName : 艺术照
                 * updateUserName : ;
                 * updatetimes : 1495553511363;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class RelieveBean {
                /**
                 * arrInfoid :
                 * url :
                 * status :
                 * attrModelId :
                 * photoName : 解除协议
                 * updateUserName :
                 * updatetimes :
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class BankCardIdentityBean {
                /**
                 * arrInfoid : 15273;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkAMs2ASflxAAoGEuQLouc314.jpg
                 * status : 0
                 * attrModelId : 11
                 * photoName : 银行卡反面
                 * updateUserName : ;
                 * updatetimes : 1493186141760;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class CooperationWillBean {
                /**
                 * arrInfoid : 15259;15260;15261;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkAMxiAWTlnAAcEK0-Fq84020.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMxyASZYyAAdlro9TZS0811.jpg;http://img9.rxjy.com/image/0150wKgB8FkAMx-AeFSoAAVEFrFEQu0995.jpg;
                 * status : 0;0;0;
                 * attrModelId : 17
                 * photoName : 合作意向书
                 * updateUserName : ;;;
                 * updatetimes : 1493186141653;1493186141683;1493186141700;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class IDCardIdentityBean {
                /**
                 * arrInfoid : 15271;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkAMseAdapnAAoKJZ0TDy8404.jpg
                 * status : 0
                 * attrModelId : 8
                 * photoName : 身份证反面
                 * updateUserName : ;
                 * updatetimes : 1493186141747;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class SincerityBean {
                /**
                 * arrInfoid :
                 * url :
                 * status :
                 * attrModelId :
                 * photoName : 诚信协议
                 * updateUserName :
                 * updatetimes :
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class QualityBean {
                /**
                 * arrInfoid :
                 * url :
                 * status :
                 * attrModelId :
                 * photoName : 质量协议
                 * updateUserName :
                 * updatetimes :
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class SecurityBean {
                /**
                 * arrInfoid :
                 * url :
                 * status :
                 * attrModelId :
                 * photoName : 安全协议
                 * updateUserName :
                 * updatetimes :
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class VisualizeBean {
                /**
                 * arrInfoid : 1335;
                 * url : http://img9.rxjy.com:9120/image/0150wKgB8FkANGmAT6WwAABasK7lR7k220.jpg
                 * status : 0
                 * attrModelId : 40
                 * photoName : 形象照
                 * updateUserName : ;
                 * updatetimes : 1495553511363;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class ExaminationBean {
                /**
                 * arrInfoid : 15262;15263;15264;15265;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkANCGALZMdAAbMFmrmUr4604.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCSAN13kAAZIOQ4ioTw853.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCeATmysAAa9B5LvbS0750.jpg;http://img9.rxjy.com/image/0150wKgB8FkANCqAb7VrAAafYe8mVF8326.jpg;
                 * status : 0;0;0;0;
                 * attrModelId : 19
                 * photoName : 体检报告
                 * updateUserName : ;;;;
                 * updatetimes : 1493186141700;1493186141700;1493186141713;1493186141713;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class IDCardFaceBean {
                /**
                 * arrInfoid : 15270;
                 * url : http://img9.rxjy.com/image/0150wKgB8FkAMsOAGV8pAAnA-W0l7Ng538.jpg
                 * status : 0
                 * attrModelId : 4
                 * photoName : 身份证正面
                 * updateUserName : ;
                 * updatetimes : 1493186141747;
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }

            public static class CooperationBean {
                /**
                 * arrInfoid :
                 * url :
                 * status :
                 * attrModelId :
                 * photoName : 合作协议
                 * updateUserName :
                 * updatetimes :
                 */

                private String arrInfoid;
                private String url;
                private String status;
                private String attrModelId;
                private String photoName;
                private String updateUserName;
                private String updatetimes;

                public String getArrInfoid() {
                    return arrInfoid;
                }

                public void setArrInfoid(String arrInfoid) {
                    this.arrInfoid = arrInfoid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getAttrModelId() {
                    return attrModelId;
                }

                public void setAttrModelId(String attrModelId) {
                    this.attrModelId = attrModelId;
                }

                public String getPhotoName() {
                    return photoName;
                }

                public void setPhotoName(String photoName) {
                    this.photoName = photoName;
                }

                public String getUpdateUserName() {
                    return updateUserName;
                }

                public void setUpdateUserName(String updateUserName) {
                    this.updateUserName = updateUserName;
                }

                public String getUpdatetimes() {
                    return updatetimes;
                }

                public void setUpdatetimes(String updatetimes) {
                    this.updatetimes = updatetimes;
                }
            }
        }
    }
}
