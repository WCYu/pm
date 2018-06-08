package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ProcessAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProcessInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.EnvironmentContract;
import com.rxjy.pm.mvp.presenter.EnvironmentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class EnvironmentActivity extends BaseActivity<EnvironmentPresenter> implements ExpandableListView.OnChildClickListener, EnvironmentContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.elv_environment)
    ExpandableListView elvEnvironment;

    public static final String TITLE = "环境巡检";

    private List<ProcessInfo.ProcessGroup> proList;

    private ProcessAdapter mAdapter;

    private int xjID;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_environment;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initEnvironmentData();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ENVIRONMENT_PRO);
        xjID = getIntent().getIntExtra(Constants.ACTION_TO_ENVIRONMENT_XJ_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initEnvironmentData() {

        proList = new ArrayList<>();

        mAdapter = new ProcessAdapter(this, proList);

        elvEnvironment.setAdapter(mAdapter);

        elvEnvironment.setOnChildClickListener(this);

    }

    @Override
    protected EnvironmentPresenter onCreatePresenter() {
        return new EnvironmentPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getEnvironmentList(proInfo.getOrderNo(), xjID);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        ProcessInfo.ProcessGroup.ProcessChild info = proList.get(groupPosition).getList().get(childPosition);
        Intent intent = new Intent(this, EnvironmentDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_PRO_INFO, proInfo);
        intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_PROCESS_ID, info.getProcess_id());
        intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_DETAIL_XJ_ID, xjID);
        startActivity(intent);
        return false;
    }

    @Override
    public void responseEnvironmentListData(List<ProcessInfo.ProcessGroup> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseEnvironmentDataError(String msg) {
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
