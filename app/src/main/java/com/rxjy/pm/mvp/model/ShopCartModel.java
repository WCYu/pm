package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.utils.DoubleUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.DelMatJson;
import com.rxjy.pm.entity.PaymentJson;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.entity.SubjoinJson;
import com.rxjy.pm.entity.UpdCheckedJson;
import com.rxjy.pm.entity.UpdMatJson;
import com.rxjy.pm.mvp.contract.ShopCartContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/10/16.
 */

public class ShopCartModel implements ShopCartContract.Model {
    @Override
    public Observable<String> getShopCart(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getShopCart(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updAllCheckedStatus(String orderNo, int IsChecked) {

        UpdCheckedJson info = new UpdCheckedJson();
        info.setOrderNo(orderNo);
        info.setIsChecked(IsChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updCheckedStatus(body)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updAllMerchantCheckedStatus(String orderNo, int userID, int IsChecked) {

        UpdCheckedJson info = new UpdCheckedJson();
        info.setOrderNo(orderNo);
        info.setUserID(userID);
        info.setIsChecked(IsChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updCheckedStatus(body)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updAllMatCheckedStatus(String orderNo, String matID, int userID, int IsChecked) {

        UpdCheckedJson info = new UpdCheckedJson();
        info.setOrderNo(orderNo);
        info.setMatID(matID);
        info.setUserID(userID);
        info.setIsChecked(IsChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updCheckedStatus(body)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> updMat(String orderNo, String matID, int userID, double count, int isChecked) {

        UpdMatJson info = new UpdMatJson(orderNo, matID, userID, count, isChecked);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updMat(body)
                .compose(RxSchedulers.<String>switchThread());

    }

    @Override
    public Observable<String> updSubjoin(String orderNo, int userID, String subSubjoinPrice, int type) {

        SubjoinJson info = new SubjoinJson();

        switch (type) {
            case 0:
                info.setOrderNo(orderNo);
                info.setUserID(userID);
                info.setIsFPrice(1);
                info.setFPrice(Double.parseDouble(subSubjoinPrice));
                break;
            case 1:
                info.setOrderNo(orderNo);
                info.setUserID(userID);
                info.setIsPPrice(1);
                info.setPPrice(Double.parseDouble(subSubjoinPrice));
                break;
            case 2:
                info.setOrderNo(orderNo);
                info.setUserID(userID);
                info.setIsAPrice(1);
                info.setAPrice(Double.parseDouble(subSubjoinPrice));
                break;
            case 3:
                info.setOrderNo(orderNo);
                info.setUserID(userID);
                info.setIsOTime(1);
                info.setOTime(subSubjoinPrice);
                break;
        }

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .updSubjoin(body)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> delMat(String orderNo, String matID) {

        DelMatJson info = new DelMatJson();
        info.setOrderNo(orderNo);
        info.setMatID(matID);

        String json = JSONUtils.toString(info);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .delMat(body)
                .compose(RxSchedulers.<String>switchThread());

    }

    @Override
    public Observable<String> payment(String orderNo, List<ShopCartInfo.ShopCart.Merchant> merList) {

        List<PaymentJson> list = new ArrayList<>();

        for (ShopCartInfo.ShopCart.Merchant info : merList) {
            if (info.getChecked() == 0) {
                continue;
            } else {
                PaymentJson json = new PaymentJson();
                json.setOrderNo(orderNo);
                json.setUserID(info.getUserID());
                json.setTotalMoney(getTotal(info));
                list.add(json);
            }
        }

        String json = JSONUtils.toString(list);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        return ApiEngine.getInstance().getGcApiService()
                .payment(body)
                .compose(RxSchedulers.<String>switchThread());
    }

    private double getTotal(ShopCartInfo.ShopCart.Merchant data) {
        double sum = 0;
        if (data.getChecked() != 0) {
            Double aPrice = Double.parseDouble(data.getAPrice().equals("") ? 0 + "" : data.getAPrice());
            Double pPrice = Double.parseDouble(data.getPPrice().equals("") ? 0 + "" : data.getPPrice());
            Double fPrice = Double.parseDouble(data.getFPrice().equals("") ? 0 + "" : data.getFPrice());
            sum = sum + aPrice + pPrice + fPrice;
        }
        for (ShopCartInfo.ShopCart.Merchant.Mat mat : data.getItems()) {
            if (mat.getIsChecked() == 0) {
                continue;
            } else {
                Double count = Double.parseDouble(mat.getBuyCount().equals("") ? 0 + "" : mat.getBuyCount());
                Double price = Double.parseDouble(mat.getMatPrice().equals("") ? 0 + "" : mat.getMatPrice());
                sum = sum + DoubleUtils.mul(count, price);
            }
        }
        return sum;
    }
}
