package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CameraAbnormalInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.CameraAbnormalContract;
import com.rxjy.pm.mvp.model.CameraAbnormalModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/17.
 */

public class CameraAbnormalPresenter extends CameraAbnormalContract.Presenter {

    public static final String TAG = "CameraAbnormalPresenter";

    public CameraAbnormalPresenter(CameraAbnormalContract.View mView) {
        this.mView = mView;
        mModel = new CameraAbnormalModel();
    }

    @Override
    public void getCraftAbnormalList(String orderNo, String eNumber) {
        Subscription subscribe = mModel.getCraftAbnormalList(orderNo, eNumber)
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
                        Log.e(TAG, "获取异常列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CameraAbnormalInfo info = JSONUtils.toObject(s, CameraAbnormalInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<CameraAbnormalInfo.CameraAbnormal> dataList = info.getBody();
                            mView.responseCraftAbnormalListData(dataList);
                        } else {
                            mView.responseCraftAbnormalListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void unbindCamera(int areaID, String orderNo, int uid, String userNo, String eNumber) {
        Subscription subscribe = mModel.unbindCamera(areaID, orderNo, uid, userNo, eNumber)
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
                        Log.e(TAG, "解绑摄像头失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUnbindCameraData();
                        } else {
                            mView.responseUnbindCameraDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
