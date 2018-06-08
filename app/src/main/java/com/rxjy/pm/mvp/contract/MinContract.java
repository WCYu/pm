package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by AAA on 2018/3/27.
 */

public interface MinContract {
    interface View extends BaseView {
        void loadPhotoImage(String image);
        void showDialog();

        void hideDialog();
        void showMessage(String message);
    }

    interface Model extends BaseModel {
        Observable<String> loadPhotoImage(
                int uid
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void loadPhotoImage(
               int uid
        );
    }
}