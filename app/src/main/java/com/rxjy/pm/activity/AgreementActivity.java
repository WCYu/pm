package com.rxjy.pm.activity;

import android.view.KeyEvent;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.mvp.presenter.AgreementPresenter;

/**
 * Created by asus on 2018/4/26.
 */

public class AgreementActivity extends BaseActivity<AgreementPresenter> implements AgreementContract.View {
    private ProjectInfo.Project proInfo;
    @Override
    public int getLayout() {
        return R.layout.activity_agreement;
    }

    @Override
    public void initData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        mPresenter.getgetPackageData(proInfo.getOrderNo());
        mPresenter.getSecurityData(proInfo.getOrderNo());
        mPresenter.getAdministrationData(proInfo.getOrderNo());
    }

    @Override
    protected AgreementPresenter onCreatePresenter() {
        return new AgreementPresenter(this);
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
    public void showMessage(String message) {

    }

    @Override
    public void getAgreementImage(String image) {

    }

    @Override
    public void getSuccessfulOperation() {

    }


}
