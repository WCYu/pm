package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.RoutingBean;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by AAA on 2017/8/28.
 */

public interface RoutingContract {

    interface View extends BaseView {

        void responseRoutingListData(List<RoutingBean.BodyBean> dataList, List<Map<String,String>> mlist);

        void responseRoutingListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getRoutingList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getRoutingList(
                String orderNo
        );

    }

}
