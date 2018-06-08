package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.HotWordInfo;
import com.rxjy.pm.mvp.contract.MatSearchContract;
import com.rxjy.pm.mvp.model.MatSearchModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/12.
 */

public class MatSearchPresenter extends MatSearchContract.Presenter {

    public static final String TAG = "MatSearchPresenter";

    public MatSearchPresenter(MatSearchContract.View mView) {
        this.mView = mView;
        mModel = new MatSearchModel();
    }

    @Override
    public void getHotWord() {
        Subscription subscribe = mModel.getHotWord()
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
                        Log.e(TAG, "获取热词失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        HotWordInfo info = JSONUtils.toObject(s, HotWordInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<HotWordInfo.HotWord> dataList = info.getBody();
                            mView.responseHotWordData(dataList);
                        } else {
                            mView.responseHotWordDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFuzzyInfo(String orderNo, String content) {
        Subscription subscribe = mModel.getFuzzyInfo(orderNo, content)
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
                        Log.e(TAG, "获取模糊搜索列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        HotWordInfo info = JSONUtils.toObject(s, HotWordInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<HotWordInfo.HotWord> dataList = info.getBody();
                            mView.responseFuzzyData(dataList);
                        } else {
                            mView.responseFuzzyDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
