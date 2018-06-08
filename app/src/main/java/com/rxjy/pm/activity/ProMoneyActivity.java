package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ProMoneyAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProMoneyInfo;
import com.rxjy.pm.mvp.contract.ProMoneyContract;
import com.rxjy.pm.mvp.presenter.ProMoneyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProMoneyActivity extends BaseActivity<ProMoneyPresenter> implements ProMoneyContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_pro_money)
    ListView lvProMoney;

    public static final String TITLE = "项目款";

    private List<ProMoneyInfo.ProMoney> proList;

    private ProMoneyAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_money;
    }

    @Override
    public void initData() {
        initTitle();
        initProMoneyData();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initProMoneyData() {

        proList = new ArrayList<>();

        mAdapter = new ProMoneyAdapter(this, proList);

        lvProMoney.setAdapter(mAdapter);

        lvProMoney.setOnItemClickListener(this);

        //获取项目款
        mPresenter.getProMoneyList(App.pmUserInfo.getUid());

    }

    @Override
    protected ProMoneyPresenter onCreatePresenter() {
        return new ProMoneyPresenter(this);
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
    public void responseProMoneyListData(List<ProMoneyInfo.ProMoney> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProdMoneyListDataError(String msg) {
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
        ProMoneyInfo.ProMoney info = proList.get(position);
        Intent intent = new Intent(this, ProMoneyDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_ORDER_NO, info.getOrderno());
        intent.putExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_PRO_NAME,info.getProname());
        startActivity(intent);
    }
}
