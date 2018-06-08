package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SuccessfulBean;
import com.rxjy.pm.mvp.contract.BarcGaningContract;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.mvp.model.BarcGaningModel;
import com.rxjy.pm.mvp.model.ReceiptModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/16.
 */

public class BarcGaningPresenter extends BarcGaningContract.Presenter {

    public static final String TAG = "BarcGaningPresenter";

    public BarcGaningPresenter(BarcGaningContract.View mView) {
        this.mView = mView;
        mModel = new BarcGaningModel();
    }

    @Override
    public void getProjectManager(String orderno, int pmuid, int pushstatus, String reason, List<String> imglist) {
        Subscription subscribe = mModel.getProjectManager(orderno, pmuid,pushstatus,reason,imglist)
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
                        Log.e("", "获取项目详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("项目经理操作成功=====", s);
                        SuccessfulBean info = JSONUtils.toObject(s, SuccessfulBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.getSuccessfulOperation();
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
