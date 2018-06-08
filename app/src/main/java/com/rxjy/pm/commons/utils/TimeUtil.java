package com.rxjy.pm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AAA on 2017/10/18.
 */

public class TimeUtil {

    //        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getYear() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getMonth() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getDay() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getTime() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getNormalTime(String time) {
        String str = "";
        if (time == null) {
            return str;
        }
        if (time.contains("T")) {
            return time.substring(0, time.indexOf("T"));
        }
        if (time.contains(" ")){
            return time.substring(0, time.indexOf(" "));
        }
        return time;
    }

}
