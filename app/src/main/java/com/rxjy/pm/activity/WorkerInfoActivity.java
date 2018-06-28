package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/6/22.
 */

public class WorkerInfoActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ic_icon)
    ImageView icIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_trydate)
    TextView tvTrydate;
    @Bind(R.id.tv_gcid)
    TextView tvGcid;
    @Bind(R.id.ly_gcid)
    LinearLayout lyGcid;
    @Bind(R.id.tv_team)
    TextView tvTeam;
    @Bind(R.id.ly_team)
    LinearLayout lyTeam;
    @Bind(R.id.tv_userId)
    TextView tvUserId;
    @Bind(R.id.ly_userId)
    LinearLayout lyUserId;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.textView16)
    TextView textView16;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.textView17)
    TextView textView17;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.textView18)
    TextView textView18;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.rl_phone)
    RelativeLayout rlPhone;
    @Bind(R.id.textView30)
    TextView textView30;
    @Bind(R.id.et_email)
    TextView etEmail;
    @Bind(R.id.rl_email)
    RelativeLayout rlEmail;
    @Bind(R.id.textView19)
    TextView textView19;
    @Bind(R.id.tv_ismarry)
    TextView tvIsmarry;
    @Bind(R.id.rl_ismarry)
    RelativeLayout rlIsmarry;
    @Bind(R.id.tv_zhanghu)
    TextView tvZhanghu;
    @Bind(R.id.img_xiangmu)
    ImageView imgXiangmu;
    @Bind(R.id.tv_xiangmu_shangchuan)
    TextView tvXiangmuShangchuan;
    @Bind(R.id.rl_xiangmu)
    RelativeLayout rlXiangmu;

    @Override
    public int getLayout() {
        return R.layout.worker_userinfo;
    }

    @Override
    public void initData() {
        tvName.setText(App.workerInfo.getWorkerName() == null ? "昵称" :App.workerInfo.getWorkerName());

        tvTrydate.setText(App.baseInfo.getBirthday());
        String imgurl = getIntent().getStringExtra("imgurl");
        tvSex.setText(App.workerInfo.getSex());
        tvPhone.setText(App.baseInfo.getPhone());
        tvUserId.setText(App.baseInfo.getPhone());
        String area = App.workerInfo.getArea();
        tvGcid.setText(area+"-施工");
        Glide.with(this).load(imgurl).apply(RequestOptions.circleCropTransform()).into(icIcon);
        rlXiangmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          startActivity(new Intent(WorkerInfoActivity.this,WorkerInfoDataActivity.class));
            }
        });
    }
    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


}
