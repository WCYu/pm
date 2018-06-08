package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.DisbursementStandardInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/7/14.
 */

public interface DisbursementStandardContract {

    interface View extends BaseView {

        void responseDisbursementStateData(DisbursementStandardInfo.DisbursementStandard data);

        void responseDisbursementStateDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getDisbursementState(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getDisbursementState(
                String orderNo
        );

    }

}
