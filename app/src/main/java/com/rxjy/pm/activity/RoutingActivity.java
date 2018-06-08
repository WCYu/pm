package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.RoutingAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.RoutingBean;
import com.rxjy.pm.mvp.contract.RoutingContract;
import com.rxjy.pm.mvp.presenter.RoutingPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class RoutingActivity extends BaseActivity<RoutingPresenter> implements RoutingContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_routing)
    ListView lvRouting;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_pro_detail_project_icon)
    ImageView ivProDetailProjectIcon;
    @Bind(R.id.tv_pro_detail_project)
    TextView tvProDetailProject;
    @Bind(R.id.iv_pro_detail_address_icon)
    ImageView ivProDetailAddressIcon;
    @Bind(R.id.tv_pro_detail_address)
    TextView tvProDetailAddress;
    public static final String TITLE = "自检";
    private List<RoutingBean.BodyBean> routList;

    private RoutingAdapter mAdapter;

    private ProjectInfo.Project proInfo;
    private List<Map<String,String>> dataArrayList;

    @Override
    public int getLayout() {
        return R.layout.activity_routing;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRoutingData();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_PRO_INFO);
        tvProDetailProject.setText(proInfo.getProName());
        tvProDetailAddress.setText(proInfo.getProAddr());

//
//        tvProName.setText(proInfo.getProName());
//        tvOrderNo.setText(proInfo.getOrderNo());
//        tvAddress.setText(proInfo.getProAddr());
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRoutingData() {
        dataArrayList=new ArrayList<>();
        routList = new ArrayList<>();

        mAdapter = new RoutingAdapter(this, routList);

        lvRouting.setAdapter(mAdapter);

        lvRouting.setOnItemClickListener(this);

    }

    @Override
    protected RoutingPresenter onCreatePresenter() {

        return new RoutingPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //获取巡检列表
        mPresenter.getRoutingList(proInfo.getOrderNo());
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }

    @Override
    public void responseRoutingListData(List<RoutingBean.BodyBean> dataList, List<Map<String,String>> map) {
        dataArrayList.clear();
        dataArrayList.addAll(map);
        //dataList.get(0);
        routList.clear();
        routList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        // tvCount.setText(routList.size() + "");
    }

    @Override
    public void responseRoutingListDataError(String msg) {
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
        RoutingBean.BodyBean info = routList.get(position);

        if (info.getXj_state() == 1) {

            if(info.getXj_type() == 11) {
                Intent intent = new Intent(this, RoutingHistoryDetailActivity.class);
                RoutingBean.BodyBean bodyBean = routList.get(position);
                Map<String, String> stringStringMap = dataArrayList.get(position);
                intent.putExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_INFO,  bodyBean);
                intent.putExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_PICTURE_INFO, (Serializable) stringStringMap);
                startActivity(intent);
            }else {
                Intent intent = new Intent(this, EnvironmentActivity.class);
                intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_PRO, proInfo);
                intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_XJ_ID, info.getXj_id());
                startActivity(intent);

            }
        } else if (info.getXj_state() == 0) {
            if (info.getXj_type() == 11) {
                Intent intent = new Intent(this, RoutingSubActivity.class);
                intent.putExtra(Constants.ACTION_TO_ROUTING_SUB_XJ_ID, info.getXj_id());
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, EnvironmentActivity.class);
                intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_PRO, proInfo);
                intent.putExtra(Constants.ACTION_TO_ENVIRONMENT_XJ_ID, info.getXj_id());
                startActivity(intent);
            }
        }
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
