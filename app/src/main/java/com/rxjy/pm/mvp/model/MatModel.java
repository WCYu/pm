package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.UpdMatJson;
import com.rxjy.pm.mvp.contract.MatContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/10.
 */

public class MatModel implements MatContract.Model {
    @Override
    public Observable<String> getFirstMat(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getFirstMat(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getSecondMat(String orderNo, String treeID) {
        return ApiEngine.getInstance().getGcApiService()
                .getSecondMat(orderNo, treeID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMatList(String orderNo, String treeID, String treeTwo) {
        return ApiEngine.getInstance().getGcApiService()
                .getMatList(orderNo, treeID, treeTwo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMatMoneyInfo(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getMatMoneyInfo(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updMat(String orderNo, String matID, int userID, double count, int isChecked) {

        UpdMatJson info = new UpdMatJson(orderNo, matID, userID, count, isChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updMat(body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
