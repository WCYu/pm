package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.OrdersListAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.OrdersListInfo;
import com.rxjy.pm.mvp.contract.OrdersListContract;
import com.rxjy.pm.mvp.presenter.OrdersListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单查询
 */
public class OrDerSelectActivity extends BaseActivity<OrdersListPresenter> implements OrdersListContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_orders_list_pro_name)
    TextView tvProName;
    @Bind(R.id.lv_orders_list)
    ListView lvOrdersList;

    public static final String TITLE = "订单查询";

    private List<OrdersListInfo.OrdersList> ordList;

    private OrdersListAdapter mAdapter;

    private String orderNo;

    private String proName;

    private String proAddress;

    @Override
    public int getLayout() {
        return R.layout.activity_orders_list;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initOrdersList();
    }

    private void initIntent() {
        orderNo = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_LIST_ORDER_NO);
        proName = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_NAME);
        proAddress = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_ADDRESS);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initOrdersList() {

        tvProName.setText(proName);

        ordList = new ArrayList<>();

        mAdapter = new OrdersListAdapter(this, ordList);

        lvOrdersList.setAdapter(mAdapter);

        lvOrdersList.setOnItemClickListener(this);

    }

    @Override
    protected OrdersListPresenter onCreatePresenter() {
        return new OrdersListPresenter(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
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
        mPresenter.getOrdersList(orderNo);
    }

    @Override
    public void responseOrdersListData(List<OrdersListInfo.OrdersList> dataList) {
        ordList.clear();
        ordList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseOrdersListDataError(String msg) {
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
        OrdersListInfo.OrdersList info = ordList.get(position);
        Intent intent = new Intent(this, OrdersDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDER_ID, info.getOrderID());
        intent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDERS_STATUS, info.getOrderState());
        intent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_NAME, proName);
        intent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_NAME, proAddress);
        startActivity(intent);
    }
}
