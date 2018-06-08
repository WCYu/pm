package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import rx.Observable;

/**
 * Created by asus on 2018/4/2.
 */

public interface WorkerMinContract  {
    interface View extends BaseView{
        void showDialog();

        void hideDialog();
        void showMeaage(String msg);

        void loadPhotoImage(String image);
    }
    interface Model extends BaseModel{
        Observable<String> loadPhotoImage(
                String model
        );
    }
    abstract class Presenter extends BasePresenter<WorkerMinContract.View, WorkerMinContract.Model> {
        public abstract void loadPhotoImage(
                String mldel

        );
    }
}
