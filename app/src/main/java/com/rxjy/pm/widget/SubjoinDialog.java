package com.rxjy.pm.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;

/**
 * Created by AAA on 2017/10/11.
 */

public class SubjoinDialog extends Dialog {

    public interface OnYesOnClickListener {

        void onYes(int count, int matID);

    }

    public interface OnNoOnClickListener {

        void onNo();

    }

    private OnYesOnClickListener onYesOnClickListener;
    private OnNoOnClickListener onNoOnClickListener;

    private Button btnYes;
    private Button btnNo;
    private EditText etCount;
    private TextView tvTitle;

    private String yesStr, noStr;

    private int count;

    private int userID;

    private Context mContext;

    public SubjoinDialog(@NonNull Context context) {
        super(context, R.style.CountDialog);
        this.mContext = context;
    }

    //设置确认按钮
    public void setOnYesOnClickListener(String str, OnYesOnClickListener onYesOnClickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.onYesOnClickListener = onYesOnClickListener;
    }

    //设置取消按钮
    public void setOnNoOnClickListener(String str, OnNoOnClickListener onNoOnClickListener) {
        if (str != null) {
            noStr = str;
        }
        this.onNoOnClickListener = onNoOnClickListener;
    }

    public void setCount(int count, int userID) {
        this.count = count;
        this.userID = userID;
        etCount.setText(this.count + "");
        //设置内容全选
        etCount.setText(etCount.getText().toString());// 添加这句后实现效果  
        etCount.selectAll();
    }

    public void setHintText(String hintText) {
        if (hintText != null)
            etCount.setHint(hintText);
    }

    public void setTitleText(String titleText) {
        if (titleText != null)
            tvTitle.setText(titleText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(mContext, R.layout.dialog_subjoin, null);
        AutoUtils.auto(rootView);
        setContentView(rootView);
        //按空白处不取消
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面控件的事件
        initEvent();

    }

    private void initView() {
        etCount = (EditText) findViewById(R.id.et_dialog_count);
        btnNo = (Button) findViewById(R.id.btn_dialog_no);
        btnYes = (Button) findViewById(R.id.btn_dialog_yes);
        tvTitle = (TextView) findViewById(R.id.tv_dialog_title);
    }

    private void initEvent() {

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onYesOnClickListener != null)
                    onYesOnClickListener.onYes(count, userID);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onNoOnClickListener != null)
                    onNoOnClickListener.onNo();
            }
        });

        etCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(""))
                    count = Integer.parseInt(s.toString());
                else
                    count = 0;
            }
        });

    }

}
