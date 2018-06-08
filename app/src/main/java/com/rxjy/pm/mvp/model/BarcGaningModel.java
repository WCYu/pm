package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.BarcGaningContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by asus on 2018/5/16.
 */

public class BarcGaningModel implements BarcGaningContract.Model {
    @Override
    public Observable<String> getProjectManager(String orderno, int pmuid, int pushstatus, String reason,  List<String> imglist) {
        List<MultipartBody.Part> list = new ArrayList<>();
        for (String url : imglist){
            //将照片路径转换为File对象
            File file = new File(url);
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("files", file.getName(), requestFile);
            list.add(body);
        }
        return ApiEngine.getInstance().getLmApiService()
                .getBarGainingData(orderno,pmuid,pushstatus,reason,list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
