package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProInfo;
import com.rxjy.pm.mvp.contract.FefundContract;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.mvp.model.FefundModel;
import com.rxjy.pm.mvp.model.ReceiptModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/26.
 */

public class FefundPresenter extends FefundContract.Presenter {
    public static final String TAG = "ReceiptPresenter";

    public FefundPresenter(FefundContract.View mView) {
        this.mView = mView;
        mModel = new FefundModel();
    }

    @Override
    public void getProjectManager(String orderno, int pmuid, int pushstatus, String reason) {
        Subscription subscribe = mModel.getProjectManager(orderno, pmuid,pushstatus,reason)
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

                        if(s.contains("success")){
                            mView.toIntent();
                        }
//                        ProInfo info = JSONUtils.toObject(s, ProInfo.class);
//                        if (info.getStatusCode() == 1) {
//                            mView.responseProInfo(info.getBody());
//                        } else {
//                            mView.showMessage(info.getStatusMsg());
//                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
