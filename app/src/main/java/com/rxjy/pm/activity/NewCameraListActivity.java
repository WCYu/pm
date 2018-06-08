package com.rxjy.pm.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.BindAdapter;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.adapter.UnBindAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.NewCameraListInfo;
import com.rxjy.pm.entity.NewUnBindCameraInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;
import com.rxjy.pm.widget.CustomGridView;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewCameraListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, Thread.UncaughtExceptionHandler {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_camera_list_person)
    TextView tvPerson;
    @Bind(R.id.tv_camera_list_project)
    TextView tvProject;
    @Bind(R.id.tv_camera_list_address)
    TextView tvAddress;
    @Bind(R.id.tv_camera_list_normal_count)
    TextView tvtNormalCount;
    @Bind(R.id.tv_camera_list_abnormal_count)
    TextView tvAbnormalCount;
    @Bind(R.id.gv_camera_list_pro_camera)
    CustomGridView gvProCamera;
    @Bind(R.id.gv_camera_list_unbind_camera)
    CustomGridView gvUnbindCamera;
    @Bind(R.id.lin_unbind_camera)
    LinearLayout linUnbindCamera;
    @Bind(R.id.btn_camera_list_recycle)
    Button btnRecycle;

    public static final String TITLE = "摄像头查看";


    private List<CameraListInfo.CameraInfo> bindList;

    private BindAdapter bindAdapter;

    private List<UnbindCameraListInfo.UnbindCameraInfo> unBindList;

    private UnBindAdapter unBindAdapter;

    private ProjectInfo.Project proInfo;
    public static final String TAG = "CameraListActivity";
    private List<NewCameraListInfo.BodyBean> body;
    private List<NewUnBindCameraInfo.BodyBean> body1;
    private NewUnBindCameraInfo newCameraListInfo;
    private NewCameraListInfo newCameraListInfo1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_camera_list, null);
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
        initPro();
        initNewData();


    }


    private void initNewData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderno", proInfo.getOrderNo());
        OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/getYesCamera", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i(TAG, "使用的" + string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        newCameraListInfo = JSONUtils.toObject(string, NewUnBindCameraInfo.class);
                        body1 = newCameraListInfo.getBody();
                        initProCamera();
                    }
                });
            }
        });
        OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/getNotCamera", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i(TAG, "未使用的" + string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        newCameraListInfo1 = JSONUtils.toObject(string, NewCameraListInfo.class);
                        body = newCameraListInfo1.getBody();
                        initUnbindCamera();
                    }
                });
            }
        });
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CAMERA_LIST_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPro() {
        tvPerson.setText(proInfo.getSupervisorName() + " " + proInfo.getSupervisorPhone());
        tvProject.setText(proInfo.getProName());
        tvAddress.setText(proInfo.getProAddr());
    }

    private void initProCamera() {

        bindList = new ArrayList<>();

        bindAdapter = new BindAdapter(this, body1);

        gvProCamera.setAdapter(bindAdapter);

        bindAdapter.notifyDataSetChanged();

        gvProCamera.setOnItemClickListener(this);

    }

    private void initUnbindCamera() {

        unBindList = new ArrayList<>();

        unBindAdapter = new UnBindAdapter(this, body);
        gvUnbindCamera.setAdapter(unBindAdapter);
        unBindAdapter.notifyDataSetChanged();

        gvUnbindCamera.setOnItemClickListener(this);

    }


    @OnClick({R.id.iv_back, R.id.btn_camera_list_recycle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_camera_list_recycle:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确认回收所有摄像头吗");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("orderno", proInfo.getOrderNo());
                        OkhttpUtils.doPost("http://sxt.gc.cs/cameraManage/app/unbindCamera", map, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String string = response.body().string();
                                Log.i("tag", "回收所有设备>>>>>>>>>>" + string);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(NewCameraListActivity.this, "已解绑所有设备", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                        try {
                            Thread.sleep(3000);
                            initNewData();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("取消", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.gv_camera_list_pro_camera:
                NewUnBindCameraInfo.BodyBean bodyBean = newCameraListInfo.getBody().get(position);
                Log.i(TAG, "bodyBean.getStatus()>>>>>>>>>>>>" + bodyBean.getStatus() + "");
                if (bodyBean.getStatus() == 1) {
                    Intent normalIntent = new Intent(this, CameraNormalActivity.class);
                    normalIntent.putExtra(Constants.ACTION_TO_CAMERA_NORMAL_CAMERA_INFO, body1.get(position));
                    normalIntent.putExtra(Constants.ACTION_TO_CAMERA_NORMAL_PRO_INFO, proInfo);
                    startActivity(normalIntent);
                } else {
                    Intent abnormalIntent = new Intent(this, CameraAbnormalActivity.class);
                    abnormalIntent.putExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_CAMERA_INFO, body1.get(position));
                    abnormalIntent.putExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_PRO_INFO, proInfo);
                    startActivity(abnormalIntent);
                }
                break;
            case R.id.gv_camera_list_unbind_camera:
                NewCameraListInfo.BodyBean bodyBean1 = body.get(position);
//                UnbindCameraListInfo.UnbindCameraInfo unbindInfo = unBindList.get(position);
                Intent unbindIntent = new Intent(this, CameraUnbindActivity.class);
                unbindIntent.putExtra(Constants.ACTION_TO_CAMERA_UNBIND_CAMERA_INFO, bodyBean1);
                unbindIntent.putExtra(Constants.ACTION_TO_CAMERA_UNBIND_PRO_INFO, proInfo);
                startActivity(unbindIntent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        bindAdapter.notifyDataSetChanged();
//        unBindAdapter.notifyDataSetChanged();
        initNewData();
        Log.i("tag", "onResume");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i(TAG, e.getMessage());
    }
}
