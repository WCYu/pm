package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by AAA on 2017/7/28.
 */

public interface AddBankCardContract {

    interface View extends BaseView {

        void responseAddBankCard();

        void responseAddBankCardError(String msg);

        void reLogin(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> subAddBankCard(
                String token,
                String cardNo,
                String bankCard,
                String bankName,
                String bankUserName
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void subAddBankCard(
                String token,
                String cardNo,
                String bankCard,
                String bankName,
                String bankUserName
        );
    }

}
