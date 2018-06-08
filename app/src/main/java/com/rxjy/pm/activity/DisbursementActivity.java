package com.rxjy.pm.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.DisbursementAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.DisbursementInfo;
import com.rxjy.pm.entity.DisbursementListInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.DisbursementContract;
import com.rxjy.pm.mvp.presenter.DisbursementPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.rxjy.pm.R.id.lin_disbursement;

public class DisbursementActivity extends BaseActivity<DisbursementPresenter> implements DisbursementContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_disbursement_pro_name)
    TextView tvProName;
    @Bind(R.id.tv_disbursement_money)
    TextView tvMoney;
    @Bind(R.id.tv_disbursement_punish_money)
    TextView tvPunishMoney;
    @Bind(R.id.et_disbursement_content)
    EditText etContent;
    @Bind(R.id.et_disbursement_apply_money)
    EditText etApplyMoney;
    @Bind(lin_disbursement)
    LinearLayout linDis;
    @Bind(R.id.btn_submit)
    Button btnSub;
    @Bind(R.id.lv_disbursement)
    ListView lvDisbursement;

    public static final String TITLE = "支款";

    private List<DisbursementListInfo.DisbursementList> disList;

    private DisbursementAdapter mAdapter;

    private double kMoney = 0;
    private double fMoney = 0;
    private String faIds;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_disbursement;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initDisbursementData();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_DISBURSEMENT_PRO_INFO);
        if (proInfo.getState() == 8 || proInfo.getState() == 71) {
            linDis.setVisibility(View.GONE);
        }
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initDisbursementData() {

        //初始化提交按钮不可点击
        btnSub.setEnabled(false);

        tvProName.setText(proInfo.getProName());

        disList = new ArrayList<>();

        mAdapter = new DisbursementAdapter(this, disList);

        lvDisbursement.setAdapter(mAdapter);

        //获取工人可用款信息
        mPresenter.getDisbursementData(proInfo.getOrderNo());
        //获取支款记录信息
        mPresenter.getDisbursementListData(proInfo.getOrderNo());

    }

    @Override
    protected DisbursementPresenter onCreatePresenter() {
        return new DisbursementPresenter(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_disbursement_read, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_disbursement_read:
                showToast("开发中...");
                break;
            case R.id.btn_submit:
                final String content = etContent.getText().toString().trim();
                String disMoney = etApplyMoney.getText().toString().trim();
                if (!disMoney.equals("")) {
                    final double money = Double.parseDouble(disMoney);
                    if (content.equals("")) {
                        showToast("请填写申请内容");
                    } else {
                        if (money > kMoney) {
                            showToast("申请金额不得大于可用金额");
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("提示");
                            builder.setMessage("申请支款将如果含有罚款将扣除罚款金额，是否继续申请");
                            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //按钮不可点击
                                    btnSub.setEnabled(false);
                                    mPresenter.subDisbursementData(proInfo.getOrderNo(), money, content, faIds, App.pmUserInfo.getUid());
                                    etContent.setText("");
                                    etApplyMoney.setText("");
                                }
                            });
                            builder.setNegativeButton("取消", null);
                            builder.show();
                        }
                    }
                } else {
                    showToast("请填写申请金额");
                }
                break;
        }
    }

    @Override
    public void responseDisbursementData(DisbursementInfo.Disbursement data) {
        if (data.getMoneyStatus() == -1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("行政主管未提交保险支付凭证");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else if (data.getMoneyStatus() == -2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("对不起，人工可用资金不足，请您催甲方进行回款！");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else if (data.getMoneyStatus() == -3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("中期资料未上传，请及时上传！");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else if (data.getMoneyStatus() == -4) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("首期资料未上传，请及时上传！");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else {
            kMoney = data.getKeMoney();
            fMoney = data.getFaMoney();
            faIds = data.getFaIds();
            tvMoney.setText("¥ " + kMoney);
            tvPunishMoney.setText("¥ " + fMoney);
        }
    }

    @Override
    public void responseDisbursementDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseDisbursementListData(List<DisbursementListInfo.DisbursementList> dataList) {
        disList.clear();
        disList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        if (disList.size() == 0) {
            btnSub.setEnabled(true);
        } else {
            if (disList.get(0).getBranch_state() == 0) {
                btnSub.setEnabled(false);
                linDis.setVisibility(View.GONE);
            } else {
                btnSub.setEnabled(true);
                linDis.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void responseDisbursementListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseDisbursementSubData() {
        showToast("申请成功");
        mPresenter.getDisbursementListData(proInfo.getOrderNo());
    }

    @Override
    public void responseDisbursementSubDataError(String msg) {
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
