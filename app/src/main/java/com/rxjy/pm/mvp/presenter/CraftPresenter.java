package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CraftInfo;
import com.rxjy.pm.mvp.contract.CraftContract;
import com.rxjy.pm.mvp.model.CraftModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/24.
 */

public class CraftPresenter extends CraftContract.Presenter {

    public static final String TAG = "CraftPresenter";

    public CraftPresenter(CraftContract.View mView) {
        this.mView = mView;
        mModel = new CraftModel();
    }

    @Override
    public void getCraftList(String orderNo) {
        Subscription subscribe = mModel.getCraftList(orderNo)
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
                        Log.e(TAG, "获取工艺列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CraftInfo info = JSONUtils.toObject(s, CraftInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<CraftInfo.Craft> dataList = info.getBody();
                            mView.responseCraftListData(dataList);
                        } else {
                            mView.responseCraftListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
