package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.SHA;
import com.rxjy.pm.entity.CameraAbnormalJson;
import com.rxjy.pm.mvp.contract.CameraAbnormalContract;
import com.rxjy.pm.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/11/17.
 */

public class CameraAbnormalModel implements CameraAbnormalContract.Model {
    @Override
    public Observable<String> getCraftAbnormalList(String orderNo, String eNumber) {

        String timeStamp = App.getTimeStamp();
        String apiSign = "ENumber" + eNumber + "SubItemId" + orderNo + "timeStamp" + timeStamp;
        StringBuffer sb = new StringBuffer();
        sb.append(App.apiKey).append(apiSign).append(App.apiValue);
        apiSign = sb.toString();

        CameraAbnormalJson.JsonDataBean jsonDataBean = new CameraAbnormalJson.JsonDataBean();
        jsonDataBean.setApiKey(App.apiKey);
        jsonDataBean.setApiSign(SHA.SHA1(apiSign));
        jsonDataBean.setSubItemId(orderNo);
        jsonDataBean.setTimeStamp(timeStamp);
        jsonDataBean.setENumber(eNumber);
        CameraAbnormalJson cameraAbnormalListJson = new CameraAbnormalJson();
        cameraAbnormalListJson.setJsonData(jsonDataBean);

        String json = JSONUtils.toString(cameraAbnormalListJson);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        return ApiEngine.getInstance().getRdApiService()
                .getCameraAbnormalList(requestBody)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> unbindCamera(int areaID, String orderNo, int uid, String userNo, String eNumber) {
        return ApiEngine.getInstance().getGcApiService()
                .unbindCamera(areaID, orderNo, uid, userNo, eNumber, 1)
                .compose(RxSchedulers.<String>switchThread());
    }
}
