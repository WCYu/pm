package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 阿禹 on 2018/6/5.
 */

public class XiangMuInfoBean {

    /**
     * statusMsg : success
     * statusCode : 1
     * body : {"userInfo":{"isNewRecord":true,"overProjectNum":"1","temporaryDesc":"","officialDesc":"","intentionStatus":1,"intentionTime":"2017-04-26 13:55:41","switchStatus":0,"idcard":"513026197602101799","depositCash":12000,"stageState":2,"msgstate":2,"userState":"1","sex":1,"userName":"张雪帮","inductionArea":11,"mobile":"13911185610","inductionDate":1493136000000,"approvedesc":"","bankAccount":"6212260200106103225","bankType":1,"bankName":"工商银行","nameCheckstate":0,"idcardCheckstate":0,"bankAmountCheckstate":0,"bankTypeCheckstate":0,"photoCheckstate":0,"photoArtCheckstate":0},"userinfoProject":[{"isNewRecord":true,"proId":"9","name":"南磨房社区卫生服务中心等17家公共卫生单位及医疗机构维修改造工程（第5包）","address":"朝阳区来广营红军营东路","customerName":"朝阳区卫生局","proMoney":"35426.0000","phone":"13911185610","uId":"1335","area":"0.00","company":"","witnessName":"","witnessPhone":"","aduitState":"0","uid":"1335"},{"isNewRecord":true,"proId":"10","name":"2015年学校食堂建设项目第一批第二标段（北师大奥林匹克花园小学）","address":"北京市朝阳区富力又一城","customerName":"朝阳教委","proMoney":"135548.0000","phone":"13911185610","uId":"1335","area":"0.00","company":"","witnessName":"","witnessPhone":"","aduitState":"2","uid":"1335"}],"userinfoEvaluate":{"isNewRecord":true,"uId":"1335","projectQuality":0,"customerEvaluation":0,"managementAbility":0,"userCharacter":0,"communicationSkills":1,"enterpriseRecognition":1,"credibility":0,"moralCharacter":1,"workerCooperation":0,"uid":"1335"},"userinfoProjectMsg":[{"isNewRecord":true,"aduitState":"1","dicname":"油工","workerName":"李怀堂","idcard":"513722197902041559","pmWorkerobile":"13521179001","realUrl":"http://img9.rxjy.com/image/0142wKgB8Fj9oDSAfKJmAAcvSuQz-6U935.jpg","workerid":789},{"isNewRecord":true,"aduitState":"1","dicname":"瓦工","workerName":"高中于","idcard":"512225197430281014","pmWorkerobile":"18310440554","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oJiAPE4SAAcvSuQz-6U210.jpg","workerid":790},{"isNewRecord":true,"aduitState":"1","dicname":"木工","workerName":"何为","idcard":"513026197407091679","pmWorkerobile":"18301055963","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oMyAcs7PAAcvSuQz-6U561.jpg","workerid":791},{"isNewRecord":true,"aduitState":"1","dicname":"电工","workerName":"李江城","idcard":"513026197512181756","pmWorkerobile":"18382831207","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oSqAKs-iAAcvSuQz-6U766.jpg","workerid":792},{"isNewRecord":true,"aduitState":"1","dicname":"水工","workerName":"梁广彩","idcard":"513028196705058031","pmWorkerobile":"13641381178","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9ocqAbOD9AAcvSuQz-6U011.jpg","workerid":793}]}
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
         * userinfoProject : [{"isNewRecord":true,"proId":"9","name":"南磨房社区卫生服务中心等17家公共卫生单位及医疗机构维修改造工程（第5包）","address":"朝阳区来广营红军营东路","customerName":"朝阳区卫生局","proMoney":"35426.0000","phone":"13911185610","uId":"1335","area":"0.00","company":"","witnessName":"","witnessPhone":"","aduitState":"0","uid":"1335"},{"isNewRecord":true,"proId":"10","name":"2015年学校食堂建设项目第一批第二标段（北师大奥林匹克花园小学）","address":"北京市朝阳区富力又一城","customerName":"朝阳教委","proMoney":"135548.0000","phone":"13911185610","uId":"1335","area":"0.00","company":"","witnessName":"","witnessPhone":"","aduitState":"2","uid":"1335"}]
         * userinfoEvaluate : {"isNewRecord":true,"uId":"1335","projectQuality":0,"customerEvaluation":0,"managementAbility":0,"userCharacter":0,"communicationSkills":1,"enterpriseRecognition":1,"credibility":0,"moralCharacter":1,"workerCooperation":0,"uid":"1335"}
         * userinfoProjectMsg : [{"isNewRecord":true,"aduitState":"1","dicname":"油工","workerName":"李怀堂","idcard":"513722197902041559","pmWorkerobile":"13521179001","realUrl":"http://img9.rxjy.com/image/0142wKgB8Fj9oDSAfKJmAAcvSuQz-6U935.jpg","workerid":789},{"isNewRecord":true,"aduitState":"1","dicname":"瓦工","workerName":"高中于","idcard":"512225197430281014","pmWorkerobile":"18310440554","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oJiAPE4SAAcvSuQz-6U210.jpg","workerid":790},{"isNewRecord":true,"aduitState":"1","dicname":"木工","workerName":"何为","idcard":"513026197407091679","pmWorkerobile":"18301055963","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oMyAcs7PAAcvSuQz-6U561.jpg","workerid":791},{"isNewRecord":true,"aduitState":"1","dicname":"电工","workerName":"李江城","idcard":"513026197512181756","pmWorkerobile":"18382831207","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9oSqAKs-iAAcvSuQz-6U766.jpg","workerid":792},{"isNewRecord":true,"aduitState":"1","dicname":"水工","workerName":"梁广彩","idcard":"513028196705058031","pmWorkerobile":"13641381178","realUrl":"http://img9.rxjy.com/image/0143wKgB8Fj9ocqAbOD9AAcvSuQz-6U011.jpg","workerid":793}]
         */

