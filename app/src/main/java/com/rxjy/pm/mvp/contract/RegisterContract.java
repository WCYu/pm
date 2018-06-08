package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/6.
 */
public interface RegisterContract {

    interface View extends BaseView {

        void responseRegisterData();

        void responseRegisterError(String msg);

        void responseVerificationCodeDataError(String msg);

        void responseToken(TokenInfo.Token data);

        void responseTokenError(String msg);

        void responseLogin(UserInfo.User data);

        void responseLoginError(String msg);

        void responsePmUserInfo(PmUserInfo.BodyBean data);

        void responsePmUserInfoError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getRegister(
                String code,
                String phoneNum,
                String password,
                String invitationCode
        );

        Observable<String> getVerificationCode(
                String phoneNum
        );

        Observable<String> getToken(
                String userNo,
                String password
        );

        Observable<String> getLoginUserInfo(
                String userNo,
                String token
        );

        Observable<String> getPmUserInfo(
                String phoneNum
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getRegister(
                String code,
                String phoneNum,
                String password,
                String invitationCode
        );

        public abstract void getVerificationCode(
                String phoneNum
        );

        public abstract void getToken(
                String userNo,
                String password
        );

        public abstract void getLoginUserInfo(
                String userNo,
                String token
        );

        public abstract void getPmUserInfo(
                String phoneNum
        );

    }

}
