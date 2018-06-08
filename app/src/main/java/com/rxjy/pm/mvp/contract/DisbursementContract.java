package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.DisbursementInfo;
import com.rxjy.pm.entity.DisbursementListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/7/14.
 */

public interface DisbursementContract {

    interface View extends BaseView {

        void responseDisbursementData(DisbursementInfo.Disbursement data);

        void responseDisbursementDataError(String msg);

        void responseDisbursementListData(List<DisbursementListInfo.DisbursementList> dataList);

        void responseDisbursementListDataError(String msg);

        void responseDisbursementSubData();

        void responseDisbursementSubDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getDisbursementData(
                String orderNo
        );

        Observable<String> getDisbursementListData(
                String orderNo
        );

        Observable<String> subDisbursementData(
                String orderNo,
                double money,
                String reason,
                String fine_id,
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getDisbursementData(
                String orderNo
        );

        public abstract void getDisbursementListData(
                String orderNo
        );

        public abstract void subDisbursementData(
                String orderNo,
                double money,
                String reason,
                String fine_id,
                int uid
        );

    }

}
