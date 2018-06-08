package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.WorkerMinContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/2.
 */

public class WorkerMinModel implements WorkerMinContract.Model {
    @Override
    public Observable<String> loadPhotoImage(String model) {
        return ApiEngine.getInstance().getGcApiService()
                .getWorkerPhotoImage(model)
                .compose(RxSchedulers.<String>switchThread());
    }
    }

