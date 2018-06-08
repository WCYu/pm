package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProcessInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/7/12.
 */

public interface ProcessContract {

    interface View extends BaseView {

        void responseProcessListData(List<ProcessInfo.ProcessGroup> dataList);

        void responseProcessListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProcessList(
                String orderNo,
                int flag
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProcessList(
                String orderNo,
                int flag
        );

    }

}
