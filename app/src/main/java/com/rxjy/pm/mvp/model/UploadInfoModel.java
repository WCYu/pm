package com.rxjy.pm.mvp.model;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.entity.UploadImageInfo;
import com.rxjy.pm.mvp.contract.UploadInfoContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2018/1/30.
 */

public class UploadInfoModel implements UploadInfoContract.Model {
    @Override
    public Observable<String> getUploadInfo(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getUploadInfo(uid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getBankList() {
        return ApiEngine.getInstance().getGcApiService()
                .getBankList()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getRelationList() {
        return ApiEngine.getInstance().getGcApiService()
                .getRelationList()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> uploadInfo(int uid, String name, String idCard, String bankCard, String bankCardMaster, String bankType, String bankAddress, String emergencyName, String emergencyRelation, String mobile, UploadImageInfo data) {

        List<MultipartBody.Part> list = new ArrayList<>();

        if (data.getIcCardUp() != null) {
            //将照片路径转换为File对象
            File file = new File(data.getIcCardUp());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(4 + "", file.getName(), requestFile);
            list.add(body);
        }
        if (data.getIcCardDown() != null) {
            //将照片路径转换为File对象
            File file = new File(data.getIcCardDown());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(8 + "", file.getName(), requestFile);
            list.add(body);
        }
        if (data.getBankCardUp() != null) {
            //将照片路径转换为File对象
            File file = new File(data.getBankCardUp());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(9 + "", file.getName(), requestFile);
            list.add(body);
        }
        if (data.getArtisticPhoto() != null) {
            //将照片路径转换为File对象
            File file = new File(data.getArtisticPhoto());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(1001 + "", file.getName(), requestFile);
            list.add(body);
        }
        if (data.getIdentificationPhoto() != null) {
            //将照片路径转换为File对象
            File file = new File(data.getIdentificationPhoto());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(1000 + "", file.getName(), requestFile);
            list.add(body);
        }
        if (data.getMedicalExaminationReport() != null) {
            for (LocalMedia imgUrl : data.getMedicalExaminationReport()) {
                //将照片路径转换为File对象
                File file = new File(imgUrl.getCompressPath());
                //创建RequestBody ,用于Retrofit2.0上传照片
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                // MultipartBody.Part  和后端约定好Key，这里的partName是用image
                MultipartBody.Part body =
                        MultipartBody.Part.createFormData(19 + "", file.getName(), requestFile);
                list.add(body);
            }
        }

        return ApiEngine.getInstance().getGcApiService()
                .uploadInfo(uid, name, idCard, bankCard, bankCardMaster, bankType, bankAddress, emergencyName, emergencyRelation, mobile, list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
