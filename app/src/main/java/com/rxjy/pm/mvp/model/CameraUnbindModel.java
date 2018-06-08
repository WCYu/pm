package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.SHA;
import com.rxjy.pm.entity.DebugImageJson;
import com.rxjy.pm.entity.DebugJson;
import com.rxjy.pm.mvp.contract.CameraUnbindContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/11/20.
 */

public class CameraUnbindModel implements CameraUnbindContract.Model {
    @Override
    public Observable<String> getAreaList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getAreaList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

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
                .getUnbindDebugData(requestBody)
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

    @Override
    public Observable<String> subCameraInfo(int areaID, String orderNo, String eNumber, String areaName, String url) {
        //压缩图片
        File file = new File(url);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getGcApiService()
                .subCameraInfo(areaID, orderNo, eNumber, areaName, 1, App.pmUserInfo.getUid(), App.cardNo, App.baseInfo.getName(), body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
