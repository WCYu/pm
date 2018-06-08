package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ProcessContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public class ProcessModel implements ProcessContract.Model {
    @Override
    public Observable<String> getProcessList(String orderNo, int flag) {
        return ApiEngine.getInstance().getGcApiService()
                .getProcessList(orderNo, 1, flag)
                .compose(RxSchedulers.<String>switchThread());
    }
}
