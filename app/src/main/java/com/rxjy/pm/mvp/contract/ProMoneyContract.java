package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProMoneyInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/25.
 */

public interface ProMoneyContract {

    interface View extends BaseView {

        void responseProMoneyListData(List<ProMoneyInfo.ProMoney> dataList);

        void responseProdMoneyListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProMoneyList(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProMoneyList(
                int uid
        );

    }

}
