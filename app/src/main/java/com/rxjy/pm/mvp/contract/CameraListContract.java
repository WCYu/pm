package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.UnbindCameraListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/8.
 */

public interface CameraListContract {

    interface View extends BaseView {

        void responseCameraLineStatusData(int state);

        void responseCameraLineStatusDataError(String msg);

        void responseCameraCountData(int count);

        void responseCameraCountDataError(String msg);

        void responseBindCameraListData(List<CameraListInfo.CameraInfo> dataList);

        void responseBindCameraListDataError(String msg);

        void responseUnBindCameraListData(List<UnbindCameraListInfo.UnbindCameraInfo> dataList);

        void responseUnBindCameraListDataError(String msg);

        void responseUnBindAllCameraData();

        void responseUnBindAllCameraDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getUsedCameraList(
                String orderNo
        );

        Observable<String> getUnbindCameraList(
                int areaID,
                int uid
        );

        Observable<String> getCameraCount(
                String orderNo
        );

        Observable<String> getCameraLineStatus(
                String orderNo
        );

        Observable<String> unbindAllCamera(
                int areaID,
                String orderNo,
                int uid,
                String userNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getCraftList(
                String orderNo
        );

        public abstract void getUnbindCameraList(
                int areaID,
                int uid
        );

        public abstract void getCameraCount(
                String orderNo
        );

        public abstract void getCameraLineStatus(
                String orderNo
        );

        public abstract void unbindAllCamera(
                int areaID,
                String orderNo,
                int uid,
                String userNo
        );

    }

}
