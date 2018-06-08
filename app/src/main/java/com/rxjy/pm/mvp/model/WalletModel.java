package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.WalletContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/30.
 */
public class WalletModel implements WalletContract.Model {
    @Override
    public Observable<String> getWalletInfo(String cardNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getWalletInfo(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getWalletRecordList(String cardNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getGcApiService()
                .getWalletRecord(cardNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getWalletRecordLoadList(String cardNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getGcApiService()
                .getWalletRecord(cardNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }
}
