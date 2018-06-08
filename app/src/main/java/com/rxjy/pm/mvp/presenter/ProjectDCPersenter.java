package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.DetailsBean;
import com.rxjy.pm.entity.ProjectCBean;
import com.rxjy.pm.mvp.contract.ProjectDCContract;
import com.rxjy.pm.mvp.model.ProjectCModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectDCPersenter extends ProjectDCContract.Presenter{

    public ProjectDCPersenter(ProjectDCContract.View mView) {
        this.mView=mView;
        this.mModel=new ProjectCModel();
    }

    @Override
    public void getProjectCDetail(String rwdID) {
        Subscription subscribe = mModel.getProjectCDetail(rwdID)
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
                        Log.e("ccccccc",s);
                        DetailsBean info= JSONUtils.toObject(s, DetailsBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseProjectCData(info);
                        } else {
                            mView.responseProjectCDataError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
