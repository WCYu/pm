package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.DisbursementInfo;
import com.rxjy.pm.entity.DisbursementListInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.DisbursementContract;
import com.rxjy.pm.mvp.model.DisbursementModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/25.
 */

public class DisbursementPresenter extends DisbursementContract.Presenter {

    public static final String TAG = "DisbursementPresenter";

    public DisbursementPresenter(DisbursementContract.View mView) {
        this.mView = mView;
        mModel = new DisbursementModel();
    }

    @Override
    public void getDisbursementData(String orderNo) {
        Subscription subscribe = mModel.getDisbursementData(orderNo)
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
                        Log.e(TAG, "获取项目可用款失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        DisbursementInfo info = JSONUtils.toObject(s, DisbursementInfo.class);
                        if (info.getStatusCode() == 1) {
                            DisbursementInfo.Disbursement data = info.getBody();
                            mView.responseDisbursementData(data);
                        } else {
                            mView.responseDisbursementDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getDisbursementListData(String orderNo) {
        Subscription subscribe = mModel.getDisbursementListData(orderNo)
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
                        Log.e(TAG, "获取支款记录失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        DisbursementListInfo info = JSONUtils.toObject(s, DisbursementListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<DisbursementListInfo.DisbursementList> dataList = info.getBody();
                            mView.responseDisbursementListData(dataList);
                        } else {
                            mView.responseDisbursementListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subDisbursementData(String orderNo, double money, String reason, String fine_id, int uid) {
        Subscription subscribe = mModel.subDisbursementData(orderNo, money, reason, fine_id, uid)
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
                        Log.e(TAG, "支款失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseDisbursementSubData();
                        } else {
                            mView.responseDisbursementSubDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
