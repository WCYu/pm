package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by AAA on 2017/10/18.
 */

public interface SubjoinContract {

    interface View extends BaseView {

        void responseSubjoinData();

        void responseSubJoinDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> updSubjoin(
                String orderNo,
                int userID,
                String subSubjoinPrice
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void updSubjoin(
                String orderNo,
                int userID,
                String subSubjoinPrice
        );

    }

}
