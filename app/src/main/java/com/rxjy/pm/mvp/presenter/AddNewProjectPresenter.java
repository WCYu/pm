package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.AddNewProjectInfo;
import com.rxjy.pm.mvp.contract.AddNewProjectContract;
import com.rxjy.pm.mvp.model.AddNewProjectModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2018/3/7.
 */

public class AddNewProjectPresenter extends AddNewProjectContract.Presenter {
    public static final String TAG = "AddNewProjectPresenter";

    public AddNewProjectPresenter(AddNewProjectContract.View view) {
        this.mView = view;
        this.mModel = new AddNewProjectModel();
    }


    @Override
    public void addNewProject(String clientName, String clientPhone, String projectName, double projectArea, int projectType, int projectState, int mAreaId, int mId, String mName) {
        Subscription subscribe = mModel.addNewProject(clientName, clientPhone, projectName, projectArea, projectType, 2, mAreaId, App.pmUserInfo.getUid(), mName)
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
                            onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("find",s);
                        AddNewProjectInfo info = JSONUtils.toObject(s, AddNewProjectInfo.class);
                        if(info.getStatusCode()==1)    {
                            mView.AddSuccess(info.getStatusMsg());
                            System.out.println(info.getStatusCode()+"++++++++++");
                        }else{
                            mView.AddFail("Fail");
                             System.out.println(info.getStatusCode()+"++++++++++");
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
