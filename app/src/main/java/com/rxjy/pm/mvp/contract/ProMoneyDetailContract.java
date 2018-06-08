package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProMoneyDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/17.
 */

public interface ProMoneyDetailContract {

    interface View extends BaseView {

        void responseProMoneyDetailData(ProMoneyDetailInfo.ProMoneyDetail data);

        void responseProMoneyDetailListData(List<ProMoneyDetailInfo.ProMoneyDetail.ProMoney> dataList);

        void responseProMoneyDetailListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProMoneyDetailData(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProMoneyDetailData(
                String orderNo
        );

    }

}
