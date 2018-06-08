package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.FefundContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public class FefundModel implements FefundContract.Model {
    @Override
    public Observable<String> getProjectManager(String orderno, int pmuid, int pushstatus, String reason) {
        return ApiEngine.getInstance().getLmApiService()
                .getOperationData(orderno,pmuid,pushstatus,reason)
                .compose(RxSchedulers.<String>switchThread());
    }
}
