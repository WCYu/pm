package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.EnvironmentDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/15.
 */

public interface EnvironmentDetailContract {

    interface View extends BaseView {

        void responseSubEnvironmentDetailData();

        void responseSubEnvironmentDetailDataError(String msg);

        void responseEnvironmentDetailData(List<EnvironmentDetailInfo.EnvironmentDetail> dataList);

        void responseEnvironmentDetailDataError(String msg);

        void largePhoto(String url);

        void subProcessPhoto(EnvironmentDetailInfo.EnvironmentDetail data, int position);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getEnvironmentDetail(
                int processID,
                int xjID
        );

        Observable<String> subEnvironmentDetailPhoto(
                int stepID,
                int xjID,
                String orderNo,
                String address,
                String xjsX,
                String xjsY,
                String url
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getEnvironmentDetail(
                int processID,
                int xjID
        );

        public abstract void subEnvironmentDetailPhoto(
                int stepID,
                int xjID,
                String orderNo,
                String address,
                String xjsX,
                String xjsY,
                String url
        );

    }

}
