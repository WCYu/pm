package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.MatProListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/20.
 */

public interface MatProListContract {

    interface View extends BaseView {

        void responseMatProListData(List<MatProListInfo.MatProList> dataList);

        void responseMatProListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMatProList(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMatProList(
                int uid
        );

    }

}
