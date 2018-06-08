package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.CodeLoginContract;
import com.rxjy.pm.mvp.model.CodeLoginModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/27.
 */

public class CodeLoginPresenter extends CodeLoginContract.Presenter {

    public static final String TAG = "CodeLoginPresenter";

    public CodeLoginPresenter(CodeLoginContract.View mView) {
        this.mView = mView;
        mModel = new CodeLoginModel();
    }

    @Override
    public void getTokenByCode(String userNo, String vCode) {
       // Log.e(TAG,userNo+vCode);
        Subscription subscribe = mModel.getTokenByCode(userNo, vCode)
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

                        Log.e(TAG, "验证码获取Token失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("bug",s);
                        TokenInfo info = JSONUtils.toObject(s, TokenInfo.class);

                        if (info.getStatusCode() == 0) {
                            TokenInfo.Token data = info.getBody();
                            mView.responseTokenByCode(data);
                        }
                        else {
                            mView.responseTokenByCodeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getLoginUserInfoByCode(String userNo, String token) {
        Subscription subscribe = mModel.getLoginUserInfoByCode(userNo, token)
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
                        Log.e(TAG, "验证码获取用户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("aa",s);
                        UserInfo info = JSONUtils.toObject(s, UserInfo.class);

                        if (info.getStatusCode() == 0) {
                            UserInfo.User data = info.getBody();


                            mView.responseLoginByCode(data);
                        } else {
                            mView.responseLoginByCodeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getVCode(String phoneNum) {
        Subscription subscribe = mModel.getVCode(phoneNum)
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
                            mView.responseVCodeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getPmUserInfo(String phoneNum) {
        Subscription subscribe = mModel.getPmUserInfo(phoneNum)
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
                        //Log.e(TAG,info.getStatusCode()+"");
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

    @Override
    public void getLoginWorkerInfo(String mobile) {
        Subscription subscribe = mModel.getLoginWorkerInfo(mobile)
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

                        Log.e(TAG, "获取工程人员信息.f,.sd,f.sd,f = " + s);

                        WorkerInfo info = JSONUtils.toObject(s, WorkerInfo.class);

                        if (info.getStatusCode() == 1) {
                            WorkerInfo.BodyBean data = info.getBody();
                            mView.responseWorkerLogin(data);
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
