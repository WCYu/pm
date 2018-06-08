package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.AddBankCardContract;
import com.rxjy.pm.mvp.model.AddBankCardModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/28.
 */

public class AddBankCardPresenter extends AddBankCardContract.Presenter {

    public static final String TAG = "AddBankCardPresenter";

    public AddBankCardPresenter(AddBankCardContract.View mView) {
        this.mView = mView;
        mModel = new AddBankCardModel();
    }

    @Override
    public void subAddBankCard(String token, String cardNo, String bankCard, String bankName, String bankUserName) {
        Subscription subscribe = mModel.subAddBankCard(token, cardNo, bankCard, bankName, bankUserName)
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
                        Log.e(TAG, "添加银行卡失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseAddBankCard();
                        }else if (info.getStatusCode() == 104){
                            mView.reLogin(info.getStatusMsg());
                        }else {
                            mView.responseAddBankCardError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
