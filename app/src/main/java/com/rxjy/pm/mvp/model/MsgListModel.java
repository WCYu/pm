package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.MsgListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgListModel implements MsgListContract.Model {
    @Override
    public Observable<String> getMsgList(int uid, int typeID) {
        return ApiEngine.getInstance().getGcApiService()
                .getMsgList(uid, typeID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
