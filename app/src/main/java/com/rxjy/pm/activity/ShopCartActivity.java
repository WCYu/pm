package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.ShopMerchantAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.DoubleUtils;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.mvp.contract.ShopCartContract;
import com.rxjy.pm.mvp.presenter.ShopCartPresenter;
import com.rxjy.pm.widget.ShopCountDialog;
import com.rxjy.pm.widget.SubjoinDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

public class ShopCartActivity extends BaseActivity<ShopCartPresenter> implements ShopCartContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_text)
    TextView tvText;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_shop_cart_pro_name)
    TextView tvProName;
    @Bind(R.id.tv_shop_cart_pro_address)
    TextView tvProAddress;
    @Bind(R.id.lv_shop_cart)
    ListView lvShopCart;
    @Bind(R.id.iv_all_checked)
    ImageView ivAllChecked;
    @Bind(R.id.tv_shop_cart_total)
    TextView tvTotal;
    @Bind(R.id.tv_shop_cart_payment)
    TextView tvPayment;

    public static final String TITLE = "购物车";

    private List<ShopCartInfo.ShopCart.Merchant> merList;

    private ShopMerchantAdapter merAdapter;

    private ShopCountDialog countDialog;

    private SubjoinDialog subjoinDialog;

    private DatePicker picker;

    private double total;

    private String proName;

    private String proAddress;

    private String orderNo;

    private int type = 0;

    private boolean isCheckedAll = false;

    private boolean editFlag = false;

    private boolean isAllTimeChecked = false;

    private int checkedCount = 0;

    @Override
    public int getLayout() {
        return R.layout.activity_shop_cart;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPro();
        initShopCart();
        initCountDialog();
        initSubjoinDialog();
        initPicker();
    }

    private void initIntent() {
        proName = getIntent().getStringExtra(Constants.ACTION_TO_SHOP_CART_PRO_NAME);
        proAddress = getIntent().getStringExtra(Constants.ACTION_TO_SHOP_CART_PRO_ADDRESS);
        orderNo = getIntent().getStringExtra(Constants.ACTION_TO_SHOP_CART_PRO_ORDER_NO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        tvText.setText("编辑");
    }

    private void initPro() {
        tvProName.setText("项目：" + proName);
        tvProAddress.setText(proAddress);
    }

    private void initShopCart() {

        merList = new ArrayList<>();

        merAdapter = new ShopMerchantAdapter(this, merList);

        merAdapter.setListener(this);

        lvShopCart.setAdapter(merAdapter);

    }

    private void initCountDialog() {

        countDialog = new ShopCountDialog(this);

        countDialog.setOnNoOnClickListener("取消", null);

        countDialog.setOnYesOnClickListener("确认", new ShopCountDialog.OnYesOnClickListener() {
            @Override
            public void onYes(double count, ShopCartInfo.ShopCart.Merchant.Mat data) {
                mPresenter.updMat(orderNo, data.getMatID(), data.getUserID(), count, data.getIsChecked());
            }
        });

    }

    private void initSubjoinDialog() {

        subjoinDialog = new SubjoinDialog(this);

        subjoinDialog.setOnNoOnClickListener("取消", null);

        subjoinDialog.setOnYesOnClickListener("确认", new SubjoinDialog.OnYesOnClickListener() {
            @Override
            public void onYes(int count, int userID) {
                mPresenter.updSubjoin(orderNo, userID, count + "", type);
            }
        });

    }

    private void initPicker() {

        picker = new DatePicker(this);

        picker.setRange(Integer.parseInt(TimeUtil.getYear()), 2100);

    }

    private void setTotal(List<ShopCartInfo.ShopCart.Merchant> dataList) {
        double sum = 0;
        for (ShopCartInfo.ShopCart.Merchant mer : dataList) {
            if (mer.getChecked() == 0) {
                continue;
            } else {
                Double aPrice = Double.parseDouble(mer.getAPrice().equals("") ? 0 + "" : mer.getAPrice());
                Double pPrice = Double.parseDouble(mer.getPPrice().equals("") ? 0 + "" : mer.getPPrice());
                Double fPrice = Double.parseDouble(mer.getFPrice().equals("") ? 0 + "" : mer.getFPrice());
                sum = sum + aPrice + pPrice + fPrice;
            }
            for (ShopCartInfo.ShopCart.Merchant.Mat mat : mer.getItems()) {
                if (mat.getIsChecked() == 0) {
                    continue;
                } else {
                    Double count = Double.parseDouble(mat.getBuyCount().equals("") ? 0 + "" : mat.getBuyCount());
                    Double price = Double.parseDouble(mat.getMatPrice().equals("") ? 0 + "" : mat.getMatPrice());
                    sum = sum + DoubleUtils.mul(count, price);
                }
            }
        }
        total = sum;
        tvTotal.setText("合计：¥" + total);
    }

    @Override
    protected ShopCartPresenter onCreatePresenter() {
        return new ShopCartPresenter(this);
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
        mPresenter.getShopCart(orderNo);
    }

    @OnClick({R.id.iv_back, R.id.iv_all_checked, R.id.tv_text, R.id.tv_shop_cart_payment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_all_checked:
                if (isCheckedAll) {
                    mPresenter.updAllCheckedStatus(orderNo, 0);
                } else {
                    mPresenter.updAllCheckedStatus(orderNo, 1);
                }
                break;
            case R.id.tv_text:
                if (editFlag) {
                    tvText.setText("编辑");
                    editFlag = false;
                    merAdapter.setEditFlag(false);
                } else {
                    tvText.setText("完成");
                    editFlag = true;
                    merAdapter.setEditFlag(true);
                }
                merAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_shop_cart_payment:
                if (merList.size() == 0) {
                    showToast("购物车中没有材料，无法下单");
                } else {
                    for (ShopCartInfo.ShopCart.Merchant info : merList) {
                        if (info.getChecked() == 0) {
                            checkedCount++;
                        } else {
                            continue;
                        }
                    }
                    if (checkedCount == merList.size()) {
                        showToast("请选择下单材料");
                        break;
                    }
                    for (ShopCartInfo.ShopCart.Merchant info : merList) {
                        if (info.getChecked() == 0) {
                            continue;
                        }
                        if (info.getOTime().equals("")) {
                            isAllTimeChecked = true;
                            break;
                        }
                    }
                    if (isAllTimeChecked)
                        showToast("请选择全部配送日期");
                    else
                        mPresenter.payment(orderNo, merList);
                }
                break;
        }
    }

    @Override
    public void responseShopCartData(ShopCartInfo.ShopCart data) {
        if (data.getChecked() == 2) {
            isCheckedAll = true;
            ivAllChecked.setImageResource(R.mipmap.checked_box_pressed_icon);
        } else {
            isCheckedAll = false;
            ivAllChecked.setImageResource(R.mipmap.checked_box_normal_icon);
        }
        setTotal(data.getItems());
    }

    @Override
    public void responseMerchantData(List<ShopCartInfo.ShopCart.Merchant> dataList) {
        checkedCount = 0;
        isAllTimeChecked = false;
        if (dataList.size() == 0) {
            merList.clear();
        } else {
            merList.clear();
            merList.addAll(dataList);
        }
        merAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseShopCartDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseIsCheckedStatus() {
        mPresenter.getShopCart(orderNo);
    }

    @Override
    public void responseIsCheckedStatusError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSubjoinData() {
        mPresenter.getShopCart(orderNo);
    }

    @Override
    public void responseSubJoinDataError(String msg) {
        checkedCount = 0;
        isAllTimeChecked = false;
        showToast(msg);
    }

    @Override
    public void isCheckedMerchantAll(ShopCartInfo.ShopCart.Merchant data, int type) {
        mPresenter.updAllMerchantCheckedStatus(orderNo, data.getUserID(), type);
    }

    @Override
    public void isCheckedMat(ShopCartInfo.ShopCart.Merchant.Mat data, int type) {
        mPresenter.updAllMatCheckedStatus(orderNo, data.getMatID(), data.getUserID(), type);
    }

    @Override
    public void updMatCount(ShopCartInfo.ShopCart.Merchant.Mat data, int type) {
        //type 0-新增 1-减少 2-修改 3-删除
        switch (type) {
            case 0:
                mPresenter.updMat(orderNo, data.getMatID(), data.getUserID(), (Double.parseDouble(data.getBuyCount()) + 1), data.getIsChecked());
                break;
            case 1:
                if (Double.parseDouble(data.getBuyCount()) < 1)
                    mPresenter.updMat(orderNo, data.getMatID(), data.getUserID(), 0, data.getIsChecked());
                else
                    mPresenter.updMat(orderNo, data.getMatID(), data.getUserID(), (Double.parseDouble(data.getBuyCount()) - 1), data.getIsChecked());
                break;
            case 2:
                countDialog.show();
                countDialog.setCount(Double.parseDouble(data.getBuyCount()), data);
                break;
            case 3:
                mPresenter.delMat(orderNo, data.getMatID());
                break;
        }
    }

    @Override
    public void updSubjoin(final ShopCartInfo.ShopCart.Merchant data, int type) {
        //0-配送费 1-加工费 2-辅料费 3-日期 4-备注
        switch (type) {
            case 0:
                this.type = 0;
                subjoinDialog.show();
                subjoinDialog.setTitleText("填写配送费用");
                subjoinDialog.setHintText("填写配送费用-¥");
                subjoinDialog.setCount((int) Double.parseDouble(data.getFPrice()), data.getUserID());
                break;
            case 1:
                this.type = 1;
                subjoinDialog.show();
                subjoinDialog.setTitleText("填写加工费用");
                subjoinDialog.setHintText("填写加工费用-¥");
                subjoinDialog.setCount((int) Double.parseDouble(data.getPPrice()), data.getUserID());
                break;
            case 2:
                this.type = 2;
                subjoinDialog.show();
                subjoinDialog.setTitleText("填写辅料费用");
                subjoinDialog.setHintText("填写辅料费用-¥");
                subjoinDialog.setCount((int) Double.parseDouble(data.getAPrice()), data.getUserID());
                break;
            case 3:
                this.type = 3;
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        if (Integer.parseInt(month) < Integer.parseInt(TimeUtil.getMonth())) {
                            showToast("无法选择今天之前的日期");
                        } else {
                            if (Integer.parseInt(day) < Integer.parseInt(TimeUtil.getDay())) {
                                showToast("无法选择今天之前的日期");
                            } else {
                                mPresenter.updSubjoin(orderNo, data.getUserID(), year + "-" + month + "-" + day, 3);
                            }
                        }
                    }
                });
                picker.setSelectedItem(Integer.parseInt(TimeUtil.getYear()), Integer.parseInt(TimeUtil.getMonth()), Integer.parseInt(TimeUtil.getDay()));
                picker.show();
                break;
            case 4:
                Intent intent = new Intent(this, SubjoinActivity.class);
                intent.putExtra(Constants.ACTION_TO_SUBJOIN_ORDER_NO, orderNo);
                intent.putExtra(Constants.ACTION_TO_SUBJOIN_MERCHANT_INFO, data);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void responseUpdMatInfo() {
        mPresenter.getShopCart(orderNo);
    }

    @Override
    public void responseUpdMatInfoError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsePayment() {
        showToast("下单成功");
        Intent intent = new Intent(this, OrdersListActivity.class);
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_ORDER_NO, orderNo);
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_NAME, proName);
        intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_ADDRESS, proAddress);
        startActivity(intent);
        finish();
    }

    @Override
    public void responsePaymentError(String msg) {
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
