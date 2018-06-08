package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.mvp.contract.AddNewProjectContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2018/3/7.
 */

public class AddNewProjectModel implements AddNewProjectContract.Model {

    @Override
    public Observable<String> addNewProject(String clientName, String clientPhone, String projectName, double projectArea, int projectType, int projectState, int mAreaId, int mId, String mName) {
        return ApiEngine.getInstance().getGccApiService()
                .addNewProject(
                        clientName,
                        clientPhone,
                        projectName,
                        projectArea,
                        projectType,
                        App.pmUserInfo.getUser_join_state(),
                        mAreaId,
                        App.pmUserInfo.getUid(),
                        mName)
                .compose(RxSchedulers.<String>switchThread());
    }
}
