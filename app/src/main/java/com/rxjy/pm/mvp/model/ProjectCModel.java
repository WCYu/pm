package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ProjectDCContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectCModel implements ProjectDCContract.Model{


    @Override
    public Observable<String> getProjectCDetail(String rwdID,  int OrderType) {
        return ApiEngine.getInstance().getGccApiService()
                .getCustomerCDlist(rwdID,OrderType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
