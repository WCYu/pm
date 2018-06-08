package com.rxjy.pm.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/2/23.
 */

public class WorkerPersonDBean {

    private int StatusCode;
    private String StatusMsg;
    private Data Body;

    public WorkerPersonDBean() {
        super();
    }

    @Override
    public String toString() {
        return "WorkerPersonDBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public Data getBody() {
        return Body;
    }

    public void setBody(Data body) {
        Body = body;
    }

    public class Data{

//        "WorkerName":"李飞",
//                "Mobile":"13022102972",
//                "Sex":"男",
//                "Area":"上海",
//                "WorkType":"带班",
//                "UserState":null,
//                "WorkMonth":8,
//                "IdCardPositiveUrl":"http://img9.rxjy.com:80/image/0BCDwKgBtFp8IkuATXbeAALQvnNYT7I072.JPG",
//                "IdCardPositive":0,
//                "IdCardConUrl":"http://img9.rxjy.com:80/image/0BCDwKgBtFp8JHSASxDCAA4np67pRno146.jpg",
//                "BankPositiveUrl":"http://img9.rxjy.com:80/image/0BCAwKgBtFp7sXWAcNWWAA07WJ6GpCM290.jpg",
//                "BankConUrl":null,
//                "IdCard":"130456198706560231",
//                "BankCard":"1111300000000000000",
//                "Bank":"农业银行",
//                "BankId":3,
//                "BankAccountName":"李飞飞",
//                "BankAddress":"余总路支行",
//                "Job":"搬运",
//                "JobId":10,
//                "RegisterPlace":"河北",
//                "RefereeMobile":"13862977955",
//                "IsOperation":true,

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
        private ArrayList<ImageTypeItem> ImageType;

        public Data() {super();
        }

        @Override
        public String toString() {
            return "Data{" +
                    "WorkerName='" + WorkerName + '\'' +
                    ", Mobile='" + Mobile + '\'' +
                    ", Sex='" + Sex + '\'' +
                    ", Area='" + Area + '\'' +
                    ", WorkType='" + WorkType + '\'' +
                    ", UserState='" + UserState + '\'' +
                    ", WorkMonth=" + WorkMonth +
                    ", IdCardPositiveUrl='" + IdCardPositiveUrl + '\'' +
                    ", IdCardPositive=" + IdCardPositive +
                    ", IdCardConUrl='" + IdCardConUrl + '\'' +
                    ", BankPositiveUrl='" + BankPositiveUrl + '\'' +
                    ", BankConUrl='" + BankConUrl + '\'' +
                    ", IdCard='" + IdCard + '\'' +
                    ", BankCard='" + BankCard + '\'' +
                    ", Bank='" + Bank + '\'' +
                    ", BankId=" + BankId +
                    ", BankAccountName='" + BankAccountName + '\'' +
                    ", BankAddress='" + BankAddress + '\'' +
                    ", Job='" + Job + '\'' +
                    ", JobId=" + JobId +
                    ", RegisterPlace='" + RegisterPlace + '\'' +
                    ", RefereeMobile='" + RefereeMobile + '\'' +
                    ", IsOperation=" + IsOperation +
                    ", ImageType=" + ImageType +
                    '}';
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

        public ArrayList<ImageTypeItem> getImageType() {
            return ImageType;
        }

        public void setImageType(ArrayList<ImageTypeItem> imageType) {
            ImageType = imageType;
        }

        public class ImageTypeItem{
            private String Url;
            private int Type;
            private int State;

            public ImageTypeItem() {
                super();
            }

            @Override
            public String toString() {
                return "ImageTypeItem{" +
                        "Url='" + Url + '\'' +
                        ", Type=" + Type +
                        ", State=" + State +
                        '}';
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String url) {
                Url = url;
            }

            public int getType() {
                return Type;
            }

            public void setType(int type) {
                Type = type;
            }

            public int getState() {
                return State;
            }

            public void setState(int state) {
                State = state;
            }
        }


    }
}
