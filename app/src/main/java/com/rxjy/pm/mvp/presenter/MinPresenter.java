package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.UserInfoPhoto;
import com.rxjy.pm.mvp.contract.MinContract;
import com.rxjy.pm.mvp.model.MinModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2018/3/27.
 */

public class MinPresenter extends MinContract.Presenter {
    public static final String TAG = "MinPresenter";

    public MinPresenter(MinContract.View mView) {
        this.mView=mView;
        mModel=new MinModel();
    }

    @Override
    public void loadPhotoImage(int uid) {
        Subscription subscribe = mModel.loadPhotoImage(uid)
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
                        Log.e(TAG, "获取消息详情失败 = " + e.toString());
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
                            mView.showMessage(userInfoPhoto.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
