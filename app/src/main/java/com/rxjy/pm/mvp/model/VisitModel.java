package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.VisitContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/27.
 */

public class VisitModel implements VisitContract.Model {
    @Override
    public Observable<String> getVisit(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getVisit(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subVisit(String orderNo, String content) {
        return ApiEngine.getInstance().getGcApiService()
                .subVisit(orderNo, content)
                .compose(RxSchedulers.<String>switchThread());
    }
}
