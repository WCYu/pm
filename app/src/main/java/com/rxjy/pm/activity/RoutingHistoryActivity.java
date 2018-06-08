package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.RoutingHistoryAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.RoutingHistoryInfo;
import com.rxjy.pm.mvp.contract.RoutingHistoryContract;
import com.rxjy.pm.mvp.presenter.RoutingHistoryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class RoutingHistoryActivity extends BaseActivity<RoutingHistoryPresenter> implements RoutingHistoryContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_routing_history)
    ListView lvRoutingHistory;

    public static final String TITLE = "巡检历史";

    private List<RoutingHistoryInfo.RoutingHistory> rouList;

    private RoutingHistoryAdapter mAdapter;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_routing_history;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRoutingData();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRoutingData() {

        rouList = new ArrayList<>();

        mAdapter = new RoutingHistoryAdapter(this, rouList);

        lvRoutingHistory.setAdapter(mAdapter);

        lvRoutingHistory.setOnItemClickListener(this);



    }

    @Override
    protected void onResume() {
        super.onResume();
        //获取巡检历史

            mPresenter.getRoutingHistoryList(proInfo.getOrderNo() );



    }

    @Override
    protected RoutingHistoryPresenter onCreatePresenter() {
        return new RoutingHistoryPresenter(this);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseRoutingHistoryListData(List<RoutingHistoryInfo.RoutingHistory> dataList) {
        rouList.clear();
        rouList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseRoutingHistoryListDataError(String msg) {
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
        RoutingHistoryInfo.RoutingHistory info = rouList.get(position);
        Intent intent = new Intent(this, RoutingHistoryDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_ROUTING_HISTORY_DETAIL_XJ_INFO, info);
        startActivity(intent);
    }
}
