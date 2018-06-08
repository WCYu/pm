package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MinContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2018/3/27.
 */

public class MinModel implements MinContract.Model {
    @Override
    public Observable<String> loadPhotoImage(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getPhotoImage(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
