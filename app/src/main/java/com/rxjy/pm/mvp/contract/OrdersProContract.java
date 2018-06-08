package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.OrdersProInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/19.
 */

public interface OrdersProContract {

    interface View extends BaseView {

        void responseOrdersProData(List<OrdersProInfo.OrdersPro> dataList);

        void responseOrdersProDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getOrdersPro(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getOrdersPro(
                int uid
        );

    }

}
