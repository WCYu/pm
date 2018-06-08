package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.VisitProListInfo;
import com.rxjy.pm.mvp.contract.VisitProListContract;
import com.rxjy.pm.mvp.model.VisitProListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/26.
 */

public class VisitProListPresenter extends VisitProListContract.Presenter {

    public static final String TAG = "VisitProListPresenter";

    public VisitProListPresenter(VisitProListContract.View mView) {
        this.mView = mView;
        mModel = new VisitProListModel();
    }

    @Override
    public void getVisitProList(int uid) {
        Subscription subscribe = mModel.getVisitProList(uid)
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
                        Log.e(TAG, "获取回访项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        VisitProListInfo info = JSONUtils.toObject(s, VisitProListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<VisitProListInfo.VisitProList> dataList = info.getBody();
                            mView.responseVisitProListData(dataList);
                        } else {
                            mView.responseVisitProListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
