package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ShopCartProAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ShopCartProInfo;
import com.rxjy.pm.mvp.contract.ShopCartProContract;
import com.rxjy.pm.mvp.presenter.ShopCartProPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopCartProActivity extends BaseActivity<ShopCartProPresenter> implements ShopCartProContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_shop_cart_pro)
    ListView lvShopCartPro;

    public static final String TITLE = "购物车";

    private List<ShopCartProInfo.ShopCartPro> shopList;

    private ShopCartProAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_shop_cart_pro;
    }

    @Override
    public void initData() {
        initTitle();
        initShopCartPro();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initShopCartPro() {

        shopList = new ArrayList<>();

        mAdapter = new ShopCartProAdapter(this, shopList);

        lvShopCartPro.setAdapter(mAdapter);

        lvShopCartPro.setOnItemClickListener(this);

    }

    @Override
    protected ShopCartProPresenter onCreatePresenter() {
        return new ShopCartProPresenter(this);
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
        mPresenter.getShopCartPro(App.pmUserInfo.getUid());
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseShopCartProData(List<ShopCartProInfo.ShopCartPro> dataList) {
        shopList.clear();
        shopList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseShopCartProDataError(String msg) {
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
        ShopCartProInfo.ShopCartPro info = shopList.get(position);
        Intent intent = new Intent(this, ShopCartActivity.class);
        intent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_NAME, info.getProName());
        intent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_ADDRESS, info.getProAddr());
        intent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_ORDER_NO, info.getOrderNo());
        startActivity(intent);
    }
}
