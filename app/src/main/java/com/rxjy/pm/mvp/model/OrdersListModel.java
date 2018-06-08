package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.OrdersListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersListModel implements OrdersListContract.Model {
    @Override
    public Observable<String> getOrdersList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getOrdersList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
