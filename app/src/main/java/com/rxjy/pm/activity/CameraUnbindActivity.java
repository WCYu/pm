package com.rxjy.pm.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.AreaInfo;
import com.rxjy.pm.entity.CameraImageInfo;
import com.rxjy.pm.entity.DebugCameraImageURLInfo;
import com.rxjy.pm.entity.DebugCameraInfo;
import com.rxjy.pm.entity.NewCameraListInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;
import com.rxjy.pm.entity.UpDataPictureSuccessInfo;
import com.rxjy.pm.mvp.contract.CameraUnbindContract;
import com.rxjy.pm.mvp.presenter.CameraUnbindPresenter;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Decoder.BASE64Encoder;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CameraUnbindActivity extends AppCompatActivity {

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

    public static final String TAG = "CameraUnbindActivity";
    private OptionsPickerView areaPicker;

    private List<String> areaList;

    private List<AreaInfo.Area> aList;

    private String standardUrl = "http://imgsgpt.rxjy.com/UploadFile/NewBaojia/File_fc51f0c06eba41779c66977b2af150df.jpg";

    private String areaName = "";

    private String bindUrl = "";

    private String debugUrl = "";

    private Timer mTimer;

    private int count = 0;
    private ProgressDialog dialog;
    private NewCameraListInfo.BodyBean cameraInfo;
    private Timer timer;
    private TimerTask timerTask;
    private ProjectInfo.Project proInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_camera_unbind, null);
        AutoUtils.setSize(this, false, 720, 1280);

        AutoUtils.auto(view);
        setContentView(view);

        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        initIntent();
        initTitle();
        initPhoto();
        initDebug();
        initArea();
    }

    private void initIntent() {
        cameraInfo = (NewCameraListInfo.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_UNBIND_CAMERA_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_UNBIND_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPhoto() {

        tvNumber.setText("编号：" + cameraInfo.getCamerano());

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
                    Log.i(TAG, "bindURL>>>>>>>>>>>" + bindUrl);
                    Glide.with(this).load(bindUrl).into(ivUserPhoto);
                    break;
            }
        }
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
//                mPresenter.getDebugData(proInfo.getOrderNo(), cameraInfo.getEquipmentno());
                HashMap<String, Object> map = new HashMap<>();
                map.put("orderno", proInfo.getOrderNo());
                map.put("imei", cameraInfo.getImei());
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

                                DebugCameraInfo debugCameraInfo = JSONUtils.toObject(string, DebugCameraInfo.class);
                                String statusCode = debugCameraInfo.getStatusCode();
                                if (timer == null) {
                                    timer = new Timer();
                                }
                                if (timerTask == null) {
                                    //WorkerThread不能操作UI，交给Handler处理
                                    timerTask = new TimerTask() {
                                        private String string1;

                                        @Override
                                        public void run() {
                                            //WorkerThread不能操作UI，交给Handler处理
                                            HashMap<String, Object> map1 = new HashMap<>();
                                            map1.put("orderno", proInfo.getOrderNo());
                                            map1.put("imei", cameraInfo.getImei());
                                            map1.put("position", cameraInfo.getPosition());
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
            case R.id.tv_camera_unbind_area:
                areaPicker.show();
                break;
            case R.id.btn_camera_unbind:
                areaName = etArea.getText().toString().trim();
                if (bindUrl.equals("")) {
                    Toast.makeText(this, "请选择一张一张摄像头照片", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (areaName.equals("")) {
                    Toast.makeText(this, "请添加区域名称", Toast.LENGTH_SHORT).show();
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
                        String imageStr = getImageStr(bindUrl);
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("orderno", proInfo.getOrderNo());
                        map.put("imei", cameraInfo.getImei());
                        map.put("position", areaName);
                        map.put("imgBase", imageStr);
//                        mPresenter.subCameraInfo(proInfo.getCityID(), proInfo.getOrderNo(), cameraInfo.getEquipmentno(), CameraUnbindActivity.this.areaName, bindUrl);
                        OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/finishCamera", map, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String string = response.body().string();
                                Log.i(TAG, "确认安装摄像头" + string);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        UpDataPictureSuccessInfo upDataPictureSuccessInfo = JSONUtils.toObject(string, UpDataPictureSuccessInfo.class);
                                        String statusCode = upDataPictureSuccessInfo.getStatusCode();
                                        if (statusCode.equals(1)) {
                                            finish();
                                        }
                                    }
                                });
                            }
                        });
                        try {
                            Thread.sleep(800);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });
                builder.setNegativeButton("取消", null);
                builder.show();
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

    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] b = null;
        try {
            if (null != imgFile) {
                inputStream = new FileInputStream(imgFile);
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();
                }
                b = new byte[count];
                Log.i("tag", "imgfile============" + imgFile);
                Log.i("tag", "count============" + count);
                inputStream.read(b);
                inputStream.close();
            } else {
                Log.i("tag", "data为空！！！");
            }
        } catch (IOException e) {
            Log.i("tag", e.getMessage());
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        if (null != b) {
//            Log.i("tag", "encoder>>>>>>>>>>>>" + encoder.encode(b));
            return encoder.encode(b);
        } else {
            return "error";
        }
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
                    Toast.makeText(CameraUnbindActivity.this, "抓拍超时", Toast.LENGTH_SHORT).show();
                    dismissLoading();
                    btnDebug.setVisibility(View.VISIBLE);
                    timer.cancel();
                    timer = null;
                    timerTask.cancel();
                    timerTask = null;
                    i = 0;
                } else if (!(imgUrl.equals(""))) {
                    Glide.with(CameraUnbindActivity.this).load(imgUrl).into(ivDebug);
                    dismissLoading();
//                    photoPreview(imgUrl);
                    btnDebug.setVisibility(View.VISIBLE);
                    timer.cancel();
                    timer = null;
                    timerTask.cancel();
                    timerTask = null;
                    i=0;
                    Toast.makeText(CameraUnbindActivity.this, "抓拍成功", Toast.LENGTH_SHORT).show();
                    Log.i("tag", "任务取消");
                }
            }
        }
    };

}
