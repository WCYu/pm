package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.RoutingSubContract;
import com.rxjy.pm.mvp.model.RoutingSubModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/14.
 */

public class RoutingSubPresenter extends RoutingSubContract.Presenter {

    public static final String TAG = "RoutingSubPresenter";

    public RoutingSubPresenter(RoutingSubContract.View mView) {
        this.mView = mView;
        mModel = new RoutingSubModel();
    }

    @Override
    public void subRoutingData(int xjID, String content, String address, double xjX, double xjY, List<LocalMedia> imgList) {
        Subscription subscribe = mModel.subRoutingData(xjID, content, address, xjX, xjY, imgList)
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
                        Log.e(TAG, "上传进度巡检失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseRoutingSubData();
                        } else {
                            mView.responseRoutingSubDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
