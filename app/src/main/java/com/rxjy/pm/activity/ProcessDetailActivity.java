package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ProcessDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProcessDetailInfo;
import com.rxjy.pm.mvp.contract.ProcessDetailContract;
import com.rxjy.pm.mvp.presenter.ProcessDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProcessDetailActivity extends BaseActivity<ProcessDetailPresenter> implements ProcessDetailContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_process_detail)
    ListView lvProcessDetail;

    public static final String TITLE = "工序详情";

    private int processID;

    private List<ProcessDetailInfo.ProcessDetail> proList;

    private ProcessDetailAdapter mAdapter;

    //记录返回照片的路径
    private String photoUrl = "";
    //item中的数据
    private ProcessDetailInfo.ProcessDetail proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_process_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initProcessData();
    }

    private void initIntent() {
        processID = getIntent().getIntExtra(Constants.ACTION_TO_PROCESS_DETAIL_PROCESS_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initProcessData() {

        proList = new ArrayList<>();

        mAdapter = new ProcessDetailAdapter(this, this, proList);

        lvProcessDetail.setAdapter(mAdapter);

        //获取工序详情
        mPresenter.getProcessDetail(processID);

    }

    @Override
    protected ProcessDetailPresenter onCreatePresenter() {
        return new ProcessDetailPresenter(this);
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
    public void responseSubProcessPhotoData() {
        showToast("上传成功");
        mPresenter.getProcessDetail(processID);
    }

    @Override
    public void responseSubProcessPhotoDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSubProcessPhotoCameraData() {
        showToast("上传成功");
        mPresenter.getProcessDetail(processID);
    }

    @Override
    public void responseSubProcessPhotoCameraDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseProcessDetailData(List<ProcessDetailInfo.ProcessDetail> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProcessDetailDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void largePhoto(String url) {
        photoPreview(url);
    }

    @Override
    public void subProcessPhoto(ProcessDetailInfo.ProcessDetail data) {
        proInfo = data;
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .compress(true)// 是否压缩 true or fals
                .isCamera(true)// 是否显示拍照按钮 true or false
                .forResult(Constants.CAMERA_FIRST_PHOTO_CODE);//结果回调onActivityResult code 
    }

    @Override
    public void subProcessCameraPhoto(ProcessDetailInfo.ProcessDetail data) {
        proInfo = data;
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .compress(true)// 是否压缩 true or fals
                .isCamera(true)// 是否显示拍照按钮 true or false
                .forResult(Constants.CAMERA_OTHER_PHOTO_CODE);//结果回调onActivityResult code 
    }

    @Override
    public void hasUploadPhotoView(List<String> imgList) {
        if (imgList == null || imgList.size() == 0) {
            showToast("未上传现场摄像头照片，无法预览");
        } else {
            List<LocalMedia> photoList = new ArrayList<>();
            for (String url : imgList) {
                LocalMedia localMedia = new LocalMedia();
                localMedia.setPath(url);
                photoList.add(localMedia);
            }
            PictureSelector.create(this).externalPicturePreview(0, photoList);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // 图片选择结果回调
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            photoUrl = localMedias.get(0).getCompressPath();
            switch (requestCode) {
                case Constants.CAMERA_FIRST_PHOTO_CODE:
                    mPresenter.subProcessDetailPhoto(proInfo.getStepId(), processID, proInfo.getStepPhotoID(), photoUrl);
                    break;
                case Constants.CAMERA_OTHER_PHOTO_CODE:
                    mPresenter.subProcessDetailPhotoCamera(0, processID, 0, photoUrl);
                    break;
            }
        }
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
