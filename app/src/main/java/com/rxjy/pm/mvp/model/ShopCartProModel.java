package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ShopCartProContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/13.
 */

public class ShopCartProModel implements ShopCartProContract.Model {
    @Override
    public Observable<String> getShopCartPro(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getShopCartPro(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
