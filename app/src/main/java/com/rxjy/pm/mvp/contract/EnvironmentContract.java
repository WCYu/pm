package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProcessInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/15.
 */

public interface EnvironmentContract {

    interface View extends BaseView {

        void responseEnvironmentListData(List<ProcessInfo.ProcessGroup> dataList);

        void responseEnvironmentDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getEnvironmentList(
                String orderNo,
                int xjID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getEnvironmentList(
                String orderNo,
                int xjID
        );

    }

}
