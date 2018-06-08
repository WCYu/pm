package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
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
import com.rxjy.pm.adapter.RoutingSubAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.mvp.contract.RoutingSubContract;
import com.rxjy.pm.mvp.presenter.RoutingSubPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class RoutingSubActivity extends BaseActivity<RoutingSubPresenter> implements AMapLocationListener, AdapterView.OnItemClickListener, RoutingSubContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_routing_sub)
    EditText etSub;
    @Bind(R.id.tv_routing_sub_address)
    TextView tvSubAddress;
    @Bind(R.id.et_routing_sub_count)
    EditText etSubCount;
    @Bind(R.id.gv_routing_sub)
    GridView gvSub;

    public static final String TITLE = "进度巡检";

    private List<LocalMedia> imgList;

    private RoutingSubAdapter mAdapter;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    private String province = "";
    private String city = "";
    private String district = "";
    private String street = "";

    private double lat;
    private double lon;

    private String address = "";

    private int xjID;

    @Override
    public int getLayout() {
        return R.layout.activity_routing_sub;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initLocation();
        initPicture();
    }

    private void initIntent() {
        xjID = getIntent().getIntExtra(Constants.ACTION_TO_ROUTING_SUB_XJ_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
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
        //设置只定位一次
        mLocationOption.setOnceLocation(true);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    private void initPicture() {

        imgList = new ArrayList<>();

        mAdapter = new RoutingSubAdapter(this, imgList);

        gvSub.setAdapter(mAdapter);

        gvSub.setOnItemClickListener(this);

    }

    @Override
    protected RoutingSubPresenter onCreatePresenter() {
        return new RoutingSubPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (imgList != null) {
            if (imgList.size() > 0) {
                if (!(imgList.get(imgList.size() - 1).getCompressPath() == null)) {
                    imgList.add(new LocalMedia());
                }
            } else {
                imgList.add(new LocalMedia());
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    imgList.clear();
                    imgList.addAll(localMedias);
                    imgList.add(new LocalMedia());
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }


    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                String content = etSub.getText().toString().trim();
                String count = etSubCount.getText().toString().trim();
                if (content.equals("")) {
                    showToast("请填写现场施工进度，以及施工内容弄");
                    return;
                }
                if (count.equals("")) {
                    showToast("请填写现场工人总数");
                    return;
                }
                if (imgList.size() < 16) {
                    showToast("至少上传15张照片");
                    return;
                }
                imgList.remove(imgList.size() - 1);
                mPresenter.subRoutingData(xjID, content, address, lat, lon, imgList);
                break;
        }
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        //省
        province = aMapLocation.getProvince();
        //市
        city = aMapLocation.getCity();
        //区
        district = aMapLocation.getDistrict();
        //街
        street = aMapLocation.getStreet();

        lat = aMapLocation.getLatitude();

        lon = aMapLocation.getLongitude();

        address = province + city + district + street;

        tvSubAddress.setText(address);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == imgList.size() - 1) {
            if (imgList.size() != 0) {
                imgList.remove(imgList.size() - 1);
            }
            // 进入相册 以下是例子：用不到的api可以不写
            PictureSelector.create(this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .imageSpanCount(3)// 每行显示个数 int
                    .maxSelectNum(20)// 最大图片选择数量 int
                    .minSelectNum(1)// 最小选择数量 int
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .compress(true)// 是否压缩 true or fals
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .selectionMedia(imgList)
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
        } else {
            imgList.remove(imgList.size() - 1);
            PictureSelector.create(this).externalPicturePreview(position, imgList);
        }
    }

    @Override
    public void responseRoutingSubData() {
        showToast("上传成功");
        finish();
    }

    @Override
    public void responseRoutingSubDataError(String msg) {
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
