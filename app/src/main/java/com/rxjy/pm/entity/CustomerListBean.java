package com.rxjy.pm.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/2/28.
 */

public class CustomerListBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public CustomerListBean() {
        super();
    }

    @Override
    public String toString() {
        return "CustomerListBean{" +
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

    public ArrayList<BodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BodyBean> body) {
        Body = body;
    }

    public class BodyBean{
        private int id;
        private int pi_Type;
        private String pi_OrderId;
        private String pi_Number;
        private String pi_Remarks;
        private String pi_ImgUrl;
        private String pi_Name;
        private String pi_DesignerCard;
        private String pi_DesignerName;
        private String pi_DesignerPhone;
        private String pi_UserName;
        private String pi_CreateTime;
        private String pi_UpdateTime;
        private int pi_Amount;
        private int pi_Region;
        private int pi_Uid;
        private int pi_State;
        private int pi_JinCheng;
        private int vi_jtDiffDay;
        private int ID;
        private int jt_State;


        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "id=" + id +
                    ", pi_Type=" + pi_Type +
                    ", pi_OrderId='" + pi_OrderId + '\'' +
                    ", pi_Number='" + pi_Number + '\'' +
                    ", pi_Remarks='" + pi_Remarks + '\'' +
                    ", pi_ImgUrl='" + pi_ImgUrl + '\'' +
                    ", pi_Name='" + pi_Name + '\'' +
                    ", pi_DesignerCard='" + pi_DesignerCard + '\'' +
                    ", pi_DesignerName='" + pi_DesignerName + '\'' +
                    ", pi_DesignerPhone='" + pi_DesignerPhone + '\'' +
                    ", pi_UserName='" + pi_UserName + '\'' +
                    ", pi_CreateTime='" + pi_CreateTime + '\'' +
                    ", pi_UpdateTime='" + pi_UpdateTime + '\'' +
                    ", pi_Amount=" + pi_Amount +
                    ", pi_Region=" + pi_Region +
                    ", pi_Uid=" + pi_Uid +
                    ", pi_State=" + pi_State +
                    ", pi_JinCheng=" + pi_JinCheng +
                    ", vi_jtDiffDay=" + vi_jtDiffDay +
                    ", ID=" + ID +
                    ", jt_State=" + jt_State +
                    '}';
        }

        public int getPi_Type() {
            return pi_Type;
        }

        public void setPi_Type(int pi_Type) {
            this.pi_Type = pi_Type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPi_OrderId() {
            return pi_OrderId;
        }

        public void setPi_OrderId(String pi_OrderId) {
            this.pi_OrderId = pi_OrderId;
        }

        public String getPi_Number() {
            return pi_Number;
        }

        public void setPi_Number(String pi_Number) {
            this.pi_Number = pi_Number;
        }

        public String getPi_Remarks() {
            return pi_Remarks;
        }

        public void setPi_Remarks(String pi_Remarks) {
            this.pi_Remarks = pi_Remarks;
        }

        public String getPi_ImgUrl() {
            return pi_ImgUrl;
        }

        public void setPi_ImgUrl(String pi_ImgUrl) {
            this.pi_ImgUrl = pi_ImgUrl;
        }

        public String getPi_Name() {
            return pi_Name;
        }

        public void setPi_Name(String pi_Name) {
            this.pi_Name = pi_Name;
        }

        public String getPi_DesignerCard() {
            return pi_DesignerCard;
        }

        public void setPi_DesignerCard(String pi_DesignerCard) {
            this.pi_DesignerCard = pi_DesignerCard;
        }

        public String getPi_DesignerName() {
            return pi_DesignerName;
        }

        public void setPi_DesignerName(String pi_DesignerName) {
            this.pi_DesignerName = pi_DesignerName;
        }

        public String getPi_DesignerPhone() {
            return pi_DesignerPhone;
        }

        public void setPi_DesignerPhone(String pi_DesignerPhone) {
            this.pi_DesignerPhone = pi_DesignerPhone;
        }

        public String getPi_UserName() {
            return pi_UserName;
        }

        public void setPi_UserName(String pi_UserName) {
            this.pi_UserName = pi_UserName;
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

        public int getPi_Amount() {
            return pi_Amount;
        }

        public void setPi_Amount(int pi_Amount) {
            this.pi_Amount = pi_Amount;
        }

        public int getPi_Region() {
            return pi_Region;
        }

        public void setPi_Region(int pi_Region) {
            this.pi_Region = pi_Region;
        }

        public int getPi_Uid() {
            return pi_Uid;
        }

        public void setPi_Uid(int pi_Uid) {
            this.pi_Uid = pi_Uid;
        }

        public int getPi_State() {
            return pi_State;
        }

        public void setPi_State(int pi_State) {
            this.pi_State = pi_State;
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

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getJt_State() {
            return jt_State;
        }

        public void setJt_State(int jt_State) {
            this.jt_State = jt_State;
        }
    }

}