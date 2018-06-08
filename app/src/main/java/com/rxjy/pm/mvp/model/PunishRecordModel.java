package com.rxjy.pm.mvp.model;

import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.mvp.contract.PunishRecordContract;
import com.rxjy.pm.rx.RxSchedulers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import rx.Observable;

/**
 * Created by AAA on 2017/8/28.
 */

public class PunishRecordModel implements PunishRecordContract.Model {
    @Override
    public Observable<String> getPunishRecordInfo(int uid, int type) {

        String before = getBeforeOneMonthDate();

        return ApiEngine.getInstance().getGcApiService()
                .getPunishRecordInfo(uid, type, before)
                .compose(RxSchedulers.<String>switchThread());
    }

    /**
     * 获取30天之前的日期
     *
     * @return
     */
    private String getBeforeOneMonthDate() {
        String time = "";
        Calendar c = Calendar.getInstance();
        String[] months = new String[30];
        StringBuilder date = new StringBuilder();
        String firstday = "";
        for (int i = 0; i < 30; i++) {
            months[i] = new SimpleDateFormat("yyyy-MM-dd").format(new Date(
                    c.getTimeInMillis()));
            c.add(Calendar.DAY_OF_MONTH, -1);
            if (i == months.length - 1) {
                firstday = months[i];
            }
        }
        date.append(firstday);
        time = date.toString();
        return time;
    }

}
