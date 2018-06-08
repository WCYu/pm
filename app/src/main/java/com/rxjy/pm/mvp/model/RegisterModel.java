package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.RegisterContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class RegisterModel implements RegisterContract.Model {

    @Override
    public Observable<String> getRegister(String code, String phoneNum, String password, String invitationCode) {
        return ApiEngine.getInstance().getRsApiService()
                .getRegister(code, phoneNum, password, 4, "项目经理", 1, invitationCode)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVerificationCode(String phoneNum) {
        return ApiEngine.getInstance().getRsApiService()
                .getVerificationCode(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getToken(String userNo, String password) {
        return ApiEngine.getInstance().getRsApiService()
                .getToken(userNo, password)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPmUserInfo(String phoneNum) {
        return ApiEngine.getInstance().getGcApiService()
                .getPmUserInfo(phoneNum, 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
