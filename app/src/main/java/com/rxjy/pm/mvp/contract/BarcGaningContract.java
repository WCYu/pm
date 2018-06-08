package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ConfirmationInfo;
import com.rxjy.pm.entity.ProInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/5/16.
 */

public interface BarcGaningContract  {

    interface View extends BaseView {


        void showDialog();

        void hideDialog();


        void showMessage(String message);

        void getSuccessfulOperation();

    }
    interface Model extends BaseModel {

        Observable<String> getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason,
                List<String>imglist
        );
    }
    abstract class Presenter extends BasePresenter<BarcGaningContract.View, BarcGaningContract.Model> {
        public abstract void getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason,
                List<String>imglist
        );
    }
}
