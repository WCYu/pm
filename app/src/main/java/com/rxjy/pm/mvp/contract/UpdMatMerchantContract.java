package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.MerChantInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/13.
 */

public interface UpdMatMerchantContract {

    interface View extends BaseView {

        void responseMerchantListData(List<MerChantInfo.Merchant> dataList);

        void responseMerchantListDataError(String msg);

        void responseUpdMerchant();

        void responseUpdMerchantError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMerchantList(
                String matID
        );

        Observable<String> updMerchant(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMerchantList(
                String matID
        );

        public abstract void updMerchant(
                String orderNo,
                String matID,
                int userID,
                double count,
                int isChecked
        );

    }

}
