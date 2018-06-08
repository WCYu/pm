package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PunishRecordInfo;
import com.rxjy.pm.mvp.contract.PunishRecordContract;
import com.rxjy.pm.mvp.model.PunishRecordModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/28.
 */

public class PunishRecordPresenter extends PunishRecordContract.Presenter {

    public static final String TAG = "PunishRecordPresenter";

    public PunishRecordPresenter(PunishRecordContract.View mView) {
        this.mView = mView;
        mModel = new PunishRecordModel();
    }

    @Override
    public void getPunishRecordInfo(int uid, int type) {
        Subscription subscribe = mModel.getPunishRecordInfo(uid, type)
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
                        Log.e(TAG, "获取奖罚记录失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        PunishRecordInfo info = JSONUtils.toObject(s, PunishRecordInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<PunishRecordInfo.PunishRecord> dataList = info.getBody();
                            mView.responsePunishRecordData(dataList);
                        } else {
                            mView.responsePunishRecordDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
