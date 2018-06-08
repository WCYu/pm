package com.rxjy.pm.mvp.model;

import android.util.Log;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ResultChatContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2018/3/1.
 */

public class ResultChatModel implements ResultChatContract.Model{
    @Override
    public Observable<String> postData(String pi_OrderId, String pi_Remarks, String pi_State, ArrayList<String> imgslist) {
        List<MultipartBody.Part> list = new ArrayList<>();
        Log.e("用来上传的图片：",imgslist.toString());

        for (String url : imgslist)
        {
            //将照片路径转换为File对象
            File file = new File(url);
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);
            list.add(body);
        }

        return ApiEngine.getInstance().getGccApiService()
                .postResultChat(pi_OrderId,pi_Remarks,pi_State,list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
