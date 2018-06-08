package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CameraCountInfo;
import com.rxjy.pm.entity.CameraStatusInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;
import com.rxjy.pm.mvp.contract.CameraListContract;
import com.rxjy.pm.mvp.model.CameraListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/8.
 */

public class CameraListPresenter extends CameraListContract.Presenter {

    public static final String TAG = "CameraListPresenter";

    public CameraListPresenter(CameraListContract.View mView) {
        this.mView = mView;
        mModel = new CameraListModel();
    }

    @Override
    public void getCraftList(String orderNo) {
        Subscription subscribe = mModel.getUsedCameraList(orderNo)
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
                        Log.e(TAG, "获取摄像头列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取摄像头列表成功 = " + s);
                        CameraListInfo info = JSONUtils.toObject(s, CameraListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<CameraListInfo.CameraInfo> dataList = info.getBody();
                            mView.responseBindCameraListData(dataList);
                        } else {
                            mView.responseBindCameraListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getUnbindCameraList(int areaID, int uid) {
        Subscription subscribe = mModel.getUnbindCameraList(areaID, uid)
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
                        Log.e(TAG, "获取未绑定摄像头列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG,"获取未绑定摄像头列表成功"+s);
                        UnbindCameraListInfo info = JSONUtils.toObject(s, UnbindCameraListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<UnbindCameraListInfo.UnbindCameraInfo> dataList = info.getBody();
                            mView.responseUnBindCameraListData(dataList);
                        } else {
                            mView.responseUnBindCameraListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCameraCount(String orderNo) {
        Subscription subscribe = mModel.getCameraCount(orderNo)
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
                        Log.e(TAG, "获取摄像头数量失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG,"获取摄像头数量成功 = "+s);
                        CameraCountInfo info = JSONUtils.toObject(s, CameraCountInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseCameraCountData(info.getBody());
                        } else {
                            mView.responseCameraCountDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCameraLineStatus(String orderNo) {
        Subscription subscribe = mModel.getCameraLineStatus(orderNo)
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
                        Log.e(TAG, "获取摄像头在线状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取摄像头在线状态成功 = " +s);
                        CameraStatusInfo info = JSONUtils.toObject(s, CameraStatusInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseCameraLineStatusData(info.getBody());
                        } else {
                            mView.responseCameraLineStatusDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void unbindAllCamera(int areaID, String orderNo, int uid, String userNo) {
        Subscription subscribe = mModel.unbindAllCamera(areaID, orderNo, uid, userNo)
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
                        Log.e(TAG, "回收摄像头失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUnBindAllCameraData();
                        } else {
                            mView.responseUnBindAllCameraDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
