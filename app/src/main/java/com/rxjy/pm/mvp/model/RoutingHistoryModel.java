package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.RoutingHistoryContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/18.
 */

public class RoutingHistoryModel implements RoutingHistoryContract.Model {
    @Override
    public Observable<String> getRoutingHistoryList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getRoutingHistoryList(orderNo, 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
