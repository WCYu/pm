package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.ShopCartContract;
import com.rxjy.pm.mvp.model.ShopCartModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/16.
 */

public class ShopCartPresenter extends ShopCartContract.Presenter {

    public static final String TAG = "ShopCartPresenter";

    public ShopCartPresenter(ShopCartContract.View mView) {
        this.mView = mView;
        mModel = new ShopCartModel();
    }

    @Override
    public void getShopCart(String orderNo) {
        Subscription subscribe = mModel.getShopCart(orderNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取购物车信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ShopCartInfo info = JSONUtils.toObject(s, ShopCartInfo.class);
                        if (info.getStatusCode() == 1) {
                            ShopCartInfo.ShopCart data = info.getBody();
                            List<ShopCartInfo.ShopCart.Merchant> dataList = new ArrayList<ShopCartInfo.ShopCart.Merchant>();
                            dataList.clear();
                            if (data != null) {
                                dataList.addAll(data.getItems());
                            }
                            mView.responseShopCartData(data);
                            mView.responseMerchantData(dataList);
                        } else {
                            mView.responseShopCartDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updAllCheckedStatus(String orderNo, int IsChecked) {
        Subscription subscribe = mModel.updAllCheckedStatus(orderNo, IsChecked)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "全选失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseIsCheckedStatus();
                        } else {
                            mView.responseIsCheckedStatusError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updAllMerchantCheckedStatus(String orderNo, int userID, int IsChecked) {
        Subscription subscribe = mModel.updAllMerchantCheckedStatus(orderNo, userID, IsChecked)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "全选失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseIsCheckedStatus();
                        } else {
                            mView.responseIsCheckedStatusError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updAllMatCheckedStatus(String orderNo, String matID, int userID, int IsChecked) {
        Subscription subscribe = mModel.updAllMatCheckedStatus(orderNo, matID, userID, IsChecked)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "全选失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseIsCheckedStatus();
                        } else {
                            mView.responseIsCheckedStatusError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updMat(String orderNo, String matID, int userID, double count, int isChecked) {
        Subscription subscribe = mModel.updMat(orderNo, matID, userID, count, isChecked)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "修改材料数量失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUpdMatInfo();
                        } else {
                            mView.responseUpdMatInfoError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updSubjoin(String orderNo, int userID, String subSubjoinPrice, int type) {
        Subscription subscribe = mModel.updSubjoin(orderNo, userID, subSubjoinPrice, type)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "添加附加材料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubjoinData();
                        } else {
                            mView.responseSubJoinDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void delMat(String orderNo, String matID) {
        Subscription subscribe = mModel.delMat(orderNo, matID)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "移除材料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUpdMatInfo();
                        } else {
                            mView.responseUpdMatInfoError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void payment(String orderNo, List<ShopCartInfo.ShopCart.Merchant> merList) {
        Subscription subscribe = mModel.payment(orderNo, merList)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "下单失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responsePayment();
                        } else {
                            mView.responsePaymentError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
