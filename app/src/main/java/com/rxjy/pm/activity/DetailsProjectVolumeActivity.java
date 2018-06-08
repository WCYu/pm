package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.EnvironmentDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.EngineeringInfo;
import com.rxjy.pm.entity.ProListBean;
import com.rxjy.pm.mvp.contract.EngineeringInfoContract;
import com.rxjy.pm.mvp.presenter.EngineeringInfoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsProjectVolumeActivity extends BaseActivity<EngineeringInfoPresenter> implements EngineeringInfoContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.pro_list_xiangqing)
    ListView proListXiangqing;
//    @Bind(R.id.engineeringtype)
//    TextView engineeringtype;
//    @Bind(R.id.Engineering_brief)
//    TextView EngineeringBrief;
//    @Bind(R.id.Unit_quantity)
//    TextView UnitQuantity;
//    @Bind(R.id.quantity_Engineering)
//    TextView quantityEngineering;
//    @Bind(R.id.iv_back)
//    ImageView ivBack;
//    @Bind(R.id.tv_title)
//    TextView tvTitle;
    private EngineeringInfoAdapter detailAdapter;
   private List<ProListBean> mlist;
    @Override
    public int getLayout() {
        return R.layout.activity_pro_list_xiangqing;
    }

    @Override
    public void initData() {
        tvTitle.setText("详情");
        mlist=new ArrayList<>();
        detailAdapter=new EngineeringInfoAdapter(mlist,this);
        proListXiangqing.setAdapter(detailAdapter);
        Intent intent = getIntent();
        EngineeringInfo info = (EngineeringInfo) intent.getSerializableExtra(Constants.DETAILSPROJECTVOLUME);
        String orderNo = intent.getStringExtra(Constants.CARDNUMBER);
        mPresenter.getTotalCost(orderNo,info.getF_KEY());
//        engineeringtype.setText(info.getF_AREA_NAME()+"");
//        EngineeringBrief.setText(info.getF_KEY() + "");
//        UnitQuantity.setText(info.getF_SORT()+"");
//        quantityEngineering.setText(info.getF_TOTAL() + "");
    }

    @Override
    protected EngineeringInfoPresenter onCreatePresenter() {

        return new EngineeringInfoPresenter(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseEnvironmentListData(String mlist) {

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

    }

    @Override
    public void responseEnvironmentData(String data) {
        mlist.clear();
        List<ProListBean> mlist = new Gson().fromJson(data, new TypeToken<List<ProListBean>>() {
        }.getType());
        this.mlist.addAll(mlist);
        detailAdapter.notifyDataSetChanged();
    }

}
