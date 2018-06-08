package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.LoginContract;
import com.rxjy.pm.mvp.model.LoginModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/27.
 */

public class LoginPresenter extends LoginContract.Presenter {

    public static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        mModel = new LoginModel();
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
                        mView.responseTokenError("账号或则密码错误");
                        Log.e(TAG, "获取Token失败 = " + e.toString());
                        onCompleted();

                    }

                    @Override
                    public void onNext(String s) {
                        TokenInfo info = JSONUtils.toObject(s, TokenInfo.class);
                        if (info.getStatusCode() == 0||info.getStatusCode()==-1) {
                            TokenInfo.Token data = info.getBody();
                            mView.responseToken(data);
                        } else if (info.getStatusCode() == -2) {
                            mView.responseUpdPwd(info.getStatusMsg());
                        } else  {
                            mView.responseTokenError(info.getStatusMsg());
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

    @Override
    public void getLoginUserInfo(String userNo, String token) {
      // Log.e("e",userNo+"=============="+token);
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
                        Log.e("qq",s);
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

                        Log.e("gg", "获取工程人员信息.f,.sd,f.sd,f = " + s);

                        PmUserInfo info = JSONUtils.toObject(s, PmUserInfo.class);

                        if (info.getStatusCode() == 1) {
                            PmUserInfo.BodyBean body = info.getBody();
                            mView.responsePmUserInfo(body);
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
