package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.AddBankCardContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/28.
 */

public class AddBankCardModel implements AddBankCardContract.Model {
    @Override
    public Observable<String> subAddBankCard(String token, String cardNo, String bankCard, String bankName, String bankUserName) {
        return ApiEngine.getInstance().getRsApiService()
                .subAddOrUpd(token, cardNo, bankCard, bankName, bankUserName)
                .compose(RxSchedulers.<String>switchThread());
    }
}
