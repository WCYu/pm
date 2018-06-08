package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.HotWordInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.UpdMatInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/10.
 */

public interface SearchMatContract {

    interface View extends BaseView {

        void responseMatData(List<MatInfo.Mat> dataList);

        void responseMatDataError(String msg);

        void responseUpdMatInfo(UpdMatInfo.UpdMat data);

        void responseUpdMatInfoError(String msg);

        void responseFuzzyData(List<HotWordInfo.HotWord> dataList);

        void responseFuzzyDataError(String msg);

        void updMatCount(MatInfo.Mat data, int type);

        void updMatMerchant(MatInfo.Mat data);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMatList(
                String orderNo,
                String content
        );

        Observable<String> updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

        Observable<String> getFuzzyInfo(
                String orderNo,
                String content
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMatList(
                String orderNo,
                String content
        );

        public abstract void updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

        public abstract void getFuzzyInfo(
                String orderNo,
                String content
        );

    }

}
