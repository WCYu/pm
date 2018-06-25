package com.rxjy.pm.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.NetUtil;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.entity.AccountInfo;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.LogoContract;
import com.rxjy.pm.mvp.presenter.LogoPresenter;

import java.util.Timer;
import java.util.TimerTask;

public class LogoActivity extends BaseActivity<LogoPresenter> implements LogoContract.View {
    private int Worker_TAGE=4;
    @Override
    public int getLayout() {
        return R.layout.activity_logo;
    }

    @Override
    public void initData() {
     //   更新版本
       // newVersion();
        // 判断是否是第一次开启应用
        int version = getVersion();
        Log.e("version",version+"");
        boolean isFirstOpen = PrefUtils.getBooleanValue(this, Constants.IS_FIRST_LOGIN);
        // 如果是第一次启动，则先进入功能引导页
        if (!isFirstOpen) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Timer mTimer = new Timer();

        Boolean isLogin = PrefUtils.getBooleanValue(this, Constants.IS_LOGIN);
        if (!NetUtil.isConnected(this)) {
            showDialogTip(1);
        } else {
            if (!isLogin) {
                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            } else {

                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String cardNo = PrefUtils.getValue(LogoActivity.this, Constants.CARD_NO);
                        String token = PrefUtils.getValue(LogoActivity.this, Constants.TOKEN);

                        App.cardNo = cardNo;
                        App.token = token;
                        mPresenter.getLoginUserInfo(cardNo, token);

                    }
                }, 2000);
            }

        }
    }

    private void showDialogTip(int type) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (type) {
            case 1:
                builder.setTitle("提示");
                builder.setMessage("没有网络，请链接网络");
                builder.setCancelable(false);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(wifiSettingsIntent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
            case 2:
                builder.setTitle("提示");
                builder.setMessage("网络超时，请检查网络");
                builder.setCancelable(false);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(wifiSettingsIntent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
        }
    }

    @Override
    protected LogoPresenter onCreatePresenter() {
        return new LogoPresenter(this);
    }


    @Override
    public void responseLogin(UserInfo.User data) {

        App.cardNo = PrefUtils.getValue(this, Constants.CARD_NO);
        App.token = PrefUtils.getValue(this, Constants.TOKEN);

        App.baseInfo = data.getBaseinfo();
        App.personnelInfo = data.getPersonnelInfo();

         if(data.getPersonnelInfo().getPostId()==Worker_TAGE){
             //存储已经登录的状态
           // PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);
            // PrefUtils.putIntValue(this,Constants.FLAG,data.getPersonnelInfo().getPostId());
             mPresenter.getLoginWorkerInfo(App.baseInfo.getPhone());
         }else {
             if(data.getPersonnelInfo().getPostId()==20001||data.getPersonnelInfo().getPostId()==20002){
                 mPresenter.getPmUserInfo(data.getBaseinfo().getPhone(),2);
             }else if(data.getPersonnelInfo().getPostId()==1){
                 mPresenter.getPmUserInfo(data.getBaseinfo().getPhone(),1);
             }

         }

    }

    @Override
    public void responseLoginError(String msg) {
        showToast(msg);
        showDialogTip(2);
    }

    @Override
    public void responsePmUserInfo(PmUserInfo.BodyBean data) {

        App.pmUserInfo = data;
      //  Log.e("qqqqqqqqq", App.pmUserInfo .toString());
     //   App.pmUserInfo.setUser_join_state(1);
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);

        startActivity(new Intent(this, NjjActivity.class));
        finish();

    }

    @Override
    public void responsePmUserInfoError(String msg) {
        showToast(msg);
    }

    @Override
    public void reLogin(String msg) {
        showToast(msg);
        PrefUtils.RemoveValue(this, Constants.IS_LOGIN);
        PrefUtils.RemoveValue(this, Constants.CARD_NO);
        PrefUtils.RemoveValue(this, Constants.TOKEN);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void responseWorkerLogin(WorkerInfo.BodyBean data) {

        //存储已经登录的状态
        App.workerid=data.getWorkerId();
        App.workerInfo=data;
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);
        startActivity(new Intent(this, NjjActivity.class));
        finish();
    }

    @Override
    public void toLogin() {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    private void newVersion() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("market://details?id=" + "com.rxjy.pm");//app包名
        intent.setData(uri);
        intent.setPackage("com.tencent.android.qqdownloader");//应用市场包名
        startActivity(intent);

    }

    /**
     2  * 获取版本号
     3  * @return 当前应用的版本号
       */
  public int getVersion() {
          try {
                   PackageManager manager = this.getPackageManager();
              PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
               String version = info.versionName;
              int versionCode = info.versionCode;
              return versionCode;
                } catch (Exception e) {
                e.printStackTrace();
                  return 0;
               }
      }
}
