package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ConfirmationInfo;
import com.rxjy.pm.entity.ProInfo;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public interface AgreementContract  {

    interface View extends BaseView {

        void showDialog();

        void hideDialog();

        void showMessage(String message);

        void getAgreementImage(String image);

        void getSuccessfulOperation();


    }
    interface Model extends BaseModel {
        Observable<String> getPackageData(
                String orderno

        );
        //security
        Observable<String> getSecurityData(
                String orderno

        );
        //Administration
        Observable<String> getAdministrationData(
                String orderno

        );
        Observable<String> getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason
        );
    }
    abstract class Presenter extends BasePresenter<AgreementContract.View, AgreementContract.Model> {
        public abstract void getgetPackageData(
                String orderno

        );
        public abstract void getSecurityData(
                String orderno

        );
        public abstract void getAdministrationData(
                String orderno

        );
        public abstract void getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason
        );
    }
}
