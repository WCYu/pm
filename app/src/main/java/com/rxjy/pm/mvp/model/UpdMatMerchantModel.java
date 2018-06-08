package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.UpdMatJson;
import com.rxjy.pm.mvp.contract.UpdMatMerchantContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/13.
 */

public class UpdMatMerchantModel implements UpdMatMerchantContract.Model {
    @Override
    public Observable<String> getMerchantList(String matID) {
        return ApiEngine.getInstance().getGcApiService()
                .getMatMerchantList(matID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updMerchant(String orderNo, String matID, int userID, double count, int isChecked) {

        UpdMatJson info = new UpdMatJson(orderNo, matID, userID, count, isChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updMatMerchantInfo(body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
