package com.rxjy.pm.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.CameraImageInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.CameraNormalContract;
import com.rxjy.pm.mvp.presenter.CameraNormalPresenter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraNormalActivity extends BaseActivity<CameraNormalPresenter> implements CameraNormalContract.View {

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

    public static final String TITLE = "摄像头详情";

    private String debugUrl = "";

    private Timer mTimer;

    private int count = 0;

    private CameraListInfo.CameraInfo cameraInfo;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_camera_normal;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initCamera();
        initDebug();
    }

    private void initIntent() {
        cameraInfo = (CameraListInfo.CameraInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_NORMAL_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_NORMAL_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initCamera() {
        tvNum.setText("编号：" + cameraInfo.getENumber());
        tvArea.setText("区域：" + cameraInfo.getPte_AreaName());
        Glide.with(this).load(cameraInfo.getSc_ImgSrc()).into(ivUserPhoto);
        Glide.with(this).load(cameraInfo.getStandard_ImgSrc()).into(ivStandard);
    }

    private void initDebug() {

        mTimer = new Timer();

    }

    @Override
    protected CameraNormalPresenter onCreatePresenter() {
        return new CameraNormalPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.iv_camera_normal_standard, R.id.iv_camera_normal_user_photo, R.id.iv_camera_normal_debug, R.id.btn_camera_normal_debug})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_camera_normal_standard:
                photoPreview(cameraInfo.getStandard_ImgSrc());
                break;
            case R.id.iv_camera_normal_user_photo:
                photoPreview(cameraInfo.getSc_ImgSrc());
                break;
            case R.id.iv_camera_normal_debug:
                if (!debugUrl.equals("")) {
                    photoPreview(debugUrl);
                }
                break;
            case R.id.btn_camera_normal_debug:
                showLoading();
                mPresenter.getDebugData(proInfo.getOrderNo(), cameraInfo.getENumber());
                break;
        }
    }

    @Override
    public void responseDebugData() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                count++;
                if (count != 10) {
                    mPresenter.getDebugImageData(proInfo.getOrderNo(), cameraInfo.getENumber());
                } else {
                    Message msg = Message.obtain();
                    msg.obj = "timeOut";
                    mHandler.sendMessage(msg);
                }
            }
        }, 0, 10000);
    }

    @Override
    public void handlerMeaasg(Message msg) {
        String obj = (String) msg.obj;
        if (obj.equals("timeOut")) {
            count = 0;
            dismissLoading();
            showToast("抓拍超时");
            mTimer.cancel();
            mTimer = null;
        }
    }

    @Override
    public void responseDebugDataError(String msg) {
        dismissLoading();
        showToast(msg);
    }

    @Override
    public void responseDebugImageData(CameraImageInfo.CameraImage data) {
        if (data != null) {
            count = 0;
            dismissLoading();
            mTimer.cancel();
            mTimer = null;
            debugUrl = data.getPti_ImgSrc() + "/" + data.getPti_SaveFileName();
            Glide.with(this).load(data.getPti_ImgSrc() + "/240X240/" + data.getPti_SaveFileName()).into(ivDebug);
        }
    }

    @Override
    public void responseDebugImageDataError(String msg) {
        dismissLoading();
        mTimer.cancel();
        mTimer = null;
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
}
