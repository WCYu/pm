package com.rxjy.pm.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.MerchantAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.MerChantInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.UpdMatMerchantContract;
import com.rxjy.pm.mvp.presenter.UpdMatMerchantPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdMatMerchantActivity extends BaseActivity<UpdMatMerchantPresenter> implements UpdMatMerchantContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_upd_mat_merchant)
    ListView lvUpdMatMerchant;

    private List<MerChantInfo.Merchant> merList;

    private MerchantAdapter mAdapter;

    private int userID;

    private MatInfo.Mat matInfo;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_upd_mat_merchant;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMerchant();
    }

    private void initIntent() {
        matInfo = (MatInfo.Mat) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_MERCHANT_MAT_INFO);
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_MERCHANT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(matInfo.getMatName());
    }

    private void initMerchant() {

        merList = new ArrayList<>();

        mAdapter = new MerchantAdapter(this, merList);

        lvUpdMatMerchant.setAdapter(mAdapter);

        lvUpdMatMerchant.setOnItemClickListener(this);

        mPresenter.getMerchantList(matInfo.getMatID());

    }

    @Override
    protected UpdMatMerchantPresenter onCreatePresenter() {
        return new UpdMatMerchantPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.btn_upd_mat_merchant_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_upd_mat_merchant_confirm:
                if (merList.size() != 0) {
                    mPresenter.updMerchant(proInfo.getOrderNo(), matInfo.getMatID(), userID, matInfo.getBuyCount(), 1);
                } else {
                    showToast("此材料没有材料商，无法更改材料商");
                }
                break;
        }
    }

    @Override
    public void responseMerchantListData(List<MerChantInfo.Merchant> dataList) {
        merList.clear();
        merList.addAll(dataList);
        for (MerChantInfo.Merchant info : merList) {
            if (info.getUserID() == matInfo.getUserID()) {
                info.setIsChecked(1);
                userID = matInfo.getUserID();
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMerchantListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpdMerchant() {
        showToast("修改成功");
        finish();
    }

    @Override
    public void responseUpdMerchantError(String msg) {
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
        for (MerChantInfo.Merchant info : merList) {
            info.setIsChecked(0);
        }
        userID = merList.get(position).getUserID();
        merList.get(position).setIsChecked(1);
        mAdapter.notifyDataSetChanged();
    }
}
