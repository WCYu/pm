package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.BankListInfo;
import com.rxjy.pm.entity.RelationListInfo;
import com.rxjy.pm.entity.UploadImageInfo;
import com.rxjy.pm.entity.UploadInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2018/1/30.
 */

public interface UploadInfoContract {

    interface View extends BaseView {

        void responseInfoSubData();

        void responseInfoSubDataError(String msg);

        void responseRelationData(List<RelationListInfo.RelationInfo> dataList);

        void responseRelationDataError(String msg);

        void responseBankListData(List<BankListInfo.BankInfo> dataList);

        void responseBankListDataError(String msg);

        void responseUploadInfoData(UploadInfo.Upload data);

        void responseUploadInfoDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getUploadInfo(
                int uid
        );

        Observable<String> getBankList(

        );

        Observable<String> getRelationList(

        );

        Observable<String> uploadInfo(
                int uid,
                String name,
                String idCard,
                String bankCard,
                String bankCardMaster,
                String bankType,
                String bankAddress,
                String emergencyName,
                String emergencyRelation,
                String mobile,
                UploadImageInfo data
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getUploadInfo(
                int uid
        );

        public abstract void getBankList(

        );

        public abstract void getRelationList(

        );

        public abstract void uploadInfo(
                int uid,
                String name,
                String idCard,
                String bankCard,
                String bankCardMaster,
                String bankType,
                String bankAddress,
                String emergencyName,
                String emergencyRelation,
                String mobile,
                UploadImageInfo data
        );

    }

}
