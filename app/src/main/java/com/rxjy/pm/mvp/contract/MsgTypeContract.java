package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.MsgTypeInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public interface MsgTypeContract {

    interface View extends BaseView {

        void responseMsgTypeData(List<MsgTypeInfo.MsgType.MsgInfo> dataList);

        void responseMsgTypeDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMstType(
                int uid
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMstType(
                int uid
        );

    }

}
