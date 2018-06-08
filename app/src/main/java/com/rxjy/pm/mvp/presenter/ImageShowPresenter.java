package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.IconBean;
import com.rxjy.pm.entity.ResultBean;
import com.rxjy.pm.mvp.contract.ImageShowContract;
import com.rxjy.pm.mvp.model.ImageShowModel;


import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/2/24.
 */

public class ImageShowPresenter extends ImageShowContract.Presenter {

    public ImageShowPresenter(ImageShowContract.View view) {
        this.mView = view;
        mModel = new ImageShowModel();
    }

    @Override
    public void getupdateicon(String AttrId, String UId, String Modelid, String imglist) {
        Subscription subscribe = mModel.getupdateicon(AttrId, UId, Modelid, imglist)
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
                        Log.e("", "获取项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("修改图片结果",s);
                        IconBean info = JSONUtils.toObject(s, IconBean.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseupdateiconData(info.getBody());
                        } else {
                            mView.responseupdateiconDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
