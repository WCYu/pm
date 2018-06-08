package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.PictureContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public class PictureModel implements PictureContract.Model {
    @Override
    public Observable<String> getConstructionPicture(String orderno) {
        return ApiEngine.getInstance().getLmApiService()
                .getConstructionPicture(orderno)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getEffectPicture(String orderno) {
        return ApiEngine.getInstance().getLmApiService()
                .getEffectPicture(orderno)
                .compose(RxSchedulers.<String>switchThread());
    }
}
