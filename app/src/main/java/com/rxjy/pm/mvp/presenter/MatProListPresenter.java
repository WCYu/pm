package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.mvp.contract.MatProListContract;
import com.rxjy.pm.mvp.model.MatProListModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/20.
 */

public class MatProListPresenter extends MatProListContract.Presenter {

    public static final String TAG = "MatProListPresenter";

    public MatProListPresenter(MatProListContract.View mView) {
        this.mView = mView;
        mModel = new MatProListModel();
    }

    @Override
    public void getMatProList(int uid) {
        Subscription subscribe = mModel.getMatProList(uid)
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
                        Log.e(TAG, "获取材料项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
        addSubscribe(subscribe);
    }
}
