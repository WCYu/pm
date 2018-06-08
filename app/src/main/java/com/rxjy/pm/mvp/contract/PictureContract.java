package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProcessInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/26.
 */

public interface PictureContract {

    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void showMessage(String message);

        void responseEffect(List<String> data);

        void responseConstruction(List<String> data);

    }
    interface Model extends BaseModel {
        Observable<String> getConstructionPicture(
                String orderno

        );
        Observable<String> getEffectPicture(
                String orderno

        );
    }
    abstract class Presenter extends BasePresenter<PictureContract.View, PictureContract.Model> {
        public abstract void getConstructionPicture(

                String orderno

        );

        public abstract void getEffectPicture(
                String orderno

        );
    }
}
