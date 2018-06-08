package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.DisbursementStandardInfo;
import com.rxjy.pm.mvp.contract.DisbursementStandardContract;
import com.rxjy.pm.mvp.model.DisbursementStandardModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/24.
 */

public class DisbursementStandardPresenter extends DisbursementStandardContract.Presenter {

    public static final String TAG = "DisbursementStandard";

    public DisbursementStandardPresenter(DisbursementStandardContract.View mView) {
        this.mView = mView;
        mModel = new DisbursementStandardModel();
    }

    @Override
    public void getDisbursementState(String orderNo) {
        Subscription subscribe = mModel.getDisbursementState(orderNo)
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
                        Log.e(TAG, "获取支款状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        DisbursementStandardInfo info = JSONUtils.toObject(s, DisbursementStandardInfo.class);
                        if (info.getStatusCode() == 1) {
                            DisbursementStandardInfo.DisbursementStandard data = info.getBody();
                            mView.responseDisbursementStateData(data);
                        } else {
                            mView.responseDisbursementStateDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
