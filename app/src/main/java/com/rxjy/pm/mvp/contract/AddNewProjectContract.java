package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by AAA on 2018/3/7.
 */

public interface AddNewProjectContract {
    interface View extends BaseView {
        void AddSuccess(String msg);

        void AddFail(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<String> addNewProject(
                String clientName,
                String clientPhone,
                String projectName,
                double projectArea,
                int projectType,
                int projectState,
                int mAreaId,
                int mId,
                String mName
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void addNewProject(
                String clientName,
                String clientPhone,
                String projectName,
                double projectArea,
                int projectType,
                int projectState,
                int mAreaId,
                int mId,
                String mName
        );
    }
}
