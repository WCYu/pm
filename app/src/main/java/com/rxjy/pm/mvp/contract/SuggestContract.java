package com.rxjy.pm.mvp.contract;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/22.
 */

public interface SuggestContract {

    interface View extends BaseView {

        void responseSuggestData();

        void responseSuggestDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> subSuggestInfo(
                int uid,
                int type,
                String content,
                List<LocalMedia> imgList
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void subSuggestInfo(
                int uid,
                int type,
                String content,
                List<LocalMedia> imgList
        );

    }

}
