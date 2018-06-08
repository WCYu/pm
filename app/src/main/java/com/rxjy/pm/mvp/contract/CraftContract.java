package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.CraftInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/24.
 */

public interface CraftContract {

    interface View extends BaseView {

        void responseCraftListData(List<CraftInfo.Craft> dataList);

        void responseCraftListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getCraftList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getCraftList(
                String orderNo
        );

    }

}
