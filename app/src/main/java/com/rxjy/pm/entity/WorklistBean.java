package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asus on 2018/3/31.
 */

public class WorklistBean {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : [{"OrderNo":"19-71157","CityID":19,"ProName":"优贝乐国际儿童教育中心室内装修工程","ProAddr":"天津市南开区航宇道5号底商","ProType":5,"State":7,"BeginTime":"2017-07-11T00:00:00","BeginFinishTime":"2017-07-17T00:00:00","EndTime":"2017-08-25T00:00:00","WorkDays":45,"ProArea":460,"ContractDate":"2017-06-29T00:00:00","UserName":"李老师","mobile":"13132103766","pm_uid":390,"CarmaCount":0,"isInspection":0,"AwaitStartReady":0,"AwaitSelfTest":0,"AwaitPayment":0,"AwaitMaterial":0,"SupervisorName":null,"SupervisorPhone":null}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean implements Serializable {
        @Override
        public String toString() {
            return "BodyBean{" +
                    "OrderNo='" + OrderNo + '\'' +
                    ", CityID=" + CityID +
                    ", ProName='" + ProName + '\'' +
                    ", ProAddr='" + ProAddr + '\'' +
                    ", ProType=" + ProType +
                    ", State=" + State +
                    ", BeginTime='" + BeginTime + '\'' +
                    ", BeginFinishTime='" + BeginFinishTime + '\'' +
                    ", EndTime='" + EndTime + '\'' +
                    ", WorkDays=" + WorkDays +
                    ", ProArea=" + ProArea +
                    ", ContractDate='" + ContractDate + '\'' +
                    ", UserName='" + UserName + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", pm_uid=" + pm_uid +
                    ", CarmaCount=" + CarmaCount +
                    ", isInspection=" + isInspection +
                    ", AwaitStartReady=" + AwaitStartReady +
                    ", AwaitSelfTest=" + AwaitSelfTest +
                    ", AwaitPayment=" + AwaitPayment +
                    ", AwaitMaterial=" + AwaitMaterial +
                    ", SupervisorName=" + SupervisorName +
                    ", SupervisorPhone=" + SupervisorPhone +
                    '}';
        }

        /**
         * OrderNo : 19-71157
         * CityID : 19
         * ProName : 优贝乐国际儿童教育中心室内装修工程
         * ProAddr : 天津市南开区航宇道5号底商
         * ProType : 5
         * State : 7
         * BeginTime : 2017-07-11T00:00:00
         * BeginFinishTime : 2017-07-17T00:00:00
         * EndTime : 2017-08-25T00:00:00
         * WorkDays : 45
         * ProArea : 460.0
         * ContractDate : 2017-06-29T00:00:00
         * UserName : 李老师
         * mobile : 13132103766
         * pm_uid : 390
         * CarmaCount : 0
         * isInspection : 0
         * AwaitStartReady : 0
         * AwaitSelfTest : 0
         * AwaitPayment : 0
         * AwaitMaterial : 0
         * SupervisorName : null
         * SupervisorPhone : null
         */

        private String OrderNo;
        private int CityID;
        private String ProName;
        private String ProAddr;
        private int ProType;
        private int State;
        private String BeginTime;
        private String BeginFinishTime;
        private String EndTime;
        private int WorkDays;
        private double ProArea;
        private String ContractDate;
        private String UserName;
        private String mobile;
        private int pm_uid;
        private int CarmaCount;
        private int isInspection;
        private int AwaitStartReady;
        private int AwaitSelfTest;
        private int AwaitPayment;
        private int AwaitMaterial;
        private Object SupervisorName;
        private Object SupervisorPhone;

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public int getCityID() {
            return CityID;
        }

        public void setCityID(int CityID) {
            this.CityID = CityID;
        }

        public String getProName() {
            return ProName;
        }

        public void setProName(String ProName) {
            this.ProName = ProName;
        }

        public String getProAddr() {
            return ProAddr;
        }

        public void setProAddr(String ProAddr) {
            this.ProAddr = ProAddr;
        }

        public int getProType() {
            return ProType;
        }

        public void setProType(int ProType) {
            this.ProType = ProType;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public String getBeginTime() {
            return BeginTime;
        }

        public void setBeginTime(String BeginTime) {
            this.BeginTime = BeginTime;
        }

        public String getBeginFinishTime() {
            return BeginFinishTime;
        }

        public void setBeginFinishTime(String BeginFinishTime) {
            this.BeginFinishTime = BeginFinishTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getWorkDays() {
            return WorkDays;
        }

        public void setWorkDays(int WorkDays) {
            this.WorkDays = WorkDays;
        }

        public double getProArea() {
            return ProArea;
        }

        public void setProArea(double ProArea) {
            this.ProArea = ProArea;
        }

        public String getContractDate() {
            return ContractDate;
        }

        public void setContractDate(String ContractDate) {
            this.ContractDate = ContractDate;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getPm_uid() {
            return pm_uid;
        }

        public void setPm_uid(int pm_uid) {
            this.pm_uid = pm_uid;
        }

        public int getCarmaCount() {
            return CarmaCount;
        }

        public void setCarmaCount(int CarmaCount) {
            this.CarmaCount = CarmaCount;
        }

        public int getIsInspection() {
            return isInspection;
        }

        public void setIsInspection(int isInspection) {
            this.isInspection = isInspection;
        }

        public int getAwaitStartReady() {
            return AwaitStartReady;
        }

        public void setAwaitStartReady(int AwaitStartReady) {
            this.AwaitStartReady = AwaitStartReady;
        }

        public int getAwaitSelfTest() {
            return AwaitSelfTest;
        }

        public void setAwaitSelfTest(int AwaitSelfTest) {
            this.AwaitSelfTest = AwaitSelfTest;
        }

        public int getAwaitPayment() {
            return AwaitPayment;
        }

        public void setAwaitPayment(int AwaitPayment) {
            this.AwaitPayment = AwaitPayment;
        }

        public int getAwaitMaterial() {
            return AwaitMaterial;
        }

        public void setAwaitMaterial(int AwaitMaterial) {
            this.AwaitMaterial = AwaitMaterial;
        }

        public Object getSupervisorName() {
            return SupervisorName;
        }

        public void setSupervisorName(Object SupervisorName) {
            this.SupervisorName = SupervisorName;
        }

        public Object getSupervisorPhone() {
            return SupervisorPhone;
        }

        public void setSupervisorPhone(Object SupervisorPhone) {
            this.SupervisorPhone = SupervisorPhone;
        }
    }
}
