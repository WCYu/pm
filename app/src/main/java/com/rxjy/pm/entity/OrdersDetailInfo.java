package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2017/10/20.
 */

public class OrdersDetailInfo {

    private int StatusCode;
    private String StatusMsg;
    private OrdersDetail Body;

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

    public OrdersDetail getBody() {
        return Body;
    }

    public void setBody(OrdersDetail Body) {
        this.Body = Body;
    }

    public static class OrdersDetail {
        /**
         * SendTime :
         * AcceptTime : 2017-10-18
         * StartTime :
         * ApplyTime : 2017-10-19
         * ReceiptTime :
         * PaidTime :
         * OtherMoney : 2000
         * OrderID : b5195049-54b6-4dd4-bba9-d79d59d69006
         * OrderNumber : 22CD0300167
         * UserID : 1363
         * UserName : 樊小英
         * UserPhone : 13086668280
         * UserPhoto : http://img9.rxjy.com:9120/image/007DwKgB8FjJEiKAbBvqAFrSbOXhJ9Y701.jpg
         * OrderState : 8
         * OrderTime : 2017-10-23
         * OrderRemark :
         * TotalMoney : 5827.4
         * ListMat : [{"MatName":"轻钢龙骨","MatSpec":"75竖向（3M/根）","BrandName":"千龙牌/旭洋","UnitName":"根","MatPrice":11.5,"AlreadyCount":69},{"MatName":"轻钢龙骨","MatSpec":"38主骨（3M/根）","BrandName":"旭洋/千龙牌","UnitName":"根","MatPrice":6.8,"AlreadyCount":23},{"MatName":"轻钢龙骨","MatSpec":"75天地（3M/根）","BrandName":"旭洋/千龙牌","UnitName":"根","MatPrice":8.5,"AlreadyCount":23},{"MatName":"多层板","MatSpec":"2440mm*1220mm*12mm","BrandName":"骏马/星佳利","UnitName":"张","MatPrice":98,"AlreadyCount":8},{"MatName":"普通石膏板","MatSpec":"2400mm*1200mm*12mm","BrandName":"泰山","UnitName":"张","MatPrice":36.5,"AlreadyCount":32},{"MatName":"普通石膏板","MatSpec":"2400mm*1200mm*9.5mm","BrandName":"泰山","UnitName":"张","MatPrice":32.5,"AlreadyCount":10},{"MatName":"普通防火岩棉","MatSpec":"厚度50mm","BrandName":"瀚江","UnitName":"平方米","MatPrice":9,"AlreadyCount":45}]
         * ListMoney : [{"Title":"配送费","OtherMoney":500},{"Title":"辅料费","OtherMoney":1000},{"Title":"加工费","OtherMoney":500}]
         * ListPhoto : ["http://img9.rxjy.com:9120/image/0637wKgBtFnoriKAQ7B8AA0lckimFMY369.png","http://img9.rxjy.com:9120/image/0637wKgBtFnoriKACKXUAA69fCB-_xQ105.png"]
         * EvaluateOrder : {"UserID":0,"OrderID":"00000000-0000-0000-0000-000000000000","EvaluateStar":4,"EvaluateReamrk":"回到家就睡觉的睡觉时间","MarkItems":["",""]}
         */

        private String SendTime;
        private String AcceptTime;
        private String StartTime;
        private String ApplyTime;
        private String ReceiptTime;
        private String PaidTime;
        private int OtherMoney;
        private String OrderID;
        private String OrderNumber;
        private int UserID;
        private String UserName;
        private String UserPhone;
        private String UserPhoto;
        private int OrderState;
        private String OrderTime;
        private String OrderRemark;
        private double TotalMoney;
        private EvaluateOrderBean EvaluateOrder;
        private List<ListMatBean> ListMat;
        private List<ListMoneyBean> ListMoney;
        private List<String> ListPhoto;

        public String getSendTime() {
            return SendTime;
        }

        public void setSendTime(String SendTime) {
            this.SendTime = SendTime;
        }

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getApplyTime() {
            return ApplyTime;
        }

        public void setApplyTime(String ApplyTime) {
            this.ApplyTime = ApplyTime;
        }

        public String getReceiptTime() {
            return ReceiptTime;
        }

        public void setReceiptTime(String ReceiptTime) {
            this.ReceiptTime = ReceiptTime;
        }

        public String getPaidTime() {
            return PaidTime;
        }

        public void setPaidTime(String PaidTime) {
            this.PaidTime = PaidTime;
        }

        public int getOtherMoney() {
            return OtherMoney;
        }

        public void setOtherMoney(int OtherMoney) {
            this.OtherMoney = OtherMoney;
        }

        public String getOrderID() {
            return OrderID;
        }

