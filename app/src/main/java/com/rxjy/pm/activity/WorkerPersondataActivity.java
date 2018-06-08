package com.rxjy.pm.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.BankBean;
import com.rxjy.pm.entity.IconBean;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.entity.WorkerPersonDBean;
import com.rxjy.pm.mvp.contract.WorkerPersonDContract;
import com.rxjy.pm.mvp.presenter.WorkerPersonDPresenter;
import com.rxjy.pm.widget.RoundAngleImageView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/23.
 */

public class WorkerPersondataActivity extends BaseActivity<WorkerPersonDPresenter> implements WorkerPersonDContract.View {
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.riv_head_photo)
    RoundAngleImageView rivHeadPhoto;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.tv_workerkind)
    TextView tvWorkerkind;
    @Bind(R.id.tv_workernum)
    TextView tvWorkernum;
    @Bind(R.id.tv_workerold)
    TextView tvWorkerold;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_msg)
    TextView tvMsg;

    @Override
    public int getLayout() {
        return R.layout.activity_persondata;
    }

    @Override
    public void initData() {
        tvTitle.setText("个人资料");
      //  Log.e("tag",App.pmUserInfo.toString());
        mPresenter.getData(App.workerInfo.getMobile());
        mPresenter.getIcon(App.workerInfo.getMobile());
        Log.e("App.worker",App.workerInfo.getMobile());
    }

    @Override
    protected WorkerPersonDPresenter onCreatePresenter() {
        return new WorkerPersonDPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.rl_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_msg://跳转资料页

                mPresenter.getUploadInfo(App.workerInfo.getMobile());
               // mPresenter.getData("13022102972");
                break;
        }
    }

    @Override
    public void responsegetData(WorkerPersonDBean info) {
        tvAddress.setText(info.getBody().getArea());
        tvWorkerkind.setText(info.getBody().getWorkType() + info.getBody().getJob());
//        tvWorkernum.setText(info.getBody().);//工号暂时没有
        tvWorkerold.setText(info.getBody().getWorkMonth() + "月");
        tvName.setText(info.getBody().getWorkerName());
        tvSex.setText(info.getBody().getSex());
        tvPhone.setText(info.getBody().getMobile());

//        tvMsg.setText(info.getBody().getArea());
    }


    @Override
    public void responsegetDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetBankData(BankBean info) {

    }

    @Override
    public void responsegetBankDataError(String msg) {

    }

    @Override
    public void responsegetWorkData(BankBean info) {

    }

    @Override
    public void responsegetWorkDataError(String msg) {

    }

    @Override
    public void responsegetImgData() {

    }

    @Override
    public void responsegetImgDataError(String msg) {

    }

    @Override
    public void responsegetSubmitData() {

    }

    @Override
    public void responsegetSubmitDataError(String msg) {

    }

    @Override
    public void responsegetIconData(IconBean info) {
        if (info.getBody() != null)
            Glide.with(this).load(info.getBody()).into(rivHeadPhoto);
    }

    @Override
    public void responsegetIconDataError(String msg) {

    }

    @Override
    public void getUploadInfo(UploadInfo.Upload data) {

        if (data.getUid()==0) {
            startActivity(new Intent(this, AccountDataActivity.class));
        } else {
            startActivity(new Intent(this, UpdPasswordActivity.class));
        }
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