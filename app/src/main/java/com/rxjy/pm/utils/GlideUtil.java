package com.rxjy.pm.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.commons.base.BaseActivity;

/**
 * Created by 阿禹 on 2018/3/28.
 * 加载图片工具类
 */

public class GlideUtil {

    public static GlideUtil getInstance() {
        return new GlideUtil();
    }

    public void setBitmip(String url, ImageView imageView, Context context) {
        Glide.with(context).load(url).into(imageView);
    }

    public void load(String url, ImageView imageView,Context context) {
        Glide.with(context).load(url).into(imageView);
    }

    //加在圆角
    public void loadRound(Object url, ImageView imageView,Context context){
        RoundCornersTransformation transformation =
                new RoundCornersTransformation(context, UiUtil.dp2px(5,context), RoundCornersTransformation.CornerType.ALL);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)//优先级
                .transform(transformation);//缓存策略
        Glide.with(context).load(url).apply(options).into(imageView);
    }

}
