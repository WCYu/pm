package com.rxjy.pm.mvp.model;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.SuggestContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/9/22.
 */

public class SuggestModel implements SuggestContract.Model {
    @Override
    public Observable<String> subSuggestInfo(int uid, int type, String content, List<LocalMedia> imgList) {

        List<MultipartBody.Part> list = new ArrayList<>();

        for (LocalMedia info : imgList) {
            //将照片路径转换为File对象
            File file = new File(info.getCompressPath());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);
            list.add(body);
        }

        return ApiEngine.getInstance().getGcApiService()
                .subSuggestInfo(uid, 101, type, content, list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
