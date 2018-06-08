package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.OrdersBean;
import com.rxjy.pm.entity.OrdersSubmitBean;

import rx.Observable;

/**
 * Created by asus on 2018/4/9.
 */

public interface OrdersContract {
    interface View extends BaseView {
        void showDialog();

        void hideDialog();

        void showMessge(String msg);

        void getSubmit(String body);

        void toSubmit(OrdersSubmitBean submitBean);
    }
    interface Model extends BaseModel {

        Observable<String> toSubmit(
                String startTime,
                String endTime,
                String summary,
                int uid,
                int state
        );

        Observable<String> getSubmit(
                int uid
        );
    }
        abstract class Presenter extends BasePresenter<OrdersContract.View, OrdersContract.Model> {

            public abstract void toSubmit(
                    String startTime,
                    String endTime,
                    String summary,
                    int uid,
                    int state
            );

            public abstract void getSubmit(
                    int uid
            );

        }

}
