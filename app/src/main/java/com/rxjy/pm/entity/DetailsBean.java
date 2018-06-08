package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsBean {

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"ci_Area":"200.00","ca_DecBudgetPrice":"10.00","ci_ClientName":"健健康康快快乐乐过公司","ProjectAddress":null,"ci_RwdId":"19-74872","ci_DesignerName":null,"Mobile":null,"ci_TypeName":"餐饮","CustomerName":"立即","CustomerMobile":"18955531234","pi_Type":3}
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
         * ci_Area : 200.00
         * ca_DecBudgetPrice : 10.00
         * ci_ClientName : 健健康康快快乐乐过公司
         * ProjectAddress : null
         * ci_RwdId : 19-74872
         * ci_DesignerName : null
         * Mobile : null
         * ci_TypeName : 餐饮
         * CustomerName : 立即
         * CustomerMobile : 18955531234
         * pi_Type : 3
         */

        private String ci_Area;
        private String ca_DecBudgetPrice;
        private String ci_ClientName;
        private Object ProjectAddress;
        private String ci_RwdId;
        private Object ci_DesignerName;
        private Object Mobile;
        private String ci_TypeName;
        private String CustomerName;
        private String CustomerMobile;
        private int pi_Type;

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

        public Object getProjectAddress() {
            return ProjectAddress;
        }

        public void setProjectAddress(Object ProjectAddress) {
            this.ProjectAddress = ProjectAddress;
        }

        public String getCi_RwdId() {
            return ci_RwdId;
        }

        public void setCi_RwdId(String ci_RwdId) {
            this.ci_RwdId = ci_RwdId;
        }

        public Object getCi_DesignerName() {
            return ci_DesignerName;
        }

        public void setCi_DesignerName(Object ci_DesignerName) {
            this.ci_DesignerName = ci_DesignerName;
        }

        public Object getMobile() {
            return Mobile;
        }

        public void setMobile(Object Mobile) {
            this.Mobile = Mobile;
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
    }
}
