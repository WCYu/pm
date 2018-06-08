package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.UpdMatJson;
import com.rxjy.pm.mvp.contract.SearchMatContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/12.
 */

public class SearchMatModel implements SearchMatContract.Model {
    @Override
    public Observable<String> getMatList(String orderNo, String content) {
        return ApiEngine.getInstance().getGcApiService()
                .getSearchMat(orderNo, content)
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

    @Override
    public Observable<String> getFuzzyInfo(String orderNo, String content) {
        return ApiEngine.getInstance().getGcApiService()
                .getFuzzySearch(orderNo, content)
                .compose(RxSchedulers.<String>switchThread());
    }
}
