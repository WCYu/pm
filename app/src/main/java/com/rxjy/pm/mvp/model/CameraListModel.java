package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.CameraListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/11/8.
 */

public class CameraListModel implements CameraListContract.Model {
    @Override
    public Observable<String> getUsedCameraList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getCameraList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getUnbindCameraList(int areaID, int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getCameraListByStatus(areaID, uid, 0)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCameraCount(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getCameraCount(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCameraLineStatus(String orderNo) {
        return ApiEngine.getInstance().getZtApiService()
                .getCameraLineStatus(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> unbindAllCamera(int areaID, String orderNo, int uid, String userNo) {
        return ApiEngine.getInstance().getGcApiService()
                .unbindCamera(areaID, orderNo, uid, userNo, "", 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
