package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.SHA;
import com.rxjy.pm.entity.DebugImageJson;
import com.rxjy.pm.entity.DebugJson;
import com.rxjy.pm.mvp.contract.CameraNormalContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/11/20.
 */

public class CameraNormalModel implements CameraNormalContract.Model {
    @Override
    public Observable<String> getDebugData(String orderNo, String eNumber) {

        String timeStamp = App.getTimeStamp();
        String apiSign = "ENumber" + eNumber + "SubItemId" + orderNo + "timeStamp" + timeStamp;
        StringBuffer sb = new StringBuffer();
        sb.append(App.apiKey).append(apiSign).append(App.apiValue);
        apiSign = sb.toString();

        DebugJson.JsonDataBean jsonDataBean = new DebugJson.JsonDataBean();
        jsonDataBean.setApiKey(App.apiKey);
        jsonDataBean.setApiSign(SHA.SHA1(apiSign));
        jsonDataBean.setSubItemId(orderNo);
        jsonDataBean.setTimeStamp(timeStamp);
        jsonDataBean.setENumber(eNumber);
        jsonDataBean.setReason("");
        DebugJson cameraListJson = new DebugJson();
        cameraListJson.setJsonData(jsonDataBean);

        String json = JSONUtils.toString(cameraListJson);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        return ApiEngine.getInstance().getRdApiService()
                .getDebugData(requestBody)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getDebugImageData(String orderNo, String eNumber) {

        String timeStamp = App.getTimeStamp();
        String apiSign = "ENumber" + eNumber + "Flag" + "1" + "SubItemId" + orderNo + "timeStamp" + timeStamp;
        StringBuffer sb = new StringBuffer();
        sb.append(App.apiKey).append(apiSign).append(App.apiValue);
        apiSign = sb.toString();

        DebugImageJson.JsonDataBean jsonDataBean = new DebugImageJson.JsonDataBean();
        jsonDataBean.setApiKey(App.apiKey);
        jsonDataBean.setApiSign(SHA.SHA1(apiSign));
        jsonDataBean.setSubItemId(orderNo);
        jsonDataBean.setTimeStamp(timeStamp);
        jsonDataBean.setENumber(eNumber);
        jsonDataBean.setFlag("1");
        DebugImageJson cameraListJson = new DebugImageJson();
        cameraListJson.setJsonData(jsonDataBean);

        String json = JSONUtils.toString(cameraListJson);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        return ApiEngine.getInstance().getRdApiService()
                .getDebugImageData(requestBody)
                .compose(RxSchedulers.<String>switchThread());
    }
}
