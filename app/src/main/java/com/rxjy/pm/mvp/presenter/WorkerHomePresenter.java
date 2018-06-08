package com.rxjy.pm.mvp.presenter;

import android.renderscript.ScriptGroup;
import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.WalletInfo;
import com.rxjy.pm.entity.WorklistBean;
import com.rxjy.pm.fragment.BindingBean;
import com.rxjy.pm.mvp.contract.WalletContract;
import com.rxjy.pm.mvp.contract.WorkHomedataContract;
import com.rxjy.pm.mvp.model.WalletModel;
import com.rxjy.pm.mvp.model.WorkerHomeModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/3/31.
 */

public class WorkerHomePresenter extends WorkHomedataContract.Presenter {
    public static final String TAG = "WorkerHomePresenter";
    public WorkerHomePresenter(WorkHomedataContract.View mView) {
        this.mView = mView;
        mModel = new WorkerHomeModel();
    }
    @Override
    public void getData(String workerid) {
        Subscription subscribe = mModel.getData(workerid)
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
                        Log.e(TAG, "获取工人列表信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("qqss",s);
                        WorklistBean info = JSONUtils.toObject(s, WorklistBean.class);

                        if (info.getStatusCode() == 1) {
                            List<WorklistBean.BodyBean> body = info.getBody();

                            mView.responsegetData(body);
                        } else {
                            mView.responsegetDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getBinDing(String workerid, String orderno, String uid) {
        Subscription subscribe = mModel.getBinDing(workerid,orderno,uid)
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
                        Log.e(TAG, "获取绑定项目信息 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("s",s);
                       BindingBean info = JSONUtils.toObject(s, BindingBean.class);

                        if (info.getStatusCode() == 1) {
                            //String body = info.getBody();
                            mView.responseBinDing();
                            mView.responsegetDataError(info.getStatusMsg());
                        } else {
                           mView.responsegetDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
