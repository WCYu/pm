package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.CraftContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public class CraftModel implements CraftContract.Model {
    @Override
    public Observable<String> getCraftList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getCraftList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
