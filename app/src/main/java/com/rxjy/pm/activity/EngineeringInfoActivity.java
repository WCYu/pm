package com.rxjy.pm.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ProListAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.EngineeringInfo;
import com.rxjy.pm.entity.ProListBean;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.EngineeringInfoContract;
import com.rxjy.pm.mvp.presenter.EngineeringInfoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/27.
 */

public class EngineeringInfoActivity extends BaseActivity<EngineeringInfoPresenter> implements EngineeringInfoContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.engineeringList)
    ListView engineeringList;
    @Bind(R.id.cost_amount)
    TextView costAmount;
    @Bind(R.id.beijing)
    ImageView beijing;
    @Bind(R.id.total_Amount)
    LinearLayout totalAmount;

    private ProListAdapter proListAdapter;
    private List<EngineeringInfo> mlist;
    private ProjectInfo.Project proInfo;

    @Override
    public void responseEnvironmentListData(String dataList) {
        mlist.clear();

        if (dataList.length() <= 5) {
            beijing.setVisibility(View.VISIBLE);
            engineeringList.setVisibility(View.GONE);
        } else {
            List<EngineeringInfo> mlist = new Gson().fromJson(dataList, new TypeToken<List<EngineeringInfo>>() {
            }.getType());
            Log.e("mlist",mlist.size()+"");
            this.mlist.addAll(mlist);
            proListAdapter.notifyDataSetChanged();
       }


    }

    @Override
    public void showMessage(String msg) {
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
    public void responseTotalCost(String count) {
//        costAmount.setText("");
//        costAmount.setText("成本总金额: ￥" + count);
    }

    @Override
    public void responseEnvironmentData(String data) {

    }

    @Override
    public int getLayout() {
        return R.layout.engineeringlist;
    }

    @Override
    public void initData() {
        tvTitle.setText("工程量");
        mlist = new ArrayList<>();
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        proListAdapter = new ProListAdapter(this,mlist);
        engineeringList.setAdapter(proListAdapter);
        engineeringList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EngineeringInfoActivity.this, DetailsProjectVolumeActivity.class).putExtra(Constants.DETAILSPROJECTVOLUME, mlist.get(position));
                intent.putExtra(Constants.CARDNUMBER,proInfo.getOrderNo());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getEnvironmentList(proInfo.getOrderNo());
        Log.e("tag", proInfo.getOrderNo() + "");
     //   mPresenter.getTotalCost(proInfo.getOrderNo());
    }

    @Override
    protected EngineeringInfoPresenter onCreatePresenter() {
        return new EngineeringInfoPresenter(this);
    }

    @OnClick({R.id.iv_back, R.id.cost_amount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.cost_amount:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
