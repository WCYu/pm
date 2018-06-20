package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CustomerListBean;
import com.rxjy.pm.mvp.contract.CustomerContract;
import com.rxjy.pm.mvp.model.CustomerModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/2/28.
 */

public class CustomerPresenter extends CustomerContract.Presenter {

    public CustomerPresenter(CustomerContract.View mView) {
        this.mView = mView;
        mModel = new CustomerModel();
    }

    @Override
    public void getCustomerList(String uid, String CardNo, String UserType) {
        Subscription subscribe = mModel.getCustomerList(uid, CardNo, UserType)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取工艺列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("======", "获取客户数据啦啦啦啦啦= " + s);
                        CustomerListBean info = JSONUtils.toObject(s, CustomerListBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseCustomer(info);
                        } else {
                            mView.responseCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
