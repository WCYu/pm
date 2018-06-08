package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MsgDetailContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgDetailModel implements MsgDetailContract.Model {
    @Override
    public Observable<String> getMsgDetail(int tsID) {
        return ApiEngine.getInstance().getGcApiService()
                .getMsgDetail(tsID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
