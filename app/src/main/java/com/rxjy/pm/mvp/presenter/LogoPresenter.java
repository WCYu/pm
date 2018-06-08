package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.LogoContract;
import com.rxjy.pm.mvp.model.LogoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/1.
 */

public class LogoPresenter extends LogoContract.Presenter {

    public static final String TAG = "LogoPresenter";

    public LogoPresenter(LogoContract.View mView) {
        this.mView = mView;
        mModel = new LogoModel();
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
                        Log.e(TAG, "获取用户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UserInfo info = JSONUtils.toObject(s, UserInfo.class);
                        if (info.getStatusCode() == 0) {
                            UserInfo.User data = info.getBody();
                            mView.responseLogin(data);
                        } else if (info.getStatusCode() == 104) {
                            mView.reLogin(info.getStatusMsg());
                        } else {
                            int postId = info.getBody().getPersonnelInfo().getPostId();
                            if(postId==4){

                            }
                            mView.responseLoginError(info.getStatusMsg());
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
