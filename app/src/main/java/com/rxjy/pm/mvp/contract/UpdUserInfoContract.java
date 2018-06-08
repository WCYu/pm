package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by AAA on 2017/7/12.
 */

public interface UpdUserInfoContract {

    interface View extends BaseView {

        void responseUpdateData();

        void responseUpdateDataError(String msg);

        void responseUpPicture();

        void responseUpPictureError(String msg);

        void reLogin(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> updateUserInfo(
                String token,
                String cardNo,
                String key,
                String value
        );

        Observable<String> upHeaderPicture(
                String token,
                String cardNo,
                String picturePath
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void updateUserInfo(
                String token,
                String cardNo,
                String key,
                String value
        );

        public abstract void upHeaderPicture(
                String token,
                String cardNo,
                String picturePath
        );
    }

}
