package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ProMoneyDetailContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/17.
 */

public class ProMoneyDetailModel implements ProMoneyDetailContract.Model {
    @Override
    public Observable<String> getProMoneyDetailData(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getProMoneyInfo(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
