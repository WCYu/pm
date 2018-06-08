package com.rxjy.pm.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanwei on 2018/4/28.
 */

public class UiUtil {
    private static Toast mToast = null;

    public static Context getContext(Context context) {
        return context;
    }

    /**
     * 短吐司
     */
    public static void Toast(String text,Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(context), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 将xml转换成view对象
     */
    public static View getXmlView(int resId,Context context) {
        return View.inflate(getContext(context), resId, null);
    }

    /**
     * 获取颜色
     */
    public static int getColor(int colorId,Context context) {
        return getContext(context).getResources().getColor(colorId);
    }

    /**
     * 获取string
     */
    public static String getString(int stringId,Context context) {
        return getContext(context).getResources().getString(stringId);
    }


    /**
     * 获得状态栏的高度
     */
    public static int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = getContext(context).getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获得屏幕高度
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) getContext(context)
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) getContext(context)
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 1dp=1px;
     * 1dp=0.5px;
     * 1dp=0.75px;
     * 1dp=1.5px;
     */

    /**
     * dp转px
     */
    public static int dp2px(int dp,Context context) {
        float density = getContext(context).getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    /**
     * dp转px
     */
    public static int dp2px(float dp,Context context) {
        float density = getContext(context).getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    /**
     * px转dp
     */
    public static int px2dp(int px,Context context) {
        float density = getContext(context).getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }

    /**
     * sp转px
     */
    public static int sp2px(int spValue,Context context) {
        final float fontScale = getContext(context).getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     */
    public static float px2sp(float pxVal,Context context) {
        return (pxVal / getContext(context).getResources().getDisplayMetrics().scaledDensity);
    }


    /**
     * @param time
     * @param format "yyyy-MM-dd"
     * @return
     */
    public static String formatDate(long time, String format) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(d);
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
