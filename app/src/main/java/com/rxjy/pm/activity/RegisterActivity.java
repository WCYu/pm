package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.commons.utils.StringUtils;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.mvp.contract.RegisterContract;
import com.rxjy.pm.mvp.presenter.RegisterPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_phone_num)
    EditText etPhoneNum;
    @Bind(R.id.tv_old_password_line)
    TextView tvPhoneLine;
    @Bind(R.id.et_verification_code)
    EditText etVerificationCode;
    @Bind(R.id.tv_verification_code_line)
    TextView tvVerificationCodeLine;
    @Bind(R.id.et_new_password)
    EditText etNewPassword;
    @Bind(R.id.tv_new_password_line)
    TextView tvNewPasswordLine;
    @Bind(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @Bind(R.id.tv_confirm_password_line)
    TextView tvConfirmPasswordLine;
    @Bind(R.id.et_referral_code)
    EditText etReferralCode;
    @Bind(R.id.tv_referral_code_line)
    TextView tvReferralCodeLine;
    @Bind(R.id.cb_agreement)
    CheckBox cbAgreement;
    @Bind(R.id.btn_register)
    Button btnRegister;

    public static final String TITLE = "工人注册";
    private String phoneNum;
    private String newPassword;

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {
        initTitle();
        initLine();
        initButton();
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
        etNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvNewPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvNewPasswordLine.setEnabled(false);
                }
            }
        });
        etConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvConfirmPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvConfirmPasswordLine.setEnabled(false);
                }
            }
        });
        etReferralCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvReferralCodeLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvReferralCodeLine.setEnabled(false);
                }
            }
        });
    }

    private void initButton() {

        cbAgreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnRegister.setEnabled(true);
                } else {
                    btnRegister.setEnabled(false);
                }
            }
        });

    }

    @Override
    protected RegisterPresenter onCreatePresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_agreement, R.id.btn_verification_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_agreement:
                startActivity(new Intent(this, ProtocolActivity.class));
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
                mPresenter.getVerificationCode(phone);
                break;
            case R.id.btn_register:
                phoneNum = etPhoneNum.getText().toString().trim();
                newPassword = etNewPassword.getText().toString().trim();
                String verificationCode = etVerificationCode.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();
                String referralCode = etReferralCode.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    showToast("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phoneNum)) {
                    showToast("请输入正确的手机号");
                    return;
                }
                if (TextUtils.isEmpty(verificationCode)) {
                    showToast("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    showToast("请输入新密码");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    showToast("请输入确认密码");
                    return;
                }
                if (!newPassword.equals(confirmPassword)) {
                    showToast("两次密码输入不一致");
                    return;
                }
                if (TextUtils.isEmpty(referralCode)) {
                    showToast("请输入推荐码");
                    return;
                }
                //注册
                mPresenter.getRegister(verificationCode, phoneNum, newPassword, referralCode);
                break;
        }
    }

    @Override
    public void responseRegisterData() {
        showToast("注册成功");
        mPresenter.getToken(phoneNum, newPassword);
    }

    @Override
    public void responseRegisterError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseVerificationCodeDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseToken(TokenInfo.Token data) {

        PrefUtils.putValue(this, Constants.CARD_NO, data.getCardNo());
        PrefUtils.putValue(this, Constants.TOKEN, data.getToken());

        mPresenter.getLoginUserInfo(data.getCardNo(), data.getToken());

    }

    @Override
    public void responseTokenError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseLogin(UserInfo.User data) {

        App.cardNo = PrefUtils.getValue(this, Constants.CARD_NO);
        App.token = PrefUtils.getValue(this, Constants.TOKEN);

        App.baseInfo = data.getBaseinfo();
        App.personnelInfo = data.getPersonnelInfo();

    }

    @Override
    public void responseLoginError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsePmUserInfo(PmUserInfo.BodyBean data) {

        App.pmUserInfo = data;

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
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
}
