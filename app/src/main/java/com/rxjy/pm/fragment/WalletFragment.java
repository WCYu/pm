package com.rxjy.pm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.BankCardActivity;
import com.rxjy.pm.adapter.WalletRecordAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.WalletInfo;
import com.rxjy.pm.entity.WalletRecordInfo;
import com.rxjy.pm.mvp.contract.WalletContract;
import com.rxjy.pm.mvp.presenter.WalletPresenter;
import com.rxjy.pm.widget.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/7/26.
 */

public class WalletFragment extends BaseFragment<WalletPresenter> implements WalletContract.View, XListView.IXListViewListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_wallet_has_withdraw)
    TextView tvHasWithdraw;
    @Bind(R.id.tv_wallet_balance)
    TextView tvBalance;
    @Bind(R.id.tv_wallet_bank_card_count)
    TextView tvBankCardCount;
    @Bind(R.id.xlv_wallet_detail)
    XListView xlvDetail;

    public static final String TITLE = "钱包";

    private List<WalletRecordInfo.WalletRecord> recList;

    private WalletRecordAdapter mAdapter;

    private WalletInfo.Wallet walletInfo;

    private int pageIndex = 1;

    private int pageSize = 10;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_wallet;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        initWalletData();
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initWalletData() {

        recList = new ArrayList<>();

        mAdapter = new WalletRecordAdapter(getActivity(), recList);

        xlvDetail.setAdapter(mAdapter);

        xlvDetail.setXListViewListener(this);

    }

    @Override
    protected WalletPresenter onCreatePresenter() {
        return new WalletPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取钱包数据
        mPresenter.getWalletInfo(App.cardNo);
        //获取收支明细数据
        mPresenter.getWalletRecordList(App.cardNo, pageIndex, pageSize);
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        //获取新闻列表接口
        mPresenter.getWalletRecordList(App.cardNo, pageIndex, pageSize);
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        //获取收支明细
        mPresenter.getWalletRecordLoadList(App.cardNo, pageIndex, pageSize);
    }

    //停止刷新
    private void onLoad() {
        xlvDetail.stopRefresh();
        xlvDetail.stopLoadMore();
        xlvDetail.setRefreshTime("刚刚");
    }

    //是否显示加载更多
    private void isShowLoad(int size) {
        if (size < pageSize) {
            xlvDetail.setPullLoadEnable(false);
        } else {
            xlvDetail.setPullLoadEnable(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.lin_wallet_has_withdraw, R.id.lin_wallet_balance, R.id.lin_wallet_bank_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_wallet_has_withdraw:
                break;
            case R.id.lin_wallet_balance:
//                Intent intent = new Intent(getActivity(), BalanceActivity.class);
//                intent.putExtra(Constants.ACTION_TO_BALANCE_BALANCE_INFO, walletInfo.getBalance());
//                startActivity(intent);
                break;
            case R.id.lin_wallet_bank_card:
                startActivity(new Intent(getActivity(), BankCardActivity.class));
                break;
        }
    }

    @Override
    public void responseWalletData(WalletInfo.Wallet data) {
        walletInfo = data;
        tvBalance.setText("¥ " + data.getBalance());
        tvHasWithdraw.setText("¥ " + data.getMonthIncome());
        if (App.baseInfo.getBankCard() != null) {
            tvBankCardCount.setText("1 张");
        } else {
            tvBankCardCount.setText("0 张");
        }
    }

    @Override
    public void responseWalletDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseWalletRecordListData(List<WalletRecordInfo.WalletRecord> dataList) {
        onLoad();
        recList.clear();
        recList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
    }

    @Override
    public void responseWalletRecordListDataError(String msg) {
        onLoad();
        showToast(msg);
    }

    @Override
    public void responseWalletRecordLoadListData(List<WalletRecordInfo.WalletRecord> dataList) {
        onLoad();
        recList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
    }

    @Override
    public void responseWalletRecordLoadListDataError(String msg) {
        onLoad();
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
