package com.rxjy.pm.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import com.rxjy.pm.R;

public class AddIndicateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplication();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d  = windowManager.getDefaultDisplay();
        android.view.WindowManager.LayoutParams p=getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.5); // 高度设置为屏幕的0.3
        p.width = (int) (d.getWidth() * 0.7); // 宽度设置为屏幕的0.7
        getWindow().setAttributes(p);
        setContentView(R.layout.activity_add_indicate);
    }

}
