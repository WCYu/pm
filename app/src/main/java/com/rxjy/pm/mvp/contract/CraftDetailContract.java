package com.rxjy.pm.mvp.contract;


import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.CraftDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/7/12.
 */

public interface CraftDetailContract {

    interface View extends BaseView {

        void responseSubCraftPhotoData();

        void responseSubCraftPhotoDataError(String msg);

        void responseCraftDetailData(List<CraftDetailInfo.CraftDetail> dataList);

        void responseCraftDetailDataError(String msg);

        void largePhoto(String url);

        void subCraftPhoto(CraftDetailInfo.CraftDetail data, int position);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getCraftDetail(
                int craftID
        );

        Observable<String> subCraftDetailPhoto(
                int craftID,
                int craftPhotoID,
                String url
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getCraftDetail(
                int craftID
        );

        public abstract void subCraftDetailPhoto(
                int craftID,
                int craftPhotoID,
                String url
        );

    }

}
