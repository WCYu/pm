package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.EnvironmentDetailInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.EnvironmentDetailContract;
import com.rxjy.pm.mvp.model.EnvironmentDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/15.
 */

public class EnvironmentDetailPresenter extends EnvironmentDetailContract.Presenter {

    public static final String TAG = "EnvironmentDetail";

    public EnvironmentDetailPresenter(EnvironmentDetailContract.View mView) {
        this.mView = mView;
        mModel = new EnvironmentDetailModel();
    }

    @Override
    public void getEnvironmentDetail(int processID, int xjID) {
        Subscription subscribe = mModel.getEnvironmentDetail(processID, xjID)
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
                        Log.e(TAG, "获取环境巡检失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        EnvironmentDetailInfo info = JSONUtils.toObject(s, EnvironmentDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<EnvironmentDetailInfo.EnvironmentDetail> dataList = info.getBody();
                            mView.responseEnvironmentDetailData(dataList);
                        } else {
                            mView.responseEnvironmentDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subEnvironmentDetailPhoto(int stepID, int xjID, String orderNo, String address, String xjsX, String xjsY, String url) {
        Subscription subscribe = mModel.subEnvironmentDetailPhoto(stepID, xjID, orderNo, address, xjsX, xjsY, url)
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
                        Log.e(TAG, "上传巡检详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubEnvironmentDetailData();
                        } else {
                            mView.responseSubEnvironmentDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
