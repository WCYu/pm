package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProjectInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public interface FefundContract {
    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void toIntent();

    }
    interface Model extends BaseModel {

        Observable<String> getProjectManager(
              String orderno,
              int pmuid,
              int pushstatus,
              String reason
        );

    }
    abstract class Presenter extends BasePresenter<FefundContract.View, FefundContract.Model> {
        public abstract void getProjectManager(
                String orderno,
                int pmuid,
                int pushstatus,
                String reason
        );
    }
}
