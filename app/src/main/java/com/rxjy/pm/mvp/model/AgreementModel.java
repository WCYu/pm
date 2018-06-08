package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public class AgreementModel implements AgreementContract.Model {
    @Override
    public Observable<String> getPackageData(String orderno) {
        return ApiEngine.getInstance().getLmApiService()
                .getDecorationcontract(orderno)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getSecurityData(String orderno) {
        return ApiEngine.getInstance().getLmApiService()
                .getSafetprotocol(orderno)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getAdministrationData(String orderno) {

        return ApiEngine.getInstance().getLmApiService()
                .getSecurityProtocol(orderno)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getProjectManager(String orderno, int pmuid, int pushstatus, String reason) {
        return ApiEngine.getInstance().getLmApiService()
                .getOperationData(orderno,pmuid,pushstatus,reason)
                .compose(RxSchedulers.<String>switchThread());
    }
}
