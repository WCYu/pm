package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.BankBean;
import com.rxjy.pm.entity.IconBean;
import com.rxjy.pm.entity.ResultBean;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.entity.WorkerPersonDBean;
import com.rxjy.pm.mvp.contract.WorkerPersonDContract;
import com.rxjy.pm.mvp.model.WorkerPersonDModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/2/23.
 */

public class WorkerPersonDPresenter extends WorkerPersonDContract.Presenter{

    public WorkerPersonDPresenter(WorkerPersonDContract.View view) {
        this.mView = view;
        mModel = new WorkerPersonDModel();
    }

    @Override
    public String getUploadInfo(String mobile) {
        Subscription subscribe = mModel.getUploadInfo(mobile)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {

                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("c",s);
                        UploadInfo info = JSONUtils.toObject(s, UploadInfo.class);
                        if (info.getStatusCode() == 1) {
                            UploadInfo.Upload data = info.getBody();
                            mView.getUploadInfo(data);
                        } else {
                            //mView.responseUploadInfoDataError(info.getStatusMsg());
                            mView.responsegetImgDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
        return null;
    }

    @Override
    public void getData(String mobile) {
        Subscription subscribe = mModel.getData(mobile)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("d", "获取工人信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        WorkerPersonDBean info = JSONUtils.toObject(s, WorkerPersonDBean.class);
                               // Log.e("aa",s);
                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetData(info);
                        }else {
                            mView.responsegetDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getBankData() {

        Subscription subscribe = mModel.getBankData()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取工人信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        BankBean info = JSONUtils.toObject(s, BankBean.class);

                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetBankData(info);
                        }else {
                            mView.responsegetBankDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getWorkData() {
        Subscription subscribe = mModel.getWorkData()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取工人信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        BankBean info = JSONUtils.toObject(s, BankBean.class);

                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetWorkData(info);
                        }else {
                            mView.responsegetWorkDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getImg(String mobile, String ImgType, List<String> imglist) {
        Subscription subscribe = mModel.getImg(mobile,ImgType,imglist)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取工人信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("图片上传结果",s);
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetImgData();
                        }else {
                            mView.responsegetImgDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getsubmit(String mobile, String IdCard, String BankCard, String Bank, String BankAccountName, String BankAddress, String RegisterPlace, String RefreeMobile, String Job) {
        Subscription subscribe = mModel.getsubmit(mobile, IdCard, BankCard, Bank, BankAccountName, BankAddress, RegisterPlace, RefreeMobile, Job)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "资料上传失败信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("资料上传结果",s);
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetSubmitData();
                        }else {
                            mView.responsegetSubmitDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getIcon(String mobile) {
        Subscription subscribe = mModel.getIcon(mobile)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取头像失败信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("获取头像结果",s);
                        IconBean info = JSONUtils.toObject(s, IconBean.class);
                        if (info.getStatusCode() == 1) {//成功
                            mView.responsegetIconData(info);
                        }else {
                            mView.responsegetIconDataError("网络不给力！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
