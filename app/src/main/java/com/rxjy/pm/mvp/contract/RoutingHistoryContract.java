package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.RoutingHistoryInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/28.
 */

public interface RoutingHistoryContract {

    interface View extends BaseView {

        void responseRoutingHistoryListData(List<RoutingHistoryInfo.RoutingHistory> dataList);

        void responseRoutingHistoryListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getRoutingHistoryList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getRoutingHistoryList(
                String orderNo
        );

    }

}
