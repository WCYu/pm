package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.EvaluateJson;
import com.rxjy.pm.mvp.contract.EvaluateContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public class EvaluateModel implements EvaluateContract.Model {
    @Override
    public Observable<String> getEvaluateMarks(int eType) {
        return ApiEngine.getInstance().getGcApiService()
                .getEvaluateMarks(eType)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subEvaluate(String orderID, int EvaluateStar, String remark, int userID, List<Integer> markItems) {

        EvaluateJson info = new EvaluateJson();

        info.setOrderID(orderID);
        info.setEvaluateStar(EvaluateStar);
        info.setEvaluateReamrk(remark);
        info.setUserID(userID);
        info.setMarkItems(markItems);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .subEvaluate(body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
