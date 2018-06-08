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
import android.widget.ImageView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.MatInfo;

/**
 * Created by AAA on 2017/10/11.
 */

public class CountDialog extends Dialog {

    public interface OnYesOnClickListener {

        void onYes(double count, MatInfo.Mat data);

    }

    public interface OnNoOnClickListener {

        void onNo();

    }

    private OnYesOnClickListener onYesOnClickListener;
    private OnNoOnClickListener onNoOnClickListener;

    private Button btnYes;
    private Button btnNo;
    private ImageView ivAdd;
    private ImageView ivRemove;
    private EditText etCount;

    private String yesStr, noStr;

    private double count;

    private MatInfo.Mat data;

    private Context mContext;

    public CountDialog(@NonNull Context context) {
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

    public void setCount(double count, MatInfo.Mat data) {
        this.count = count;
        this.data = data;
        etCount.setText(this.count + "");
        //设置内容全选
        etCount.setText(etCount.getText().toString());// 添加这句后实现效果  
        etCount.selectAll();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(mContext, R.layout.dialog_count, null);
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
        ivAdd = (ImageView) findViewById(R.id.iv_dialog_add);
        ivRemove = (ImageView) findViewById(R.id.iv_dialog_remove);
        etCount = (EditText) findViewById(R.id.et_dialog_count);
        btnNo = (Button) findViewById(R.id.btn_dialog_no);
        btnYes = (Button) findViewById(R.id.btn_dialog_yes);
    }

    private void initEvent() {

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onYesOnClickListener != null)
                    onYesOnClickListener.onYes(count, data);
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

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                etCount.setText(count + "");
            }
        });

        ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 1) {
                    count = 0;
                    etCount.setText(count + "");
                } else {
                    count--;
                    etCount.setText(count + "");
                }
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
                    count = Double.parseDouble(s.toString());
                else
                    count = 0;
            }
        });

    }

}
