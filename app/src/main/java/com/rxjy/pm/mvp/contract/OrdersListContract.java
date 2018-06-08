package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.OrdersListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/19.
 */

public interface OrdersListContract {

    interface View extends BaseView {

        void responseOrdersListData(List<OrdersListInfo.OrdersList> dataList);

        void responseOrdersListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getOrdersList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getOrdersList(
                String orderNo
        );

    }

}
