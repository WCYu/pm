package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/21.
 */
public interface CodeLoginContract {

    interface View extends BaseView {

        void responseTokenByCode(TokenInfo.Token data);

        void showIntent(int tag);

        void responseTokenByCodeError(String msg);

        void responseLoginByCode(UserInfo.User data);

        void responseLoginByCodeError(String msg);

        void responseVCodeError(String msg);

        void responsePmUserInfo(PmUserInfo.BodyBean data);

        void responsePmUserInfoError(String msg);

        void showDialog();

        void hideDialog();

        void responseWorkerLogin(WorkerInfo.BodyBean  data);
        void responseLoginError(String msg);

    }

    interface Model extends BaseModel {
        Observable<String> getTokenByCode(
                String userNo,
                String vCode
        );

        Observable<String> getLoginUserInfoByCode(
                String userNo,
                String token
        );

        Observable<String> getVCode(
                String phoneNum
        );

        Observable<String> getPmUserInfo(
                String phoneNum,
                int id
        );
        Observable<String> getLoginWorkerInfo(
                String mobile

        );
        void responseWorkerLogin(WorkerInfo.BodyBean  data);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getTokenByCode(
                String userNo,
                String vCode
        );

        public abstract void getLoginUserInfoByCode(
                String userNo,
                String token
        );

        public abstract void getVCode(
                String phoneNum
        );

        public abstract void getPmUserInfo(
                String phoneNum,
                int id
        );
        public abstract void getLoginWorkerInfo(
                String mobile
        );

    }

}
