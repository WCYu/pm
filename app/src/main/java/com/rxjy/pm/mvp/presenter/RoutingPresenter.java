package com.rxjy.pm.mvp.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.RoutingBean;
import com.rxjy.pm.mvp.contract.RoutingContract;
import com.rxjy.pm.mvp.model.RoutingModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/28.
 */

public class RoutingPresenter extends RoutingContract.Presenter {

    public static final String TAG = "RoutingPresenter";
    private JSONArray body;

    public RoutingPresenter(RoutingContract.View mView) {
        this.mView = mView;
        mModel = new RoutingModel();
    }

    @Override
    public void getRoutingList(final String orderNo) {
        Subscription subscribe = mModel.getRoutingList(orderNo)
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
                        Log.e(TAG, "获取巡检详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                        RoutingBean info = JSONUtils.toObject(s, RoutingBean.class);
                      //  JSONArray body =  JSON.parseArray("Body");
                        List<Map<String,String>> map=new ArrayList<Map<String, String>>();
                        try {
                            org.json.JSONObject json=new org.json.JSONObject(s);
                            body = json.getJSONArray("Body");
                            for (int i = 0; i <body.length() ; i++) {
                                org.json.JSONObject jsonObject = body.getJSONObject(i);
                                org.json.JSONObject dic = jsonObject.getJSONObject("Dic");
                                JSONObject t = JSON.parseObject(dic.toString());
                                Set<String> strings= t.keySet();
                                List<String> hh=new ArrayList<String>();
                                Map<String,String> mlist=new TreeMap<String, String>();
                                Iterator<String> iterator = strings.iterator();
                                while (iterator.hasNext()) {
                                    String next = iterator.next();
                                    if (next.contains("http://img9.rxjy.com:80")) {
                                        String string = t.getString(next);
                                       // hh.add(string);
                                        mlist.put(next,string);
                                    }
                                }
                                map.add(mlist);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }






                        if (info.getStatusCode() == 1) {
                            List<RoutingBean.BodyBean> dataList = info.getBody();



                            mView.responseRoutingListData(dataList,map);
                        } else {
                            mView.responseRoutingListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
