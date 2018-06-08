package com.rxjy.pm.entity;

/**
 * Created by AAA on 2018/3/7.
 */

public class ProjectCBean{

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"Id":0,"ta_OrderId":null,"ta_Remarks":null,"ta_Region":0,"ta_Type":0,"ta_SalesmanName":null,"ta_SalesmanCard":null,"ta_SalesmanMoney":0,"ta_DesignerName":null,"ta_DesignerCard":null,"ta_DesignerMoney":0,"ta_SWBossName":null,"ta_SWBossCard":null,"ta_SWBossMoney":0,"ta_ZABossName":null,"ta_ZABossCard":null,"ta_ZABossMoney":0,"ta_XZBossName":null,"ta_XZBossCard":null,"ta_XZBossMoney":0,"ta_CreateTime":"0001-01-01T00:00:00","ta_UpdateTime":"0001-01-01T00:00:00","ta_JinCheng":0,"tb_diqu":0,"ht_Money":0,"ci_RwdId":"11-181550","ci_ClientName":"国泰家和集团","ca_proAttribute":null,"ci_Stage":null,"ci_Area":"1550.00","ca_DecBudgetPrice":"100.00","ci_DesignerName":"刘平","ci_DesignerCard":"01011485","Mobile":"18501091089","ci_TypeName":"办公","CardNo":null,"CustomerName":null,"ci_SalesmanTel":null,"ci_ReceiveTime":null,"u_kahao":null,"u_xingming":null,"u_shouji":null,"ID":0}
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
        private int Id;
        private Object ta_OrderId;
        private Object ta_Remarks;
        private int ta_Region;
        private int ta_Type;
        private Object ta_SalesmanName;
        private Object ta_SalesmanCard;
        private int ta_SalesmanMoney;
        private Object ta_DesignerName;
        private Object ta_DesignerCard;
        private int ta_DesignerMoney;
        private Object ta_SWBossName;
        private Object ta_SWBossCard;
        private int ta_SWBossMoney;
        private Object ta_ZABossName;
        private Object ta_ZABossCard;
        private int ta_ZABossMoney;
        private Object ta_XZBossName;
        private Object ta_XZBossCard;
        private int ta_XZBossMoney;
        private String ta_CreateTime;
        private String ta_UpdateTime;
        private int ta_JinCheng;
        private int tb_diqu;
        private int ht_Money;
        private String ci_RwdId;
        private String ci_ClientName;
        private Object ca_proAttribute;
        private Object ci_Stage;
        private String ci_Area;
        private String ca_DecBudgetPrice;
        private String ci_DesignerName;
        private String ci_DesignerCard;
        private String Mobile;
        private String ci_TypeName;
        private Object CardNo;
        private Object CustomerName;
        private Object ci_SalesmanTel;
        private Object ci_ReceiveTime;
        private Object u_kahao;
        private Object u_xingming;
        private Object u_shouji;
        private int ID;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public Object getTa_OrderId() {
            return ta_OrderId;
        }

        public void setTa_OrderId(Object ta_OrderId) {
            this.ta_OrderId = ta_OrderId;
        }

        public Object getTa_Remarks() {
            return ta_Remarks;
        }

        public void setTa_Remarks(Object ta_Remarks) {
            this.ta_Remarks = ta_Remarks;
        }

        public int getTa_Region() {
            return ta_Region;
        }

        public void setTa_Region(int ta_Region) {
            this.ta_Region = ta_Region;
        }

        public int getTa_Type() {
            return ta_Type;
        }

        public void setTa_Type(int ta_Type) {
            this.ta_Type = ta_Type;
        }

        public Object getTa_SalesmanName() {
            return ta_SalesmanName;
        }

        public void setTa_SalesmanName(Object ta_SalesmanName) {
            this.ta_SalesmanName = ta_SalesmanName;
        }

        public Object getTa_SalesmanCard() {
            return ta_SalesmanCard;
        }

        public void setTa_SalesmanCard(Object ta_SalesmanCard) {
            this.ta_SalesmanCard = ta_SalesmanCard;
        }

        public int getTa_SalesmanMoney() {
            return ta_SalesmanMoney;
        }

        public void setTa_SalesmanMoney(int ta_SalesmanMoney) {
            this.ta_SalesmanMoney = ta_SalesmanMoney;
        }

        public Object getTa_DesignerName() {
            return ta_DesignerName;
        }

        public void setTa_DesignerName(Object ta_DesignerName) {
            this.ta_DesignerName = ta_DesignerName;
        }

        public Object getTa_DesignerCard() {
            return ta_DesignerCard;
        }

        public void setTa_DesignerCard(Object ta_DesignerCard) {
            this.ta_DesignerCard = ta_DesignerCard;
        }

        public int getTa_DesignerMoney() {
            return ta_DesignerMoney;
        }

        public void setTa_DesignerMoney(int ta_DesignerMoney) {
            this.ta_DesignerMoney = ta_DesignerMoney;
        }

        public Object getTa_SWBossName() {
            return ta_SWBossName;
        }

        public void setTa_SWBossName(Object ta_SWBossName) {
            this.ta_SWBossName = ta_SWBossName;
        }

        public Object getTa_SWBossCard() {
            return ta_SWBossCard;
        }

        public void setTa_SWBossCard(Object ta_SWBossCard) {
            this.ta_SWBossCard = ta_SWBossCard;
        }

        public int getTa_SWBossMoney() {
            return ta_SWBossMoney;
        }

        public void setTa_SWBossMoney(int ta_SWBossMoney) {
            this.ta_SWBossMoney = ta_SWBossMoney;
        }

        public Object getTa_ZABossName() {
            return ta_ZABossName;
        }

        public void setTa_ZABossName(Object ta_ZABossName) {
            this.ta_ZABossName = ta_ZABossName;
        }

        public Object getTa_ZABossCard() {
            return ta_ZABossCard;
        }

        public void setTa_ZABossCard(Object ta_ZABossCard) {
            this.ta_ZABossCard = ta_ZABossCard;
        }

        public int getTa_ZABossMoney() {
            return ta_ZABossMoney;
        }

        public void setTa_ZABossMoney(int ta_ZABossMoney) {
            this.ta_ZABossMoney = ta_ZABossMoney;
        }

        public Object getTa_XZBossName() {
            return ta_XZBossName;
        }

        public void setTa_XZBossName(Object ta_XZBossName) {
            this.ta_XZBossName = ta_XZBossName;
        }

        public Object getTa_XZBossCard() {
            return ta_XZBossCard;
        }

        public void setTa_XZBossCard(Object ta_XZBossCard) {
            this.ta_XZBossCard = ta_XZBossCard;
        }

        public int getTa_XZBossMoney() {
            return ta_XZBossMoney;
        }

        public void setTa_XZBossMoney(int ta_XZBossMoney) {
            this.ta_XZBossMoney = ta_XZBossMoney;
        }

        public String getTa_CreateTime() {
            return ta_CreateTime;
        }

        public void setTa_CreateTime(String ta_CreateTime) {
            this.ta_CreateTime = ta_CreateTime;
        }

        public String getTa_UpdateTime() {
            return ta_UpdateTime;
        }

        public void setTa_UpdateTime(String ta_UpdateTime) {
            this.ta_UpdateTime = ta_UpdateTime;
        }

        public int getTa_JinCheng() {
            return ta_JinCheng;
        }

        public void setTa_JinCheng(int ta_JinCheng) {
            this.ta_JinCheng = ta_JinCheng;
        }

        public int getTb_diqu() {
            return tb_diqu;
        }

        public void setTb_diqu(int tb_diqu) {
            this.tb_diqu = tb_diqu;
        }

        public int getHt_Money() {
            return ht_Money;
        }

        public void setHt_Money(int ht_Money) {
            this.ht_Money = ht_Money;
        }

        public String getCi_RwdId() {
            return ci_RwdId;
        }

        public void setCi_RwdId(String ci_RwdId) {
            this.ci_RwdId = ci_RwdId;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public Object getCa_proAttribute() {
            return ca_proAttribute;
        }

        public void setCa_proAttribute(Object ca_proAttribute) {
            this.ca_proAttribute = ca_proAttribute;
        }

        public Object getCi_Stage() {
            return ci_Stage;
        }

        public void setCi_Stage(Object ci_Stage) {
            this.ci_Stage = ci_Stage;
        }

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

        public String getCi_DesignerName() {
            return ci_DesignerName;
        }

        public void setCi_DesignerName(String ci_DesignerName) {
            this.ci_DesignerName = ci_DesignerName;
        }

        public String getCi_DesignerCard() {
            return ci_DesignerCard;
        }

        public void setCi_DesignerCard(String ci_DesignerCard) {
            this.ci_DesignerCard = ci_DesignerCard;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getCi_TypeName() {
            return ci_TypeName;
        }

        public void setCi_TypeName(String ci_TypeName) {
            this.ci_TypeName = ci_TypeName;
        }

        public Object getCardNo() {
            return CardNo;
        }

        public void setCardNo(Object CardNo) {
            this.CardNo = CardNo;
        }

        public Object getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(Object CustomerName) {
            this.CustomerName = CustomerName;
        }

        public Object getCi_SalesmanTel() {
            return ci_SalesmanTel;
        }

        public void setCi_SalesmanTel(Object ci_SalesmanTel) {
            this.ci_SalesmanTel = ci_SalesmanTel;
        }

        public Object getCi_ReceiveTime() {
            return ci_ReceiveTime;
        }

        public void setCi_ReceiveTime(Object ci_ReceiveTime) {
            this.ci_ReceiveTime = ci_ReceiveTime;
        }

        public Object getU_kahao() {
            return u_kahao;
        }

        public void setU_kahao(Object u_kahao) {
            this.u_kahao = u_kahao;
        }

        public Object getU_xingming() {
            return u_xingming;
        }

        public void setU_xingming(Object u_xingming) {
            this.u_xingming = u_xingming;
        }

        public Object getU_shouji() {
            return u_shouji;
        }

        public void setU_shouji(Object u_shouji) {
            this.u_shouji = u_shouji;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}
