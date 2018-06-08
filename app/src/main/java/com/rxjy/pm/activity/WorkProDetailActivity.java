package com.rxjy.pm.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.WorklistBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/3/31.
 */

public class WorkProDetailActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_pro_detail_person_icon)
    ImageView ivProDetailPersonIcon;
    @Bind(R.id.tv_pro_detail_person)
    TextView tvProDetailPerson;
    @Bind(R.id.iv_pro_detail_project_icon)
    ImageView ivProDetailProjectIcon;
    @Bind(R.id.tv_pro_detail_project)
    TextView tvProDetailProject;
    @Bind(R.id.iv_pro_detail_address_icon)
    ImageView ivProDetailAddressIcon;
    @Bind(R.id.tv_pro_detail_address)
    TextView tvProDetailAddress;
    @Bind(R.id.or_code)
    ImageView orCode;
    @Bind(R.id.iv_prepare)
    ImageView ivPrepare;
    @Bind(R.id.tv_prepare)
    TextView tvPrepare;
    @Bind(R.id.tv_prepare_state_count)
    TextView tvPrepareStateCount;
    @Bind(R.id.rl_prepare)
    RelativeLayout rlPrepare;
    @Bind(R.id.iv_routing)
    ImageView ivRouting;
    @Bind(R.id.tv_routing)
    TextView tvRouting;
    @Bind(R.id.tv_routing_state_count)
    TextView tvRoutingStateCount;
    @Bind(R.id.rl_routing)
    RelativeLayout rlRouting;
    @Bind(R.id.iv_camera)
    ImageView ivCamera;
    @Bind(R.id.tv_camera)
    TextView tvCamera;
    @Bind(R.id.tv_camera_state_count)
    TextView tvCameraStateCount;
    @Bind(R.id.rl_camera)
    RelativeLayout rlCamera;
    @Bind(R.id.iv_pro_management)
    ImageView ivProManagement;
    @Bind(R.id.tv_pro_management)
    TextView tvProManagement;
    @Bind(R.id.tv_pro_management_state_count)
    TextView tvProManagementStateCount;
    @Bind(R.id.rl_pro_management)
    RelativeLayout rlProManagement;
    @Bind(R.id.iv_mat)
    ImageView ivMat;
    @Bind(R.id.tv_mat)
    TextView tvMat;
    @Bind(R.id.tv_mat_state_count)
    TextView tvMatStateCount;
    @Bind(R.id.rl_mat)
    RelativeLayout rlMat;
    @Bind(R.id.iv_two)
    ImageView ivTwo;
    @Bind(R.id.tv_two)
    TextView tvTwo;
    @Bind(R.id.tv_two_state_count)
    TextView tvTwoStateCount;
    @Bind(R.id.rl_two)
    RelativeLayout rlTwo;
    @Bind(R.id.iv_pro_money)
    ImageView ivProMoney;
    @Bind(R.id.tv_pro_money)
    TextView tvProMoney;
    @Bind(R.id.tv_pro_money_state_count)
    TextView tvProMoneyStateCount;
    @Bind(R.id.rl_pro_money)
    RelativeLayout rlProMoney;
    @Bind(R.id.iv_disbursement)
    ImageView ivDisbursement;
    @Bind(R.id.tv_disbursement)
    TextView tvDisbursement;
    @Bind(R.id.tv_disbursement_state_count)
    TextView tvDisbursementStateCount;
    @Bind(R.id.rl_disbursement)
    RelativeLayout rlDisbursement;
    private WorklistBean.BodyBean info;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_detail;
    }

    @Override
    public void initData() {
       LinearLayout linearLayout= (LinearLayout) findViewById(R.id.contract);
        linearLayout.setVisibility(View.GONE );
        orCode.setVisibility(View.GONE);
        orCode.setVisibility(View.INVISIBLE);
        initIntent();
        initTitle();
    }

    private void initTitle() {
        tvTitle.setText("工人");
        tvProDetailPerson.setText(info.getUserName() + " " + info.getMobile());
        tvProDetailProject.setText(info.getProName());
        tvProDetailAddress.setText(info.getProAddr());
    }

    private void initIntent() {
        info = (WorklistBean.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick({R.id.iv_back, R.id.iv_add, R.id.tv_title, R.id.iv_pro_detail_person_icon, R.id.tv_pro_detail_person, R.id.iv_pro_detail_project_icon, R.id.tv_pro_detail_project, R.id.iv_pro_detail_address_icon, R.id.tv_pro_detail_address, R.id.or_code, R.id.iv_prepare, R.id.tv_prepare, R.id.tv_prepare_state_count, R.id.rl_prepare, R.id.iv_routing, R.id.tv_routing, R.id.tv_routing_state_count, R.id.rl_routing, R.id.iv_camera, R.id.tv_camera, R.id.tv_camera_state_count, R.id.rl_camera, R.id.iv_pro_management, R.id.tv_pro_management, R.id.tv_pro_management_state_count, R.id.rl_pro_management, R.id.iv_mat, R.id.tv_mat, R.id.tv_mat_state_count, R.id.rl_mat, R.id.iv_two, R.id.tv_two, R.id.tv_two_state_count, R.id.rl_two, R.id.iv_pro_money, R.id.tv_pro_money, R.id.tv_pro_money_state_count, R.id.rl_pro_money, R.id.iv_disbursement, R.id.tv_disbursement, R.id.tv_disbursement_state_count, R.id.rl_disbursement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                break;
            case R.id.tv_title:
                break;
            case R.id.iv_pro_detail_person_icon:
                break;
            case R.id.tv_pro_detail_person:
                break;
            case R.id.iv_pro_detail_project_icon:
                break;
            case R.id.tv_pro_detail_project:
                break;
            case R.id.iv_pro_detail_address_icon:
                break;
            case R.id.tv_pro_detail_address:
                break;
            case R.id.or_code:
                break;
            case R.id.iv_prepare:
                break;
            case R.id.tv_prepare:
                break;
            case R.id.tv_prepare_state_count:
                break;
            case R.id.rl_prepare:
                break;
            case R.id.iv_routing:
                break;
            case R.id.tv_routing:
                break;
            case R.id.tv_routing_state_count:
                break;
            case R.id.rl_routing:
                break;
            case R.id.iv_camera:
                break;
            case R.id.tv_camera:
                break;
            case R.id.tv_camera_state_count:
                break;
            case R.id.rl_camera:
                break;
            case R.id.iv_pro_management:
                break;
            case R.id.tv_pro_management:
                break;
            case R.id.tv_pro_management_state_count:
                break;
            case R.id.rl_pro_management:
                break;
            case R.id.iv_mat:
                break;
            case R.id.tv_mat:
                break;
            case R.id.tv_mat_state_count:
                break;
            case R.id.rl_mat:
                break;
            case R.id.iv_two:
                break;
            case R.id.tv_two:
                break;
            case R.id.tv_two_state_count:
                break;
            case R.id.rl_two:
                break;
            case R.id.iv_pro_money:
                break;
            case R.id.tv_pro_money:
                break;
            case R.id.tv_pro_money_state_count:
                break;
            case R.id.rl_pro_money:
                break;
            case R.id.iv_disbursement:
                break;
            case R.id.tv_disbursement:
                break;
            case R.id.tv_disbursement_state_count:
                break;
            case R.id.rl_disbursement:
                break;
        }
    }
}
