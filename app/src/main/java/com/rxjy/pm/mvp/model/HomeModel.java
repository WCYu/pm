package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.HomeContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/31.
 */

public class HomeModel implements HomeContract.Model {

    @Override
    public Observable<String> getProList(int uid) {
        return ApiEngine.getInstance().getLmApiService()
                .getProList(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
