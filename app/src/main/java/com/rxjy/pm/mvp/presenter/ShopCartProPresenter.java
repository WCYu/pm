package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.ShopCartProInfo;
import com.rxjy.pm.mvp.contract.ShopCartProContract;
import com.rxjy.pm.mvp.model.ShopCartProModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/10/13.
 */

public class ShopCartProPresenter extends ShopCartProContract.Presenter {

    public static final String TAG = "ShopCartProPresenter";

    public ShopCartProPresenter(ShopCartProContract.View mView) {
        this.mView = mView;
        mModel = new ShopCartProModel();
    }

    @Override
    public void getShopCartPro(int uid) {
        Subscription subscribe = mModel.getShopCartPro(uid)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取购物车项目列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ShopCartProInfo info = JSONUtils.toObject(s, ShopCartProInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ShopCartProInfo.ShopCartPro> dataList = info.getBody();
                            mView.responseShopCartProData(dataList);
                        } else {
                            mView.responseShopCartProDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
