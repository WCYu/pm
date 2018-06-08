package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PictureInfo;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.mvp.contract.PictureContract;
import com.rxjy.pm.mvp.model.AgreementModel;
import com.rxjy.pm.mvp.model.PictureModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/26.
 */

public class PicturePresenter extends PictureContract.Presenter {
    public static final String TAG = "ReceiptPresenter";

    public PicturePresenter(PictureContract.View mView) {
        this.mView = mView;
        mModel = new PictureModel();
    }
    @Override
    public void getConstructionPicture(String orderno) {
        Subscription subscribe = mModel.getConstructionPicture(orderno)
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
                        Log.e("施工图片=====", s);

                        PictureInfo info = JSONUtils.toObject(s, PictureInfo.class);

                        if (info.getStatusCode() == 1) {
                            mView.responseConstruction(info.getBody());
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getEffectPicture(String orderno) {
        Subscription subscribe = mModel.getEffectPicture(orderno)
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
                        Log.e("效果图片=====", s);

                        PictureInfo info = JSONUtils.toObject(s, PictureInfo.class);

                        if (info.getStatusCode() == 1) {
                            mView.responseConstruction(info.getBody());
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
