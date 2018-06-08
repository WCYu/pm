package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.VersionInfo;
import com.rxjy.pm.mvp.contract.MainContract;
import com.rxjy.pm.mvp.model.MainModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/20.
 */

public class MainPresenter extends MainContract.Presenter {

    public static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void getVersionInfo() {
        Subscription subscribe = mModel.getVersionInfo()
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("hjhvesonsssss",s);
                        VersionInfo info = JSONUtils.toObject(s, VersionInfo.class);
                        if (info.getStatusCode() == 0) {
                            VersionInfo.Version data = info.getBody();
                            mView.responseVersionData(data);
                        } else {
                            mView.responseVersionDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
