package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CraftDetailInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.mvp.contract.CraftDetailContract;
import com.rxjy.pm.mvp.model.CraftDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/24.
 */

public class CraftDetailPresenter extends CraftDetailContract.Presenter {

    public static final String TAG = "CraftDetailPresenter";

    public CraftDetailPresenter(CraftDetailContract.View mView) {
        this.mView = mView;
        mModel = new CraftDetailModel();
    }

    @Override
    public void getCraftDetail(int craftID) {
        Subscription subscribe = mModel.getCraftDetail(craftID)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取工艺详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CraftDetailInfo info = JSONUtils.toObject(s, CraftDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<CraftDetailInfo.CraftDetail> dataList = info.getBody();
                            mView.responseCraftDetailData(dataList);
                        } else {
                            mView.responseCraftDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subCraftDetailPhoto(int craftID, int craftPhotoID, String url) {
        Subscription subscribe = mModel.subCraftDetailPhoto(craftID, craftPhotoID, url)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "上传工艺详情照片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubCraftPhotoData();
                        } else {
                            mView.responseSubCraftPhotoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
