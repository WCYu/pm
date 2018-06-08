package com.rxjy.pm.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.BindAdapter;
import com.rxjy.pm.adapter.CameraListInfo;
import com.rxjy.pm.adapter.UnBindAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;
import com.rxjy.pm.mvp.contract.CameraListContract;
import com.rxjy.pm.mvp.presenter.CameraListPresenter;
import com.rxjy.pm.widget.CustomGridView;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CameraListActivity extends BaseActivity<CameraListPresenter> implements CameraListContract.View, AdapterView.OnItemClickListener {

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

    @Override
    public int getLayout() {
        return R.layout.activity_camera_list;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPro();

        initProCamera();
        initUnbindCamera();
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

//        bindAdapter = new BindAdapter(this, bindList);

        gvProCamera.setAdapter(bindAdapter);

        gvProCamera.setOnItemClickListener(this);

    }

    private void initUnbindCamera() {

        unBindList = new ArrayList<>();

//        unBindAdapter = new UnBindAdapter(this, unBindList);

        gvUnbindCamera.setAdapter(unBindAdapter);

        gvUnbindCamera.setOnItemClickListener(this);

    }

    @Override
    protected CameraListPresenter onCreatePresenter() {
        return new CameraListPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getCameraLineStatus(proInfo.getOrderNo());
//        mPresenter.getCraftList(proInfo.getOrderNo());
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
                builder.setMessage("确认回收所有摄像头");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.unbindAllCamera(proInfo.getCityID(), proInfo.getOrderNo(), App.pmUserInfo.getUid(), App.cardNo);
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
                CameraListInfo.CameraInfo bindInfo = bindList.get(position);
                if (bindInfo.getCarmeaState() == 1) {
                    Intent normalIntent = new Intent(this, CameraNormalActivity.class);
                    normalIntent.putExtra(Constants.ACTION_TO_CAMERA_NORMAL_CAMERA_INFO, bindInfo);
                    normalIntent.putExtra(Constants.ACTION_TO_CAMERA_NORMAL_PRO_INFO, proInfo);
                    startActivity(normalIntent);
                } else {
                    Intent abnormalIntent = new Intent(this, CameraAbnormalActivity.class);
                    abnormalIntent.putExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_CAMERA_INFO, bindInfo);
                    abnormalIntent.putExtra(Constants.ACTION_TO_CAMERA_ABNORMAL_PRO_INFO, proInfo);
                    startActivity(abnormalIntent);
                }
                break;
            case R.id.gv_camera_list_unbind_camera:
                UnbindCameraListInfo.UnbindCameraInfo unbindInfo = unBindList.get(position);
                Intent unbindIntent = new Intent(this, CameraUnbindActivity.class);
                unbindIntent.putExtra(Constants.ACTION_TO_CAMERA_UNBIND_CAMERA_INFO, unbindInfo);
                unbindIntent.putExtra(Constants.ACTION_TO_CAMERA_UNBIND_PRO_INFO, proInfo);
                startActivity(unbindIntent);
                break;
        }
    }

    @Override
    public void responseCameraLineStatusData(int state) {
//        bindAdapter.setStatus(state);
        mPresenter.getCraftList(proInfo.getOrderNo());
    }

    @Override
    public void responseCameraLineStatusDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseCameraCountData(int count) {
        tvtNormalCount.setText("总量：" + count);
        tvAbnormalCount.setText("已装：" + bindList.size());
        if (bindList.size() == count) {
            linUnbindCamera.setVisibility(View.GONE);
        } else {
            linUnbindCamera.setVisibility(View.VISIBLE);
            mPresenter.getUnbindCameraList(proInfo.getCityID(), App.pmUserInfo.getUid());
        }
    }

    @Override
    public void responseCameraCountDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseBindCameraListData(List<CameraListInfo.CameraInfo> dataList) {

        bindList.clear();
        bindList.addAll(dataList);
        bindAdapter.notifyDataSetChanged();
        mPresenter.getCameraCount(proInfo.getOrderNo());
        if (bindList.size() > 0) {
            btnRecycle.setVisibility(View.VISIBLE);
        } else {
            btnRecycle.setVisibility(View.GONE);
        }
    }

    @Override
    public void responseBindCameraListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUnBindCameraListData(List<UnbindCameraListInfo.UnbindCameraInfo> dataList) {
        unBindList.clear();
        unBindList.addAll(dataList);
        unBindAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseUnBindCameraListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUnBindAllCameraData() {
        mPresenter.getCameraLineStatus(proInfo.getOrderNo());
    }

    @Override
    public void responseUnBindAllCameraDataError(String msg) {
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
