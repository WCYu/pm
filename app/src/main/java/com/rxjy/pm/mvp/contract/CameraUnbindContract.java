package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.AreaInfo;
import com.rxjy.pm.entity.CameraImageInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/20.
 */

public interface CameraUnbindContract {

    interface View extends BaseView {

        void responseAreaListData(List<AreaInfo.Area> dataList);

        void responseAreaListDataError(String msg);

        void responseDebugData();

        void responseDebugDataError(String msg);

        void responseDebugImageData(CameraImageInfo.CameraImage data);

        void responseDebugImageDataError(String msg);

        void responseBindCameraData();

        void responseBindCameraDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getAreaList(
                String orderNo
        );

        Observable<String> getDebugData(
                String orderNo,
                String eNumber
        );

        Observable<String> getDebugImageData(
                String orderNo,
                String eNumber
        );

        Observable<String> subCameraInfo(
                int areaID,
                String orderNo,
                String eNumber,
                String areaName,
                String url
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getAreaList(
                String orderNo
        );

        public abstract void getDebugData(
                String orderNo,
                String eNumber
        );

        public abstract void getDebugImageData(
                String orderNo,
                String eNumber
        );

        public abstract void subCameraInfo(
                int areaID,
                String orderNo,
                String eNumber,
                String areaName,
                String url
        );

    }

}
