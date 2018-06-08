package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.OrdersDetailInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.OrdersDetailContract;
import com.rxjy.pm.mvp.model.OrdersDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/20.
 */

public class OrdersDetailPresenter extends OrdersDetailContract.Presenter {

    public static final String TAG = "OrdersDetailPresenter";

    public OrdersDetailPresenter(OrdersDetailContract.View mView) {
        this.mView = mView;
        mModel = new OrdersDetailModel();
    }

    @Override
    public void getOrdersDetail(String orderID) {
        Subscription subscribe = mModel.getOrdersDetail(orderID)
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
                        Log.e(TAG, "获取订单详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        OrdersDetailInfo info = JSONUtils.toObject(s, OrdersDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            OrdersDetailInfo.OrdersDetail data = info.getBody();
                            List<OrdersDetailInfo.OrdersDetail.ListMatBean> matList = data.getListMat();
                            List<OrdersDetailInfo.OrdersDetail.ListMoneyBean> otherList = data.getListMoney();
                            List<String> imgList = data.getListPhoto();
                            OrdersDetailInfo.OrdersDetail.EvaluateOrderBean eData = data.getEvaluateOrder();
                            mView.responseOrdersDetailData(data);
                            mView.responseOrdersDetailMat(matList);
                            mView.responseOrdersDetailSubjoin(otherList);
                            mView.responseOrderDetailEvaluate(eData);
                            mView.responseOrdersDetailImage(imgList);
                        } else {
                            mView.responseOrdersDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void confirmOrders(String orderID) {
        Subscription subscribe = mModel.confirmOrders(orderID)
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
                        Log.e(TAG, "确认收货失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseConfirmOrders();
                        } else {
                            mView.responseConfirmOrdersError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
