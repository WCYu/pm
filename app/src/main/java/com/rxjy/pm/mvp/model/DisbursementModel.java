package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.DisbursementContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/25.
 */

public class DisbursementModel implements DisbursementContract.Model {
    @Override
    public Observable<String> getDisbursementData(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getDisbursementData(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getDisbursementListData(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getDisbursementList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subDisbursementData(String orderNo, double money, String reason, String fine_id, int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .subDisbursementInfo(orderNo, money, reason, fine_id, uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
