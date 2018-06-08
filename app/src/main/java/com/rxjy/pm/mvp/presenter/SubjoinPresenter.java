package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.SubjoinContract;
import com.rxjy.pm.mvp.model.SubjoinModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/18.
 */

public class SubjoinPresenter extends SubjoinContract.Presenter {

    public static final String TAG = "SubjoinPresenter";

    public SubjoinPresenter(SubjoinContract.View mView) {
        this.mView = mView;
        mModel = new SubjoinModel();
    }

    @Override
    public void updSubjoin(String orderNo, int userID, String subSubjoinPrice) {
        Subscription subscribe = mModel.updSubjoin(orderNo, userID, subSubjoinPrice)
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
                        Log.e(TAG, "修改备注失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubjoinData();
                        } else {
                            mView.responseSubJoinDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
