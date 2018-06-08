package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.MsgDetailInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public interface MsgDetailContract {

    interface View extends BaseView {

        void responseMsgDetailData(MsgDetailInfo.MsgDetail data);

        void responseMsgDetailDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMsgDetail(
                int tsID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMsgDetail(
                int tsID
        );

    }

}
