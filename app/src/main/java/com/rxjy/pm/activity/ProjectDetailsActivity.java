package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.DetailsBean;
import com.rxjy.pm.entity.ProjectDBean;
import com.rxjy.pm.mvp.contract.ProjectDCContract;
import com.rxjy.pm.mvp.contract.ProjectDContract;
import com.rxjy.pm.mvp.presenter.ProjectDCPersenter;
import com.rxjy.pm.mvp.presenter.ProjectDPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/28.
 */

public class ProjectDetailsActivity extends BaseActivity<ProjectDPersenter> implements ProjectDContract.View, ProjectDCContract.View {
    @Bind(R.id.tv_cmianji)
    TextView tvCmianji;
    @Bind(R.id.et_Designer_Name)
    TextView etDesignerName;
    @Bind(R.id.Design_Name)
    RelativeLayout DesignName;
    @Bind(R.id.tv_Designer_phone)
    TextView tvDesignerPhone;
    @Bind(R.id.Design_Phone)
    RelativeLayout DesignPhone;
    @Bind(R.id.show_popup)
    RelativeLayout showPopup;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_Businessaddress)
    TextView tvBusinessaddress;
    @Bind(R.id.et_Businessaddress)
    EditText etBusinessaddress;
    @Bind(R.id.re_Businessaddress)
    RelativeLayout reBusinessaddress;
    @Bind(R.id.tv_shejishi)
    TextView tvShejishi;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    private List<String> typeslist = new ArrayList<>();

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_cphone)
    EditText etCphone;
    @Bind(R.id.et_ccompanyname)
    TextView etCcompanyname;
    @Bind(R.id.et_cmianji)
    EditText etCmianji;
    @Bind(R.id.et_ctype)
    TextView etCtype;
    @Bind(R.id.rl_ctype)
    RelativeLayout rlCtype;
    @Bind(R.id.ll_customer)
    LinearLayout llCustomer;
    @Bind(R.id.et_companyname)
    TextView etCompanyname;
    @Bind(R.id.et_num)
    EditText etNum;
    @Bind(R.id.et_shejishi)
    EditText etShejishi;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_type)
    TextView etType;
    @Bind(R.id.rl_type)
    RelativeLayout rlType;
    @Bind(R.id.et_mianji)
    EditText etMianji;
    @Bind(R.id.et_yusuan)
    EditText etYusuan;
    @Bind(R.id.ll_company)
    LinearLayout llCompany;
    @Bind(R.id.tv_no)
    TextView tvNo;
    @Bind(R.id.tv_yes)
    TextView tvYes;
    public static ProjectDetailsActivity instance = null;

    @Override
    public int getLayout()

    {

        instance = this;
        return R.layout.activity_projectdetails;
    }

    String type, rid, state;

    @Override
    public void initData() {
        typeslist.add(0, "办公");
        typeslist.add(1, "餐饮");
        typeslist.add(2, "商业");
        typeslist.add(3, "酒店");
        typeslist.add(4, "其他");
        tvTitle.setText("项目详情");
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        rid = intent.getStringExtra("rid");
        System.out.println(rid + "888888888");
        state = intent.getStringExtra("state");
        if (state.equals("3") || state.equals("4")) {
            tvNo.setVisibility(View.GONE);
            tvYes.setVisibility(View.GONE);
        } else {
            tvNo.setVisibility(View.VISIBLE);
            tvYes.setVisibility(View.VISIBLE);
        }

        switch (type) {
            case "customer":
                llCustomer.setVisibility(View.VISIBLE);
                llCompany.setVisibility(View.GONE);
                break;
            case "company":
                llCustomer.setVisibility(View.GONE);
                llCompany.setVisibility(View.VISIBLE);
                break;


        }

        etName.setEnabled(false);
        etCphone.setEnabled(false);
        etCcompanyname.setEnabled(false);
        etCmianji.setEnabled(false);
        etCompanyname.setEnabled(false);
        etNum.setEnabled(false);
        etShejishi.setEnabled(false);
        etPhone.setEnabled(false);
        etMianji.setEnabled(false);
        etYusuan.setEnabled(false);
        etBusinessaddress.setEnabled(false);
        ProjectDCPersenter pres = new ProjectDCPersenter(this);
        pres.getProjectCDetail(rid);
        mPresenter.getProjectDetail(rid);
    }

    @Override
    protected ProjectDPersenter onCreatePresenter() {
        return new ProjectDPersenter(this);
    }


    @OnClick({R.id.iv_back, R.id.rl_ctype, R.id.ll_customer, R.id.rl_type, R.id.ll_company, R.id.tv_no, R.id.tv_yes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_ctype:
                break;
            case R.id.ll_customer:
                break;
            case R.id.rl_type:
                break;
            case R.id.ll_company:
                break;
            case R.id.tv_no:
                startActivity(new Intent(this, ResultChatActivity.class).putExtra("type", "no").putExtra("orderid", rid).putExtra("state", "4"));
                break;
            case R.id.tv_yes:
                startActivity(new Intent(this, ResultChatActivity.class).putExtra("type", "yes").putExtra("orderid", rid).putExtra("state", "3"));
                break;
        }
    }


    @Override
    public void responseProjectData(ProjectDBean info) {
        Log.e("type", type);
        switch (type) {
            case "customer":
                etName.setText(info.getBody().getPi_ClientName() + "");
                etCphone.setText(info.getBody().getPi_ClientPhone() + "");
                etCcompanyname.setText(info.getBody().getPi_Name());
                etCmianji.setText(info.getBody().getPi_Area() + "㎡");
                etCtype.setText(typeslist.get(Integer.valueOf(info.getBody().getPi_ProjectType() - 1)));
                break;
        }
    }

    @Override
    public void responseProjectDataError(String msg) {

    }


    @Override
    public void responseProjectCData(DetailsBean info) {
        etCompanyname.setText(info.getBody().getCi_ClientName());
        etType.setText(info.getBody().getCi_TypeName());
        etMianji.setText(info.getBody().getCi_Area() + "㎡");
        etYusuan.setText(info.getBody().getCa_DecBudgetPrice() + "万元");
        etNum.setText(rid);
        switch (info.getBody().getPi_Type()) {
            case 1:
                tvShejishi.setText("客户姓名");
                tvPhone.setText("客户电话");
                reBusinessaddress.setVisibility(View.VISIBLE);
                Log.e("aaaaa",info.getBody().getCustomerName());
                etShejishi.setText(info.getBody().getCustomerName());
                etPhone.setText(info.getBody().getCustomerMobile());
                etBusinessaddress.setText(info.getBody().getProjectAddress() + "");
                break;
            case 2:
                reBusinessaddress.setVisibility(View.GONE);
                if(info.getBody().getCi_ClientName()==null){
                    etShejishi.setText("无");
                }else {
                    etShejishi.setText(info.getBody().getCi_ClientName());
                }
                if(info.getBody().getMobile()==null) {
                    etPhone.setText(info.getBody().getMobile() + "");
                }else {

                }
                break;
            case 3:

                break;
        }


    }

    @Override
    public void responseProjectCDataError(String msg) {

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