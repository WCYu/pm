package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProjectInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/7/31.
 */

public interface HomeContract {

    interface View extends BaseView {

        void responseProListData(List<ProjectInfo.Project> dataList);

        void responseProListDataError(String msg);

        void startToPrepare(ProjectInfo.Project data);

        void startToRouting(ProjectInfo.Project data);

        void startToDisbursement(ProjectInfo.Project data);

        void startToMat(ProjectInfo.Project data);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProList(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProList(
                int uid
        );

    }

}
