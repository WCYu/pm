package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.VisitListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/27.
 */

public interface VisitContract {

    interface View extends BaseView {

        void responseVisitData(List<VisitListInfo.VisitInfo> dataList);

        void responseVisitDataError(String msg);

        void responseVisitSubData();

        void responseVisitSubDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getVisit(
                String orderNo
        );

        Observable<String> subVisit(
                String orderNo,
                String content
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getVisit(
                String orderNo
        );

        public abstract void subVisit(
                String orderNo,
                String content
        );

    }

}
