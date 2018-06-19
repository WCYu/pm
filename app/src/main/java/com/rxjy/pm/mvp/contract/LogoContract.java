package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/8/1.
 */

public interface LogoContract {

    interface View extends BaseView {

        void responseLogin(UserInfo.User data);

        void responseLoginError(String msg);

        void responsePmUserInfo(PmUserInfo.BodyBean data);

        void responsePmUserInfoError(String msg);

        void reLogin(String msg);

        void showDialog();

        void hideDialog();

        void responseWorkerLogin(WorkerInfo.BodyBean  data);


    }

    interface Model extends BaseModel {

        Observable<String> getLoginUserInfo(
                String userNo,
                String token
        );

        Observable<String> getLoginWorkerInfo(
                String mobile

        );

        Observable<String> getPmUserInfo(
                String phoneNum,
                int id
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getLoginUserInfo(
                String userNo,
                String token
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
