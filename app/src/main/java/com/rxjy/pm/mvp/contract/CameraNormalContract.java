package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.CameraImageInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/11/20.
 */

public interface CameraNormalContract {

    interface View extends BaseView {

        void responseDebugData();

        void responseDebugDataError(String msg);

        void responseDebugImageData(CameraImageInfo.CameraImage data);

        void responseDebugImageDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getDebugData(
                String orderNo,
                String eNumber
        );

        Observable<String> getDebugImageData(
                String orderNo,
                String eNumber
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getDebugData(
                String orderNo,
                String eNumber
        );

        public abstract void getDebugImageData(
                String orderNo,
                String eNumber
        );

    }

}
