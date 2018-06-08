package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MatSearchContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/12.
 */

public class MatSearchModel implements MatSearchContract.Model {
    @Override
    public Observable<String> getHotWord() {
        return ApiEngine.getInstance().getGcApiService()
                .getHotWord()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFuzzyInfo(String orderNo, String content) {
        return ApiEngine.getInstance().getGcApiService()
                .getFuzzySearch(orderNo, content)
                .compose(RxSchedulers.<String>switchThread());
    }
}
