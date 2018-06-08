package com.rxjy.pm.fragment;

import java.util.List;

/**
 * Created by asus on 2018/4/2.
 */

public class WorkerInfo {


    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : {"WorkerId":2275,"WorkerName":"郑荣华","Mobile":"15922402046","Sex":"男","Area":"合肥","WorkType":"带班","UserState":null,"WorkMonth":8,"IdCardPositiveUrl":"http://img9.rxjy.com/image/0209wKgBtFli_3eAKxq7AALGhWfIKGM420.png","IdCardPositive":0,"IdCardConUrl":"http://img9.rxjy.com/image/0209wKgBtFli_4KAatJQAALXgMxsAWU632.png","BankPositiveUrl":null,"BankConUrl":null,"IdCard":"342425198310146917","BankCard":"6228480668146795079","Bank":"农业银行","BankId":3,"BankAccountName":null,"BankAddress":null,"Job":"木工","JobId":2,"RegisterPlace":null,"RefereeMobile":"17755101838","IsOperation":true,"ImageType":[{"Url":null,"Type":9,"State":0},{"Url":null,"Type":11,"State":0},{"Url":"http://img9.rxjy.com/image/0209wKgBtFli_3eAKxq7AALGhWfIKGM420.png","Type":4,"State":0},{"Url":"http://img9.rxjy.com/image/0209wKgBtFli_4KAatJQAALXgMxsAWU632.png","Type":8,"State":0},{"Url":"http://img9.rxjy.com:9120/image/0209wKgBtFli_4yAX00uAAB16fBMI6A810.png","Type":12,"State":0}]}
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
         * WorkerId : 2275
         * WorkerName : 郑荣华
         * Mobile : 15922402046
         * Sex : 男
         * Area : 合肥
         * WorkType : 带班
         * UserState : null
         * WorkMonth : 8
         * IdCardPositiveUrl : http://img9.rxjy.com/image/0209wKgBtFli_3eAKxq7AALGhWfIKGM420.png
         * IdCardPositive : 0
         * IdCardConUrl : http://img9.rxjy.com/image/0209wKgBtFli_4KAatJQAALXgMxsAWU632.png
         * BankPositiveUrl : null
         * BankConUrl : null
         * IdCard : 342425198310146917
         * BankCard : 6228480668146795079
         * Bank : 农业银行
         * BankId : 3
         * BankAccountName : null
         * BankAddress : null
         * Job : 木工
         * JobId : 2
         * RegisterPlace : null
         * RefereeMobile : 17755101838
         * IsOperation : true
         * ImageType : [{"Url":null,"Type":9,"State":0},{"Url":null,"Type":11,"State":0},{"Url":"http://img9.rxjy.com/image/0209wKgBtFli_3eAKxq7AALGhWfIKGM420.png","Type":4,"State":0},{"Url":"http://img9.rxjy.com/image/0209wKgBtFli_4KAatJQAALXgMxsAWU632.png","Type":8,"State":0},{"Url":"http://img9.rxjy.com:9120/image/0209wKgBtFli_4yAX00uAAB16fBMI6A810.png","Type":12,"State":0}]
         */

        private int WorkerId;
        private String WorkerName;
        private String Mobile;
        private String Sex;
        private String Area;
        private String WorkType;
        private String UserState;
        private int WorkMonth;
        private String IdCardPositiveUrl;
        private int IdCardPositive;
        private String IdCardConUrl;
        private String BankPositiveUrl;
        private String BankConUrl;
        private String IdCard;
        private String BankCard;
        private String Bank;
        private int BankId;
        private String BankAccountName;
        private String BankAddress;
        private String Job;
        private int JobId;
        private String RegisterPlace;
        private String RefereeMobile;
        private boolean IsOperation;
        private List<ImageTypeBean> ImageType;

        public int getWorkerId() {
            return WorkerId;
        }

        public void setWorkerId(int workerId) {
            WorkerId = workerId;
        }

        public String getWorkerName() {
            return WorkerName;
        }

        public void setWorkerName(String workerName) {
            WorkerName = workerName;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String mobile) {
            Mobile = mobile;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String sex) {
            Sex = sex;
        }

        public String getArea() {
            return Area;
        }

        public void setArea(String area) {
            Area = area;
        }

        public String getWorkType() {
            return WorkType;
        }

        public void setWorkType(String workType) {
            WorkType = workType;
        }

        public String getUserState() {
            return UserState;
        }

        public void setUserState(String userState) {
            UserState = userState;
        }

        public int getWorkMonth() {
            return WorkMonth;
        }

        public void setWorkMonth(int workMonth) {
            WorkMonth = workMonth;
        }

        public String getIdCardPositiveUrl() {
            return IdCardPositiveUrl;
        }

        public void setIdCardPositiveUrl(String idCardPositiveUrl) {
            IdCardPositiveUrl = idCardPositiveUrl;
        }

        public int getIdCardPositive() {
            return IdCardPositive;
        }

        public void setIdCardPositive(int idCardPositive) {
            IdCardPositive = idCardPositive;
        }

        public String getIdCardConUrl() {
            return IdCardConUrl;
        }

        public void setIdCardConUrl(String idCardConUrl) {
            IdCardConUrl = idCardConUrl;
        }

        public String getBankPositiveUrl() {
            return BankPositiveUrl;
        }

        public void setBankPositiveUrl(String bankPositiveUrl) {
            BankPositiveUrl = bankPositiveUrl;
        }

        public String getBankConUrl() {
            return BankConUrl;
        }

        public void setBankConUrl(String bankConUrl) {
            BankConUrl = bankConUrl;
        }

        public String getIdCard() {
            return IdCard;
        }

        public void setIdCard(String idCard) {
            IdCard = idCard;
        }

        public String getBankCard() {
            return BankCard;
        }

        public void setBankCard(String bankCard) {
            BankCard = bankCard;
        }

        public String getBank() {
            return Bank;
        }

        public void setBank(String bank) {
            Bank = bank;
        }

        public int getBankId() {
            return BankId;
        }

        public void setBankId(int bankId) {
            BankId = bankId;
        }

        public String getBankAccountName() {
            return BankAccountName;
        }

        public void setBankAccountName(String bankAccountName) {
            BankAccountName = bankAccountName;
        }

        public String getBankAddress() {
            return BankAddress;
        }

        public void setBankAddress(String bankAddress) {
            BankAddress = bankAddress;
        }

        public String getJob() {
            return Job;
        }

        public void setJob(String job) {
            Job = job;
        }

        public int getJobId() {
            return JobId;
        }

        public void setJobId(int jobId) {
            JobId = jobId;
        }

        public String getRegisterPlace() {
            return RegisterPlace;
        }

        public void setRegisterPlace(String registerPlace) {
            RegisterPlace = registerPlace;
        }

        public String getRefereeMobile() {
            return RefereeMobile;
        }

        public void setRefereeMobile(String refereeMobile) {
            RefereeMobile = refereeMobile;
        }

        public boolean isOperation() {
            return IsOperation;
        }

        public void setOperation(boolean operation) {
            IsOperation = operation;
        }

        public List<ImageTypeBean> getImageType() {
            return ImageType;
        }

        public void setImageType(List<ImageTypeBean> imageType) {
            ImageType = imageType;
        }

        public static class ImageTypeBean {
            /**
             * Url : null
             * Type : 9
             * State : 0
             */

            private String Url;
            private int Type;
            private int State;

            public Object getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }

            public int getState() {
                return State;
            }

            public void setState(int State) {
                this.State = State;
            }
        }
    }
}
