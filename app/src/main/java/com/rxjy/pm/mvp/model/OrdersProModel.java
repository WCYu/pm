package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.OrdersProContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersProModel implements OrdersProContract.Model {
    @Override
    public Observable<String> getOrdersPro(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getOrdersPro(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
