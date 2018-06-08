package com.rxjy.pm.adapter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.MsgDetailInfo;
import com.rxjy.pm.mvp.contract.MsgDetailContract;
import com.rxjy.pm.mvp.presenter.MsgDetailPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MsgDetailActivity extends BaseActivity<MsgDetailPresenter> implements MsgDetailContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_msg_detail_title)
    TextView tvMsgTitle;
    @Bind(R.id.tv_msg_detail_content)
    TextView tvContent;
    @Bind(R.id.tv_msg_detail_time)
    TextView tvTime;

    public static final String TITLE = "消息详情";

    private int tsID;

    @Override
    public int getLayout() {
        return R.layout.activity_msg_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMsgDetail();
    }

    private void initIntent() {
        tsID = getIntent().getIntExtra(Constants.ACTION_TO_MSG_DETAIL_TS_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMsgDetail() {
        mPresenter.getMsgDetail(tsID);
    }

    @Override
    protected MsgDetailPresenter onCreatePresenter() {
        return new MsgDetailPresenter(this);
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
    public void responseMsgDetailData(MsgDetailInfo.MsgDetail data) {
        tvMsgTitle.setText(data.getTs_msg_title());
        tvContent.setText(data.getTs_msg_content());
        tvTime.setText(data.getTs_post_time());
    }

    @Override
    public void responseMsgDetailDataError(String msg) {
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
