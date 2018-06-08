package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.HotWordInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.UpdMatInfo;
import com.rxjy.pm.mvp.contract.SearchMatContract;
import com.rxjy.pm.mvp.model.SearchMatModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/12.
 */

public class SearchMatPresenter extends SearchMatContract.Presenter {

    public static final String TAG = "SearchMatPresenter";

    public SearchMatPresenter(SearchMatContract.View mView) {
        this.mView = mView;
        mModel = new SearchMatModel();
    }

    @Override
    public void getMatList(String orderNo, String content) {
        Subscription subscribe = mModel.getMatList(orderNo, content)
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
                        Log.e(TAG, "获取材料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MatInfo info = JSONUtils.toObject(s, MatInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<MatInfo.Mat> dataList = info.getBody();
                            mView.responseMatData(dataList);
                        } else {
                            mView.responseMatDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updMat(String orderNo, String matID, int userID, double count, int isChecked) {
        Subscription subscribe = mModel.updMat(orderNo, matID, userID, count, isChecked)
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
                        Log.e(TAG, "修改材料数量失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UpdMatInfo info = JSONUtils.toObject(s, UpdMatInfo.class);
                        if (info.getStatusCode() == 1) {
                            UpdMatInfo.UpdMat data = info.getBody();
                            mView.responseUpdMatInfo(data);
                        } else {
                            mView.responseUpdMatInfoError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFuzzyInfo(String orderNo, String content) {
        Subscription subscribe = mModel.getFuzzyInfo(orderNo, content)
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
                        Log.e(TAG, "获取模糊搜索失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        HotWordInfo info = JSONUtils.toObject(s, HotWordInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<HotWordInfo.HotWord> dataList = info.getBody();
                            mView.responseFuzzyData(dataList);
                        } else {
                            mView.responseFuzzyDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
