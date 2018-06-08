package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.HotWordInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/12.
 */

public interface MatSearchContract {

    interface View extends BaseView {

        void responseHotWordData(List<HotWordInfo.HotWord> dataList);

        void responseHotWordDataError(String msg);

        void responseFuzzyData(List<HotWordInfo.HotWord> dataList);

        void responseFuzzyDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getHotWord(

        );

        Observable<String> getFuzzyInfo(
                String orderNo,
                String content
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getHotWord(

        );

        public abstract void getFuzzyInfo(
                String orderNo,
                String content
        );

    }

}
