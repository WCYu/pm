package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.OrdersProAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.OrdersProInfo;
import com.rxjy.pm.mvp.contract.OrdersProContract;
import com.rxjy.pm.mvp.presenter.OrdersProPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrdersProActivity extends BaseActivity<OrdersProPresenter> implements OrdersProContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_orders_pro)
    ListView lvOrdersPro;

    public static final String TITLE = "项目订单";

    private List<OrdersProInfo.OrdersPro> ordList;

    private OrdersProAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_orders_pro;
    }

    @Override
    public void initData() {
        initTitle();
        initOrdersPro();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initOrdersPro() {

        ordList = new ArrayList<>();

        mAdapter = new OrdersProAdapter(this, ordList);

        lvOrdersPro.setAdapter(mAdapter);

        lvOrdersPro.setOnItemClickListener(this);

    }

    @Override
    protected OrdersProPresenter onCreatePresenter() {
        return new OrdersProPresenter(this);
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
        mPresenter.getOrdersPro(App.pmUserInfo.getUid());
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseOrdersProData(List<OrdersProInfo.OrdersPro> dataList) {
        ordList.clear();
        ordList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseOrdersProDataError(String msg) {
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
        OrdersProInfo.OrdersPro info = ordList.get(position);
        Intent intent = new Intent(this, OrdersListActivity.class);
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_ORDER_NO, info.getOrderNo());
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_NAME, info.getProName());
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_ADDRESS, info.getProAddr());
        startActivity(intent);
    }
}
