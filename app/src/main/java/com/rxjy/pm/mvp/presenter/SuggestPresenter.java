package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.SuggestContract;
import com.rxjy.pm.mvp.model.SuggestModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/22.
 */

public class SuggestPresenter extends SuggestContract.Presenter {

    public static final String TAG = "SuggestPresenter";

    public SuggestPresenter(SuggestContract.View mView) {
        this.mView = mView;
        mModel = new SuggestModel();
    }

    @Override
    public void subSuggestInfo(int uid, int type, String content, final List<LocalMedia> imgList) {
        Subscription subscribe = mModel.subSuggestInfo(uid, type, content, imgList)
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
                        Log.e(TAG, "投诉失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s,SubInfo.class);
                        if (info.getStatusCode() == 0){
                            mView.responseSuggestData();
                        }else {
                            mView.responseSuggestDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
