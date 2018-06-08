package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.CodeLoginContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class CodeLoginModel implements CodeLoginContract.Model {
    @Override
    public Observable<String> getTokenByCode(String userNo, String vCode) {
        return ApiEngine.getInstance().getRsApiService()
                .getTokenByCode(userNo, vCode)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginUserInfoByCode(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVCode(String phoneNum) {
        return ApiEngine.getInstance().getRsApiService()
                .getVCodeLogin(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPmUserInfo(String phoneNum) {
        return ApiEngine.getInstance().getGcApiService()
                .getPmUserInfo(phoneNum,1)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginWorkerInfo(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getLoginWorkerInfo(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public void responseWorkerLogin(WorkerInfo.BodyBean data) {

    }
}
