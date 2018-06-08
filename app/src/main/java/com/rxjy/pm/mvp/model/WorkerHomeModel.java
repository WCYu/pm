package com.rxjy.pm.mvp.model;

import android.util.Log;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.WorkHomedataContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/3/31.
 */

public class WorkerHomeModel implements WorkHomedataContract.Model {
    @Override
    public Observable<String> getData(String workerid) {
        return ApiEngine.getInstance().getGcApiService()
                .loadDataWork(Integer.parseInt(workerid))
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getBinDing(String workerid, String orderno, String uid) {
        Log.e("bug",workerid+  "      "+orderno+"         "+uid);
        return ApiEngine.getInstance().getGcApiService()
                .loadBinding(workerid,orderno,uid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
