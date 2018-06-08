package com.rxjy.pm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.CameraAbnormalAdapter;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.CameraAbnormalInfo;
import com.rxjy.pm.entity.NewCameraNormalInfo;
import com.rxjy.pm.entity.NewUnBindCameraInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.CameraAbnormalContract;
import com.rxjy.pm.mvp.presenter.CameraAbnormalPresenter;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CameraAbnormalActivity extends AppCompatActivity{

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

    private NewUnBindCameraInfo.BodyBean newCameraListInfo;

    private ProjectInfo.Project proInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_camera_abnormal, null);
        AutoUtils.setSize(this, false, 720, 1280);

        AutoUtils.auto(view);
        setContentView(view);

        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        initIntent();
        initTitle();
        initCamera();
        initAbnormal();
    }

    private void initIntent() {
         newCameraListInfo = (NewUnBindCameraInfo.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_PRO_INFO);
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
                        Glide.with(CameraAbnormalActivity.this).load(imgUrl).into(ivUserPhoto);
                        Glide.with(CameraAbnormalActivity.this).load(standardUrl).into(ivStandard);
                    }
                });
            }
        });
        tvNum.setText("编号：" + newCameraListInfo.getCamerano());
        tvArea.setText("区域：" + newCameraListInfo.getPosition());
//        Glide.with(this).load(cameraInfo.getSc_ImgSrc()).into(ivUserPhoto);
//        Glide.with(this).load(cameraInfo.getStandard_ImgSrc()).into(ivStandard);
    }

    private void initAbnormal() {

        cameraList = new ArrayList<>();

        mAdapter = new CameraAbnormalAdapter(this, cameraList);

        lvCameraAbnormal.setAdapter(mAdapter);

//        mPresenter.getCraftAbnormalList(cameraInfo.getProjectID(), cameraInfo.getENumber());

    }


    private String standardUrl = "http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg";

    @OnClick({R.id.iv_back, R.id.iv_camera_abnormal_standard, R.id.iv_camera_abnormal_user_photo, R.id.btn_camera_abnormal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_camera_abnormal_standard:
                photoPreview(standardUrl);
                break;
            case R.id.iv_camera_abnormal_user_photo:
//                photoPreview(newCameraListInfo.get);
                break;
            case R.id.btn_camera_abnormal:
//                mPresenter.unbindCamera(proInfo.getCityID(), proInfo.getOrderNo(), App.pmUserInfo.getUid(), App.cardNo, cameraInfo.getENumber());
                break;
        }
    }

//    @Override
//    public void responseCraftAbnormalListData(List<CameraAbnormalInfo.CameraAbnormal> dataList) {
//        cameraList.clear();
//        cameraList.addAll(dataList);
//        mAdapter.notifyDataSetChanged();
//    }

//    @Override
//    public void responseCraftAbnormalListDataError(String msg) {
//        showToast(msg);
//    }

//    @Override
//    public void responseUnbindCameraData() {
//        showToast("解绑成功");
//        finish();
//    }

//    @Override
//    public void responseUnbindCameraDataError(String msg) {
//        showToast(msg);
//    }
    /**
     * 照片预览
     */
    public void photoPreview(String url) {
        com.luck.picture.lib.entity.LocalMedia localMedia = new com.luck.picture.lib.entity.LocalMedia();
        localMedia.setPath(url);
        List<com.luck.picture.lib.entity.LocalMedia> list = new ArrayList<>();
        list.add(localMedia);
        PictureSelector.create(this).externalPicturePreview(0, list);
    }
}
