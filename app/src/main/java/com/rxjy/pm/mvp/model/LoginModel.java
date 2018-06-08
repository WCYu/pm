package com.rxjy.pm.mvp.model;

import android.util.Log;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.LoginContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;


/**
 * Created by AAA on 2017/7/27.
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<String> getToken(String userNo, String password) {
        return ApiEngine.getInstance().getRsApiService()
                .getToken(userNo, password)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        Log.e("tag","actionapi/apphome/GetUserMessageuserNo"+userNo+"     "+token);
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());

    }

    @Override
    public Observable<String> getLoginWorkerInfo(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getLoginWorkerInfo(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPmUserInfo(String phoneNum) {
        return ApiEngine.getInstance().getGcApiService()
                .getPmUserInfo(phoneNum,1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
