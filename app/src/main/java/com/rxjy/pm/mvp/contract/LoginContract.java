package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.fragment.WorkerInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/21.
 */
public interface LoginContract {

    interface View extends BaseView {

        void responseToken(TokenInfo.Token data);

        void responseTokenError(String msg);

        void responseLogin(UserInfo.User data);

        void responseLoginError(String msg);

        void responsePmUserInfo(PmUserInfo.BodyBean data);

        void responsePmUserInfoError(String msg);

        void responseUpdPwd(String msg);

        void intentWorker(int tag);

        void responseWorkerLogin(WorkerInfo.BodyBean  data);
        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getToken(
                String userNo,
                String password
        );

        Observable<String> getLoginUserInfo(
                String userNo,
                String token
        );
        Observable<String> getLoginWorkerInfo(
                String mobile

        );
        Observable<String> getPmUserInfo(
                String phoneNum
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getToken(
                String userNo,
                String password
        );

        public abstract void getLoginWorkerInfo(
                String mobile
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
