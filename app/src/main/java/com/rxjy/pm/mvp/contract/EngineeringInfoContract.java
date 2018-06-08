package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.EngineeringInfo;
import com.rxjy.pm.entity.ProcessInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/27.
 */

public interface EngineeringInfoContract {

    interface View extends BaseView {

        void responseEnvironmentListData(String mlist);

        void showMessage(String msg);

        void showDialog();

        void hideDialog();
        void responseTotalCost(String count);

        void responseEnvironmentData(String data);

    }
    interface Model extends BaseModel {

        Observable<String> getEnvironmentList(
                String F_RWDID

        );
        Observable<String> getTotalCost(
                String F_RWDID,
                String F_AREA_KEY


        );
    }
    abstract class Presenter extends BasePresenter<EngineeringInfoContract.View, EngineeringInfoContract.Model> {


        public abstract void getEnvironmentList(
                String F_RWDID
        );
        public abstract void getTotalCost(
                String F_RWDID,
                String  F_AREA_KEY
        );
    }
}
