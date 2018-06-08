package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MainContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/20.
 */

public class MainModel implements MainContract.Model {
    @Override
    public Observable<String> getVersionInfo() {
        return ApiEngine.getInstance().getGcApiService()
                .getVersionInfo()
                .compose(RxSchedulers.<String>switchThread());
    }
}
