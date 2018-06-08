package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.OrdersContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/9.
 */

public class OrdersModel implements OrdersContract.Model {
    @Override
    public Observable<String> toSubmit(String startTime, String endTime, String summary, int uid, int state) {
        return ApiEngine.getInstance().getLmApiService()
                .postSubmit(startTime,endTime,summary,uid,state)
                .compose(RxSchedulers.<String>switchThread());
    }
    @Override
    public Observable<String> getSubmit(int uid) {
        return ApiEngine.getInstance().getLmApiService()
                .getSubmit(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
