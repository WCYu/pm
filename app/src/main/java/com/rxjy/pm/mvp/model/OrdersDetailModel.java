package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.OrdersDetailContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/20.
 */

public class OrdersDetailModel implements OrdersDetailContract.Model {
    @Override
    public Observable<String> getOrdersDetail(String orderID) {
        return ApiEngine.getInstance().getGcApiService()
                .getOrdersDetail(orderID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> confirmOrders(String orderID) {
        return ApiEngine.getInstance().getGcApiService()
                .confirmOrders(orderID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
