package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.UserInfoPhoto;
import com.rxjy.pm.mvp.contract.MinContract;
import com.rxjy.pm.mvp.contract.WorkerMinContract;
import com.rxjy.pm.mvp.model.MinModel;
import com.rxjy.pm.mvp.model.WorkerMinModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/2.
 */

public class WorkerMinPresenter extends WorkerMinContract.Presenter {
    public static final String TAG = "MinPresenter";

    public WorkerMinPresenter(WorkerMinContract.View mView) {
        this.mView=mView;
        mModel=new WorkerMinModel();
    }
    @Override
    public void loadPhotoImage(String mldel) {
        Subscription subscribe = mModel.loadPhotoImage(mldel)
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
                        Log.e(TAG, "获取头像失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        // MsgDetailInfo info = JSONUtils.toObject(s, MsgDetailInfo.class);
                        UserInfoPhoto userInfoPhoto = JSONUtils.toObject(s, UserInfoPhoto.class);
                        if (userInfoPhoto.getStatusCode() == 1) {
                            String data = userInfoPhoto.getBody();
                            mView.loadPhotoImage(data);
                        } else {
                            mView.showMeaage(userInfoPhoto.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
