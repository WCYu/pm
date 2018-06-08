package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProcessInfo;
import com.rxjy.pm.mvp.contract.ProcessContract;
import com.rxjy.pm.mvp.model.ProcessModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/24.
 */

public class ProcessPresenter extends ProcessContract.Presenter {

    public static final String TAG = "ProcessPresenter";

    public ProcessPresenter(ProcessContract.View mView) {
        this.mView = mView;
        mModel = new ProcessModel();
    }

    @Override
    public void getProcessList(String orderNo, int flag) {
        Subscription subscribe = mModel.getProcessList(orderNo, flag)
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
                        Log.e(TAG, "获取工序列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("zhuibei",s);
                        ProcessInfo info = JSONUtils.toObject(s, ProcessInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProcessInfo.ProcessGroup> dataList = info.getBody();
                            mView.responseProcessListData(dataList);
                        } else {
                            mView.responseProcessListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
