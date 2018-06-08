package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProjectDBean;
import com.rxjy.pm.mvp.contract.ProjectDContract;
import com.rxjy.pm.mvp.model.ProjectModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectDPersenter extends ProjectDContract.Presenter{

    public ProjectDPersenter(ProjectDContract.View mView) {
        this.mView = mView;
        mModel = new ProjectModel();
    }

    @Override
    public void getProjectDetail(String rwdID) {
        Subscription subscribe = mModel.getProjectDetail(rwdID)
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
                        Log.e("", "获取消息类型列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("ProjectDPersenter",s);
                        ProjectDBean info = JSONUtils.toObject(s, ProjectDBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseProjectData(info);
                        } else {
                            mView.responseProjectDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }
}
