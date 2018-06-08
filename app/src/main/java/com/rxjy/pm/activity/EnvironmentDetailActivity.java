package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.EnvironmentDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.EnvironmentDetailInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.EnvironmentDetailContract;
import com.rxjy.pm.mvp.presenter.EnvironmentDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EnvironmentDetailActivity extends BaseActivity<EnvironmentDetailPresenter> implements EnvironmentDetailContract.View,AMapLocationListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_environment_detail)
    ListView lvEnvironmentDetail;

    public static final String TITLE = "环境巡检详情";

    private List<EnvironmentDetailInfo.EnvironmentDetail> envList;

    private EnvironmentDetailAdapter mAdapter;

    private ProjectInfo.Project proInfo;

    private int processID;

    private int xjID;

    //记录是第几个item点击上传照片
    private int photoPosition = 0;
    //记录返回照片的路径
    private String photoUrl;
    //item中的数据
    private EnvironmentDetailInfo.EnvironmentDetail envInfo;

    private String address = "";

    private double xjX = 0;

    private double xjY = 0;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    @Override
    public int getLayout() {
        return R.layout.activity_environment_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initEnvironmentDetail();
        initLocation();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_PRO_INFO);
        processID = getIntent().getIntExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_PROCESS_ID, 0);
        xjID = getIntent().getIntExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_XJ_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initEnvironmentDetail() {

        envList = new ArrayList<>();

        mAdapter = new EnvironmentDetailAdapter(this, this, envList);

        lvEnvironmentDetail.setAdapter(mAdapter);

        //获取巡检信息接口
        mPresenter.getEnvironmentDetail(processID, xjID);

    }

    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    protected EnvironmentDetailPresenter onCreatePresenter() {
        return new EnvironmentDetailPresenter(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    photoUrl = localMedias.get(0).getCompressPath();
                    //将照片显示到item上
                    envList.get(photoPosition).setPhotoUrl(photoUrl);
                    mAdapter.notifyDataSetChanged();
                    mPresenter.subEnvironmentDetailPhoto(envInfo.getStepId(), xjID, proInfo.getOrderNo(), address, xjX + "", xjY + "", photoUrl);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseSubEnvironmentDetailData() {
        showToast("上传成功");
    }

    @Override
    public void responseSubEnvironmentDetailDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseEnvironmentDetailData(List<EnvironmentDetailInfo.EnvironmentDetail> dataList) {
        envList.clear();
        envList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseEnvironmentDetailDataError(String msg) {
        showToast(msg);
        envList.get(photoPosition).setPhotoUrl("");
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void largePhoto(String url) {
        photoPreview(url);
    }

    @Override
    public void subProcessPhoto(EnvironmentDetailInfo.EnvironmentDetail data, int position) {
        photoPosition = position;
        envInfo = data;
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
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {

        String city = aMapLocation.getCity();//城市信息
        String district = aMapLocation.getDistrict();//城区信息
        String street = aMapLocation.getStreet();//街道信息
        String streetNum = aMapLocation.getStreetNum();//街道门牌号信息
        double latitude = aMapLocation.getLatitude();//获取纬度
        double longitude = aMapLocation.getLongitude();//获取经度

        address = city + district + street + streetNum;
        xjY = latitude;
        xjX = longitude;
    }
}
