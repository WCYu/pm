package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ShopCartProInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/13.
 */

public interface ShopCartProContract {

    interface View extends BaseView {

        void responseShopCartProData(List<ShopCartProInfo.ShopCartPro> dataList);

        void responseShopCartProDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getShopCartPro(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getShopCartPro(
                int uid
        );

    }

}
