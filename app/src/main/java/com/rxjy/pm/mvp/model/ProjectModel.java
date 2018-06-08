package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.ProjectDContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectModel implements ProjectDContract.Model{


    @Override
    public Observable<String> getProjectDetail(String rwdID) {
        return ApiEngine.getInstance().getGccApiService()
                .getCustomerDlist(rwdID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
