package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.PunishRecordAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.PunishRecordInfo;
import com.rxjy.pm.mvp.contract.PunishRecordContract;
import com.rxjy.pm.mvp.presenter.PunishRecordPresenter;
import com.rxjy.pm.widget.TopPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PunishRecordActivity extends BaseActivity<PunishRecordPresenter> implements PunishRecordContract.View, View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_punish_record)
    ListView lvPunishRecord;

    public static final String TITLE = "奖罚记录";

    public static final int ALL = 0;
    public static final int REWARD = 1;
    public static final int PUNISH = 2;

    private List<PunishRecordInfo.PunishRecord> punList;

    private PunishRecordAdapter mAdapter;

    private TopPopWindow topPopWindow;

    @Override
    public int getLayout() {
        return R.layout.activity_punish_record;
    }

    @Override
    public void initData() {
        initTitle();
        initPunishRecordData();
    }

    private void initTitle() {
        ivAdd.setVisibility(View.VISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initPunishRecordData() {

        punList = new ArrayList<>();

        mAdapter = new PunishRecordAdapter(this, punList);

        lvPunishRecord.setAdapter(mAdapter);

        lvPunishRecord.setOnItemClickListener(this);

        //获取全部奖罚记录
        getPunishRecordByType(ALL);

    }

    private void getPunishRecordByType(int type) {
        //获取奖罚记录
        mPresenter.getPunishRecordInfo(App.pmUserInfo.getUid(), type);
    }

    /**
     * 显示右上角popup菜单
     */
    private void showTopRightPopMenu() {
        if (topPopWindow == null) {
            int displayWidthValue = AutoUtils.getDisplayWidthValue(320);
            int displayHeightValue = AutoUtils.getDisplayHeightValue(360);
            topPopWindow = new TopPopWindow(this, this, displayWidthValue, displayHeightValue);
            //监听窗口的焦点事件，点击窗口外面则取消显示
            topPopWindow.getContentView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        topPopWindow.dismiss();
                    }
                }
            });
        }
        //设置默认获取焦点
        topPopWindow.setFocusable(true);
        //以某个控件的x和y的偏移量位置开始显示窗口
        topPopWindow.showAsDropDown(ivAdd, -AutoUtils.getDisplayWidthValue(300), 0);
        //如果窗口存在，则更新
        topPopWindow.update();
        //点击事件
    }

    @Override
    protected PunishRecordPresenter onCreatePresenter() {
        return new PunishRecordPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                showTopRightPopMenu();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_all:
                topPopWindow.dismiss();
                //获取全部奖罚记录
                getPunishRecordByType(ALL);
                break;
            case R.id.lin_reward:
                topPopWindow.dismiss();
                //获取奖励记录
                getPunishRecordByType(REWARD);
                break;
            case R.id.lin_punish:
                topPopWindow.dismiss();
                //获取罚款记录
                getPunishRecordByType(PUNISH);
                break;
        }
    }

    @Override
    public void responsePunishRecordData(List<PunishRecordInfo.PunishRecord> dataList) {
        punList.clear();
        punList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responsePunishRecordDataError(String msg) {
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PunishRecordInfo.PunishRecord info = punList.get(position);
        Intent intent = new Intent(this, PunishDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PUNISH_DETAIL_PUN_DETAIL, info);
        startActivity(intent);
    }
}
