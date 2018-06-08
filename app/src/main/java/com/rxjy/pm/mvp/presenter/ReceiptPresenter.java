package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ConfirmationInfo;
import com.rxjy.pm.entity.ProInfo;
import com.rxjy.pm.entity.ResultBean;
import com.rxjy.pm.entity.SuccessfulBean;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.mvp.contract.RegisterContract;
import com.rxjy.pm.mvp.model.ReceiptModel;
import com.rxjy.pm.mvp.model.RegisterModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/26.
 */

public class ReceiptPresenter extends ReceiptContract.Presenter {

    public static final String TAG = "ReceiptPresenter";

    public ReceiptPresenter(ReceiptContract.View mView) {
        this.mView = mView;
        mModel = new ReceiptModel();
    }

    @Override
    public void getReceipt(String orderno, int pmuid) {
        Subscription subscribe = mModel.getReceipt(orderno, pmuid)
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
                        Log.e("获取项目详情成功=====", s);

                        ProInfo info = JSONUtils.toObject(s, ProInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseProInfo(info.getBody());
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getReceiptConfirmation(String orderno, int pmuid) {
        Subscription subscribe = mModel.getReceiptConfirmation(orderno, pmuid)
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
                        Log.e("获取项目确认资料详情成功=====", s);

                        ConfirmationInfo info = JSONUtils.toObject(s, ConfirmationInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseConfirmationInfo(info.getBody());
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
                        Log.e("", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("项目经理操作成功=====", s);

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
