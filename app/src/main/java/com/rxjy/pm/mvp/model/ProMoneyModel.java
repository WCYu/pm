package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ProMoneyContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/25.
 */

public class ProMoneyModel implements ProMoneyContract.Model {

    @Override
    public Observable<String> getProMoneyList(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getProMoneyList(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
