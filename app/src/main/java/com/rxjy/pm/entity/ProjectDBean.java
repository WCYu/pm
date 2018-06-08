package com.rxjy.pm.entity;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectDBean {


    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"JoinId":0,"pi_OrderId":"20-109947","pi_Type":1,"pi_Number":"20-109947","pi_Remarks":null,"pi_ImgUrl":null,"pi_Name":"天地人和教育集团","pi_Amount":0,"pi_Region":20,"pi_DesignerCard":null,"pi_DesignerName":null,"pi_DesignerPhone":null,"pi_Uid":1349,"pi_UserName":"陈广伟","pi_GrossProfit":0.1,"PMUserSingleTime":"2018-04-11T16:25:06.733","pi_State":2,"pi_CreateTime":"2018-04-11T16:07:32.59","pi_UpdateTime":"2018-04-11T16:07:32.59","pi_JinCheng":1,"vi_jtDiffDay":0,"jt_State":0,"pi_ClientName":null,"pi_ClientPhone":null,"pi_Area":0,"pi_ProjectType":6,"ProjectTwoType":268,"ProjectThreeType":6,"ProjectCity":null,"OfficeLocation":"","CustomerWeiChat":"","CustomerEmail":"","CustomerIdentityType":136,"CustomerFocus":158,"CustomerAgeType":129,"CustomerSex":2,"CustomerContractState":0,"CustomerCharacterType":0,"OrderRemark":null,"ContractMoney":0,"Tax":0,"PublishMoney":0,"OrderFinishTime":null,"FinishTime":"2018-04-12T16:20:19.563","BusinessRatio":0,"BusinessMoney":0,"MainRatio":0,"MainMoney":0,"ManageRatio":0,"ManageMoney":0,"ManagementType":0,"ID":117}
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
         * JoinId : 0
         * pi_OrderId : 20-109947
         * pi_Type : 1
         * pi_Number : 20-109947
         * pi_Remarks : null
         * pi_ImgUrl : null
         * pi_Name : 天地人和教育集团
         * pi_Amount : 0.0
         * pi_Region : 20
         * pi_DesignerCard : null
         * pi_DesignerName : null
         * pi_DesignerPhone : null
         * pi_Uid : 1349
         * pi_UserName : 陈广伟
         * pi_GrossProfit : 0.1
         * PMUserSingleTime : 2018-04-11T16:25:06.733
         * pi_State : 2
         * pi_CreateTime : 2018-04-11T16:07:32.59
         * pi_UpdateTime : 2018-04-11T16:07:32.59
         * pi_JinCheng : 1
         * vi_jtDiffDay : 0
         * jt_State : 0
         * pi_ClientName : null
         * pi_ClientPhone : null
         * pi_Area : 0.0
         * pi_ProjectType : 6
         * ProjectTwoType : 268
         * ProjectThreeType : 6
         * ProjectCity : null
         * OfficeLocation :
         * CustomerWeiChat :
         * CustomerEmail :
         * CustomerIdentityType : 136
         * CustomerFocus : 158
         * CustomerAgeType : 129
         * CustomerSex : 2
         * CustomerContractState : 0
         * CustomerCharacterType : 0
         * OrderRemark : null
         * ContractMoney : 0.0
         * Tax : 0.0
         * PublishMoney : 0.0
         * OrderFinishTime : null
         * FinishTime : 2018-04-12T16:20:19.563
         * BusinessRatio : 0.0
         * BusinessMoney : 0.0
         * MainRatio : 0.0
         * MainMoney : 0.0
         * ManageRatio : 0.0
         * ManageMoney : 0.0
         * ManagementType : 0
         * ID : 117
         */

        private int JoinId;
        private String pi_OrderId;
        private int pi_Type;
        private String pi_Number;
        private Object pi_Remarks;
        private Object pi_ImgUrl;
        private String pi_Name;
        private double pi_Amount;
        private int pi_Region;
        private Object pi_DesignerCard;
        private Object pi_DesignerName;
        private Object pi_DesignerPhone;
        private int pi_Uid;
        private String pi_UserName;
        private double pi_GrossProfit;
        private String PMUserSingleTime;
        private int pi_State;
        private String pi_CreateTime;
        private String pi_UpdateTime;
        private int pi_JinCheng;
        private int vi_jtDiffDay;
        private int jt_State;
        private Object pi_ClientName;
        private Object pi_ClientPhone;
        private double pi_Area;
        private int pi_ProjectType;
        private int ProjectTwoType;
        private int ProjectThreeType;
        private Object ProjectCity;
        private String OfficeLocation;
        private String CustomerWeiChat;
        private String CustomerEmail;
        private int CustomerIdentityType;
        private int CustomerFocus;
        private int CustomerAgeType;
        private int CustomerSex;
        private int CustomerContractState;
        private int CustomerCharacterType;
        private Object OrderRemark;
        private double ContractMoney;
        private double Tax;
        private double PublishMoney;
        private Object OrderFinishTime;
        private String FinishTime;
        private double BusinessRatio;
        private double BusinessMoney;
        private double MainRatio;
        private double MainMoney;
        private double ManageRatio;
        private double ManageMoney;
        private int ManagementType;
        private int ID;

        public int getJoinId() {
            return JoinId;
        }

        public void setJoinId(int JoinId) {
            this.JoinId = JoinId;
        }

        public String getPi_OrderId() {
            return pi_OrderId;
        }

        public void setPi_OrderId(String pi_OrderId) {
            this.pi_OrderId = pi_OrderId;
        }

        public int getPi_Type() {
            return pi_Type;
        }

        public void setPi_Type(int pi_Type) {
            this.pi_Type = pi_Type;
        }

        public String getPi_Number() {
            return pi_Number;
        }

        public void setPi_Number(String pi_Number) {
            this.pi_Number = pi_Number;
        }

        public Object getPi_Remarks() {
            return pi_Remarks;
        }

        public void setPi_Remarks(Object pi_Remarks) {
            this.pi_Remarks = pi_Remarks;
        }

        public Object getPi_ImgUrl() {
            return pi_ImgUrl;
        }

        public void setPi_ImgUrl(Object pi_ImgUrl) {
            this.pi_ImgUrl = pi_ImgUrl;
        }

        public String getPi_Name() {
            return pi_Name;
        }

        public void setPi_Name(String pi_Name) {
            this.pi_Name = pi_Name;
        }

        public double getPi_Amount() {
            return pi_Amount;
        }

        public void setPi_Amount(double pi_Amount) {
            this.pi_Amount = pi_Amount;
        }

        public int getPi_Region() {
            return pi_Region;
        }

        public void setPi_Region(int pi_Region) {
            this.pi_Region = pi_Region;
        }

        public Object getPi_DesignerCard() {
            return pi_DesignerCard;
        }

        public void setPi_DesignerCard(Object pi_DesignerCard) {
            this.pi_DesignerCard = pi_DesignerCard;
        }

        public Object getPi_DesignerName() {
            return pi_DesignerName;
        }

        public void setPi_DesignerName(Object pi_DesignerName) {
            this.pi_DesignerName = pi_DesignerName;
        }

        public Object getPi_DesignerPhone() {
            return pi_DesignerPhone;
        }

        public void setPi_DesignerPhone(Object pi_DesignerPhone) {
            this.pi_DesignerPhone = pi_DesignerPhone;
        }

        public int getPi_Uid() {
            return pi_Uid;
        }

        public void setPi_Uid(int pi_Uid) {
            this.pi_Uid = pi_Uid;
        }

        public String getPi_UserName() {
            return pi_UserName;
        }

        public void setPi_UserName(String pi_UserName) {
            this.pi_UserName = pi_UserName;
        }

        public double getPi_GrossProfit() {
            return pi_GrossProfit;
        }

        public void setPi_GrossProfit(double pi_GrossProfit) {
            this.pi_GrossProfit = pi_GrossProfit;
        }

        public String getPMUserSingleTime() {
            return PMUserSingleTime;
        }

        public void setPMUserSingleTime(String PMUserSingleTime) {
            this.PMUserSingleTime = PMUserSingleTime;
        }

        public int getPi_State() {
            return pi_State;
        }

        public void setPi_State(int pi_State) {
            this.pi_State = pi_State;
        }

        public String getPi_CreateTime() {
            return pi_CreateTime;
        }

        public void setPi_CreateTime(String pi_CreateTime) {
            this.pi_CreateTime = pi_CreateTime;
        }

        public String getPi_UpdateTime() {
            return pi_UpdateTime;
        }

        public void setPi_UpdateTime(String pi_UpdateTime) {
            this.pi_UpdateTime = pi_UpdateTime;
        }

        public int getPi_JinCheng() {
            return pi_JinCheng;
        }

        public void setPi_JinCheng(int pi_JinCheng) {
            this.pi_JinCheng = pi_JinCheng;
        }

        public int getVi_jtDiffDay() {
            return vi_jtDiffDay;
        }

        public void setVi_jtDiffDay(int vi_jtDiffDay) {
            this.vi_jtDiffDay = vi_jtDiffDay;
        }

        public int getJt_State() {
            return jt_State;
        }

        public void setJt_State(int jt_State) {
            this.jt_State = jt_State;
        }

        public Object getPi_ClientName() {
            return pi_ClientName;
        }

        public void setPi_ClientName(Object pi_ClientName) {
            this.pi_ClientName = pi_ClientName;
        }

        public Object getPi_ClientPhone() {
            return pi_ClientPhone;
        }

        public void setPi_ClientPhone(Object pi_ClientPhone) {
            this.pi_ClientPhone = pi_ClientPhone;
        }

        public double getPi_Area() {
            return pi_Area;
        }

        public void setPi_Area(double pi_Area) {
            this.pi_Area = pi_Area;
        }

        public int getPi_ProjectType() {
            return pi_ProjectType;
        }

        public void setPi_ProjectType(int pi_ProjectType) {
            this.pi_ProjectType = pi_ProjectType;
        }

        public int getProjectTwoType() {
            return ProjectTwoType;
        }

        public void setProjectTwoType(int ProjectTwoType) {
            this.ProjectTwoType = ProjectTwoType;
        }

        public int getProjectThreeType() {
            return ProjectThreeType;
        }

        public void setProjectThreeType(int ProjectThreeType) {
            this.ProjectThreeType = ProjectThreeType;
        }

        public Object getProjectCity() {
            return ProjectCity;
        }

        public void setProjectCity(Object ProjectCity) {
            this.ProjectCity = ProjectCity;
        }

        public String getOfficeLocation() {
            return OfficeLocation;
        }

        public void setOfficeLocation(String OfficeLocation) {
            this.OfficeLocation = OfficeLocation;
        }

        public String getCustomerWeiChat() {
            return CustomerWeiChat;
        }

        public void setCustomerWeiChat(String CustomerWeiChat) {
            this.CustomerWeiChat = CustomerWeiChat;
        }

        public String getCustomerEmail() {
            return CustomerEmail;
        }

        public void setCustomerEmail(String CustomerEmail) {
            this.CustomerEmail = CustomerEmail;
        }

        public int getCustomerIdentityType() {
            return CustomerIdentityType;
        }

        public void setCustomerIdentityType(int CustomerIdentityType) {
            this.CustomerIdentityType = CustomerIdentityType;
        }

        public int getCustomerFocus() {
            return CustomerFocus;
        }

        public void setCustomerFocus(int CustomerFocus) {
            this.CustomerFocus = CustomerFocus;
        }

        public int getCustomerAgeType() {
            return CustomerAgeType;
        }

        public void setCustomerAgeType(int CustomerAgeType) {
            this.CustomerAgeType = CustomerAgeType;
        }

        public int getCustomerSex() {
            return CustomerSex;
        }

        public void setCustomerSex(int CustomerSex) {
            this.CustomerSex = CustomerSex;
        }

        public int getCustomerContractState() {
            return CustomerContractState;
        }

        public void setCustomerContractState(int CustomerContractState) {
            this.CustomerContractState = CustomerContractState;
        }

        public int getCustomerCharacterType() {
            return CustomerCharacterType;
        }

        public void setCustomerCharacterType(int CustomerCharacterType) {
            this.CustomerCharacterType = CustomerCharacterType;
        }

        public Object getOrderRemark() {
            return OrderRemark;
        }

        public void setOrderRemark(Object OrderRemark) {
            this.OrderRemark = OrderRemark;
        }

        public double getContractMoney() {
            return ContractMoney;
        }

        public void setContractMoney(double ContractMoney) {
            this.ContractMoney = ContractMoney;
        }

        public double getTax() {
            return Tax;
        }

        public void setTax(double Tax) {
            this.Tax = Tax;
        }

        public double getPublishMoney() {
            return PublishMoney;
        }

        public void setPublishMoney(double PublishMoney) {
            this.PublishMoney = PublishMoney;
        }

        public Object getOrderFinishTime() {
            return OrderFinishTime;
        }

        public void setOrderFinishTime(Object OrderFinishTime) {
            this.OrderFinishTime = OrderFinishTime;
        }

        public String getFinishTime() {
            return FinishTime;
        }

        public void setFinishTime(String FinishTime) {
            this.FinishTime = FinishTime;
        }

        public double getBusinessRatio() {
            return BusinessRatio;
        }

        public void setBusinessRatio(double BusinessRatio) {
            this.BusinessRatio = BusinessRatio;
        }

        public double getBusinessMoney() {
            return BusinessMoney;
        }

        public void setBusinessMoney(double BusinessMoney) {
            this.BusinessMoney = BusinessMoney;
        }

        public double getMainRatio() {
            return MainRatio;
        }

        public void setMainRatio(double MainRatio) {
            this.MainRatio = MainRatio;
        }

        public double getMainMoney() {
            return MainMoney;
        }

        public void setMainMoney(double MainMoney) {
            this.MainMoney = MainMoney;
        }

        public double getManageRatio() {
            return ManageRatio;
        }

        public void setManageRatio(double ManageRatio) {
            this.ManageRatio = ManageRatio;
        }

        public double getManageMoney() {
            return ManageMoney;
        }

        public void setManageMoney(double ManageMoney) {
            this.ManageMoney = ManageMoney;
        }

        public int getManagementType() {
            return ManagementType;
        }

        public void setManagementType(int ManagementType) {
            this.ManagementType = ManagementType;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}
