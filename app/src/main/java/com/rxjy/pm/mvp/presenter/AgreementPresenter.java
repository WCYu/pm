package com.rxjy.pm.mvp.presenter;

import android.graphics.Picture;
import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PictureInfo;
import com.rxjy.pm.entity.ProInfo;
import com.rxjy.pm.entity.SuccessfulBean;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.mvp.model.AgreementModel;
import com.rxjy.pm.mvp.model.ReceiptModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/26.
 */

public class AgreementPresenter extends AgreementContract.Presenter {
    public static final String TAG = "ReceiptPresenter";

    public AgreementPresenter(AgreementContract.View mView) {
        this.mView = mView;
        mModel = new AgreementModel();
    }

    @Override
    public void getgetPackageData(String orderno) {
        Subscription subscribe = mModel.getPackageData(orderno)
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
                        Log.e("", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("发包=====", s);

                        PictureInfo info = JSONUtils.toObject(s, PictureInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.getAgreementImage(info.getBody().get(0));
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getSecurityData(String orderno) {
        Subscription subscribe = mModel.getSecurityData(orderno)
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
                        Log.e("", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("生成=====", s);

                        PictureInfo info = JSONUtils.toObject(s, PictureInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.getAgreementImage(info.getBody().get(0));
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getAdministrationData(String orderno) {
        Subscription subscribe = mModel.getAdministrationData(orderno)
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
                        Log.e("", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("管理=====", s);

                        PictureInfo info = JSONUtils.toObject(s, PictureInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.getAgreementImage(info.getBody().get(0));
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getProjectManager(String orderno, int pmuid, int pushstatus, String reason) {
        Subscription subscribe = mModel.getProjectManager(orderno, pmuid,pushstatus,reason)
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
                        Log.e("lrj", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("lrj成功", s);

                        SuccessfulBean info = JSONUtils.toObject(s, SuccessfulBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.getSuccessfulOperation();
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
