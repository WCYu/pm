package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.FirstMatAdapter;
import com.rxjy.pm.adapter.MatAdapter;
import com.rxjy.pm.adapter.SecondMatAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.FirstMatInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.MatMoneyInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.SecondMatInfo;
import com.rxjy.pm.entity.UpdMatInfo;
import com.rxjy.pm.mvp.contract.MatContract;
import com.rxjy.pm.mvp.presenter.MatPresenter;
import com.rxjy.pm.widget.CountDialog;
import com.rxjy.pm.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatActivity extends BaseActivity<MatPresenter> implements MatContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_mat_tip)
    TextView tvMatTip;
    @Bind(R.id.hlv_mat)
    HorizontalListView hlvMat;
    @Bind(R.id.gv_mat)
    GridView gvMat;
    @Bind(R.id.lv_mat)
    ListView lvMat;
    @Bind(R.id.tv_plan_money_count)
    TextView tvPlanMoneyCount;
    @Bind(R.id.tv_has_send_count)
    TextView tvHasSendCount;
    @Bind(R.id.tv_mat_money)
    TextView tvMatMoney;
    @Bind(R.id.tv_mat_count)
    TextView tvMatCount;

    private FirstMatAdapter mFirstMatAdapter;

    private List<FirstMatInfo.FirstMat> firstList;

    private SecondMatAdapter mSecondMatAdapter;

    private List<SecondMatInfo.SecondMat> secondList;

    private List<SecondMatInfo.SecondMat> showList;

    private MatAdapter mMatAdapter;

    private List<MatInfo.Mat> matList;

    private String firstMatID;

    private String secondMatID;

    private CountDialog countDialog;

    private int count = 0;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_mat;
    }

    @Override
    public void initData() {
        initIntentData();
        initTitle();
        initTip();
        initFirstMat();
        initSecondMat();
        initThirdMat();
        initMoneyInfo();
        initCountDialog();
    }

    private void initIntentData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(proInfo.getProName());
        ivAdd.setVisibility(View.VISIBLE);
        ivAdd.setImageResource(R.mipmap.search_icon);
    }

    private void initTip() {
        tvMatTip.setText("如材料版块无内容显示，请联系材料供应商从原有材料系统进行配送。");
        tvMatTip.setSelected(true);
    }

    private void initFirstMat() {

        firstList = new ArrayList<>();

        mFirstMatAdapter = new FirstMatAdapter(this, firstList);

        hlvMat.setAdapter(mFirstMatAdapter);

        hlvMat.setOnItemClickListener(this);

        mPresenter.getFirstMat(proInfo.getOrderNo());

    }

    private void initSecondMat() {

        secondList = new ArrayList<>();

        showList = new ArrayList<>();

        mSecondMatAdapter = new SecondMatAdapter(this, showList);

        gvMat.setAdapter(mSecondMatAdapter);

        gvMat.setOnItemClickListener(this);

    }

    private void initThirdMat() {

        matList = new ArrayList<>();

        mMatAdapter = new MatAdapter(this, this, matList);

        lvMat.setAdapter(mMatAdapter);

    }

    private void initMoneyInfo() {

        mPresenter.getMatMoneyInfo(proInfo.getOrderNo());

    }

    private void setFirstMatSelector(int position) {
        for (FirstMatInfo.FirstMat info : firstList) {
            info.setIsChecked(0);
        }
        FirstMatInfo.FirstMat info = firstList.get(position);
        info.setIsChecked(1);
        firstMatID = info.getTreeID();
        mFirstMatAdapter.notifyDataSetChanged();
        //获取二级材料分类
        mPresenter.getSecondMat(proInfo.getOrderNo(), firstMatID);
    }

    private void setSecondMatSelector(int position) {
        if (mSecondMatAdapter.getShowStatus()) {
            if (showList.size() > 4) {
                mSecondMatAdapter.setShowStatus(false);
                for (SecondMatInfo.SecondMat info : showList) {
                    info.setIsChecked(0);
                }
                SecondMatInfo.SecondMat info = showList.get(position);
                info.setIsChecked(1);
                secondMatID = info.getTreeID();
                showList.remove(position);
                showList.add(0, info);
                secondList.remove(position);
                secondList.add(0, info);
                int count = showList.size();
                for (int i = 0; i < count; i++) {
                    if (i >= 3) {
                        showList.remove(3);
                    }
                }
                showList.add(new SecondMatInfo.SecondMat("更多"));
            } else {
                for (SecondMatInfo.SecondMat info : showList) {
                    info.setIsChecked(0);
                }
                SecondMatInfo.SecondMat info = showList.get(position);
                info.setIsChecked(1);
                secondMatID = info.getTreeID();
            }
        } else {
            if (position == 3) {
                mSecondMatAdapter.setShowStatus(true);
                showList.clear();
                for (int i = 0; i < secondList.size(); i++) {
                    showList.add(secondList.get(i));
                }
            } else if (position < 3) {
                for (SecondMatInfo.SecondMat info : showList) {
                    info.setIsChecked(0);
                }
                SecondMatInfo.SecondMat info = showList.get(position);
                info.setIsChecked(1);
                secondMatID = info.getTreeID();
            }
        }
        mSecondMatAdapter.notifyDataSetChanged();
        //获取材料列表数据
        mPresenter.getMatList(proInfo.getOrderNo(), firstMatID, secondMatID);
    }

    private void initCountDialog() {

        countDialog = new CountDialog(this);

        countDialog.setOnNoOnClickListener("取消", null);

        countDialog.setOnYesOnClickListener("确认", new CountDialog.OnYesOnClickListener() {
            @Override
            public void onYes(double count, MatInfo.Mat data) {
                mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), count, 1);
            }
        });

    }

    @Override
    protected MatPresenter onCreatePresenter() {
        return new MatPresenter(this);
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
        if (mPresenter != null && firstMatID != null && secondMatID != null) {
            //获取材料列表数据
            mPresenter.getMatList(proInfo.getOrderNo(), firstMatID, secondMatID);
            mPresenter.getMatMoneyInfo(proInfo.getOrderNo());
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_add, R.id.tv_shop_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                Intent intent = new Intent(this, MatSearchActivity.class);
                intent.putExtra(Constants.ACTION_TO_MAT_SEARCH_PRO_INFO, proInfo);
                startActivity(intent);
                break;
            case R.id.tv_shop_cart:
                if (count != 0) {
                    Intent shopIntent = new Intent(this, ShopCartActivity.class);
                    shopIntent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_NAME, proInfo.getProName());
                    shopIntent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_ADDRESS, proInfo.getProAddr());
                    shopIntent.putExtra(Constants.ACTION_TO_SHOP_CART_PRO_ORDER_NO, proInfo.getOrderNo());
                    startActivity(shopIntent);
                } else {
                    showToast("请选择购买材料");
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.hlv_mat:
                setFirstMatSelector(position);
                break;
            case R.id.gv_mat:
                setSecondMatSelector(position);
                break;
        }
    }

    @Override
    public void responseFirstMatData(List<FirstMatInfo.FirstMat> dataList) {
        firstList.clear();
        firstList.addAll(dataList);
        if (firstList.size() != 0) {
            setFirstMatSelector(0);
        }
    }

    @Override
    public void responseFirstMatDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSecondMatData(List<SecondMatInfo.SecondMat> dataList) {
        secondList.clear();
        showList.clear();
        secondList.addAll(dataList);
        if (dataList.size() <= 4) {
            mSecondMatAdapter.setShowStatus(true);
            showList.addAll(secondList);
        } else {
            mSecondMatAdapter.setShowStatus(false);
            for (int i = 0; i < secondList.size(); i++) {
                if (i < 3) {
                    showList.add(secondList.get(i));
                } else {
                    showList.add(new SecondMatInfo.SecondMat("更多"));
                    break;
                }
            }
        }
        if (showList.size() != 0) {
            setSecondMatSelector(0);
        }
        mSecondMatAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMatData(List<MatInfo.Mat> dataList) {
        matList.clear();
        matList.addAll(dataList);
        mMatAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMatDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSecondMatDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseMatMoneyData(MatMoneyInfo.MatMoney data) {
        tvPlanMoneyCount.setText("¥" + data.getPlanMoney());
        tvHasSendCount.setText("¥" + data.getTotalMoney());
        tvMatCount.setText(data.getDisCount() + "种");
        tvMatMoney.setText("¥" + data.getDisMoney());
        count = data.getDisCount();
    }

    @Override
    public void responseMatMoneyDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpdMatInfo(UpdMatInfo.UpdMat data) {
        tvMatCount.setText(data.getMatCount() + "种");
        tvMatMoney.setText("¥" + data.getTotalMoney());
        //刷新材料列表
        mPresenter.getMatList(proInfo.getOrderNo(), firstMatID, secondMatID);
        count = data.getMatCount();
    }

    @Override
    public void responseUpdMatInfoError(String msg) {
        showToast(msg);
    }

    @Override
    public void updMatCount(MatInfo.Mat data, int type) {
        //type 1-新增 2-减少 3-修改 4-删除
        switch (type) {
            case 0:
                mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (data.getBuyCount() + 1), 1);
                break;
            case 1:
                if (data.getBuyCount() < 1)
                    mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (0), 1);
                else
                    mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (data.getBuyCount() - 1), 1);
                break;
            case 2:
                countDialog.show();
                countDialog.setCount(data.getBuyCount(), data);
                break;
        }
    }

    @Override
    public void updMatMerchant(MatInfo.Mat data) {
        Intent intent = new Intent(this, UpdMatMerchantActivity.class);
        intent.putExtra(Constants.ACTION_TO_MAT_MERCHANT_MAT_INFO, data);
        intent.putExtra(Constants.ACTION_TO_MAT_MERCHANT_PRO_INFO, proInfo);
        startActivity(intent);
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
