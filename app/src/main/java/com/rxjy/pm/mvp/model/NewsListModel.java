package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.NewsListContract;
import com.rxjy.pm.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/15.
 */
public class NewsListModel implements NewsListContract.Model
{

    @Override
    public Observable<String> getNewsList(String cardNo, int pageIndex, int pageSize)
    {
        return ApiEngine.getInstance().getRxApiService()
                .getNewsList(cardNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getNewsListLoadMore(String cardNo, int pageIndex, int pageSize)
    {
        return ApiEngine.getInstance().getRxApiService()
                .getNewsList(cardNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }
}
