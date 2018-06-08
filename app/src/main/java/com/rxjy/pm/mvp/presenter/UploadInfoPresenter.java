package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.BankListInfo;
import com.rxjy.pm.entity.RelationListInfo;
import com.rxjy.pm.entity.SubInfo;
import com.rxjy.pm.entity.UploadImageInfo;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.mvp.contract.UploadInfoContract;
import com.rxjy.pm.mvp.model.UploadInfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2018/1/30.
 */

public class UploadInfoPresenter extends UploadInfoContract.Presenter {

    public static final String TAG = "UploadInfoPresenter";

    public UploadInfoPresenter(UploadInfoContract.View mView) {
        this.mView = mView;
        mModel = new UploadInfoModel();
    }

    @Override
    public void getUploadInfo(int uid) {
        Subscription subscribe = mModel.getUploadInfo(uid)
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
                        Log.e(TAG, "获取项目经理资料信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UploadInfo info = JSONUtils.toObject(s, UploadInfo.class);
                        if (info.getStatusCode() == 1) {
                            UploadInfo.Upload data = info.getBody();
                            mView.responseUploadInfoData(data);
                        } else {
                            mView.responseUploadInfoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getBankList() {
        Subscription subscribe = mModel.getBankList()
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取银行卡列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        BankListInfo info = JSONUtils.toObject(s, BankListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<BankListInfo.BankInfo> dataList = info.getBody();
                            mView.responseBankListData(dataList);
                        } else {
                            mView.responseBankListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getRelationList() {
        Subscription subscribe = mModel.getRelationList()
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取关系列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        RelationListInfo info = JSONUtils.toObject(s, RelationListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<RelationListInfo.RelationInfo> dataList = info.getBody();
                            mView.responseRelationData(dataList);
                        } else {
                            mView.responseRelationDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void uploadInfo(int uid, String name, String idCard, String bankCard, String bankCardMaster, String bankType, String bankAddress, String emergencyName, String emergencyRelation, String mobile, UploadImageInfo data) {
        Subscription subscribe = mModel.uploadInfo(uid, name, idCard, bankCard, bankCardMaster, bankType, bankAddress, emergencyName, emergencyRelation, mobile, data)
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
                        Log.e(TAG, "上传资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseInfoSubData();
                        } else {
                            mView.responseInfoSubDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
