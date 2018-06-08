package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProcessDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public interface ProcessDetailContract {

    interface View extends BaseView {

        void responseSubProcessPhotoData();

        void responseSubProcessPhotoDataError(String msg);

        void responseSubProcessPhotoCameraData();

        void responseSubProcessPhotoCameraDataError(String msg);

        void responseProcessDetailData(List<ProcessDetailInfo.ProcessDetail> dataList);

        void responseProcessDetailDataError(String msg);

        void largePhoto(String url);

        void subProcessPhoto(ProcessDetailInfo.ProcessDetail data);

        void subProcessCameraPhoto(ProcessDetailInfo.ProcessDetail data);

        void hasUploadPhotoView(List<String> imgList);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProcessDetail(
                int processID
        );

        Observable<String> subProcessDetailPhoto(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

        Observable<String> subProcessDetailPhotoCamera(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProcessDetail(
                int processID
        );

        public abstract void subProcessDetailPhoto(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

        public abstract void subProcessDetailPhotoCamera(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

    }

}
