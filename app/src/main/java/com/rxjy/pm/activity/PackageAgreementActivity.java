package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.mvp.presenter.AgreementPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/26.
 */

public class PackageAgreementActivity extends BaseActivity<AgreementPresenter> implements AgreementContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.agreement_image)
    ImageView agreementImage;
    @Bind(R.id.btn_quit)
    Button btnQuit;
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.cb_agreement)
    CheckBox cbAgreement;
    private ProjectInfo.Project proInfo;
    private int flag = 3;
    private Thread thread;

    @Override
    public int getLayout() {
        return R.layout.activity_agreement;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (msg.arg1 == 0) {
                        if (btnQuit != null) {
                            btnQuit.setText("签署协议");
                            btnQuit.setBackground(getResources().getDrawable(R.color.colorRed));
                        }
                    } else {
                        if (btnQuit != null) {
                            btnQuit.setText("(" + msg.arg1 + ")");
                        }

                    }
            }
        }
    };

    @Override
    public void initData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i >= 0; i--) {
                    Message msg = handler.obtainMessage();
                    msg.what = 0;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        tvTitle.setText("协议");
        // http://wrxm.lm.cs/Protocol.html?orderno=25-68489&pmuid=390
        //http://wrapi.lm.rxjy.com:8036/
        //http://wrapi.lm.rxjy.com:8036/Protocol.html?orderno=12-201542&pmuid=1099
        Log.e("tag",proInfo.getOrderNo()+"     "+App.pmUserInfo.getUid());
        //http://wrxm.lm.cs
        webview.loadUrl(ApiEngine.WANZHI+"Protocol.html?orderno="+proInfo.getOrderNo()+"&pmuid="+App.pmUserInfo.getUid());
        WebSettings wSet = webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setUseWideViewPort(true);
        wSet.setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });


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
        Glide.with(this).load(image).into(agreementImage);
    }

    @Override
    public void getSuccessfulOperation() {
        App.getApp().finishSingleActivity(ReceiptActivity.class);
        finish();
    }

    @OnClick({R.id.iv_back, R.id.btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (thread != null && thread.isAlive()) {
                    //Log.e("readCacheThread", "thread interrupt_1");
                    thread.interrupt();
                    //Log.e("status", ""+readCacheThread.isInterrupted());
                }
                finish();
                break;
            case R.id.btn_quit:
                
                if (btnQuit.getText().toString().equals("签署协议")) {
                    if(cbAgreement.isChecked()) {
                        mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 5, "");
                    }else {
                        Toast.makeText(this, "您还没有同意此协议", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (thread != null && thread.isAlive()) {
            //Log.e("readCacheThread", "thread interrupt_1");
            thread.interrupt();
            //Log.e("status", ""+readCacheThread.isInterrupted());
        }
        return super.onKeyDown(keyCode, event);
    }

}
