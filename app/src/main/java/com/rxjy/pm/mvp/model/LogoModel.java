package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.LogoContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/1.
 */

public class LogoModel implements LogoContract.Model {
    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPmUserInfo(String phoneNum,int id) {
        return ApiEngine.getInstance().getGcApiService()
                .getPmUserInfo(phoneNum,id)
                .compose(RxSchedulers.<String>switchThread());
    }
    @Override
    public Observable<String> getLoginWorkerInfo(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getLoginWorkerInfo(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }

}
