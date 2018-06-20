package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.VersionInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/10/20.
 */

public interface MainContract {

    interface View extends BaseView {

        void responseVersionData(VersionInfo.Version data);

        void responseVersionDataError(String msg);

    }

    interface Model extends BaseModel {

        Observable<String> getVersionInfo(
                    int version
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getVersionInfo(
                int version
        );

    }

}
