package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProcessDetailInfo;
import com.rxjy.pm.entity.ProjectDBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public interface ProjectDContract {

    interface View extends BaseView {

        void responseProjectData(ProjectDBean info);

        void responseProjectDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProjectDetail(
                String rwdID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProjectDetail(
                String rwdID
        );

    }

}
