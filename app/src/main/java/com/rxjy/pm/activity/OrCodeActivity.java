package com.rxjy.pm.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.ZxingUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/3/31.
 */

public class OrCodeActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.worker_or_code)
    ImageView workerOrCode;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;

    @Override
    public int getLayout() {
        return R.layout.activity_qr_code;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(Constants.ORDERNO);
        int intExtra = intent.getIntExtra(Constants.CITYID, 0);
        Log.e("tag",stringExtra);
        Log.e("tag",intExtra+"");
        tvStaterd.setVisibility(View.VISIBLE);
        tvStaterd.setText("下载");
        tvTitle.setText("扫一扫");
        Log.e("erweima", App.baseInfo+stringExtra+intExtra);
        final Bitmap bitmap = ZxingUtils.createBitmap(stringExtra+":"+intExtra);
       Log.e("tag",stringExtra+"        :        "+intExtra);
        workerOrCode.setImageBitmap(bitmap);
        tvStaterd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBitmapFile(bitmap);
            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.worker_or_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.worker_or_code:
               // SystemClock.elapsedRealtime()
                break;
        }
    }

    @OnClick(R.id.tv_staterd)
    public void onViewClicked() {
    }
    public void saveBitmapFile(Bitmap bitmap){

        File temp = new File("/sdcard/1delete/");//要保存文件先创建文件夹
        if (!temp.exists()) {
            temp.mkdir();
        }
        ////重复保存时，覆盖原同名图片
        File file=new File("/sdcard/1delete/1.jpg");//将要保存图片的路径和图片名称
        //    File file =  new File("/sdcard/1delete/1.png");/////延时较长
        try {
            BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            Toast.makeText(application, "下载成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
