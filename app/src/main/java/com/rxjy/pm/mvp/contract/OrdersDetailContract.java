package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.OrdersDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/20.
 */

public interface OrdersDetailContract {

    interface View extends BaseView {

        void responseOrdersDetailData(OrdersDetailInfo.OrdersDetail data);

        void responseOrdersDetailMat(List<OrdersDetailInfo.OrdersDetail.ListMatBean> dataList);

        void responseOrdersDetailSubjoin(List<OrdersDetailInfo.OrdersDetail.ListMoneyBean> dataList);

        void responseOrdersDetailImage(List<String> dataList);

        void responseOrderDetailEvaluate(OrdersDetailInfo.OrdersDetail.EvaluateOrderBean data);

        void responseOrdersDetailDataError(String msg);

        void responseConfirmOrders();

        void responseConfirmOrdersError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getOrdersDetail(
                String orderID
        );

        Observable<String> confirmOrders(
                String orderID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getOrdersDetail(
                String orderID
        );

        public abstract void confirmOrders(
                String orderID
        );

    }

}
