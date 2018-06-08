package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.EvaluateMarkInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/10/26.
 */

public interface EvaluateContract {

    interface View extends BaseView {

        void responseEvaluateData(List<EvaluateMarkInfo.StarInfo> dataList);

        void responseEvaluateDataError(String msg);

        void responseEvaluateMatMerchant();

        void responseEvaluateMatMerchantError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getEvaluateMarks(
                int eType
        );

        Observable<String> subEvaluate(
                String orderID,
                int EvaluateStar,
                String remark,
                int userID,
                List<Integer> markItems
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getEvaluateMarks(
                int eType
        );

        public abstract void subEvaluate(
                String orderID,
                int EvaluateStar,
                String remark,
                int userID,
                List<Integer> markItems
        );

    }

}