        public void setOrderID(String OrderID) {
            this.OrderID = OrderID;
        }

        public String getOrderNumber() {
            return OrderNumber;
        }

        public void setOrderNumber(String OrderNumber) {
            this.OrderNumber = OrderNumber;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserPhone() {
            return UserPhone;
        }

        public void setUserPhone(String UserPhone) {
            this.UserPhone = UserPhone;
        }

        public String getUserPhoto() {
            return UserPhoto;
        }

        public void setUserPhoto(String UserPhoto) {
            this.UserPhoto = UserPhoto;
        }

        public int getOrderState() {
            return OrderState;
        }

        public void setOrderState(int OrderState) {
            this.OrderState = OrderState;
        }

        public String getOrderTime() {
            return OrderTime;
        }

        public void setOrderTime(String OrderTime) {
            this.OrderTime = OrderTime;
        }

        public String getOrderRemark() {
            return OrderRemark;
        }

        public void setOrderRemark(String OrderRemark) {
            this.OrderRemark = OrderRemark;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public EvaluateOrderBean getEvaluateOrder() {
            return EvaluateOrder;
        }

        public void setEvaluateOrder(EvaluateOrderBean EvaluateOrder) {
            this.EvaluateOrder = EvaluateOrder;
        }

        public List<ListMatBean> getListMat() {
            return ListMat;
        }

        public void setListMat(List<ListMatBean> ListMat) {
            this.ListMat = ListMat;
        }

        public List<ListMoneyBean> getListMoney() {
            return ListMoney;
        }

        public void setListMoney(List<ListMoneyBean> ListMoney) {
            this.ListMoney = ListMoney;
        }

        public List<String> getListPhoto() {
            return ListPhoto;
        }

        public void setListPhoto(List<String> ListPhoto) {
            this.ListPhoto = ListPhoto;
        }

        public static class EvaluateOrderBean {
            /**
             * UserID : 0
             * OrderID : 00000000-0000-0000-0000-000000000000
             * EvaluateStar : 4
             * EvaluateReamrk : 回到家就睡觉的睡觉时间
             * MarkItems : ["",""]
             */

            private int UserID;
            private String OrderID;
            private int EvaluateStar;
            private String EvaluateReamrk;
            private List<String> MarkItems;

            public int getUserID() {
                return UserID;
            }

            public void setUserID(int UserID) {
                this.UserID = UserID;
            }

            public String getOrderID() {
                return OrderID;
            }

            public void setOrderID(String OrderID) {
                this.OrderID = OrderID;
            }

            public int getEvaluateStar() {
                return EvaluateStar;
            }

            public void setEvaluateStar(int EvaluateStar) {
                this.EvaluateStar = EvaluateStar;
            }

            public String getEvaluateReamrk() {
                return EvaluateReamrk;
            }

            public void setEvaluateReamrk(String EvaluateReamrk) {
                this.EvaluateReamrk = EvaluateReamrk;
            }

            public List<String> getMarkItems() {
                return MarkItems;
            }

            public void setMarkItems(List<String> MarkItems) {
                this.MarkItems = MarkItems;
            }
        }

        public static class ListMatBean {
            /**
             * MatName : 轻钢龙骨
             * MatSpec : 75竖向（3M/根）
             * BrandName : 千龙牌/旭洋
             * UnitName : 根
             * MatPrice : 11.5
             * AlreadyCount : 69
             */

            private String MatName;
            private String MatSpec;
            private String BrandName;
            private String UnitName;
            private double MatPrice;
            private double AlreadyCount;

            public String getMatName() {
                return MatName;
            }

            public void setMatName(String MatName) {
                this.MatName = MatName;
            }

            public String getMatSpec() {
                return MatSpec;
            }

            public void setMatSpec(String MatSpec) {
                this.MatSpec = MatSpec;
            }

            public String getBrandName() {
                return BrandName;
            }

            public void setBrandName(String BrandName) {
                this.BrandName = BrandName;
            }

            public String getUnitName() {
                return UnitName;
            }

            public void setUnitName(String UnitName) {
                this.UnitName = UnitName;
            }

            public double getMatPrice() {
                return MatPrice;
            }

            public void setMatPrice(double MatPrice) {
                this.MatPrice = MatPrice;
            }

            public double getAlreadyCount() {
                return AlreadyCount;
            }

            public void setAlreadyCount(double AlreadyCount) {
                this.AlreadyCount = AlreadyCount;
            }
        }

        public static class ListMoneyBean {
            /**
             * Title : 配送费
             * OtherMoney : 500
             */

            private String Title;
            private int OtherMoney;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getOtherMoney() {
                return OtherMoney;
            }

            public void setOtherMoney(int OtherMoney) {
                this.OtherMoney = OtherMoney;
            }
        }
    }
}
