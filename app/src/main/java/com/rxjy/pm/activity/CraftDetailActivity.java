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
import com.rxjy.pm.adapter.CraftDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.CraftDetailInfo;
import com.rxjy.pm.mvp.contract.CraftDetailContract;
import com.rxjy.pm.mvp.presenter.CraftDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CraftDetailActivity extends BaseActivity<CraftDetailPresenter> implements CraftDetailContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_craft_detail)
    ListView lvCraftDetail;

    public static final String TITLE = "工艺详情";

    private List<CraftDetailInfo.CraftDetail> craList;

    private CraftDetailAdapter mAdapter;

    private int craftID;

    //记录是第几个item点击的上传图片
    private int photoPosition = 0;
    //记录返回照片的路径
    private String photoUrl = "";
    //item中的数据
    private CraftDetailInfo.CraftDetail craInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_craft_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initCraftDetailData();
    }

    private void initIntent() {
        craftID = getIntent().getIntExtra(Constants.ACTION_TO_CRAFT_DETAIL_CRAFT_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initCraftDetailData() {

        craList = new ArrayList<>();

        mAdapter = new CraftDetailAdapter(this, this, craList);

        lvCraftDetail.setAdapter(mAdapter);

        //获取工艺详情接口
        mPresenter.getCraftDetail(craftID);

    }

    @Override
    protected CraftDetailPresenter onCreatePresenter() {
        return new CraftDetailPresenter(this);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseSubCraftPhotoData() {
        showToast("上传成功");
    }

    @Override
    public void responseSubCraftPhotoDataError(String msg) {
        showToast(msg);
        craList.get(photoPosition).setUrl("");
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseCraftDetailData(List<CraftDetailInfo.CraftDetail> dataList) {
        craList.clear();
        craList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseCraftDetailDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void largePhoto(String url) {
        photoPreview(url);
    }

    @Override
    public void subCraftPhoto(CraftDetailInfo.CraftDetail data, int position) {
        photoPosition = position;
        craInfo = data;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    photoUrl = localMedias.get(0).getCompressPath();
                    //将照片显示到item上
                    craList.get(photoPosition).setUrl(photoUrl);
                    mAdapter.notifyDataSetChanged();
                    mPresenter.subCraftDetailPhoto(craftID, craInfo.getCraft_photo_id(), photoUrl);
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
