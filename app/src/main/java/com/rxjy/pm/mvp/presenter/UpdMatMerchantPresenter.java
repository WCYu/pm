package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.MerChantInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.UpdMatMerchantContract;
import com.rxjy.pm.mvp.model.UpdMatMerchantModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/13.
 */

public class UpdMatMerchantPresenter extends UpdMatMerchantContract.Presenter {

    public static final String TAG = "UpdMatMerchantPresenter";

    public UpdMatMerchantPresenter(UpdMatMerchantContract.View mView) {
        this.mView = mView;
        mModel = new UpdMatMerchantModel();
    }

    @Override
    public void getMerchantList(String matID) {
        Subscription subscribe = mModel.getMerchantList(matID)
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
                        Log.e(TAG, "获取材料商列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MerChantInfo info = JSONUtils.toObject(s, MerChantInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<MerChantInfo.Merchant> dataList = info.getBody();
                            mView.responseMerchantListData(dataList);
                        } else {
                            mView.responseMerchantListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void updMerchant(String orderNo, String matID, int userID, double count, int isChecked) {
        Subscription subscribe = mModel.updMerchant(orderNo, matID, userID, count, isChecked)
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
                        Log.e(TAG, "修改材料商失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUpdMerchant();
                        } else {
                            mView.responseUpdMerchantError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
