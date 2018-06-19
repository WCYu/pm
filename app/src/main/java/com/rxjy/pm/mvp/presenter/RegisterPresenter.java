package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.mvp.contract.RegisterContract;
import com.rxjy.pm.mvp.model.RegisterModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/27.
 */

public class RegisterPresenter extends RegisterContract.Presenter {

    public static final String TAG = "RegisterPresenter";

    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
        mModel = new RegisterModel();
    }

    @Override
    public void getRegister(String code, String phoneNum, String password, final String invitationCode) {
        Subscription subscribe = mModel.getRegister(code, phoneNum, password, invitationCode)
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
                        Log.e(TAG, "注册失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseRegisterData();
                        } else {
                            mView.responseRegisterError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getVerificationCode(String phoneNum) {
        Subscription subscribe = mModel.getVerificationCode(phoneNum)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取验证码失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {

                        } else {
                            mView.responseVerificationCodeDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getToken(String userNo, String password) {
        Subscription subscribe = mModel.getToken(userNo, password)
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
                        Log.e(TAG, "获取Token失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        TokenInfo info = JSONUtils.toObject(s, TokenInfo.class);
                        if (info.getStatusCode() == 0) {
                            TokenInfo.Token data = info.getBody();
                            mView.responseToken(data);
                        } else {
                            mView.responseTokenError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getLoginUserInfo(String userNo, String token) {
        Subscription subscribe = mModel.getLoginUserInfo(userNo, token)
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
                        Log.e(TAG, "获取个人信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UserInfo info = JSONUtils.toObject(s, UserInfo.class);
                        if (info.getStatusCode() == 0) {
                            UserInfo.User data = info.getBody();
                            mView.responseLogin(data);
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getPmUserInfo(String phoneNum,int id) {
        Subscription subscribe = mModel.getPmUserInfo(phoneNum,id)
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
                        Log.e(TAG, "获取工程人员信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        PmUserInfo info = JSONUtils.toObject(s, PmUserInfo.class);
                        if (info.getStatusCode() == 1) {
                            PmUserInfo.BodyBean data = info.getBody();
                            mView.responsePmUserInfo(data);
                        } else {
                            mView.responsePmUserInfoError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
