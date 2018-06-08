package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ShopCartInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/16.
 */

public interface ShopCartContract {

    interface View extends BaseView {

        void responseShopCartData(ShopCartInfo.ShopCart data);

        void responseMerchantData(List<ShopCartInfo.ShopCart.Merchant> dataList);

        void responseShopCartDataError(String msg);

        void responseIsCheckedStatus();

        void responseIsCheckedStatusError(String msg);

        void responseSubjoinData();

        void responseSubJoinDataError(String msg);

        void isCheckedMerchantAll(ShopCartInfo.ShopCart.Merchant data, int type);

        void isCheckedMat(ShopCartInfo.ShopCart.Merchant.Mat data, int type);

        void updMatCount(ShopCartInfo.ShopCart.Merchant.Mat data, int type);

        void updSubjoin(ShopCartInfo.ShopCart.Merchant data, int type);

        void responseUpdMatInfo();

        void responseUpdMatInfoError(String msg);

        void responsePayment();

        void responsePaymentError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getShopCart(
                String orderNo
        );

        Observable<String> updAllCheckedStatus(
                String orderNo,
                int IsChecked
        );

        Observable<String> updAllMerchantCheckedStatus(
                String orderNo,
                int userID,
                int IsChecked
        );

        Observable<String> updAllMatCheckedStatus(
                String orderNo,
                String matID,
                int userID,
                int IsChecked
        );

        Observable<String> updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

        Observable<String> updSubjoin(
                String orderNo,
                int userID,
                String subSubjoinPrice,
                int type
        );

        Observable<String> delMat(
                String orderNo,
                String matID
        );

        Observable<String> payment(
                String orderNo,
                List<ShopCartInfo.ShopCart.Merchant> merList
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getShopCart(
                String orderNo
        );

        public abstract void updAllCheckedStatus(
                String orderNo,
                int IsChecked
        );

        public abstract void updAllMerchantCheckedStatus(
                String orderNo,
                int userID,
                int IsChecked
        );

        public abstract void updAllMatCheckedStatus(
                String orderNo,
                String matID,
                int userID,
                int IsChecked
        );

        public abstract void updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

        public abstract void updSubjoin(
                String orderNo,
                int userID,
                String subSubjoinPrice,
                int type
        );

        public abstract void delMat(
                String orderNo,
                String matID
        );

        public abstract void payment(
                String orderNo,
                List<ShopCartInfo.ShopCart.Merchant> merList
        );

    }

}
