package com.rxjy.pm.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.RoutingHistoryDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.PunishRecordInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PunishDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_punish_detail_pro_name)
    TextView tvProName;
    @Bind(R.id.tv_punish_detail_state)
    TextView tvState;
    @Bind(R.id.tv_punish_detail_content)
    TextView tvContent;
    @Bind(R.id.tv_punish_detail_time)
    TextView tvTime;
    @Bind(R.id.gv_punish_detail)
    GridView gvPunishDetail;
    @Bind(R.id.tv_punish_detail_price)
    TextView tvPrice;
    @Bind(R.id.iv_punish_detail_watermark)
    ImageView ivWatermark;

    private List<LocalMedia> photoList;

    private List<String> imgList;

    private RoutingHistoryDetailAdapter mAdapter;

    private PunishRecordInfo.PunishRecord punInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_punish_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPunishData();
    }

    private void initIntent() {
        punInfo = (PunishRecordInfo.PunishRecord) getIntent().getSerializableExtra(Constants.ACTION_TO_PUNISH_DETAIL_PUN_DETAIL);
    }

    private void initTitle() {
        if (punInfo.getFineMoney() > 0) {
            tvTitle.setText("奖励原因");
            tvState.setText("奖励原因:");
            tvPrice.setTextColor(getResources().getColor(R.color.colorOrange));
            ivWatermark.setImageResource(R.mipmap.watermark_award_icon);
        } else {
            tvTitle.setText("处罚原因");
            tvState.setText("处罚原因:");
            tvPrice.setTextColor(getResources().getColor(R.color.colorRed));
            ivWatermark.setImageResource(R.mipmap.watermark_punish_icon);
        }
    }

    private void initPunishData() {
        tvProName.setText(punInfo.getProName());
        tvContent.setText(punInfo.getFineRemark());
        tvPrice.setText("¥" + punInfo.getFineMoney());
        tvTime.setText(TimeUtil.getNormalTime(punInfo.getFineTime()));

        photoList = new ArrayList<>();

        imgList = new ArrayList<>();

        imgList.addAll(punInfo.getFineImageItems());

        for (String url : imgList) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(url);
            photoList.add(localMedia);
        }

        mAdapter = new RoutingHistoryDetailAdapter(this, imgList);

        gvPunishDetail.setAdapter(mAdapter);

        gvPunishDetail.setOnItemClickListener(this);

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PictureSelector.create(this).externalPicturePreview(position, photoList);
    }
}
