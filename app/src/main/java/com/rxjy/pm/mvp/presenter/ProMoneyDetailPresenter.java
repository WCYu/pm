package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ProMoneyDetailInfo;
import com.rxjy.pm.mvp.contract.ProMoneyDetailContract;
import com.rxjy.pm.mvp.model.ProMoneyDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/17.
 */

public class ProMoneyDetailPresenter extends ProMoneyDetailContract.Presenter {

    public static final String TAG = "ProMoneyDetailPresenter";

    public ProMoneyDetailPresenter(ProMoneyDetailContract.View mView) {
        this.mView = mView;
        mModel = new ProMoneyDetailModel();
    }

    @Override
    public void getProMoneyDetailData(String orderNo) {
        Subscription subscribe = mModel.getProMoneyDetailData(orderNo)
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
                        Log.e(TAG, "获取项目详情款失败 " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProMoneyDetailInfo info = JSONUtils.toObject(s, ProMoneyDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            ProMoneyDetailInfo.ProMoneyDetail data = info.getBody();
                            List<ProMoneyDetailInfo.ProMoneyDetail.ProMoney> dataList = data.getList();
                            mView.responseProMoneyDetailData(data);
                            mView.responseProMoneyDetailListData(dataList);
                        } else {
                            mView.responseProMoneyDetailListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