        private UserInfoBean userInfo;

        private List<UserinfoProjectBean> userinfoProject;
        private List<UserinfoProjectMsgBean> userinfoProjectMsg;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public List<UserinfoProjectBean> getUserinfoProject() {
            return userinfoProject;
        }

        public void setUserinfoProject(List<UserinfoProjectBean> userinfoProject) {
            this.userinfoProject = userinfoProject;
        }

        public List<UserinfoProjectMsgBean> getUserinfoProjectMsg() {
            return userinfoProjectMsg;
        }

        public void setUserinfoProjectMsg(List<UserinfoProjectMsgBean> userinfoProjectMsg) {
            this.userinfoProjectMsg = userinfoProjectMsg;
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

        public static class UserinfoEvaluateBean {
            /**
             * isNewRecord : true
             * uId : 1335
             * projectQuality : 0
             * customerEvaluation : 0
             * managementAbility : 0
             * userCharacter : 0
             * communicationSkills : 1
             * enterpriseRecognition : 1
             * credibility : 0
             * moralCharacter : 1
             * workerCooperation : 0
             * uid : 1335
             */

            private boolean isNewRecord;
            private String uId;
            private int projectQuality;
            private int customerEvaluation;
            private int managementAbility;
            private int userCharacter;
            private int communicationSkills;
            private int enterpriseRecognition;
            private int credibility;
            private int moralCharacter;
            private int workerCooperation;
            private String uid;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getUId() {
                return uId;
            }

            public void setUId(String uId) {
                this.uId = uId;
            }

            public int getProjectQuality() {
                return projectQuality;
            }

            public void setProjectQuality(int projectQuality) {
                this.projectQuality = projectQuality;
            }

            public int getCustomerEvaluation() {
                return customerEvaluation;
            }

            public void setCustomerEvaluation(int customerEvaluation) {
                this.customerEvaluation = customerEvaluation;
            }

            public int getManagementAbility() {
                return managementAbility;
            }

            public void setManagementAbility(int managementAbility) {
                this.managementAbility = managementAbility;
            }

            public int getUserCharacter() {
                return userCharacter;
            }

            public void setUserCharacter(int userCharacter) {
                this.userCharacter = userCharacter;
            }

            public int getCommunicationSkills() {
                return communicationSkills;
            }

            public void setCommunicationSkills(int communicationSkills) {
                this.communicationSkills = communicationSkills;
            }

            public int getEnterpriseRecognition() {
                return enterpriseRecognition;
            }

            public void setEnterpriseRecognition(int enterpriseRecognition) {
                this.enterpriseRecognition = enterpriseRecognition;
            }

            public int getCredibility() {
                return credibility;
            }

            public void setCredibility(int credibility) {
                this.credibility = credibility;
            }

            public int getMoralCharacter() {
                return moralCharacter;
            }

            public void setMoralCharacter(int moralCharacter) {
                this.moralCharacter = moralCharacter;
            }

            public int getWorkerCooperation() {
                return workerCooperation;
            }

            public void setWorkerCooperation(int workerCooperation) {
                this.workerCooperation = workerCooperation;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }

        public static class UserinfoProjectBean implements Serializable{
            /**
             * isNewRecord : true
             * proId : 9
             * name : 南磨房社区卫生服务中心等17家公共卫生单位及医疗机构维修改造工程（第5包）
             * address : 朝阳区来广营红军营东路
             * customerName : 朝阳区卫生局
             * proMoney : 35426.0000
             * phone : 13911185610
             * uId : 1335
             * area : 0.00
             * company :
             * witnessName :
             * witnessPhone :
             * aduitState : 0
             * uid : 1335
             */

            private boolean isNewRecord;
            private String proId;
            private String name;
            private String address;
            private String customerName;
            private String proMoney;
            private String phone;
            private String uId;
            private String area;
            private String company;
            private String witnessName;
            private String witnessPhone;
            private String aduitState;
            private String uid;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getProId() {
                return proId;
            }

            public void setProId(String proId) {
                this.proId = proId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getProMoney() {
                return proMoney;
            }

            public void setProMoney(String proMoney) {
                this.proMoney = proMoney;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getUId() {
                return uId;
            }

            public void setUId(String uId) {
                this.uId = uId;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getWitnessName() {
                return witnessName;
            }

            public void setWitnessName(String witnessName) {
                this.witnessName = witnessName;
            }

            public String getWitnessPhone() {
                return witnessPhone;
            }

            public void setWitnessPhone(String witnessPhone) {
                this.witnessPhone = witnessPhone;
            }

            public String getAduitState() {
                return aduitState;
            }

            public void setAduitState(String aduitState) {
                this.aduitState = aduitState;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }

        public static class UserinfoProjectMsgBean implements Serializable{
            /**
             * isNewRecord : true
             * aduitState : 1
             * dicname : 油工
             * workerName : 李怀堂
             * idcard : 513722197902041559
             * pmWorkerobile : 13521179001
             * realUrl : http://img9.rxjy.com/image/0142wKgB8Fj9oDSAfKJmAAcvSuQz-6U935.jpg
             * workerid : 789
             */

            private boolean isNewRecord;
            private String aduitState;
            private String dicname;
            private String workerName;
            private String idcard;
            private String pmWorkerobile;
            private String realUrl;
            private int workerid;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getAduitState() {
                return aduitState;
            }

            public void setAduitState(String aduitState) {
                this.aduitState = aduitState;
            }

            public String getDicname() {
                return dicname;
            }

            public void setDicname(String dicname) {
                this.dicname = dicname;
            }

            public String getWorkerName() {
                return workerName;
            }

            public void setWorkerName(String workerName) {
                this.workerName = workerName;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public String getPmWorkerobile() {
                return pmWorkerobile;
            }

            public void setPmWorkerobile(String pmWorkerobile) {
                this.pmWorkerobile = pmWorkerobile;
            }

            public String getRealUrl() {
                return realUrl;
            }

            public void setRealUrl(String realUrl) {
                this.realUrl = realUrl;
            }

            public int getWorkerid() {
                return workerid;
            }

            public void setWorkerid(int workerid) {
                this.workerid = workerid;
            }
        }
    }
}
