package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.EnvironmentContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/15.
 */

public class EnvironmentModel implements EnvironmentContract.Model {
    @Override
    public Observable<String> getEnvironmentList(String orderNo, int xjID) {
        return ApiEngine.getInstance().getGcApiService()
                .getEnvironmentList(orderNo, xjID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
