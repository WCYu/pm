package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by hjh on 2018/3/1.
 */

public interface ResultChatContract {

    interface View extends BaseView {

        void responsepostData();

        void responsepostDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> postData(
                String pi_OrderId,
                String pi_Remarks,
                String pi_State,
                ArrayList<String> imgslist
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void postData(
                String pi_OrderId,
                String pi_Remarks,
                String pi_State,
                ArrayList<String> imgslist
        );

    }
}
