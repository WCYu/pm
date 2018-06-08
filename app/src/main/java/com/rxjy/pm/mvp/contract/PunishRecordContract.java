package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.PunishRecordInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/28.
 */

public interface PunishRecordContract {

    interface View extends BaseView {

        void responsePunishRecordData(List<PunishRecordInfo.PunishRecord> dataList);

        void responsePunishRecordDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getPunishRecordInfo(
                int uid,
                int type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getPunishRecordInfo(
                int uid,
                int type
        );

    }

}
