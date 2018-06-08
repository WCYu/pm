package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.HomeContract;
import com.rxjy.pm.mvp.model.HomeModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/31.
 */

public class HomePresenter extends HomeContract.Presenter {

    public static final String TAG = "HomePresenter";

    public HomePresenter(HomeContract.View mView) {
        this.mView = mView;
        mModel = new HomeModel();
    }

    @Override
    public void getProList(int uid) {
        Subscription subscribe = mModel.getProList(uid)
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
                        Log.e(TAG, "获取项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        ProjectInfo info = JSONUtils.toObject(s, ProjectInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProjectInfo.Project> dataList = info.getBody();
                            mView.responseProListData(dataList);
                        } else {
                            mView.responseProListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
