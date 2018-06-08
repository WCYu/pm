package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/10/16.
 */

public class ShopCartInfo {

    private int StatusCode;
    private String StatusMsg;
    private ShopCart Body;

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

    public ShopCart getBody() {
        return Body;
    }

    public void setBody(ShopCart Body) {
        this.Body = Body;
    }

    public static class ShopCart {

        private int Checked;
        private List<Merchant> Items;

        public int getChecked() {
            return Checked;
        }

        public void setChecked(int Checked) {
            this.Checked = Checked;
        }

        public List<Merchant> getItems() {
            return Items;
        }

        public void setItems(List<Merchant> Items) {
            this.Items = Items;
        }

        public static class Merchant implements Serializable {

            private int UserID;
            private String UserName;
            private int Checked;
            private String Mobile;
            private String FPrice;
            private String APrice;
            private String PPrice;
            private String OTime;
            private String Remark;
            private List<Mat> Items;
            private String UserPhone;

            public String getUserPhone() {
                return UserPhone;
            }

            public void setUserPhone(String userPhone) {
                UserPhone = userPhone;
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

            public int getChecked() {
                return Checked;
            }

            public void setChecked(int Checked) {
                this.Checked = Checked;
            }

            public String getMobile() {
                return Mobile;
            }

            public void setMobile(String Mobile) {
                this.Mobile = Mobile;
            }

            public String getFPrice() {
                return FPrice;
            }

            public void setFPrice(String FPrice) {
                this.FPrice = FPrice;
            }

            public String getAPrice() {
                return APrice;
            }

            public void setAPrice(String APrice) {
                this.APrice = APrice;
            }

            public String getPPrice() {
                return PPrice;
            }

            public void setPPrice(String PPrice) {
                this.PPrice = PPrice;
            }

            public String getOTime() {
                return OTime;
            }

            public void setOTime(String OTime) {
                this.OTime = OTime;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public List<Mat> getItems() {
                return Items;
            }

            public void setItems(List<Mat> Items) {
                this.Items = Items;
            }

            public static class Mat implements Serializable {
                /**
                 * UserID : 347
                 * MatID : dfc2cd7b-8ccd-46a1-a8aa-315b70858b67
                 * MID : 6f8db558-53fa-4c14-b34e-8ced9fcae888
                 * BrandName : 邦鑫
                 * MatName : 钢化玻璃平开门（含安装，不含五金）
                 * MatSpec : 厚度12mm
                 * UnitName : 扇
                 * MatPrice : 800.00
                 * BuyCount : 1.00
                 * IsChecked : 1
                 * PhotoUrl :
                 */

                private int UserID;
                private String MatID;
                private String MID;
                private String BrandName;
                private String MatName;
                private String MatSpec;
                private String UnitName;
                private String MatPrice;
                private String BuyCount;
                private int IsChecked;
                private String PhotoUrl;

                public int getUserID() {
                    return UserID;
                }

                public void setUserID(int UserID) {
                    this.UserID = UserID;
                }

                public String getMatID() {
                    return MatID;
                }

                public void setMatID(String MatID) {
                    this.MatID = MatID;
                }

                public String getMID() {
                    return MID;
                }

                public void setMID(String MID) {
                    this.MID = MID;
                }

                public String getBrandName() {
                    return BrandName;
                }

                public void setBrandName(String BrandName) {
                    this.BrandName = BrandName;
                }

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

                public String getUnitName() {
                    return UnitName;
                }

                public void setUnitName(String UnitName) {
                    this.UnitName = UnitName;
                }

                public String getMatPrice() {
                    return MatPrice;
                }

                public void setMatPrice(String MatPrice) {
                    this.MatPrice = MatPrice;
                }

                public String getBuyCount() {
                    return BuyCount;
                }

                public void setBuyCount(String BuyCount) {
                    this.BuyCount = BuyCount;
                }

                public int getIsChecked() {
                    return IsChecked;
                }

                public void setIsChecked(int IsChecked) {
                    this.IsChecked = IsChecked;
                }

                public String getPhotoUrl() {
                    return PhotoUrl;
                }

                public void setPhotoUrl(String PhotoUrl) {
                    this.PhotoUrl = PhotoUrl;
                }
            }
        }
    }
}
