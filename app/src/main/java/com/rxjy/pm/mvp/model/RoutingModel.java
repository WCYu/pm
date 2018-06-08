package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.RoutingContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/28.
 */

public class RoutingModel implements RoutingContract.Model {
    @Override
    public Observable<String> getRoutingList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getRoutingList(orderNo, 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
