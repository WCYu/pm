package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.MsgDetailInfo;
import com.rxjy.pm.mvp.contract.MsgDetailContract;
import com.rxjy.pm.mvp.model.MsgDetailModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgDetailPresenter extends MsgDetailContract.Presenter {

    public static final String TAG = "MsgDetailPresenter";

    public MsgDetailPresenter(MsgDetailContract.View mView) {
        this.mView = mView;
        mModel = new MsgDetailModel();
    }

    @Override
    public void getMsgDetail(int tsID) {
        Subscription subscribe = mModel.getMsgDetail(tsID)
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
                        Log.e(TAG, "获取消息详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MsgDetailInfo info = JSONUtils.toObject(s, MsgDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            MsgDetailInfo.MsgDetail data = info.getBody();
                            mView.responseMsgDetailData(data);
                        } else {
                            mView.responseMsgDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
