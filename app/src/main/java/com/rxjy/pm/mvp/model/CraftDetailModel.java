package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.CraftDetailContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public class CraftDetailModel implements CraftDetailContract.Model {
    @Override
    public Observable<String> getCraftDetail(int craftID) {
        return ApiEngine.getInstance().getGcApiService()
                .getCraftDetail(craftID, 1)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subCraftDetailPhoto(int craftID, int craftPhotoID, String url) {

        //将照片路径转换为File对象
        File file = new File(url);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getGcApiService()
                .subCraftPhoto(craftID,craftPhotoID,"",1,body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
