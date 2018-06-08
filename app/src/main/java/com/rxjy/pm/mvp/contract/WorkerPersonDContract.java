package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;
import com.rxjy.pm.entity.BankBean;
import com.rxjy.pm.entity.IconBean;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.entity.WorkerPersonDBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/2/23.
 */

public interface WorkerPersonDContract {

    interface View extends BaseView {

        void responsegetData(WorkerPersonDBean info);

        void responsegetDataError(String msg);

        void responsegetBankData(BankBean info);

        void responsegetBankDataError(String msg);

        void responsegetWorkData(BankBean info);

        void responsegetWorkDataError(String msg);

        void responsegetImgData();

        void responsegetImgDataError(String msg);

        void responsegetSubmitData();

        void responsegetSubmitDataError(String msg);

        void responsegetIconData(IconBean info);

        void responsegetIconDataError(String msg);

        void getUploadInfo(UploadInfo.Upload data);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getData(
                String mobile
        );
        Observable<String> getBankData(
        );
        Observable<String> getWorkData(
        );
        Observable<String> getImg(
                String mobile,
                String ImgType,
                List<String> imglist
        );
        Observable<String> getsubmit(
                String mobile,
                String IdCard,
                String BankCard,
                String Bank,
                String BankAccountName,
                String BankAddress,
                String RegisterPlace,
                String RefreeMobile,
                String Job
        );
        Observable<String> getIcon(
                String mobile
        );
        Observable<String> getUploadInfo(
                String mobile
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract String getUploadInfo(
                String mobile
        );
        public abstract void getData(
                String mobile
        );
        public abstract void getBankData(
        );
        public abstract void getWorkData(
        );
        public abstract void getImg(
                String mobile,
                String ImgType,
                List<String> imglist
        );
        public abstract void getsubmit(
                String mobile,
                String IdCard,
                String BankCard,
                String Bank,
                String BankAccountName,
                String BankAddress,
                String RegisterPlace,
                String RefreeMobile,
                String Job
        );
        public abstract void getIcon(
                String mobile
        );
    }
}
