package com.rxjy.pm.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.DisbursementStandardInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.DisbursementStandardContract;
import com.rxjy.pm.mvp.presenter.DisbursementStandardPresenter;

import butterknife.Bind;
import butterknife.OnClick;

public class DisbursementStandardActivity extends BaseActivity<DisbursementStandardPresenter> implements DisbursementStandardContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_disbursement_standard_way)
    TextView tvDisbursementStandardWay;
    @Bind(R.id.tv_disbursement_standard_one)
    TextView tvDisbursementStandardOne;
    @Bind(R.id.tv_disbursement_standard_two)
    TextView tvDisbursementStandardTwo;
    @Bind(R.id.tv_disbursement_standard_three)
    TextView tvDisbursementStandardThree;
    @Bind(R.id.tv_disbursement_standard_condition_one)
    TextView tvDisbursementStandardConditionOne;
    @Bind(R.id.tv_disbursement_standard_condition_two)
    TextView tvDisbursementStandardConditionTwo;
    @Bind(R.id.tv_disbursement_standard_condition_three)
    TextView tvDisbursementStandardConditionThree;
    @Bind(R.id.cb_disbursement_standard)
    CheckBox cbDisbursementStandard;
    @Bind(R.id.btn_disbursement_standard_agree)
    Button btnAgree;

    public static final String TITLE = "支款须知";

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_disbursement_standard;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initStandardData();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_DISBURSEMENT_STANDARD_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initStandardData() {

        tvDisbursementStandardWay.setText("完成准备任务—完成巡检任务—支款      \n注意：工程部门每周五为支款和结算时间。");
        tvDisbursementStandardOne.setText("1.首次申请款项必须完成开工准备操作，包括：\n①施工安全 \u3000 ②文明施工 \n③质量管控 \u3000 ④摄像头 \n开工准备照片上传应在开工之日起一周内完成，否则将无法申请款项。");
        tvDisbursementStandardTwo.setText("2.自项目开工一周后起，每周需要上传一次施工现场进度照片、每两周需要上传一次现场环境照片，完成这两项操作后方可二次批款，并以此类推，请项目经理随时关注巡检版块里面的任务情况。");
        tvDisbursementStandardThree.setText("3.项目经理申请款项条件：");
        tvDisbursementStandardConditionOne.setText("①申请生活费的条件是：开工一周内完成关于施工安全准备、文明施工准备、质量管控、摄像头准备的照片上传工作。");
        tvDisbursementStandardConditionTwo.setText("②再次申请款项的条件是：继开工一周后每周拍摄1次现场进度照片、每两周拍摄1次环境照片，并以此类推。");
        tvDisbursementStandardConditionThree.setText("③严格按照巡检版块里的任务提醒来完成，并按照范例图片的标准拍摄，如有弄虚作假行为，未按流程操作，集团项目人事将根据事件严重性进行相应处罚，情结恶劣者将冻结项目支款或予以辞退。");

        //获取支款状态接口
        mPresenter.getDisbursementState(proInfo.getOrderNo());

    }

    private void setActivity(String title, String url) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra(Constants.ACTION_TO_WEB_TITLE, title);
        intent.putExtra(Constants.ACTION_TO_WEB_URL, url);
        startActivity(intent);
    }

    @Override
    protected DisbursementStandardPresenter onCreatePresenter() {
        return new DisbursementStandardPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_disbursement_standard_punish, R.id.tv_disbursement_standard_manage, R.id.tv_disbursement_standard_pm_punish, R.id.tv_disbursement_standard_pm_manage, R.id.btn_disbursement_standard_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_disbursement_standard_punish:
                setActivity("施工现场处罚制度", "http://api.gc.rxjy.com/doc/onsite_manage_system.html");
                break;
            case R.id.tv_disbursement_standard_manage:
                setActivity("施工现场管理制度", "http://api.gc.rxjy.com/doc/construction_system.html");
                break;
            case R.id.tv_disbursement_standard_pm_punish:
                setActivity("项目经理处罚制度", "http://api.gc.rxjy.com/doc/promanager_manage_system.html");
                break;
            case R.id.tv_disbursement_standard_pm_manage:
                setActivity("项目经理管理制度", "http://api.gc.rxjy.com/doc/project_manager_system.html");
                break;
            case R.id.btn_disbursement_standard_agree:
                if (cbDisbursementStandard.isChecked()) {
                    Intent intent = new Intent(this, DisbursementActivity.class);
                    intent.putExtra(Constants.ACTION_TO_DISBURSEMENT_PRO_INFO, proInfo);
                    startActivity(intent);
                    finish();
                } else {
                    showToast("请勾选同意支款规则");
                }
                break;
        }
    }

    @Override
    public void responseDisbursementStateData(DisbursementStandardInfo.DisbursementStandard data) {
        switch (data.getStatu()) {
            case 0:
                btnAgree.setEnabled(true);
                break;
            case 1:
                IsDisbursement("请按要求完成准备板块里的任务再申请支款");
                break;
            case 2:
                IsDisbursement("请按要求完成巡检板块里的任务后再申请支款");
                break;
            case 3:
                IsDisbursement("请依次完成准备板块和巡检板块里的任务后再申请支款");
                break;
            case 4:
                IsDisbursement("项目经理未操作开工");
                break;
            case 5:
                IsDisbursement("集团外部人事冻结项目支款");
                break;
        }

    }

    private void IsDisbursement(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("确认", null);
        builder.setCancelable(false);
        builder.show();
    }

    @Override
    public void responseDisbursementStateDataError(String msg) {
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
