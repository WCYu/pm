package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.CustomerContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public class CustomerModel implements CustomerContract.Model{


    @Override
    public Observable<String> getCustomerList(String uid) {
        return ApiEngine.getInstance().getGccApiService()
                .getCustomerlist(uid)
                .compose(RxSchedulers.<String>switchThread());
    }


}