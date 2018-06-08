package com.rxjy.pm.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ProMoneyDetailAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.DensityUtil;
import com.rxjy.pm.entity.ProMoneyDetailInfo;
import com.rxjy.pm.mvp.contract.ProMoneyDetailContract;
import com.rxjy.pm.mvp.presenter.ProMoneyDetailPresenter;
import com.rxjy.pm.widget.PieChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProMoneyDetailActivity extends BaseActivity<ProMoneyDetailPresenter> implements ProMoneyDetailContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_pro_money_detail_name)
    TextView tvName;
    @Bind(R.id.pie_pro_money)
    PieChartView pieProMoney;
    @Bind(R.id.tv_pro_money_detail_sum)
    TextView tvSum;
    @Bind(R.id.tv_pro_money_detail_per)
    TextView tvPer;
    @Bind(R.id.tv_pro_money_detail_mat)
    TextView tvMat;
    @Bind(R.id.lv_pro_money_detail)
    ListView lvProMoneyDetail;

    public static final String TITLE = "支款明细";

    private List<ProMoneyDetailInfo.ProMoneyDetail.ProMoney> proList;

    private ProMoneyDetailAdapter mAdapter;

    private String orderNo;

    private String proName;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_money_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initProMoney();
        showPie(0, 0);
    }

    private void initIntent() {
        orderNo = getIntent().getStringExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_ORDER_NO);
        proName = getIntent().getStringExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_PRO_NAME);
        tvName.setText(proName);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void showPie(int per, int mat) {

        List<PieChartView.PieData> pieList = new ArrayList<>();

        float sum = (float) per + mat;
       if(per!=0||mat!=0) {
           pieList.add(new PieChartView.PieData("已完成", per / sum, R.color.colorRed));
           pieList.add(new PieChartView.PieData("已完成", mat / sum, R.color.colorRedLight));
       }
        //获取屏幕宽度像素
        int pxWidth =getWindowManager().getDefaultDisplay().getWidth();
        //转换为dp
        float dpWidth = DensityUtil.px2dp(this, pxWidth);
        //得到圆的半径
        float radius = (dpWidth / 8) - 3;
        //给饼图设置半径
        pieProMoney.setOuterRadius(radius);
        //设置饼图是否空心
        pieProMoney.setIsDrawInnerCircle(false);
        //给饼图添加数据
        pieProMoney.setPieDataList(pieList);

    }

    private void initProMoney() {

        proList = new ArrayList<>();

        mAdapter = new ProMoneyDetailAdapter(this, proList);

        lvProMoneyDetail.setAdapter(mAdapter);

        mPresenter.getProMoneyDetailData(orderNo);
    }

    @Override
    protected ProMoneyDetailPresenter onCreatePresenter() {
        return new ProMoneyDetailPresenter(this);
    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void responseProMoneyDetailData(ProMoneyDetailInfo.ProMoneyDetail data) {
        showPie((int) data.getTotalmoneyr(), (int) data.getTotalmoneyc());
        tvSum.setText("¥" + data.getTotalmoney());
        tvPer.setText("¥" + data.getTotalmoneyr());
        tvMat.setText("¥" + data.getTotalmoneyc());
    }

    @Override
    public void responseProMoneyDetailListData(List<ProMoneyDetailInfo.ProMoneyDetail.ProMoney> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProMoneyDetailListDataError(String msg) {
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
