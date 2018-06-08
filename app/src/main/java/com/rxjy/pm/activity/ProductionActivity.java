package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.AgreementContract;
import com.rxjy.pm.mvp.presenter.AgreementPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/26.
 */

public class ProductionActivity extends BaseActivity<AgreementPresenter> implements AgreementContract.View{
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.agreement_image)
    ImageView agreementImage;
    @Bind(R.id.btn_quit)
    Button btnQuit;
    private ProjectInfo.Project proInfo;
    private Thread thread;

    @Override
    public int getLayout() {
        return R.layout.activity_agreement;
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (msg.arg1 == 0) {

                            btnQuit.setText("我已同意签署安全协议(下一步)");

                    } else {
                if(btnQuit!=null) {
                        btnQuit.setText("("+msg.arg1 + ")");
                }
                    }
            }
        }
    };
    @Override
    public void initData() {
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
        tvTitle.setText("安全生产");


        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        mPresenter.getSecurityData(proInfo.getOrderNo());

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

    }

    @OnClick({R.id.iv_back, R.id.btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if(thread != null && thread.isAlive()){
                    //Log.e("readCacheThread", "thread interrupt_1");
                    thread.interrupt();
                    //Log.e("status", ""+readCacheThread.isInterrupted());
                }
                finish();
                break;
            case R.id.btn_quit:
                if (btnQuit.getText().toString().equals("我已同意签署安全协议(下一步)")) {

                    Intent intent = new Intent(this, AdministrationActivity.class);
                    intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, proInfo);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(thread != null && thread.isAlive()){
            //Log.e("readCacheThread", "thread interrupt_1");
            thread.interrupt();
            //Log.e("status", ""+readCacheThread.isInterrupted());
        }
        return super.onKeyDown(keyCode, event);
    }
}
