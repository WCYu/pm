package com.rxjy.pm.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.ConfirmationInfo;
import com.rxjy.pm.entity.ProInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.ReceiptContract;
import com.rxjy.pm.mvp.presenter.ReceiptPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/25.
 */

public class ReceiptActivity extends BaseActivity<ReceiptPresenter> implements ReceiptContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.Customer_telephone)
    ImageView CustomerTelephone;
    @Bind(R.id.Customer_service)
    ImageView CustomerService;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;
    @Bind(R.id.scanning)
    ImageView scanning;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.show_popup)
    RelativeLayout showPopup;

    @Bind(R.id.first_party)
    TextView firstParty;

    @Bind(R.id.telephone)
    TextView telephone;
    @Bind(R.id.design_name)

    TextView designName;

    @Bind(R.id.special_vulgarity)
    TextView specialVulgarity;

    @Bind(R.id.material)
    TextView material;

    @Bind(R.id.date_signing)
    TextView dateSigning;

    @Bind(R.id.time_imit)
    TextView timeImit;

    @Bind(R.id.built_area)
    TextView builtArea;

    @Bind(R.id.engineering_address)
    TextView engineeringAddress;

    @Bind(R.id.Invoice_value)
    TextView InvoiceValue;

    @Bind(R.id.historical_amount)
    TextView historicalAmount;
    @Bind(R.id.refund)
    RelativeLayout refund;
    @Bind(R.id.sign_agreement)
    RelativeLayout signAgreement;
    @Bind(R.id.construction_Plans)
    LinearLayout constructionPlans;
    @Bind(R.id.design_Sketch)
    LinearLayout designSketch;
    @Bind(R.id.acketstate)
    LinearLayout acketstate;
    @Bind(R.id.single_state)
    TextView singleState;
    @Bind(R.id.orderRejection)
    TextView orderRejection;
    @Bind(R.id.engineering)
    LinearLayout engineering;
    @Bind(R.id.bargaining)
    RelativeLayout bargaining;
    @Bind(R.id.bargaining_text)
    TextView bargainingText;
    @Bind(R.id.wenhao)
    ImageView wenhao;
    private AlertDialog alertDialog;
    private AlertDialog dialog;
    private boolean aBoolean;
    private int pushStatus;
    private Dialog twodialog;
    private Dialog barGaining;

    @Override
    public int getLayout() {
        return R.layout.activity_receipt;
    }

    private ProjectInfo.Project proInfo;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getReceipt(proInfo.getOrderNo(), App.pmUserInfo.getUid());
    }

    @Override
    public void initData() {

        tvTitle.setText("客户");
       proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);

        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ReceiptActivity.this, EngineeringInfoActivity.class);
                intent1.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent1.putExtra(Constants.PICTUREMARK, true);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected ReceiptPresenter onCreatePresenter() {
        return new ReceiptPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.refund, R.id.sign_agreement, R.id.construction_Plans, R.id.design_Sketch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.refund:
                dialog();
                break;
            case R.id.sign_agreement:
                if (pushStatus != 0) {
                    Agreementdialog();
                } else {
                    mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 2, "");
                }
                break;
            case R.id.construction_Plans:
                Intent intent1 = new Intent(this, PictureActivity.class);
                intent1.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent1.putExtra(Constants.PICTUREMARK, true);
                intent1.putExtra(Constants.TITLE, "施工图");
                startActivity(intent1);
                break;
            case R.id.design_Sketch:
                Intent intent2 = new Intent(this, PictureActivity.class);
                intent2.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                intent2.putExtra(Constants.PICTUREMARK, false);
                intent2.putExtra(Constants.TITLE, "效果图");
                startActivity(intent2);
                break;
        }
    }

    protected void dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.refund_dialog, null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(inflate);
        RelativeLayout cancel = (RelativeLayout) inflate.findViewById(R.id.relative_cancel);
        TextView prompt = (TextView) inflate.findViewById(R.id.text_content);
        TextView textphone = (TextView) inflate.findViewById(R.id.text_phone);
        RelativeLayout determine = (RelativeLayout) inflate.findViewById(R.id.relative_confirm);
        if (pushStatus != 0) {
            prompt.setText("您已查看项目相关信息,");
            textphone.setText("退单可能会产生罚款");
        } else {
            prompt.setText("您在正常接单状态下拒单,");
            textphone.setText("可能会产生罚款");
        }
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiptActivity.this, FefundActivity.class);
                if (pushStatus != 0) {
                    intent.putExtra(Constants.ORDERREJECTION, true);
                } else {
                    intent.putExtra(Constants.ORDERREJECTION, false);
                }
                intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        builder.setView(inflate);
        alertDialog = builder.create();
        alertDialog.show();

    }

    protected void Agreementdialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.agreement, null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(inflate);
        RelativeLayout cancel = (RelativeLayout) inflate.findViewById(R.id.relative_cancel);
        RelativeLayout determine = (RelativeLayout) inflate.findViewById(R.id.relative_confirm);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(ReceiptActivity.this, PackageAgreementActivity.class);
                intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                startActivity(intent);


            }
        });
        builder.setView(inflate);
        dialog = builder.create();
        dialog.show();


    }

    private void woHints() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.agreement, null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(inflate);
        RelativeLayout cancel = (RelativeLayout) inflate.findViewById(R.id.relative_cancel);
        TextView textView = (TextView) inflate.findViewById(R.id.text_content);
        textView.setText("我已确认接单并签署相关协议");
        RelativeLayout determine = (RelativeLayout) inflate.findViewById(R.id.relative_confirm);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twodialog.dismiss();
            }
        });
        determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twodialog.dismiss();


            }
        });
        builder.setView(inflate);
        twodialog = builder.create();
        twodialog.show();


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
    public void responseProInfo(ProInfo.BodyBean bodyBean) {
        /**
         * contract_type : 办公
         * proarea : 764.55
         * construction_period : 40
         * construction_time : 2017-06-09
         * ProbablyAddr : -
         * PushMoney : 0.0
         * Proaddr : 天津市河西区围堤道峰汇广场B座17层
         * LastPushMoney : -
         */
        firstParty.setText(bodyBean.getProname());

        telephone.setText("");
        telephone.setText(bodyBean.getProaddr() + "");
        designName.setText("");
        designName.setText(bodyBean.getProarea() + "");
        specialVulgarity.setText("");
        specialVulgarity.setText(bodyBean.getContract_type() + "");
        material.setText("");
        material.setText(bodyBean.getConstruction_time() + "");
        dateSigning.setText("");
        dateSigning.setText(bodyBean.getConstruction_period() + "");
        timeImit.setText("");
        timeImit.setText(bodyBean.getNightwork_fee() + "");
        InvoiceValue.setText("");
        InvoiceValue.setText(bodyBean.getPushMoney() + "");
        historicalAmount.setText("");
        historicalAmount.setText(bodyBean.getPushMoney() + "");
        builtArea.setText("");
        builtArea.setText(bodyBean.getPushMoney() + "");
        pushStatus = bodyBean.getPushStatus();


        if (pushStatus != 0) {
            acketstate.setVisibility(View.VISIBLE);
            singleState.setText("签署协议");
            orderRejection.setText("退单");
            signAgreement.setBackground(getResources().getDrawable(R.color.colorGreen));
        } else {
            acketstate.setVisibility(View.INVISIBLE);
            singleState.setText("意向接单");
            orderRejection.setText("拒单");
            signAgreement.setBackground(getResources().getDrawable(R.color.blue));

        }
        Log.e("pushStatus",pushStatus+"");
        if(pushStatus<3){
            bargainingText.setText("发包有异议?");
            bargaining.setVisibility(View.VISIBLE);
        } else if (pushStatus ==3) {
            bargainingText.setText("商议中");
            wenhao.setVisibility(View.INVISIBLE);
        }else if(pushStatus==6) {
            bargaining.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }

    @Override
    public void responseConfirmationInfo(ConfirmationInfo.BodyBean bodyBean) {

    }

    @Override
    public void getSuccessfulOperation() {
        mPresenter.getReceipt(proInfo.getOrderNo(), App.pmUserInfo.getUid());
        // mPresenter.getReceiptConfirmation(proInfo.getOrderNo(), App.pmUserInfo.getUid());
    }


    @OnClick(R.id.bargaining)
    public void onViewClicked() {
        if (pushStatus == 3) {
            Toast.makeText(this, "正在议价中", Toast.LENGTH_SHORT).show();
        } else {
            barGainingDialog();
        }

    }

    private void barGainingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.agreement, null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(inflate);
        RelativeLayout cancel = (RelativeLayout) inflate.findViewById(R.id.relative_cancel);
        TextView textView = (TextView) inflate.findViewById(R.id.text_content);
        textView.setText("确认对价格存在异议?");
        RelativeLayout determine = (RelativeLayout) inflate.findViewById(R.id.relative_confirm);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barGaining.dismiss();
            }
        });
        determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 3, "");
//                barGaining.dismiss();
                barGaining.dismiss();
                Intent intent1 = new Intent(ReceiptActivity.this, BarGainingActivity.class);
                intent1.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                startActivity(intent1);

            }
        });
        builder.setView(inflate);
        barGaining = builder.create();
        barGaining.show();
    }
    private void CheckPermission() {
        if (!Settings.System.canWrite(this)) {
           // ToastUtil.longTips("请在该设置页面勾选，才可以使用路况提醒功能");
            Uri selfPackageUri = Uri.parse("package:"
                    + this.getPackageName());
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                    selfPackageUri);
            startActivity(intent);
        }
    }
}
