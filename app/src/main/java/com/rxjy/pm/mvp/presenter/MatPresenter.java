package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.FirstMatInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.MatMoneyInfo;
import com.rxjy.pm.entity.SecondMatInfo;
import com.rxjy.pm.entity.UpdMatInfo;
import com.rxjy.pm.mvp.contract.MatContract;
import com.rxjy.pm.mvp.model.MatModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/10.
 */

public class MatPresenter extends MatContract.Presenter {

    public static final String TAG = "MatPresenter";

    public MatPresenter(MatContract.View mView) {
        this.mView = mView;
        mModel = new MatModel();
    }

    @Override
    public void getFirstMat(String orderNo) {
        Subscription subscribe = mModel.getFirstMat(orderNo)
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
                        Log.e(TAG, "获取材料一级分类失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        FirstMatInfo info = JSONUtils.toObject(s, FirstMatInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<FirstMatInfo.FirstMat> dataList = info.getBody();
                            mView.responseFirstMatData(dataList);
                        } else {
                            mView.responseFirstMatDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getSecondMat(String orderNo, String treeID) {
        Subscription subscribe = mModel.getSecondMat(orderNo, treeID)
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
                        Log.e(TAG, "获取二级材料分类失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SecondMatInfo info = JSONUtils.toObject(s, SecondMatInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<SecondMatInfo.SecondMat> dataList = info.getBody();
                            mView.responseSecondMatData(dataList);
                        } else {
                            mView.responseSecondMatDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getMatList(String orderNo, String treeID, String treeTwo) {
        Subscription subscribe = mModel.getMatList(orderNo, treeID, treeTwo)
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
                        Log.e(TAG, "获取材料列表失败 = " + e.toString());
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
    public void getMatMoneyInfo(String orderNo) {
        Subscription subscribe = mModel.getMatMoneyInfo(orderNo)
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
                        Log.e(TAG, "获取材料款失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MatMoneyInfo info = JSONUtils.toObject(s, MatMoneyInfo.class);
                        if (info.getStatusCode() == 1) {
                            MatMoneyInfo.MatMoney data = info.getBody();
                            mView.responseMatMoneyData(data);
                        } else {
                            mView.responseMatMoneyDataError(info.getStatusMsg());
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
}
