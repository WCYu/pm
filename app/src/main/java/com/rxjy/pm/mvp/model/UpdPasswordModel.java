package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.UpdPasswordContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class UpdPasswordModel implements UpdPasswordContract.Model {
    @Override
    public Observable<String> updatePwd(String cardNo, String password, String newPassword, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .updatePassword(cardNo, password, newPassword, token)
                .compose(RxSchedulers.<String>switchThread());
    }
}
