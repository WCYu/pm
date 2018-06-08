package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProcessDetailInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.ProcessDetailContract;
import com.rxjy.pm.mvp.model.ProcessDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/24.
 */

public class ProcessDetailPresenter extends ProcessDetailContract.Presenter {

    public static final String TAG = "ProcessDetailPresenter";

    public ProcessDetailPresenter(ProcessDetailContract.View mView) {
        this.mView = mView;
        mModel = new ProcessDetailModel();
    }

    @Override
    public void getProcessDetail(int processID) {
        Subscription subscribe = mModel.getProcessDetail(processID)
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
                        Log.e(TAG, "获取工序详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProcessDetailInfo info = JSONUtils.toObject(s, ProcessDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProcessDetailInfo.ProcessDetail> dataList = info.getBody();
                            mView.responseProcessDetailData(dataList);
                        } else {
                            mView.responseProcessDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subProcessDetailPhoto(int stepID, int processID, int stepPhotoID, String url) {
        Subscription subscribe = mModel.subProcessDetailPhoto(stepID, processID, stepPhotoID, url)
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
                        Log.e(TAG, "上传工序图片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubProcessPhotoData();
                        } else {
                            mView.responseSubProcessPhotoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subProcessDetailPhotoCamera(int stepID, int processID, int stepPhotoID, String url) {
        Subscription subscribe = mModel.subProcessDetailPhotoCamera(stepID, processID, stepPhotoID, url)
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
                        Log.e(TAG, "上传工序摄像头图片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubProcessPhotoCameraData();
                        } else {
                            mView.responseSubProcessPhotoCameraDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
