package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MatProListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/20.
 */

public class MatProListModel implements MatProListContract.Model {

    @Override
    public Observable<String> getMatProList(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getMatProList(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
