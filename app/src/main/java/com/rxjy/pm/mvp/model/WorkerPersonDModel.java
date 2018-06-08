package com.rxjy.pm.mvp.model;

import android.util.Log;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.WorkerPersonDContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2018/2/23.
 */

public class WorkerPersonDModel implements WorkerPersonDContract.Model{
    @Override
    public Observable<String> getData(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getWorkerInfo(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getBankData() {
        return ApiEngine.getInstance().getGcApiService()
                .getBankInfo()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getWorkData() {
        return ApiEngine.getInstance().getGcApiService()
                .getWorkInfo()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getImg(String mobile, String ImgType, List<String> imglist) {
        List<MultipartBody.Part> list = new ArrayList<>();
        Log.e("用来上传的图片：",imglist.toString());

        for (String url : imglist)
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

        return ApiEngine.getInstance().getGcApiService()
                .subImage(mobile,ImgType,list)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getsubmit(String mobile, String IdCard, String BankCard, String Bank, String BankAccountName, String BankAddress, String RegisterPlace, String RefreeMobile, String Job) {
        return ApiEngine.getInstance().getGcApiService()
                .subData(mobile, IdCard, BankCard, Bank, BankAccountName, BankAddress, RegisterPlace, RefreeMobile, Job)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIcon(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getIcon(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }
    @Override
    public Observable<String> getUploadInfo(String mobile) {
        return ApiEngine.getInstance().getGcApiService()
                .getWorkerInfo(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }


//    @Override
//    public Observable<String> getsubmit(String IdCard, String BankCard, String Bank, String BankAccountName, String BankAddress, String RegisterPlace, String RefreeMobile, String Job) {
//        return ApiEngine.getInstance().getGcApiService()
//                .subData(IdCard,BankCard,Bank,BankAccountName,BankAddress,RegisterPlace,RefreeMobile,Job)
//                .compose(RxSchedulers.<String>switchThread());
//    }
}
