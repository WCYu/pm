package com.rxjy.pm.commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;

import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.ImageLoaderUtil;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/4/11.
 */
public class App extends Application {

    private static App app;

    private List<Activity> activities;

    public static String apiKey = "rxjy@123";
    public static String apiValue = "IWCS@456";
    public static BaseActivity baseActivity;
    public static String token;
    public static String cardNo;

    public static UserInfo.User.BaseInfo baseInfo;
    public static UserInfo.User.PersonnelInfo personnelInfo;
    public static PmUserInfo.BodyBean pmUserInfo;
    public static  int workerid;

    public static  WorkerInfo.BodyBean workerInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化异常处理
        app = this;
        activities = new ArrayList<>();

        ImageLoaderUtil.init(this);
        //初始化推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        //更新版本
//        Multidex.install(this);
        AutoLayoutConifg.getInstance().useDeviceSize();

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static Application getApplication() {
        return app;
    }

    public static App getApp() {
        return app;
    }

    public static Context getContext() {
        return getApp().getApplicationContext();
    }

    //获取版本号
    public static String getVersionCode() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            return String.valueOf(info.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //获取版本名称
    public static String getVersionName() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //获取时间戳
    public static String getTimeStamp() {
        String timeStamp = "";
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return timeStamp;
    }

    public App addActivity(Activity activity) {
        activities.add(activity);
        return this;
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void finishSingleActivity(Class<?> cls) {
        Activity tempActivity = null;
        for (Activity activity : activities) {
            if (activity.getClass().equals(cls)) {
                tempActivity = activity;
            }
        }
        killActivity(tempActivity);
    }

    private void killActivity(Activity ac) {
        if (ac != null) {
            ac.finish();
        }
    }

    public void exitApp() {
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            killActivity(activities.get(i));
        }
        //解绑别名
        JPushInterface.deleteAlias(this, Constants.MSG_SET_ALIAS);
    }

}
