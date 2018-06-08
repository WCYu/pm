package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.BankCardAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.BankCardInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BankCardActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_bank_card)
    ListView lvBankCard;

    public static final String TITLE = "银行卡";

    private List<BankCardInfo> cardList;

    private BankCardAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_bank_card;
    }

    @Override
    public void initData() {
        initTitle();
        initCardData();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initCardData() {

        cardList = new ArrayList<>();

        mAdapter = new BankCardAdapter(this, cardList);

        lvBankCard.setAdapter(mAdapter);

        View footerView = View.inflate(this, R.layout.list_item_add_bank, null);

        AutoUtils.auto(footerView);

        lvBankCard.addFooterView(footerView);

        lvBankCard.setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdapter != null) {
            cardList.clear();
            if (App.baseInfo.getBankCard() != null) {
                cardList.add(new BankCardInfo( App.baseInfo.getBankUserName(), App.baseInfo.getBankName(), App.baseInfo.getBankCard()));
                mAdapter.notifyDataSetChanged();
            }
        }
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
        if (cardList.size() > 0) {
            if (position == cardList.size()) {
                showToast("只允许添加一张银行卡");
            } else {
                Intent intent = new Intent(this,UpdBankCardActivity.class);
                startActivity(intent);
            }
        } else {
            startActivity(new Intent(this, AddBankCardActivity.class));
        }
    }
}
