package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.AreaInfo;
import com.rxjy.pm.entity.CameraImageInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.CameraUnbindContract;
import com.rxjy.pm.mvp.model.CameraUnbindModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/20.
 */

public class CameraUnbindPresenter extends CameraUnbindContract.Presenter {

    public static final String TAG = "CameraUnbindPresenter";

    public CameraUnbindPresenter(CameraUnbindContract.View mView) {
        this.mView = mView;
        mModel = new CameraUnbindModel();
    }

    @Override
    public void getAreaList(String orderNo) {
        Subscription subscribe = mModel.getAreaList(orderNo)
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
                        Log.e(TAG, "获取区域列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        AreaInfo info = JSONUtils.toObject(s, AreaInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<AreaInfo.Area> dataList = info.getBody();
                            mView.responseAreaListData(dataList);
                        } else {
                            mView.responseAreaListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getDebugData(String orderNo, String eNumber) {
        Subscription subscribe = mModel.getDebugData(orderNo, eNumber)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "修改摄像头抓拍状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseDebugData();
                        } else {
                            mView.responseDebugDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getDebugImageData(String orderNo, String eNumber) {
        Subscription subscribe = mModel.getDebugImageData(orderNo, eNumber)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取调试照片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CameraImageInfo info = JSONUtils.toObject(s, CameraImageInfo.class);
                        if (info.getStatusCode() == 1) {
                            CameraImageInfo.CameraImage data = info.getBody();
                            mView.responseDebugImageData(data);
                        } else {
                            mView.responseDebugImageDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subCameraInfo(int areaID,String orderNo, String eNumber, String areaName, String url) {
        Subscription subscribe = mModel.subCameraInfo(areaID,orderNo, eNumber, areaName, url)
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
                        Log.e(TAG, "绑定摄像头失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseBindCameraData();
                        } else {
                            mView.responseBindCameraDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
