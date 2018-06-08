package com.rxjy.pm.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CameraImageInfo;
import com.rxjy.pm.entity.DebugCameraImageURLInfo;
import com.rxjy.pm.entity.DebugCameraInfo;
import com.rxjy.pm.entity.NewCameraNormalInfo;
import com.rxjy.pm.entity.NewUnBindCameraInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.CameraNormalContract;
import com.rxjy.pm.mvp.presenter.CameraNormalPresenter;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CameraNormalActivity extends AppCompatActivity implements Thread.UncaughtExceptionHandler {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_camera_normal_num)
    TextView tvNum;
    @Bind(R.id.tv_camera_normal_area)
    TextView tvArea;
    @Bind(R.id.iv_camera_normal_standard)
    ImageView ivStandard;
    @Bind(R.id.iv_camera_normal_user_photo)
    ImageView ivUserPhoto;
    @Bind(R.id.iv_camera_normal_debug)
    ImageView ivDebug;
    @Bind(R.id.btn_camera_normal_debug)
    Button btnDebug;
    private String standardUrl = "http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg";

    public static final String TITLE = "摄像头详情";

    private String debugUrl = "";

    private Timer mTimer;

    private int count = 0;

    private NewUnBindCameraInfo.BodyBean newCameraListInfo;

    private ProjectInfo.Project proInfo;

    private ProgressDialog dialog;
    private String statusCode;
    private Timer timer;
    private TimerTask timerTask;

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("AAA", "uncaughtException   " + e);
    }



    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在抓拍...");
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_camera_normal, null);
        AutoUtils.setSize(this, false, 720, 1280);

        AutoUtils.auto(view);
        setContentView(view);
        Thread.setDefaultUncaughtExceptionHandler(this);
        ButterKnife.bind(this);
        initData();
    }


    public void initData() {
        initIntent();
        initTitle();
        initCamera();
        initDebug();
    }

    private void initIntent() {
        newCameraListInfo = (NewUnBindCameraInfo.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_NORMAL_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_NORMAL_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initCamera() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderno", proInfo.getOrderNo());
        map.put("imei", newCameraListInfo.getImei());
        map.put("position", newCameraListInfo.getPosition());

        OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/getByCamera", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NewCameraNormalInfo newCameraNormalInfo = JSONUtils.toObject(string, NewCameraNormalInfo.class);
                        String imgUrl = newCameraNormalInfo.getBody().getImgUrl();
                        Log.i("TAG", "imgUrl>>>>>>" + imgUrl);
                        Glide.with(CameraNormalActivity.this).load(imgUrl).into(ivUserPhoto);
                        Glide.with(CameraNormalActivity.this).load(standardUrl).into(ivStandard);
                    }
                });
            }
        });
        tvNum.setText("编号：" + newCameraListInfo.getCamerano());
        tvArea.setText("区域：" + newCameraListInfo.getPosition());
        Glide.with(this).load(standardUrl).into(ivStandard);
    }

    private void initDebug() {

        mTimer = new Timer();

    }


    @OnClick({R.id.iv_back, R.id.iv_camera_normal_standard, R.id.iv_camera_normal_user_photo, R.id.iv_camera_normal_debug, R.id.btn_camera_normal_debug})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_camera_normal_standard:
//                photoPreview(cameraInfo.getStandard_ImgSrc());
                break;
            case R.id.iv_camera_normal_user_photo:
//                photoPreview(cameraInfo.getSc_ImgSrc());
                break;
            case R.id.iv_camera_normal_debug:
                if (!debugUrl.equals("")) {
//                    photoPreview(debugUrl);
                }
                break;
            case R.id.btn_camera_normal_debug:
                showLoading();
                HashMap<String, Object> map = new HashMap<>();
                map.put("orderno", proInfo.getOrderNo());
                map.put("imei", newCameraListInfo.getImei());
//                showLoading();
//                mPresenter.getDebugData(proInfo.getOrderNo(), cameraInfo.getENumber());
                OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/updateCapturePhoto", map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.i("tag", "抓拍接口测试>>>>>>>>>>>>" + string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                showLoading();
                                DebugCameraInfo debugCameraInfo = JSONUtils.toObject(string, DebugCameraInfo.class);
                                statusCode = debugCameraInfo.getStatusCode();
                                if(timer==null){
                                    timer = new Timer();
                                }
                                if (timerTask==null){
                                    //WorkerThread不能操作UI，交给Handler处理
                                    timerTask = new TimerTask() {
                                        private String string1;

                                        @Override
                                        public void run() {
                                            //WorkerThread不能操作UI，交给Handler处理
                                            HashMap<String, Object> map1 = new HashMap<>();
                                            map1.put("orderno", proInfo.getOrderNo());
                                            map1.put("imei", newCameraListInfo.getImei());
                                            map1.put("position", newCameraListInfo.getPosition());
                                            OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/getCapturePhoto", map1, new Callback() {


                                                @Override
                                                public void onFailure(Call call, IOException e) {

                                                }

                                                @Override
                                                public void onResponse(Call call, Response response) throws IOException {
                                                    string1 = response.body().string();
                                                    Message msg = new Message();
                                                    msg.obj = string1;
                                                    msg.what = 1;
                                                    handler.sendMessage(msg);
                                                }
                                            });
                                        }
                                    };
                                }
                                    timer.schedule(timerTask, 1000, 10 * 1000);
                                    btnDebug.setVisibility(View.GONE);

                            }
                        });
                    }
                });
                break;
        }
    }


    /**
     * 照片预览
     */
    public void photoPreview(String url) {
        com.luck.picture.lib.entity.LocalMedia localMedia = new com.luck.picture.lib.entity.LocalMedia();
        localMedia.setPath(url);
        List<LocalMedia> list = new ArrayList<>();
        list.add(localMedia);
        PictureSelector.create(this).externalPicturePreview(0, list);
    }

    private int i;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String obj = (String) msg.obj;
                Log.i("tag", "摄像头详情抓拍>>>>>>>>>>" + obj);
                DebugCameraImageURLInfo debugCameraImageURLInfo = JSONUtils.toObject(obj, DebugCameraImageURLInfo.class);
                i++;
                Log.i("tag", "i==================" + i);
                String imgUrl = debugCameraImageURLInfo.getBody();
                Log.i("tag", "摄像头详情imgUrl============" + imgUrl);
                //到时间后，想要执行的代码
                if (i >= 8) {
                    Toast.makeText(CameraNormalActivity.this, "抓拍超时", Toast.LENGTH_SHORT).show();
                    dismissLoading();
                    btnDebug.setVisibility(View.VISIBLE);
                    timer.cancel();
                    timer = null;
                    timerTask.cancel();
                    timerTask = null;
                    i = 0;
                } else if (!(imgUrl.equals(""))) {
                    Glide.with(CameraNormalActivity.this).load(imgUrl).into(ivDebug);
                    dismissLoading();
//                    photoPreview(imgUrl);
                    btnDebug.setVisibility(View.VISIBLE);
                    timer.cancel();
                    timer = null;
                    timerTask.cancel();
                    timerTask = null;
                    i = 0;
                    Toast.makeText(CameraNormalActivity.this, "抓拍成功", Toast.LENGTH_SHORT).show();
                    Log.i("tag", "任务取消");
                }
            }
        }
    };

}