package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.OrdersBean;
import com.rxjy.pm.entity.OrdersProInfo;
import com.rxjy.pm.entity.OrdersSubmitBean;
import com.rxjy.pm.mvp.contract.OrdersContract;
import com.rxjy.pm.mvp.contract.OrdersProContract;
import com.rxjy.pm.mvp.model.OrdersModel;
import com.rxjy.pm.mvp.model.OrdersProModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/9.
 */

public class OrdersPresenter extends OrdersContract.Presenter {
    public static final String TAG = "OrdersPresenter";

    public OrdersPresenter(OrdersContract.View mView) {
        this.mView = mView;
        mModel = new OrdersModel();
    }

    @Override
    public void toSubmit(String startTime, String endTime, String summary, int uid, int state) {
        Subscription subscribe = mModel.toSubmit(startTime, endTime, summary, uid, state)
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
                        Log.e(TAG, "获取材料项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tijiao", s);
                        // OrdersProInfo info = JSONUtils.toObject(s, OrdersProInfo.class);
                        OrdersSubmitBean ordersBean = JSONUtils.toObject(s, OrdersSubmitBean.class);
                        if (ordersBean.getStatusCode() == 1) {
                            Log.e("tag", ordersBean.getBody());
                            // OrdersBean.BodyBean body = ordersBean.getBody();
                            mView.toSubmit(ordersBean);
                        } else {
                            String statusMsg = ordersBean.getStatusMsg();
                        }
//                        if (info.getStatusCode() == 1) {
//                            List<OrdersProInfo.OrdersPro> dataList = info.getBody();
//                            mView.responseOrdersProData(dataList);
//                        } else {
//                            mView.responseOrdersProDataError(info.getStatusMsg());
//                        }
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void getSubmit(int uid) {
        Subscription subscribe = mModel.getSubmit(uid)
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
                        Log.e(TAG, "获取材料项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                   Log.e("tag",s);
                       mView.getSubmit(s);


                    }
                });
        addSubscribe(subscribe);
    }
}
