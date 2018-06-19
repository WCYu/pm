package com.rxjy.pm.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.commons.utils.StringUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.CodeLoginContract;
import com.rxjy.pm.mvp.presenter.CodeLoginPresenter;
import com.rxjy.pm.widget.DownTimerButton;

import butterknife.Bind;
import butterknife.OnClick;

public class CodeLoginActivity extends BaseActivity<CodeLoginPresenter> implements CodeLoginContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_phone_num)
    EditText etPhoneNum;
    @Bind(R.id.tv_old_password_line)
    TextView tvPhoneLine;
    @Bind(R.id.btn_verification_code)
    DownTimerButton btnVerificationCode;
    @Bind(R.id.et_verification_code)
    EditText etVerificationCode;
    @Bind(R.id.tv_verification_code_line)
    TextView tvVerificationCodeLine;

    public static final String TITLE = "验证码登录";

    @Override
    public int getLayout() {
        return R.layout.activity_code_login;
    }

    @Override
    public void initData() {
        initTitle();
        initLine();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initLine() {
        etPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvPhoneLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvPhoneLine.setEnabled(false);
                }
            }
        });
        etVerificationCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvVerificationCodeLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvVerificationCodeLine.setEnabled(false);
                }
            }
        });
    }

    @Override
    protected CodeLoginPresenter onCreatePresenter() {
        return new CodeLoginPresenter(this);
    }



    @OnClick({R.id.iv_back, R.id.btn_verification_code, R.id.btn_code_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_verification_code:
                String phone = etPhoneNum.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    showToast("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phone)) {
                    showToast("请输入正确的手机号");
                    return;
                }
                mPresenter.getVCode(phone);
                break;
            case R.id.btn_code_login:
                String phoneNum = etPhoneNum.getText().toString().trim();
                String vCode = etVerificationCode.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    showToast("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phoneNum)) {
                    showToast("请输入正确的手机号");
                    return;
                }
                if (TextUtils.isEmpty(vCode)) {
                    showToast("请输入验证码");
                    return;
                }
                mPresenter.getTokenByCode(phoneNum, vCode);
                break;
        }
    }

    @Override
    public void responseTokenByCode(TokenInfo.Token data) {

        PrefUtils.putValue(this, Constants.CARD_NO, data.getCardNo());
        PrefUtils.putValue(this, Constants.TOKEN, data.getToken());

        App.cardNo = data.getCardNo();
        App.token = data.getToken();

        mPresenter.getLoginUserInfoByCode(App.cardNo, App.token);

    }

    @Override
    public void showIntent(int tag) {
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);
        PrefUtils.putIntValue(this,Constants.FLAG,tag);
        App.getApp().finishSingleActivity(LoginActivity.class);
        startActivity(new Intent(this,NjjActivity.class));
        finish();
    }

    @Override
    public void responseTokenByCodeError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseLoginByCode(UserInfo.User data) {

        App.baseInfo = data.getBaseinfo();
        App.personnelInfo = data.getPersonnelInfo();

         if(data.getPersonnelInfo().getPostId()==1) {
             mPresenter.getPmUserInfo(App.baseInfo.getPhone(),1);

         }else if(data.getPersonnelInfo().getPostId()==4){
             mPresenter.getLoginWorkerInfo(data.getBaseinfo().getPhone());

         }else if(data.getPersonnelInfo().getPostId()==2001){
             mPresenter.getPmUserInfo(App.baseInfo.getPhone(),2);

         }else if(data.getPersonnelInfo().getPostId()==2002){
             mPresenter.getPmUserInfo(App.baseInfo.getPhone(),2);

         }else {
             Toast.makeText(this,data.getPersonnelInfo().getPostName()+"请登陆其他平台", Toast.LENGTH_SHORT).show();
         }

    }

    @Override
    public void responseLoginByCodeError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseVCodeError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsePmUserInfo(PmUserInfo.BodyBean data) {
        App.pmUserInfo = data;
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);
        PrefUtils.putIntValue(this,Constants.FLAG,1);
        App.getApp().finishSingleActivity(LoginActivity.class);
        startActivity(new Intent(this, NjjActivity.class));
        finish();
    }

    @Override
    public void responsePmUserInfoError(String msg) {
        showToast(msg);
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
    public void responseWorkerLogin(WorkerInfo.BodyBean data) {
        App.workerInfo=data;
        showIntent(  App.personnelInfo.getPostId());
    }

    @Override
    public void responseLoginError(String msg) {
    showToast(msg);
    }
}
