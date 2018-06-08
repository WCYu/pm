package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.VisitProListAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.VisitProListInfo;
import com.rxjy.pm.mvp.contract.VisitProListContract;
import com.rxjy.pm.mvp.presenter.VisitProListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VisitProListActivity extends BaseActivity<VisitProListPresenter> implements VisitProListContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_visit_pro_list)
    ListView lvVisitProList;

    public static final String TITLE = "回访列表";

    private List<VisitProListInfo.VisitProList> visitList;

    private VisitProListAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_visit_pro_list;
    }

    @Override
    public void initData() {
        initTitle();
        initVisitProList();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initVisitProList() {

        visitList = new ArrayList<>();

        mAdapter = new VisitProListAdapter(this, visitList);

        lvVisitProList.setAdapter(mAdapter);

        lvVisitProList.setOnItemClickListener(this);

    }

    @Override
    protected VisitProListPresenter onCreatePresenter() {
        return new VisitProListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getVisitProList(App.pmUserInfo.getUid());
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        VisitProListInfo.VisitProList info = visitList.get(position);
        Intent intent = new Intent(this, VisitActivity.class);
        intent.putExtra(Constants.ACTION_TO_VISIT_ORDER_NO, info.getOrderno());
        intent.putExtra(Constants.ACTION_TO_VISIT_PRO_NAME, info.getProname());
        startActivity(intent);
    }

    @Override
    public void responseVisitProListData(List<VisitProListInfo.VisitProList> dataList) {
        visitList.clear();
        visitList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseVisitProListDataError(String msg) {
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
