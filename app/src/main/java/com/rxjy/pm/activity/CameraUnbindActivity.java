package com.rxjy.pm.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.AreaInfo;
import com.rxjy.pm.entity.CameraImageInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;
import com.rxjy.pm.mvp.contract.CameraUnbindContract;
import com.rxjy.pm.mvp.presenter.CameraUnbindPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraUnbindActivity extends BaseActivity<CameraUnbindPresenter> implements CameraUnbindContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_camera_unbind_standard)
    ImageView ivStandard;
    @Bind(R.id.iv_camera_unbind_user_photo)
    ImageView ivUserPhoto;
    @Bind(R.id.iv_camera_unbind_debug)
    ImageView ivDebug;
    @Bind(R.id.btn_camera_unbind_debug)
    Button btnDebug;
    @Bind(R.id.tv_camera_unbind_number)
    TextView tvNumber;
    @Bind(R.id.tv_camera_unbind_area)
    TextView tvArea;
    @Bind(R.id.btn_camera_unbind)
    Button btnCameraUnbind;
    @Bind(R.id.et_camera_unbind_area)
    EditText etArea;

    public static final String TITLE = "摄像头安装";

    private OptionsPickerView areaPicker;

    private List<String> areaList;

    private List<AreaInfo.Area> aList;

    private String standardUrl = "http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg";

    private String areaName = "";

    private String bindUrl = "";

    private String debugUrl = "";

    private Timer mTimer;

    private int count = 0;

    private UnbindCameraListInfo.UnbindCameraInfo cameraInfo;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_camera_unbind;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPhoto();
        initDebug();
        initArea();
    }

    private void initIntent() {
        cameraInfo = (UnbindCameraListInfo.UnbindCameraInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_UNBIND_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_UNBIND_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPhoto() {

        tvNumber.setText("编号：" + cameraInfo.getEquipmentno());

        Glide.with(this).load(standardUrl).into(ivStandard);

    }

    private void initDebug() {

        mTimer = new Timer();

    }

    private void initArea() {

        aList = new ArrayList<>();

        areaList = new ArrayList<>();

        areaPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                AreaInfo.Area info = aList.get(options1);
                areaName = info.getAeraname();
                tvArea.setText("区域：" + info.getAeraname());
            }
        }).build();

        mPresenter.getAreaList(proInfo.getOrderNo());

    }

    @Override
    protected CameraUnbindPresenter onCreatePresenter() {
        return new CameraUnbindPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    bindUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(bindUrl).into(ivUserPhoto);
                    break;
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_camera_unbind_number, R.id.iv_camera_unbind_standard, R.id.iv_camera_unbind_user_photo, R.id.iv_camera_unbind_debug, R.id.btn_camera_unbind_debug, R.id.tv_camera_unbind_area, R.id.btn_camera_unbind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_camera_unbind_standard:
                photoPreview(standardUrl);
                break;
            case R.id.iv_camera_unbind_user_photo:
                if (bindUrl.equals("")) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                } else {
                    photoPreview(bindUrl);
                }
                break;
            case R.id.iv_camera_unbind_debug:
                if (!debugUrl.equals("")) {
                    photoPreview(debugUrl);
                }
                break;
            case R.id.btn_camera_unbind_debug:
                showLoading();
                mPresenter.getDebugData(proInfo.getOrderNo(), cameraInfo.getEquipmentno());
                break;
            case R.id.tv_camera_unbind_area:
                areaPicker.show();
                break;
            case R.id.btn_camera_unbind:
                areaName = etArea.getText().toString().trim();
                if (bindUrl.equals("")) {
                    showToast("请选择一张一张摄像头照片");
                    return;
                }
                if (areaName.equals("")) {
                    showToast("请添加区域名称");
                    return;
                }
//                if (areaName.equals("")) {
//                    showToast("请添加区域名称");
//                    return;
//                }
//                if (debugUrl.equals("")){
//                    showToast("请抓拍一张照片");
//                    return;
//                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确认完成摄像头安装");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.subCameraInfo(proInfo.getCityID(), proInfo.getOrderNo(), cameraInfo.getEquipmentno(), CameraUnbindActivity.this.areaName, bindUrl);
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }
    }

    @Override
    public void responseAreaListData(List<AreaInfo.Area> dataList) {
        areaList.clear();
        aList.clear();
        aList.addAll(dataList);
        for (AreaInfo.Area info : aList) {
            areaList.add(info.getAeraname());
        }
        areaPicker.setPicker(areaList);
    }

    @Override
    public void responseAreaListDataError(String msg) {
        showToast(msg);
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
                    mPresenter.getDebugImageData(proInfo.getOrderNo(), cameraInfo.getEquipmentno());
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
    public void responseBindCameraData() {
        showToast("绑定成功");
        finish();
    }

    @Override
    public void responseBindCameraDataError(String msg) {
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
