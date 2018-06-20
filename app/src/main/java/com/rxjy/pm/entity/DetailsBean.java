package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsBean {


    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"ci_Area":"0.00","ca_DecBudgetPrice":"0.00","ci_ClientName":"木木十八","ProjectAddress":null,"ci_RwdId":"11-180598","ci_DesignerName":null,"ci_DesignerPhone":null,"ci_TypeName":"商业","CustomerName":"木木十八","CustomerMobile":"18862227485","pi_Type":7,"JoinOrderPayment":[{"PayId":3,"OrderId":"11-180598","Period":1,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-05-30T00:00:00","CreateTime":"2018-06-19T19:25:01.76","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":4,"OrderId":"11-180598","Period":2,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-05T00:00:00","CreateTime":"2018-06-19T19:25:01.773","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0},{"PayId":5,"OrderId":"11-180598","Period":3,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-05T00:00:00","CreateTime":"2018-06-19T19:25:01.773","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":6,"OrderId":"11-180598","Period":1,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:25:49.837","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":7,"OrderId":"11-180598","Period":2,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:25:49.853","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":8,"OrderId":"11-180598","Period":3,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-14T00:00:00","CreateTime":"2018-06-19T19:25:49.87","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0},{"PayId":9,"OrderId":"11-180598","Period":1,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:26:24.33","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":10,"OrderId":"11-180598","Period":2,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:26:24.343","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":11,"OrderId":"11-180598","Period":3,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-14T00:00:00","CreateTime":"2018-06-19T19:26:24.343","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0}],"OrderState":3,"PaymentType":0,"AdornmentName":null,"AdornmentContractMoney":0,"FireName":null,"FireContractMoney":0,"AirName":null,"AirContractMoney":0,"Remark":null,"ImgUrl":"http://img9.rxjy.com:9192/image/01C3wKgBtFso6DWAeqwgAAGlaAwzx3c731.JPG,"}
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
         * ci_Area : 0.00
         * ca_DecBudgetPrice : 0.00
         * ci_ClientName : 木木十八
         * ProjectAddress : null
         * ci_RwdId : 11-180598
         * ci_DesignerName : null
         * ci_DesignerPhone : null
         * ci_TypeName : 商业
         * CustomerName : 木木十八
         * CustomerMobile : 18862227485
         * pi_Type : 7
         * JoinOrderPayment : [{"PayId":3,"OrderId":"11-180598","Period":1,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-05-30T00:00:00","CreateTime":"2018-06-19T19:25:01.76","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":4,"OrderId":"11-180598","Period":2,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-05T00:00:00","CreateTime":"2018-06-19T19:25:01.773","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0},{"PayId":5,"OrderId":"11-180598","Period":3,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-05T00:00:00","CreateTime":"2018-06-19T19:25:01.773","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":6,"OrderId":"11-180598","Period":1,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:25:49.837","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":7,"OrderId":"11-180598","Period":2,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:25:49.853","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":8,"OrderId":"11-180598","Period":3,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-14T00:00:00","CreateTime":"2018-06-19T19:25:49.87","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0},{"PayId":9,"OrderId":"11-180598","Period":1,"Receivable":300,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:26:24.33","ActualTime":"0001-01-01T00:00:00","Ratio":30,"Type":0,"ID":0},{"PayId":10,"OrderId":"11-180598","Period":2,"Receivable":100,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-13T00:00:00","CreateTime":"2018-06-19T19:26:24.343","ActualTime":"0001-01-01T00:00:00","Ratio":10,"Type":0,"ID":0},{"PayId":11,"OrderId":"11-180598","Period":3,"Receivable":600,"Received":0,"Deduction":0,"EstimatedTime":"2018-06-14T00:00:00","CreateTime":"2018-06-19T19:26:24.343","ActualTime":"0001-01-01T00:00:00","Ratio":60,"Type":0,"ID":0}]
         * OrderState : 3
         * PaymentType : 0
         * AdornmentName : null
         * AdornmentContractMoney : 0.0
         * FireName : null
         * FireContractMoney : 0.0
         * AirName : null
         * AirContractMoney : 0.0
         * Remark : null
         * ImgUrl : http://img9.rxjy.com:9192/image/01C3wKgBtFso6DWAeqwgAAGlaAwzx3c731.JPG,
         */

        private String ci_Area;
        private String ca_DecBudgetPrice;
        private String ci_ClientName;
        private String ProjectAddress;
        private String ci_RwdId;
        private String ci_DesignerName;
        private String ci_DesignerPhone;
        private String ci_TypeName;
        private String CustomerName;
        private String CustomerMobile;
        private int pi_Type;
        private int OrderState;
        private int PaymentType;
        private String AdornmentName;
        private double AdornmentContractMoney;
        private String FireName;
        private double FireContractMoney;
        private String AirName;
        private double AirContractMoney;
        private String Remark;
        private String ImgUrl;
        private List<JoinOrderPaymentBean> JoinOrderPayment;

        public String getCi_Area() {
            return ci_Area;
        }

        public void setCi_Area(String ci_Area) {
            this.ci_Area = ci_Area;
        }

        public String getCa_DecBudgetPrice() {
            return ca_DecBudgetPrice;
        }

        public void setCa_DecBudgetPrice(String ca_DecBudgetPrice) {
            this.ca_DecBudgetPrice = ca_DecBudgetPrice;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getProjectAddress() {
            return ProjectAddress;
        }

        public void setProjectAddress(String ProjectAddress) {
            this.ProjectAddress = ProjectAddress;
        }

        public String getCi_RwdId() {
            return ci_RwdId;
        }

        public void setCi_RwdId(String ci_RwdId) {
            this.ci_RwdId = ci_RwdId;
        }

        public String getCi_DesignerName() {
            return ci_DesignerName;
        }

        public void setCi_DesignerName(String ci_DesignerName) {
            this.ci_DesignerName = ci_DesignerName;
        }

        public String getCi_DesignerPhone() {
            return ci_DesignerPhone;
        }

        public void setCi_DesignerPhone(String ci_DesignerPhone) {
            this.ci_DesignerPhone = ci_DesignerPhone;
        }

        public String getCi_TypeName() {
            return ci_TypeName;
        }

        public void setCi_TypeName(String ci_TypeName) {
            this.ci_TypeName = ci_TypeName;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getCustomerMobile() {
            return CustomerMobile;
        }

        public void setCustomerMobile(String CustomerMobile) {
            this.CustomerMobile = CustomerMobile;
        }

        public int getPi_Type() {
            return pi_Type;
        }

        public void setPi_Type(int pi_Type) {
            this.pi_Type = pi_Type;
        }

        public int getOrderState() {
            return OrderState;
        }

        public void setOrderState(int OrderState) {
            this.OrderState = OrderState;
        }

        public int getPaymentType() {
            return PaymentType;
        }

        public void setPaymentType(int PaymentType) {
            this.PaymentType = PaymentType;
        }

        public String getAdornmentName() {
            return AdornmentName;
        }

        public void setAdornmentName(String AdornmentName) {
            this.AdornmentName = AdornmentName;
        }

        public double getAdornmentContractMoney() {
            return AdornmentContractMoney;
        }

        public void setAdornmentContractMoney(double AdornmentContractMoney) {
            this.AdornmentContractMoney = AdornmentContractMoney;
        }

        public String getFireName() {
            return FireName;
        }

        public void setFireName(String FireName) {
            this.FireName = FireName;
        }

        public double getFireContractMoney() {
            return FireContractMoney;
        }

        public void setFireContractMoney(double FireContractMoney) {
            this.FireContractMoney = FireContractMoney;
        }

        public String getAirName() {
            return AirName;
        }

        public void setAirName(String AirName) {
            this.AirName = AirName;
        }

        public double getAirContractMoney() {
            return AirContractMoney;
        }

        public void setAirContractMoney(double AirContractMoney) {
            this.AirContractMoney = AirContractMoney;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getImgUrl() {
            return ImgUrl;
        }

        public void setImgUrl(String ImgUrl) {
            this.ImgUrl = ImgUrl;
        }

        public List<JoinOrderPaymentBean> getJoinOrderPayment() {
            return JoinOrderPayment;
        }

        public void setJoinOrderPayment(List<JoinOrderPaymentBean> JoinOrderPayment) {
            this.JoinOrderPayment = JoinOrderPayment;
        }

        public static class JoinOrderPaymentBean {
            /**
             * PayId : 3
             * OrderId : 11-180598
             * Period : 1
             * Receivable : 100.0
             * Received : 0.0
             * Deduction : 0.0
             * EstimatedTime : 2018-05-30T00:00:00
             * CreateTime : 2018-06-19T19:25:01.76
             * ActualTime : 0001-01-01T00:00:00
             * Ratio : 10
             * Type : 0
             * ID : 0
             */

            private int PayId;
            private String OrderId;
            private int Period;
            private double Receivable;
            private double Received;
            private double Deduction;
            private String EstimatedTime;
            private String CreateTime;
            private String ActualTime;
            private int Ratio;
            private int Type;
            private int ID;

            public int getPayId() {
                return PayId;
            }

            public void setPayId(int PayId) {
                this.PayId = PayId;
            }

            public String getOrderId() {
                return OrderId;
            }

            public void setOrderId(String OrderId) {
                this.OrderId = OrderId;
            }

            public int getPeriod() {
                return Period;
            }

            public void setPeriod(int Period) {
                this.Period = Period;
            }

            public double getReceivable() {
                return Receivable;
            }

            public void setReceivable(double Receivable) {
                this.Receivable = Receivable;
            }

            public double getReceived() {
                return Received;
            }

            public void setReceived(double Received) {
                this.Received = Received;
            }

            public double getDeduction() {
                return Deduction;
            }

            public void setDeduction(double Deduction) {
                this.Deduction = Deduction;
            }

            public String getEstimatedTime() {
                return EstimatedTime;
            }

            public void setEstimatedTime(String EstimatedTime) {
                this.EstimatedTime = EstimatedTime;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getActualTime() {
                return ActualTime;
            }

            public void setActualTime(String ActualTime) {
                this.ActualTime = ActualTime;
            }

            public int getRatio() {
                return Ratio;
            }

            public void setRatio(int Ratio) {
                this.Ratio = Ratio;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }
        }
    }
}
