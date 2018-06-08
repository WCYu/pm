package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.VisitProListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public interface VisitProListContract {

    interface View extends BaseView {

        void responseVisitProListData(List<VisitProListInfo.VisitProList> dataList);

        void responseVisitProListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getVisitProList(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getVisitProList(
                int uid
        );

    }

}
