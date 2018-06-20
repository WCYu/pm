package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.DetailsBean;

import rx.Observable;

/**
 * Created by hjh on 2018/2/28.
 */

public interface ProjectDCContract {

    interface View extends BaseView {

        void responseProjectCData(DetailsBean info);

        void responseProjectCDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProjectCDetail(
                String rwdID,
                int OrderType
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProjectCDetail(
                String rwdID,
                int OrderType
        );

    }

}
