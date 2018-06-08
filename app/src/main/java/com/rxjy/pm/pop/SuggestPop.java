package com.rxjy.pm.pop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;

/**
 * Created by AAA on 2017/9/22.
 */

public class SuggestPop extends PopupWindow {

    public interface OnSuggestClickListener {

        void complain();

        void suggest();

    }

    private View mView;
    private Context mContext;
    private OnSuggestClickListener mListener;

    private TextView tvComplain;
    private TextView tvSuggest;
    private TextView tvOthers;

    public SuggestPop(Context context, int layoutId, int with, int height) {
        this.mContext = context;
        mView = LayoutInflater.from(context).inflate(layoutId, null);
        AutoUtils.auto(mView);
        setContentView(mView);
        //设置宽度
        setWidth(with);
        //设置宽度
        setHeight(height);
        //设置背景透明
        setBackgroundDrawable(new ColorDrawable(80));

        tvComplain = (TextView) mView.findViewById(R.id.tv_pop_complain);
        tvSuggest = (TextView) mView.findViewById(R.id.tv_pop_suggest);

        tvComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mListener != null)
                    mListener.complain();
            }
        });

        tvSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mListener != null)
                    mListener.suggest();
            }
        });

    }

    public void setOnSuggestClickListener(OnSuggestClickListener mListener) {
        this.mListener = mListener;
    }

    public void showPop(ImageView iv){
        setFocusable(true);
        showAsDropDown(iv, AutoUtils.getDisplayWidthValue(-80), 0);
        //如果窗口存在，则更新
        update();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        //设置背景变亮
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = 1.0f; //0.0-1.0  
        ((Activity) mContext).getWindow().setAttributes(lp);
    }

    @Override
    public void update() {
        super.update();
        //设置背景变暗
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = 0.7f; //0.0-1.0  
        ((Activity) mContext).getWindow().setAttributes(lp);
    }

}
