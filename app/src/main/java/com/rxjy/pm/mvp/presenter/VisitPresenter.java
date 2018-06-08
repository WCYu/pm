package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.entity.VisitListInfo;
import com.rxjy.pm.mvp.contract.VisitContract;
import com.rxjy.pm.mvp.model.VisitModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/27.
 */

public class VisitPresenter extends VisitContract.Presenter {

    public static final String TAG = "VisitPresenter";

    public VisitPresenter(VisitContract.View mView) {
        this.mView = mView;
        mModel = new VisitModel();
    }

    @Override
    public void getVisit(String orderNo) {
        Subscription subscribe = mModel.getVisit(orderNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取回访列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        VisitListInfo info = JSONUtils.toObject(s, VisitListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<VisitListInfo.VisitInfo> dataList = info.getBody();
                            mView.responseVisitData(dataList);
                        } else {
                            mView.responseVisitDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subVisit(String orderNo, String content) {
        Subscription subscribe = mModel.subVisit(orderNo, content)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "提交回访失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseVisitSubData();
                        } else {
                            mView.responseVisitSubDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
