package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ResultBean;
import com.rxjy.pm.mvp.contract.ResultChatContract;
import com.rxjy.pm.mvp.model.ResultChatModel;

import java.util.ArrayList;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/1.
 */

public class ResultChatPresenter extends ResultChatContract.Presenter {

    public ResultChatPresenter(ResultChatContract.View mView) {
        this.mView = mView;
        mModel = new ResultChatModel();
    }

    @Override
    public void postData(String pi_OrderId, String pi_Remarks, String pi_State, ArrayList<String> imgslist) {
        Subscription subscribe = mModel.postData(pi_OrderId, pi_Remarks, pi_State, imgslist)
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
                        Log.e("", "上传洽谈结果失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("上传洽谈结果返回值=====", s);
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.responsepostData();
                        } else {
                            mView.responsepostDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}