package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.DisbursementStandardContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public class DisbursementStandardModel implements DisbursementStandardContract.Model {
    @Override
    public Observable<String> getDisbursementState(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getDisbursementState(orderNo, 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
