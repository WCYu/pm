package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.MsgListInfo;
import com.rxjy.pm.mvp.contract.MsgListContract;
import com.rxjy.pm.mvp.model.MsgListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgListPresenter extends MsgListContract.Presenter {

    public static final String TAG = "MsgListPresenter";

    public MsgListPresenter(MsgListContract.View mView) {
        this.mView = mView;
        mModel = new MsgListModel();
    }

    @Override
    public void getMsgList(int uid, int typeID) {
        Subscription subscribe = mModel.getMsgList(uid, typeID)
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
                        Log.e(TAG, "获取消息列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MsgListInfo info = JSONUtils.toObject(s, MsgListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<MsgListInfo.MsgList> dataList = info.getBody();
                            mView.responseMsgListData(dataList);
                        } else {
                            mView.responseMsgListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
