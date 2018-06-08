package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/7/11.
 */

public class ProjectInfo implements Serializable {


    /**
     * StatusCode : 1
     * StatusMsg : null
     * Body : [{"OrderNo":"19-80650","CityID":19,"ProName":"同盛美食餐饮装修工程","ProAddr":"天津市河北区如家精选酒店（狮子林大街古文化街店）旁","ProType":2,"State":7,"BeginTime":"2018-05-04T09:10:01.453","BeginFinishTime":"2018-05-10T09:10:01.453","EndTime":"2018-06-08T09:10:01","WorkDays":35,"ProArea":156,"ContractDate":"2018-04-26T00:00:00","UserName":null,"mobile":null,"pm_uid":0,"CarmaCount":0,"isInspection":0,"PushStatus":0,"AwaitStartReady":0,"AwaitSelfTest":0,"AwaitPayment":0,"AwaitMaterial":0,"SupervisorName":"李涛","SupervisorPhone":"15202260608"},{"OrderNo":"19-80113","CityID":19,"ProName":"教育培训办公室内装饰工程办公装修工程","ProAddr":"天津市和平区国际金融中心5F","ProType":1,"State":7,"BeginTime":"2018-04-08T10:20:00.94","BeginFinishTime":"2018-04-14T10:20:00.94","EndTime":"2018-05-10T10:20:00","WorkDays":32,"ProArea":81.2,"ContractDate":"2018-02-28T00:00:00","UserName":null,"mobile":null,"pm_uid":0,"CarmaCount":0,"isInspection":0,"PushStatus":0,"AwaitStartReady":0,"AwaitSelfTest":0,"AwaitPayment":0,"AwaitMaterial":0,"SupervisorName":"李涛","SupervisorPhone":"15202260608"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<Project> Body;

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

    public List<Project> getBody() {
        return Body;
    }

    public void setBody(List<Project> Body) {
        this.Body = Body;
    }

    public static class Project  implements Serializable{
        /**
         * OrderNo : 19-80650
         * CityID : 19
         * ProName : 同盛美食餐饮装修工程
         * ProAddr : 天津市河北区如家精选酒店（狮子林大街古文化街店）旁
         * ProType : 2
         * State : 7
         * BeginTime : 2018-05-04T09:10:01.453
         * BeginFinishTime : 2018-05-10T09:10:01.453
         * EndTime : 2018-06-08T09:10:01
         * WorkDays : 35
         * ProArea : 156.0
         * ContractDate : 2018-04-26T00:00:00
         * UserName : null
         * mobile : null
         * pm_uid : 0
         * CarmaCount : 0
         * isInspection : 0
         * PushStatus : 0
         * AwaitStartReady : 0
         * AwaitSelfTest : 0
         * AwaitPayment : 0
         * AwaitMaterial : 0
         * SupervisorName : 李涛
         * SupervisorPhone : 15202260608
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
        private Object UserName;
        private Object mobile;
        private int pm_uid;
        private int CarmaCount;
        private int isInspection;
        private int PushStatus;
        private int AwaitStartReady;
        private int AwaitSelfTest;
        private int AwaitPayment;
        private int AwaitMaterial;
        private String SupervisorName;
        private String SupervisorPhone;

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

        public Object getUserName() {
            return UserName;
        }

        public void setUserName(Object UserName) {
            this.UserName = UserName;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
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

        public int getPushStatus() {
            return PushStatus;
        }

        public void setPushStatus(int PushStatus) {
            this.PushStatus = PushStatus;
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

        public String getSupervisorName() {
            return SupervisorName;
        }

        public void setSupervisorName(String SupervisorName) {
            this.SupervisorName = SupervisorName;
        }

        public String getSupervisorPhone() {
            return SupervisorPhone;
        }

        public void setSupervisorPhone(String SupervisorPhone) {
            this.SupervisorPhone = SupervisorPhone;
        }
    }
}
