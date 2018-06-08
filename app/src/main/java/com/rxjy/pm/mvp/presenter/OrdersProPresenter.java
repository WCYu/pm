package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.OrdersProInfo;
import com.rxjy.pm.mvp.contract.OrdersProContract;
import com.rxjy.pm.mvp.model.OrdersProModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersProPresenter extends OrdersProContract.Presenter {

    public static final String TAG = "OrdersProPresenter";

    public OrdersProPresenter(OrdersProContract.View mView) {
        this.mView = mView;
        mModel = new OrdersProModel();
    }

    @Override
    public void getOrdersPro(int uid) {
        Subscription subscribe = mModel.getOrdersPro(uid)
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
                        Log.e(TAG, "获取材料项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        OrdersProInfo info = JSONUtils.toObject(s, OrdersProInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<OrdersProInfo.OrdersPro> dataList = info.getBody();
                            mView.responseOrdersProData(dataList);
                        } else {
                            mView.responseOrdersProDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
