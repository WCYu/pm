package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.EngineeringInfoContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/27.
 */

public class EngineeringInfoModel implements EngineeringInfoContract.Model {
    @Override
    public Observable<String> getEnvironmentList(String F_RWDID) {
        return ApiEngine.getInstance().getEqApiService()
                .etQuoteIgtem(F_RWDID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getTotalCost(String F_RWDID, String F_AREA_KEY) {
        return ApiEngine.getInstance().getEqApiService()
                .getTotalCost(F_RWDID,F_AREA_KEY)
                .compose(RxSchedulers.<String>switchThread());
    }


}
