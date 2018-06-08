package com.rxjy.pm.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.OrdersImgAdapter;
import com.rxjy.pm.adapter.OrdersMarkAdapter;
import com.rxjy.pm.adapter.OrdersMatAdapter;
import com.rxjy.pm.adapter.OrdersSubjoinAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.Utility;
import com.rxjy.pm.entity.OrdersDetailInfo;
import com.rxjy.pm.mvp.contract.OrdersDetailContract;
import com.rxjy.pm.mvp.presenter.OrdersDetailPresenter;
import com.rxjy.pm.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrdersDetailActivity extends BaseActivity<OrdersDetailPresenter> implements OrdersDetailContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_orders_detail_name)
    TextView tvProName;
    @Bind(R.id.tv_orders_detail_address)
    TextView tvProAddress;
    @Bind(R.id.tv_orders_detail_status)
    TextView tvStatus;
    @Bind(R.id.tv_orders_detail_merchant_name)
    TextView tvMerchantName;
    @Bind(R.id.lv_orders_detail_mat)
    ListView lvMat;
    @Bind(R.id.lv_orders_detail_subjoin)
    ListView lvSubjoin;
    @Bind(R.id.tv_orders_detail_time)
    TextView tvTime;
    @Bind(R.id.tv_orders_detail_total)
    TextView tvTotal;
    @Bind(R.id.cgv_orders_detail)
    CustomGridView cgvOrdersDetail;
    @Bind(R.id.iv_orders_detail_star_one)
    ImageView ivStarOne;
    @Bind(R.id.iv_orders_detail_star_two)
    ImageView ivStarTwo;
    @Bind(R.id.iv_orders_detail_star_three)
    ImageView ivStarThree;
    @Bind(R.id.iv_orders_detail_star_four)
    ImageView ivStarFour;
    @Bind(R.id.iv_orders_detail_star_five)
    ImageView ivStarFive;
    @Bind(R.id.cgv_orders_detail_evaluate)
    CustomGridView cgvEvaluate;
    @Bind(R.id.tv_orders_detail_evaluate_remark)
    TextView tvEvaluateRemark;
    @Bind(R.id.lin_orders_detail_evaluate)
    LinearLayout linEvaluate;
    @Bind(R.id.btn_orders_detail)
    Button btnOrdersDetail;
    @Bind(R.id.tv_orders_detail_evaluate)
    TextView tvEvaluate;

    public static final String TITLE = "订单确认";

    private OrdersMatAdapter matAdapter;

    private List<OrdersDetailInfo.OrdersDetail.ListMatBean> matList;

    private OrdersSubjoinAdapter subjoinAdapter;

    private List<OrdersDetailInfo.OrdersDetail.ListMoneyBean> subjoinList;

    private OrdersImgAdapter imgAdapter;

    private List<LocalMedia> imgList;

    private List<String> markList;

    private OrdersMarkAdapter markAdapter;

    private OrdersDetailInfo.OrdersDetail ordersInfo;

    private String phoneNum = "";

    private String orderID;

    private int status;

    private String proName;

    private String proAddress;

    @Override
    public int getLayout() {
        return R.layout.activity_orders_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initOrdersDetailStatus();
        initOrdersDetailData();
        initMark();
    }

    private void initIntent() {
        orderID = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDER_ID);
        status = getIntent().getIntExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDERS_STATUS, 0);
        proName = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_NAME);
        proAddress = getIntent().getStringExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_ADDRESS);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initOrdersDetailStatus() {

        tvProName.setText(proName);

        tvProAddress.setText(proAddress);

        //1-待接单 2-备货中 3-配送中 4-待确认 16-待收款 32-待收款 64-已收款
        if (status == 1) {
            tvStatus.setText("待接单");
            cgvOrdersDetail.setVisibility(View.GONE);
            linEvaluate.setVisibility(View.GONE);
            btnOrdersDetail.setVisibility(View.GONE);
        } else if (status == 2 || status == 3 || status == 4) {
            tvStatus.setText("配送中");
            cgvOrdersDetail.setVisibility(View.GONE);
            linEvaluate.setVisibility(View.GONE);
            btnOrdersDetail.setVisibility(View.GONE);
        } else if (status == 8) {
            tvStatus.setText("待确认");
            linEvaluate.setVisibility(View.GONE);
        } else if (status == 16 || status == 32) {
            tvStatus.setText("待收款");
            btnOrdersDetail.setVisibility(View.GONE);
        } else if (status == 64) {
            tvStatus.setText("已收款");
            btnOrdersDetail.setVisibility(View.GONE);
        }

    }

    private void initOrdersDetailData() {

        matList = new ArrayList<>();

        matAdapter = new OrdersMatAdapter(this, matList);

        lvMat.setAdapter(matAdapter);

        subjoinList = new ArrayList<>();

        subjoinAdapter = new OrdersSubjoinAdapter(this, subjoinList);

        lvSubjoin.setAdapter(subjoinAdapter);

        imgList = new ArrayList<>();

        imgAdapter = new OrdersImgAdapter(this, imgList);

        cgvOrdersDetail.setAdapter(imgAdapter);

        cgvOrdersDetail.setOnItemClickListener(this);

        mPresenter.getOrdersDetail(orderID);

    }

    private void initMark() {

        markList = new ArrayList<>();

        markAdapter = new OrdersMarkAdapter(this, markList);

        cgvEvaluate.setAdapter(markAdapter);

    }

    /**
     * 评价星级
     *
     * @param starCount
     */
    private void showStarCount(int starCount) {
        switch (starCount) {
            case 0:
                ivStarOne.setImageResource(R.mipmap.star_normal_icon);
                ivStarTwo.setImageResource(R.mipmap.star_normal_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 1:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_normal_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 2:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 3:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 4:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_checked_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 5:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_checked_icon);
                ivStarFive.setImageResource(R.mipmap.star_checked_icon);
                break;
        }

    }

    private void startToEvaluate() {
        Intent evaluateIntent = new Intent(this, EvaluateActivity.class);
        evaluateIntent.putExtra(Constants.ACTION_TO_EVALUATE_ORDER_ID, ordersInfo.getOrderID());
        evaluateIntent.putExtra(Constants.ACTION_TO_EVALUATE_USER_ID, ordersInfo.getUserID());
        evaluateIntent.putExtra(Constants.ACTION_TO_EVALUATE_USER_NAME, ordersInfo.getUserName());
        evaluateIntent.putExtra(Constants.ACTION_TO_EVALUATE_USER_PHOTO, ordersInfo.getUserPhoto());
        evaluateIntent.putExtra(Constants.ACTION_TO_EVALUATE_USER_PHONE, ordersInfo.getUserPhone());
        startActivity(evaluateIntent);
        finish();
    }

    @Override
    protected OrdersDetailPresenter onCreatePresenter() {
        return new OrdersDetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.lin_orders_detail_status, R.id.iv_orders_detail_call, R.id.tv_orders_detail_evaluate, R.id.btn_orders_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.lin_orders_detail_status:

                break;
            case R.id.iv_orders_detail_call:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNum));
                startActivity(intent);
                break;
            case R.id.tv_orders_detail_evaluate:
                startToEvaluate();
                break;
            case R.id.btn_orders_detail:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确认收货");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.confirmOrders(orderID);
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }
    }

    @Override
    public void responseOrdersDetailData(OrdersDetailInfo.OrdersDetail data) {
        ordersInfo = data;
        phoneNum = data.getUserPhone();
        tvMerchantName.setText("材料商" + data.getUserName());
        tvTime.setText("到货日期：" + data.getOrderTime());
        tvTotal.setText("合计：" + data.getTotalMoney());
    }

    @Override
    public void responseOrdersDetailMat(List<OrdersDetailInfo.OrdersDetail.ListMatBean> dataList) {
        matList.clear();
        matList.addAll(dataList);
        matAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(lvMat);
    }

    @Override
    public void responseOrdersDetailSubjoin(List<OrdersDetailInfo.OrdersDetail.ListMoneyBean> dataList) {
        subjoinList.clear();
        subjoinList.addAll(dataList);
        subjoinAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(lvSubjoin);
    }

    @Override
    public void responseOrdersDetailImage(List<String> dataList) {
        imgList.clear();
        for (String info : dataList) {
            LocalMedia data = new LocalMedia();
            data.setPath(info);
            imgList.add(data);
        }
        imgAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseOrderDetailEvaluate(OrdersDetailInfo.OrdersDetail.EvaluateOrderBean data) {
        if (data == null) {
            cgvEvaluate.setVisibility(View.GONE);
            tvEvaluateRemark.setVisibility(View.GONE);
        } else {
            tvEvaluate.setVisibility(View.GONE);
            showStarCount(data.getEvaluateStar());
            tvEvaluateRemark.setText(data.getEvaluateReamrk());
            markList.addAll(data.getMarkItems());
            markAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void responseOrdersDetailDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseConfirmOrders() {
        showToast("确认收货成功");
        startToEvaluate();
    }

    @Override
    public void responseConfirmOrdersError(String msg) {
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
        PictureSelector.create(this).externalPicturePreview(position, imgList);
    }
}
