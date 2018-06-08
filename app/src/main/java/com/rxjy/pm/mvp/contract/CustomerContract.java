package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.CustomerListBean;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public interface CustomerContract {

    interface View extends BaseView {

        void responseCustomer(CustomerListBean info);

        void responseCustomerError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getCustomerList(
                String uid
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCustomerList(
                String uid
        );
    }

}
