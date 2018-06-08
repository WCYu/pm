package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.ProjectInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/2/24.
 */

public interface ImageShowContract {

    interface View extends BaseView {

        void responseupdateiconData(String url);

        void responseupdateiconDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getupdateicon(
                String AttrId,
                String UId,
                String Modelid,
                String imglist
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getupdateicon(
                String AttrId,
                String UId,
                String Modelid,
                String imglist
        );

    }

}
