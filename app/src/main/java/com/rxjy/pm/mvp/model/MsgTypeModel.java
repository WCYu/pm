package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MsgTypeContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgTypeModel implements MsgTypeContract.Model {
    @Override
    public Observable<String> getMstType(int uid) {
        return ApiEngine.getInstance().getGcApiService()
                .getMsgType(uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
