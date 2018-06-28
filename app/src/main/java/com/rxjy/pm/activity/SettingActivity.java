package com.rxjy.pm.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.PrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_vision_name)
    TextView tvVisionName;

    public static final String TITLE = "设置";
    @Bind(R.id.rl_help_center)
    RelativeLayout rlHelpCenter;
    @Bind(R.id.rl_reward_punish_record)
    RelativeLayout rlRewardPunishRecord;
    @Bind(R.id.rl_evaluate)
    RelativeLayout rlEvaluate;
    @Bind(R.id.rl_Orders)
    RelativeLayout rlOrders;

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {
        initTitle();
        initVersionData();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initVersionData() {
        if (ApiEngine.GC_API_HOST.equals("http://api.gc.cs/")) {
            tvVisionName.setText("测试：V " + App.getVersionName());
        } else {
            tvVisionName.setText("V " + App.getVersionName());
        }
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.rl_upd_password, R.id.btn_quit, R.id.rl_help_center, R.id.rl_reward_punish_record,R.id.rl_Orders})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_upd_password:
                startActivity(new Intent(this, UpdPasswordActivity.class));
                break;
            case R.id.btn_quit:
                App.getApp().exitApp();
                PrefUtils.RemoveValue(this, Constants.IS_LOGIN);
                PrefUtils.RemoveValue(this, Constants.CARD_NO);
                PrefUtils.RemoveValue(this, Constants.TOKEN);
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.rl_help_center:
                Intent intent = new Intent(this, WebActivity.class);
                intent.putExtra(Constants.ACTION_TO_WEB_TITLE, "使用说明");
                intent.putExtra(Constants.ACTION_TO_WEB_URL, "http://api.gc.rxjy.com/doc/Personnel_Instructions.html");
                startActivity(intent);
                break;
            case R.id.rl_reward_punish_record:
                startActivity(new Intent(this, SuggestActivity.class));
                break;
        }
    }

    @OnClick(R.id.rl_evaluate)
    public void onViewClicked() {
        intit_getClick();
    }

    //    public static void goToMarket(Context context, String packageName) {
//        Uri uri = Uri.parse("market://details?id=" + packageName);
//        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//        try {
//            context.startActivity(goToMarket);
//        } catch (ActivityNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    //检查版本更新，跳转到腾讯应用宝进行下载
    private void intit_getClick() {
        if (isAvilible(this, "com.tencent.android.qqdownloader")) {
// 市场存在
            //Toast.makeText(getApplicationContext(), "应用宝尚未安装",Toast.LENGTH_SHORT).show();
            launchAppDetail(getApplicationContext(), "com.rxjy.pm", "com.tencent.android.qqdownloader");
        } else {
            Toast.makeText(getApplicationContext(), "应用宝尚未安装", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 启动到app详情界面
     *
     * @param appPkg    App的包名
     * @param marketPkg 应用商店包名 ,如果为""则由系统弹出应用商店列表供用户选择,否则调转到目标市场的应用详情界面，某些应用商店可能会失败
     */
    public static void launchAppDetail(Context context, String appPkg, String marketPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) {
                return;
            }
            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 判断市场是否存在的方法
    public static boolean isAvilible(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        List<String> pName = new ArrayList<String>();// 用于存储所有已安装程序的包名
// 从pinfo中将包名字逐一取出，压入pName list中
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);// 判断pName中是否有目标程序的包名，有TRUE，没有FALSE
    }



}
