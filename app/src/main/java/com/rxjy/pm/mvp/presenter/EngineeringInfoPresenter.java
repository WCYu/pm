package com.rxjy.pm.mvp.presenter;

import android.support.annotation.MainThread;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CraftDetailInfo;
import com.rxjy.pm.entity.EngineeringInfo;
import com.rxjy.pm.mvp.contract.CraftDetailContract;
import com.rxjy.pm.mvp.contract.EngineeringInfoContract;
import com.rxjy.pm.mvp.model.CraftDetailModel;
import com.rxjy.pm.mvp.model.EngineeringInfoModel;
import com.rxjy.pm.widget.data.Type;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/27.
 */

public class EngineeringInfoPresenter extends EngineeringInfoContract.Presenter {

    public static final String TAG = "CraftDetailPresenter";

    public EngineeringInfoPresenter(EngineeringInfoContract.View mView) {
        this.mView = mView;
        mModel = new EngineeringInfoModel();
    }
    @Override
    public void getEnvironmentList(String F_RWDID) {
        Subscription subscribe = mModel.getEnvironmentList(F_RWDID)
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
                        Log.e(TAG, "获取工程量失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                      //  Log.e("lrjgc",s);

                        mView.responseEnvironmentListData(s);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getTotalCost(String F_RWDID, String F_AREA_KEY) {
        Subscription subscribe = mModel.getTotalCost(F_RWDID,F_AREA_KEY)
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
                        Log.e(TAG, "获取工程量失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        mView.responseEnvironmentData(s);
                    }
                });
        addSubscribe(subscribe);
    }



}
