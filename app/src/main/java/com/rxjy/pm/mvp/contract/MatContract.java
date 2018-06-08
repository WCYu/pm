package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.FirstMatInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.MatMoneyInfo;
import com.rxjy.pm.entity.SecondMatInfo;
import com.rxjy.pm.entity.UpdMatInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/10.
 */

public interface MatContract {

    interface View extends BaseView {

        void responseFirstMatData(List<FirstMatInfo.FirstMat> dataList);

        void responseFirstMatDataError(String msg);

        void responseSecondMatData(List<SecondMatInfo.SecondMat> dataList);

        void responseMatData(List<MatInfo.Mat> dataList);

        void responseMatDataError(String msg);

        void responseSecondMatDataError(String msg);

        void responseMatMoneyData(MatMoneyInfo.MatMoney data);

        void responseMatMoneyDataError(String msg);

        void responseUpdMatInfo(UpdMatInfo.UpdMat data);

        void responseUpdMatInfoError(String msg);

        void updMatCount(MatInfo.Mat data, int type);

        void updMatMerchant(MatInfo.Mat data);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getFirstMat(
                String orderNo
        );

        Observable<String> getSecondMat(
                String orderNo,
                String treeID
        );

        Observable<String> getMatList(
                String orderNo,
                String treeID,
                String treeTwo
        );

        Observable<String> getMatMoneyInfo(
                String orderNo
        );

        Observable<String> updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getFirstMat(
                String orderNo
        );

        public abstract void getSecondMat(
                String orderNo,
                String treeID
        );

        public abstract void getMatList(
                String orderNo,
                String treeID,
                String treeTwo
        );

        public abstract void getMatMoneyInfo(
                String orderNo
        );

        public abstract void updMat(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

    }

}
