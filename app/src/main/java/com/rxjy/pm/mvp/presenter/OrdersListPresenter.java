package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.OrdersListInfo;
import com.rxjy.pm.mvp.contract.OrdersListContract;
import com.rxjy.pm.mvp.model.OrdersListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersListPresenter extends OrdersListContract.Presenter {

    public static final String TAG = "OrdersListPresenter";

    public OrdersListPresenter(OrdersListContract.View mView) {
        this.mView = mView;
        mModel = new OrdersListModel();
    }

    @Override
    public void getOrdersList(String orderNo) {
        Subscription subscribe = mModel.getOrdersList(orderNo)
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
                        Log.e(TAG, "获取订单列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        OrdersListInfo info = JSONUtils.toObject(s, OrdersListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<OrdersListInfo.OrdersList> dataList = info.getBody();
                            mView.responseOrdersListData(dataList);
                        } else {
                            mView.responseOrdersListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
