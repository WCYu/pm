package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.VisitProListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public class VisitProListModel implements VisitProListContract.Model {
    @Override
    public Observable<String> getVisitProList(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getVisitProList(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
