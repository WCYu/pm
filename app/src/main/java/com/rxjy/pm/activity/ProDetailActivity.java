package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.ProjectInfo;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProDetailActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_pro_detail_person)
    TextView tvPerson;
    @Bind(R.id.tv_pro_detail_project)
    TextView tvProject;
    @Bind(R.id.tv_pro_detail_address)
    TextView tvAddress;
    @Bind(R.id.tv_prepare_state_count)
    TextView tvPrepareStateCount;
    @Bind(R.id.tv_routing_state_count)
    TextView tvRoutingStateCount;
    @Bind(R.id.tv_disbursement_state_count)
    TextView tvDisbursementStateCount;
    @Bind(R.id.tv_mat_state_count)
    TextView tvMatStateCount;
    @Bind(R.id.tv_camera_state_count)
    TextView tvCameraStateCount;
    @Bind(R.id.tv_pro_money_state_count)
    TextView tvProMoneyStateCount;

    public static final String TITLE = "项目详情";
    @Bind(R.id.or_code)
    ImageView orCode;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_pro_detail_address_icon)
    ImageView ivProDetailAddressIcon;
    @Bind(R.id.engineering)
    AutoLinearLayout engineering;
    @Bind(R.id.construction_Plans)
    AutoLinearLayout constructionPlans;
    @Bind(R.id.design_Sketch)
    AutoLinearLayout designSketch;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPro();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
    }

    private void initTitle() {
        ivAdd.setVisibility(View.VISIBLE);
        ivAdd.setImageResource(R.mipmap.qr_code);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProDetailActivity.this, OrCodeActivity.class);
                String orderNo = proInfo.getOrderNo();
                int uid = App.pmUserInfo.getUid();
//                Log.e("id", cityID + "");
                intent.putExtra(Constants.ORDERNO, orderNo);
                intent.putExtra(Constants.CITYID, uid);
                Log.e("cc", orderNo + "        " + uid);
                startActivity(intent);
            }
        });
        tvTitle.setText(TITLE);
    }

    private void initPro() {
        tvPerson.setText(proInfo.getSupervisorName() + " " + proInfo.getSupervisorPhone());
        tvProject.setText(proInfo.getProName());
        tvAddress.setText(proInfo.getProAddr());
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick({R.id.iv_back, R.id.rl_prepare,
            R.id.rl_routing, R.id.rl_disbursement,
            R.id.rl_mat, R.id.rl_camera,
            R.id.rl_pro_money, R.id.rl_pro_management, R.id.rl_two,
            R.id.engineering, R.id.construction_Plans, R.id.design_Sketch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_prepare:
                Intent preIntent = new Intent(this, UnderConstructionActivity.class);
                preIntent.putExtra(Constants.ACTION_TO_UNDER_CONSTRUCTION_PRO_INFO, proInfo);
                startActivity(preIntent);
                break;
            case R.id.rl_routing:
                Intent routingIntent = new Intent(this, RoutingActivity.class);
                routingIntent.putExtra(Constants.ACTION_TO_ROUTING_PRO_INFO, proInfo);
                startActivity(routingIntent);
                break;
            case R.id.rl_disbursement:
                Intent disIntent = new Intent(this, DisbursementStandardActivity.class);
                disIntent.putExtra(Constants.ACTION_TO_DISBURSEMENT_STANDARD_PRO_INFO, proInfo);
                startActivity(disIntent);
                break;
            case R.id.rl_mat:
                if (proInfo.getState() == 8 || proInfo.getState() == 71) {
                    showToast("完工后不可购买材料");
                    return;
                }
                Intent matIntent = new Intent(this, MatActivity.class);
                matIntent.putExtra(Constants.ACTION_TO_MAT_PRO_INFO, proInfo);
                startActivity(matIntent);
                break;
            case R.id.rl_camera:
                Intent cameraIntent = new Intent(this, CameraListActivity.class);
                cameraIntent.putExtra(Constants.ACTION_TO_CAMERA_LIST_PRO_INFO, proInfo);
                startActivity(cameraIntent);
                break;
            case R.id.rl_pro_money:
                Intent proMoneyIntent = new Intent(this, ProMoneyDetailActivity.class);
                proMoneyIntent.putExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_ORDER_NO, proInfo.getOrderNo());
                proMoneyIntent.putExtra(Constants.ACTION_TO_PRO_MONTY_DETAIL_PRO_NAME, proInfo.getProName());
                startActivity(proMoneyIntent);
                break;
            case R.id.rl_pro_management:
                Intent proManagementIntent = new Intent(this, VisitActivity.class);
                proManagementIntent.putExtra(Constants.ACTION_TO_VISIT_ORDER_NO, proInfo.getOrderNo());
                proManagementIntent.putExtra(Constants.ACTION_TO_VISIT_PRO_NAME, proInfo.getProName());
                startActivity(proManagementIntent);
                break;

            case R.id.rl_two:
                Intent intent = new Intent(this, OrDerSelectActivity.class);
                intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_ORDER_NO, proInfo.getOrderNo());
                intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_NAME, proInfo.getProName());
                intent.putExtra(Constants.ACTION_TO_ORDERS_LIST_PRO_ADDRESS, proInfo.getProAddr());
                startActivity(intent);
                break;
            case R.id.engineering:
                Intent intent1 = new Intent(this, EngineeringInfoActivity.class);
                intent1.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent1.putExtra(Constants.PICTUREMARK, true);
                startActivity(intent1);
                break;
            case R.id.construction_Plans:
                Intent intent2 = new Intent(this, PictureActivity.class);
                intent2.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent2.putExtra(Constants.PICTUREMARK, true);
                intent2.putExtra(Constants.TITLE, "施工图");
                startActivity(intent2);
                break;
            case R.id.design_Sketch:
                Intent intent3 = new Intent(this, PictureActivity.class);
                intent3.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent3.putExtra(Constants.PICTUREMARK, false);
                intent3.putExtra(Constants.TITLE, "效果图");
                startActivity(intent3);
                break;
        }
    }


    @OnClick(R.id.or_code)
    public void onViewClicked() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
