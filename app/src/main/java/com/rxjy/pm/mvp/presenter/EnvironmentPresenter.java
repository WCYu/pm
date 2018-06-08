package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProcessInfo;
import com.rxjy.pm.mvp.contract.EnvironmentContract;
import com.rxjy.pm.mvp.model.EnvironmentModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/15.
 */

public class EnvironmentPresenter extends EnvironmentContract.Presenter {

    public static final String TAG = "EnvironmentPresenter";

    public EnvironmentPresenter(EnvironmentContract.View mView) {
        this.mView = mView;
        mModel = new EnvironmentModel();
    }

    @Override
    public void getEnvironmentList(String orderNo, int xjID) {
        Subscription subscribe = mModel.getEnvironmentList(orderNo, xjID)
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
                        Log.e(TAG, "获取环境巡检列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProcessInfo info = JSONUtils.toObject(s, ProcessInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProcessInfo.ProcessGroup> dataList = info.getBody();
                            mView.responseEnvironmentListData(dataList);
                        } else {
                            mView.responseEnvironmentDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
