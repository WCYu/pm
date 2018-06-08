package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.WorkerPersonDBean;
import com.rxjy.pm.entity.WorklistBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/3/31.
 */

public interface WorkHomedataContract {
    interface View extends BaseView {
        void responsegetData(List<WorklistBean.BodyBean> Body);

        void responsegetDataError(String msg);

        void showDialog();

        void hideDialog();

        void responseBinDing();

    }

    interface Model extends BaseModel {
        Observable<String> getData(
                String workerid
        );
        Observable<String> getBinDing(
                String workerid,
                String orderno,
                String uid
        );
    }
    abstract class Presenter extends BasePresenter<WorkHomedataContract.View, WorkHomedataContract.Model> {
        public abstract void getData(
                String workerid
        );
        public abstract void getBinDing(
                String workerid,
                String orderno,
                String uid
        );
    }

}
