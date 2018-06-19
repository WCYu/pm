package com.rxjy.pm.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.CameraAbnormalAdapter;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.CameraAbnormalInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.CameraAbnormalContract;
import com.rxjy.pm.mvp.presenter.CameraAbnormalPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraAbnormalActivity extends BaseActivity<CameraAbnormalPresenter> implements CameraAbnormalContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_camera_abnormal_num)
    TextView tvNum;
    @Bind(R.id.tv_camera_abnormal_area)
    TextView tvArea;
    @Bind(R.id.iv_camera_abnormal_standard)
    ImageView ivStandard;
    @Bind(R.id.iv_camera_abnormal_user_photo)
    ImageView ivUserPhoto;
    @Bind(R.id.lv_camera_abnormal)
    ListView lvCameraAbnormal;
    @Bind(R.id.btn_camera_abnormal)
    Button btnCameraAbnormal;

    public static final String TITLE = "摄像头报损";

    private List<CameraAbnormalInfo.CameraAbnormal> cameraList;

    private CameraAbnormalAdapter mAdapter;

    private CameraListInfo.CameraInfo cameraInfo;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_camera_abnormal;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initCamera();
        initAbnormal();
    }

    private void initIntent() {
        cameraInfo = (CameraListInfo.CameraInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_PRO_INFO);
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

    private void initAbnormal() {

        cameraList = new ArrayList<>();

        mAdapter = new CameraAbnormalAdapter(this, cameraList);

        lvCameraAbnormal.setAdapter(mAdapter);

        mPresenter.getCraftAbnormalList(cameraInfo.getProjectID(), cameraInfo.getENumber());

    }

    @Override
    protected CameraAbnormalPresenter onCreatePresenter() {
        return new CameraAbnormalPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.iv_camera_abnormal_standard, R.id.iv_camera_abnormal_user_photo, R.id.btn_camera_abnormal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_camera_abnormal_standard:
                photoPreview(cameraInfo.getStandard_ImgSrc());
                break;
            case R.id.iv_camera_abnormal_user_photo:
                photoPreview(cameraInfo.getSc_ImgSrc());
                break;
            case R.id.btn_camera_abnormal:
                mPresenter.unbindCamera(proInfo.getCityID(), proInfo.getOrderNo(), App.pmUserInfo.getUid(), App.cardNo, cameraInfo.getENumber());
                break;
        }
    }

    @Override
    public void responseCraftAbnormalListData(List<CameraAbnormalInfo.CameraAbnormal> dataList) {
        cameraList.clear();
        cameraList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseCraftAbnormalListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUnbindCameraData() {
        showToast("解绑成功");
        finish();
    }

    @Override
    public void responseUnbindCameraDataError(String msg) {
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
