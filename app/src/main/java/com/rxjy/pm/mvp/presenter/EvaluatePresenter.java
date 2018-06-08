package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.EvaluateMarkInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.EvaluateContract;
import com.rxjy.pm.mvp.model.EvaluateModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/26.
 */

public class EvaluatePresenter extends EvaluateContract.Presenter {

    public static final String TAG = "EvaluatePresenter";

    public EvaluatePresenter(EvaluateContract.View mView) {
        this.mView = mView;
        mModel = new EvaluateModel();
    }

    @Override
    public void getEvaluateMarks(int eType) {
        Subscription subscribe = mModel.getEvaluateMarks(eType)
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
                        Log.e(TAG, "获取评价标签失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        EvaluateMarkInfo info = JSONUtils.toObject(s, EvaluateMarkInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<EvaluateMarkInfo.StarInfo> dataList = info.getBody();
                            mView.responseEvaluateData(dataList);
                        } else {
                            mView.responseEvaluateDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subEvaluate(String orderID, int EvaluateStar, String remark, int userID, List<Integer> markItems) {
        Subscription subscribe = mModel.subEvaluate(orderID, EvaluateStar, remark, userID, markItems)
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
                        Log.e(TAG, "评价失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseEvaluateMatMerchant();
                        } else {
                            mView.responseEvaluateMatMerchantError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
