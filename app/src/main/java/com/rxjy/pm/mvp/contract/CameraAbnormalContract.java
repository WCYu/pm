package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.CameraAbnormalInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/17.
 */

public interface CameraAbnormalContract {

    interface View extends BaseView {

        void responseCraftAbnormalListData(List<CameraAbnormalInfo.CameraAbnormal> dataList);

        void responseCraftAbnormalListDataError(String msg);

        void responseUnbindCameraData();

        void responseUnbindCameraDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getCraftAbnormalList(
                String orderNo,
                String eNumber
        );

        Observable<String> unbindCamera(
                int areaID,
                String orderNo,
                int uid,
                String userNo,
                String eNumber
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getCraftAbnormalList(
                String orderNo,
                String eNumber
        );

        public abstract void unbindCamera(
                int areaID,
                String orderNo,
                int uid,
                String userNo,
                String eNumber
        );

    }

}
