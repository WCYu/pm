package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ConfirmationInfo;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.ProInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public interface ReceiptContract {

    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void responseProInfo(ProInfo.BodyBean bodyBean);

        void showMessage(String message);

        void responseConfirmationInfo(ConfirmationInfo.BodyBean bodyBean);

         void getSuccessfulOperation();

    }

    interface Model extends BaseModel {
        Observable<String> getReceipt(
                String orderno,
                int pmuid

        );
        Observable<String> getReceiptConfirmation(
                String orderno,
                int pmuid

        );
        Observable<String> getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason
        );
    }
    abstract class Presenter extends BasePresenter<ReceiptContract.View, ReceiptContract.Model> {
        public abstract void getReceipt(
                String orderno,
                int pmuid
        );
        public abstract void getReceiptConfirmation(
                String orderno,
                int pmuid
        );
        public abstract void getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason
        );
    }
}
