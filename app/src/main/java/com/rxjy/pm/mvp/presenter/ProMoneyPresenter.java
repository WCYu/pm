package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProMoneyInfo;
import com.rxjy.pm.mvp.contract.ProMoneyContract;
import com.rxjy.pm.mvp.model.ProMoneyModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/25.
 */

public class ProMoneyPresenter extends ProMoneyContract.Presenter {

    public static final String TAG = "ProMoneyPresenter";

    public ProMoneyPresenter(ProMoneyContract.View mView) {
        this.mView = mView;
        mModel = new ProMoneyModel();
    }

    @Override
    public void getProMoneyList(int uid) {
        Subscription subscribe = mModel.getProMoneyList(uid)
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
                        Log.e(TAG, "获取项目款失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProMoneyInfo info = JSONUtils.toObject(s, ProMoneyInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProMoneyInfo.ProMoney> dataList = info.getBody();
                            mView.responseProMoneyListData(dataList);
                        } else {
                            mView.responseProdMoneyListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
