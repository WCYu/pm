package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ImageShowContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2018/2/24.
 */

public class ImageShowModel implements ImageShowContract.Model{
    @Override
    public Observable<String> getupdateicon(String AttrId, String UId, String Modelid, String imglist) {
        //将照片路径转换为File对象
        File file = new File(imglist);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body = MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getGcApiService()
                .getUpdateIcon(AttrId,UId,Modelid,body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
