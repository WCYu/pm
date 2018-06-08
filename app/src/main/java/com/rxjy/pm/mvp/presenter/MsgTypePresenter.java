package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.MsgTypeInfo;
import com.rxjy.pm.mvp.contract.MsgTypeContract;
import com.rxjy.pm.mvp.model.MsgTypeModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgTypePresenter extends MsgTypeContract.Presenter {

    public static final String TAG = "MsgTypePresenter";

    public MsgTypePresenter(MsgTypeContract.View mView) {
        this.mView = mView;
        mModel = new MsgTypeModel();
    }

    @Override
    public void getMstType(int uid) {
        Subscription subscribe = mModel.getMstType(uid)
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
                        Log.e(TAG, "获取消息类型列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MsgTypeInfo info = JSONUtils.toObject(s, MsgTypeInfo.class);
                        if (info.getStatusCode() == 1) {
                            MsgTypeInfo.MsgType data = info.getBody();
                            List<MsgTypeInfo.MsgType.MsgInfo> dataList = data.getList();
                            mView.responseMsgTypeData(dataList);
                        } else {
                            mView.responseMsgTypeDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
