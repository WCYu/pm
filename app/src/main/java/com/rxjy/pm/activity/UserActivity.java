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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.my.GongRenActivity;
import com.rxjy.pm.activity.my.IsRuZhiActivity;
import com.rxjy.pm.activity.my.RuZhiActivity;
import com.rxjy.pm.activity.my.XiangMuActivity;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.RuZhiInfoBean;
import com.rxjy.pm.entity.XiangMuInfoBean;
import com.rxjy.pm.widget.OkhttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserActivity extends BaseActivity implements View.OnClickListener{

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
    @Bind(R.id.tv_xiangmu)
    TextView tvXiangmu;
    @Bind(R.id.img_xiangmu)
    ImageView imgXiangmu;
    @Bind(R.id.tv_xiangmu_shangchuan)
    TextView tvXiangmuShangchuan;
    @Bind(R.id.rl_xiangmu)
    RelativeLayout rlXiangmu;
    @Bind(R.id.tv_gongren)
    TextView tvGongren;
    @Bind(R.id.img_gongren)
    ImageView imgGongren;
    @Bind(R.id.tv_gongren_shangchuan)
    TextView tvGongrenShangchuan;
    @Bind(R.id.rl_gongren)
    RelativeLayout rlGongren;
    @Bind(R.id.tv_ruzhi)
    TextView tvRuzhi;
    @Bind(R.id.img_ruhzi)
    ImageView imgRuhzi;
    @Bind(R.id.tv_ruzhi_shangchuan)
    TextView tvRuzhiShangchuan;
    @Bind(R.id.rl_ruzhi)
    RelativeLayout rlRuzhi;
    @Bind(R.id.tv_join)
    TextView tvJoin;

    @Override
    public int getLayout() {
        return R.layout.activity_user;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        tvName.setText(App.baseInfo.getNickName() == null ? "昵称" : App.baseInfo.getNickName());
        tvTrydate.setText(App.baseInfo.getBirthday());
        tvSex.setText(App.baseInfo.getSex());
        tvPhone.setText(App.baseInfo.getPhone());
        String area = App.personnelInfo.getArea();
        tvGcid.setText(area+"-施工");
        tvUserId.setText(App.baseInfo.getUserId());
        Glide.with(this).load(App.baseInfo.getImage()).apply(RequestOptions.circleCropTransform()).into(icIcon);
        initListenr();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListData();
    }

    private void initListenr() {
        rlXiangmu.setOnClickListener(this);
        rlGongren.setOnClickListener(this);
        rlRuzhi.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        icIcon.setOnClickListener(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent =null;
        switch (v.getId()){
            case R.id.rl_xiangmu:
//                                startActivity(new Intent(this, UserInfoActivity.class));
//                startActivity(new Intent(this, UploadInfoActivity.class));
                intent = new Intent(this, XiangMuActivity.class);
                break;
            case R.id.rl_gongren:
                intent = new Intent(this, GongRenActivity.class);
                break;
            case R.id.rl_ruzhi:
                showLoading();
                getRuZhiData();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.ic_icon:
                startActivity(new Intent(this, UserInfoActivity.class));
//                startActivity(new Intent(this, UploadInfoActivity.class));
                break;
                default:
                    break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }

    //获取的入职信息
    public void getRuZhiData() {

        Map map = new HashMap();
        map.put("uid", App.pmUserInfo.getUid());
        OkhttpUtils.doGet(ApiEngine.RUZHIURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_入职资料", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_入职资料", string);
                Gson gson = new Gson();
                RuZhiInfoBean ruZhiInfoBean = gson.fromJson(string, RuZhiInfoBean.class);
                int statusCode = ruZhiInfoBean.getStatusCode();
                RuZhiInfoBean.BodyBean body = ruZhiInfoBean.getBody();
                final RuZhiInfoBean.BodyBean.UserInfoBean userInfo = body.getUserInfo();
                if (statusCode == 1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int intentionStatus = userInfo.getIntentionStatus();
                            dismissLoading();
                            if(intentionStatus==1){
                                Intent intent = new Intent(UserActivity.this, RuZhiActivity.class);
                                startActivity(intent);

                            }else {
                                Intent intent = new Intent(UserActivity.this, IsRuZhiActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    Toast.makeText(application, ruZhiInfoBean.getStatusMsg(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        setProgressDialog(3000);
    }

    //工人认证列表
    public void getListData() {
        Map map = new HashMap();
        map.put("uid", App.pmUserInfo.getUid());
        OkhttpUtils.doGet(ApiEngine.RENZHENGURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_工人列表",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_工人列表",string);
                Gson gson = new Gson();
                XiangMuInfoBean xiangMuInfoBean = gson.fromJson(string, XiangMuInfoBean.class);
                final XiangMuInfoBean.BodyBean body = xiangMuInfoBean.getBody();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int size = body.getUserinfoProjectMsg().size();
                                tvTeam.setText("团队-"+size+"人");
                    }
                });
            }
        });
    }

}
