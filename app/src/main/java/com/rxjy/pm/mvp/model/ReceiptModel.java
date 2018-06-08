package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public class ReceiptModel implements ReceiptContract.Model {
    @Override
    public Observable<String> getReceipt(String orderno, int pmuid) {
        return ApiEngine.getInstance().getLmApiService()
                .getReceiptData(orderno,pmuid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getReceiptConfirmation(String orderno, int pmuid) {
        return ApiEngine.getInstance().getLmApiService()
                .getConfirmationReceipt(orderno,pmuid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getProjectManager(String orderno, int pmuid, int pushstatus, String reason) {
        return ApiEngine.getInstance().getLmApiService()
                .getOperationData(orderno,pmuid,pushstatus,reason)
                .compose(RxSchedulers.<String>switchThread());
    }
}
