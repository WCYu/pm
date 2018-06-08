package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.MsgListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public interface MsgListContract {

    interface View extends BaseView {

        void responseMsgListData(List<MsgListInfo.MsgList> dataList);

        void responseMsgListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMsgList(
                int uid,
                int typeID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMsgList(
                int uid,
                int typeID
        );

    }

}
