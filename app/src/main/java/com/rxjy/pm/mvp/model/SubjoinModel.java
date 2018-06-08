package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubjoinJson;
import com.rxjy.pm.mvp.contract.SubjoinContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/18.
 */

public class SubjoinModel implements SubjoinContract.Model {
    @Override
    public Observable<String> updSubjoin(String orderNo, int userID, String subSubjoinPrice) {

        SubjoinJson info = new SubjoinJson();
        info.setOrderNo(orderNo);
        info.setUserID(userID);
        info.setIsRemark(1);
        info.setRemark(subSubjoinPrice);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updSubjoin(body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
