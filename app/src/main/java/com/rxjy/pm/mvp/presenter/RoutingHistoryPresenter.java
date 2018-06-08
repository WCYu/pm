package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.RoutingHistoryInfo;
import com.rxjy.pm.mvp.contract.RoutingHistoryContract;
import com.rxjy.pm.mvp.model.RoutingHistoryModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/18.
 */

public class RoutingHistoryPresenter extends RoutingHistoryContract.Presenter {

    public static final String TAG = "RoutingHistoryPresenter";

    public RoutingHistoryPresenter(RoutingHistoryContract.View mView) {
        this.mView = mView;
        mModel = new RoutingHistoryModel();
    }

    @Override
    public void getRoutingHistoryList(String orderNo) {
        Subscription subscribe = mModel.getRoutingHistoryList(orderNo)
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
                        Log.e(TAG, "获取巡检历史失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("cc",s);
                        RoutingHistoryInfo info = JSONUtils.toObject(s, RoutingHistoryInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<RoutingHistoryInfo.RoutingHistory> dataList = info.getBody();
                            mView.responseRoutingHistoryListData(dataList);
                        } else {
                            mView.responseRoutingHistoryListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
