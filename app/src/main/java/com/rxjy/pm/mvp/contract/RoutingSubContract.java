package com.rxjy.pm.mvp.contract;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/14.
 */

public interface RoutingSubContract {

    interface View extends BaseView {

        void responseRoutingSubData();

        void responseRoutingSubDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> subRoutingData(
                int xjID,
                String content,
                String address,
                double xjX,
                double xjY,
                List<LocalMedia> imgList
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void subRoutingData(
                int xjID,
                String content,
                String address,
                double xjX,
                double xjY,
                List<LocalMedia> imgList
        );

    }

}
