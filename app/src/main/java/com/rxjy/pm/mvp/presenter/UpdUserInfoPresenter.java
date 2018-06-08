package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.UpdUserInfoContract;
import com.rxjy.pm.mvp.model.UpdUserInfoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/28.
 */

public class UpdUserInfoPresenter extends UpdUserInfoContract.Presenter {

    public static final String TAG = "UpdUserInfoPresenter";

    public UpdUserInfoPresenter(UpdUserInfoContract.View mView) {
        this.mView = mView;
        mModel = new UpdUserInfoModel();
    }

    @Override
    public void updateUserInfo(String token, String cardNo, String key, String value) {
        Subscription subscribe = mModel.updateUserInfo(token, cardNo, key, value)
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
                        Log.e(TAG, "修改用户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseUpdateData();
                        } else if (info.getStatusCode() == 104) {
                            mView.reLogin(info.getStatusMsg());
                        } else {
                            mView.responseUpdateDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upHeaderPicture(String token, String cardNo, String picturePath) {
        Subscription subscribe = mModel.upHeaderPicture(token, cardNo, picturePath)
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
                        Log.e(TAG, "上传头像失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseUpPicture();
                        } else if (info.getStatusCode() == 104) {
                            mView.reLogin(info.getStatusMsg());
                        } else {
                            mView.responseUpPictureError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
