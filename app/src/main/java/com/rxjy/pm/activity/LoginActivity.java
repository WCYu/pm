package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.commons.utils.StringUtils;
import com.rxjy.pm.entity.AccountInfo;
import com.rxjy.pm.entity.LoginBean;
import com.rxjy.pm.entity.PmUserInfo;
import com.rxjy.pm.entity.TokenInfo;
import com.rxjy.pm.entity.UserInfo;
import com.rxjy.pm.fragment.WorkerInfo;
import com.rxjy.pm.mvp.contract.LoginContract;
import com.rxjy.pm.mvp.presenter.LoginPresenter;
import com.rxjy.pm.pop.AccountPop;
import com.rxjy.pm.widget.DownTimerButton;
import com.rxjy.pm.widget.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @Bind(R.id.iv_logo)
    ImageView ivLogo;
    @Bind(R.id.et_phone_num)
    EditText etPhoneNum;
    @Bind(R.id.tv_old_password_line)
    TextView tvPhoneLine;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.tv_password_line)
    TextView tvPasswordLine;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.iv_phone_arrow)
    ImageView ivArrow;
    @Bind(R.id.tv_prompt)
    TextView tv_prompt;

    public static final String TAG = "LoginActivity";
    @Bind(R.id.iv_phone_icon)
    ImageView ivPhoneIcon;
    @Bind(R.id.tv_phone_text)
    TextView tvPhoneText;
    @Bind(R.id.rl_phone_num)
    RelativeLayout rlPhoneNum;
    @Bind(R.id.iv_password_icon)
    ImageView ivPasswordIcon;
    @Bind(R.id.tv_password_text)
    TextView tvPasswordText;
    @Bind(R.id.rl_password)
    RelativeLayout rlPassword;
    @Bind(R.id.iv_verification_code_icon)
    ImageView ivVerificationCodeIcon;
    @Bind(R.id.tv_verification_code_text)
    TextView tvVerificationCodeText;
    @Bind(R.id.btn_verification_code)
    DownTimerButton btnVerificationCode;
    @Bind(R.id.et_verification_code)
    EditText etVerificationCode;
    @Bind(R.id.tv_verification_code_line)
    TextView tvVerificationCodeLine;
    @Bind(R.id.rl_code)
    RelativeLayout rlCode;
    @Bind(R.id.tv_verification_code_login)
    TextView tvVerificationCodeLogin;
    @Bind(R.id.rl_forget_password)
    RelativeLayout rlForgetPassword;
    @Bind(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @Bind(R.id.tv_register)
    TextView tvRegister;

    private String phoneNum;

    private String password;

    private List<AccountInfo> accountList;

    private AccountPop accountPop;

    public static final String TYPE = "type";
    private int manager = 1;
    private int worker = 4;
    private String phonenum;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        initLine();
        initAccount();
        initListener();
    }

    private void initListener() {
        etPhoneNum.addTextChangedListener(new MyEditListener(etPhoneNum));
    }

    private void initAccount() {

        String json = PrefUtils.getValue(this, Constants.ACCOUNT_RECORD);

        Type type = new TypeToken<ArrayList<AccountInfo>>() {
        }.getType();

        List<AccountInfo> list = JSONUtils.toList(json, type);

        accountList = new ArrayList<>();

        if (list != null) {
            accountList.addAll(list);
        }

        if (accountList.size() == 0) {
            ivArrow.setVisibility(View.INVISIBLE);
        } else {
            etPhoneNum.setText(accountList.get(0).getAccount());
        }

        accountPop = new AccountPop(this, R.layout.pop_account_layout, AutoUtils.getDisplayWidthValue(720), AutoUtils.getDisplayHeightValue(400));

        accountPop.setOnAccountPopClickListener(new AccountPop.OnAccountPopClickListener() {
            @Override
            public void userAccountChoice(AccountInfo data) {
                etPhoneNum.setText(data.getAccount());
            }

            @Override
            public void userAccountDel(AccountInfo data, int position) {
                accountList.remove(position);
                accountPop.setAccountList(accountList);
                if (accountList.size() == 0) {
                    ivArrow.setVisibility(View.INVISIBLE);
                }
                saveAccount();
            }
        });

        accountPop.setAccountList(accountList);

        accountPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivArrow.setImageResource(R.mipmap.account_down_arrow_icon);
            }
        });

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
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvPasswordLine.setEnabled(false);
                }
            }
        });
    }

    private boolean mContains(String str) {
        for (AccountInfo info : accountList) {
            if (info.getAccount().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(String str) {
        int index = -1;
        int count = 0;
        for (AccountInfo info : accountList) {
            if (!info.getAccount().equals(str)) {
                //  count
                count++;
            } else {
                index = count;
            }

        }
        return index;
    }

    private void saveAccount() {

        String accountJson = JSONUtils.toString(accountList);
        PrefUtils.putValue(this, Constants.ACCOUNT_RECORD, accountJson);

    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }


    @OnClick({R.id.tv_verification_code_login, R.id.tv_forget_password, R.id.tv_register, R.id.btn_login, R.id.iv_phone_arrow, R.id.btn_verification_code})
    public void onViewClicked(View view) {
        HashMap map=null;
        switch (view.getId()) {
            case R.id.tv_verification_code_login:
                startActivity(new Intent(this, CodeLoginActivity.class));
                break;
            case R.id.tv_forget_password:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login://登陆
                phoneNum = etPhoneNum.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
//                    showToast("请输入手机号");
                    tv_prompt.setText("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phoneNum)) {
//                    showToast("请输入正确的手机号");
                    tv_prompt.setText("请输入正确的手机号");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
//                    showToast("请输入密码");
                    tv_prompt.setText("请输入密码");
                    return;
                }
                if(password.length()<6){
                    tv_prompt.setText("密码不少于6位");
                    return;
                }
                Log.e("tag_登陆", "开始登陆");
                map = new HashMap();
                map.put("cardNo", etPhoneNum.getText().toString());
                map.put("password", etPassword.getText().toString());
                String code = etVerificationCode.getText().toString();
                if(TextUtils.isEmpty(code)){
                    map.put("vCode", "");
                }else {
                    map.put("vCode", code);
                }
                map.put("appId", "5");
                OkhttpUtils.doPost(ApiEngine.LOGINURL, map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag_登陆", e.getMessage().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_prompt.setText("连接失败");
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.e("tag_登陆", string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_prompt.setText("");
                                try {
                                    JSONObject jsonObject = new JSONObject(string);
                                    int statusCode = jsonObject.getInt("StatusCode");
                                    String statusMsg = jsonObject.getString("StatusMsg");
                                    switch (statusCode) {
                                        case 0:
                                            Gson gson = new Gson();
                                            LoginBean loginBean = gson.fromJson(string, LoginBean.class);

                                            PrefUtils.putValue(LoginActivity.this, Constants.CARD_NO, loginBean.getBody().getCardNo());
                                            PrefUtils.putValue(LoginActivity.this, Constants.TOKEN, loginBean.getBody().getToken());

                                            mPresenter.getLoginUserInfo(loginBean.getBody().getCardNo(), loginBean.getBody().getToken());

//                                            Intent intent = new Intent(LoginActivity.this, NjjActivity.class);
//
//                                            startActivity(intent);
                                            break;
                                        default:
//                                            Toast.makeText(application, statusMsg, Toast.LENGTH_SHORT).show();
                                            tv_prompt.setText(statusMsg);
                                            break;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
                Log.e("tag_登陆", "结束登陆");
                break;
            case R.id.iv_phone_arrow:
                ivArrow.setImageResource(R.mipmap.account_up_arrow_icon);
                //设置默认获取焦点
                accountPop.setFocusable(true);
                //以某个控件的x和y的偏移量位置开始显示窗口
                accountPop.showAsDropDown(tvPhoneLine, 0, 0);
                //如果窗口存在，则更新
                accountPop.update();
                break;
            case R.id.btn_verification_code://获取验证码
                map = new HashMap<>();
                map.put("Phone", phonenum);
                map.put("AppId", "5");
                OkhttpUtils.doGet(ApiEngine.CODE, map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag_获取验证码", e.getMessage().toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.e("tag_获取验证码", string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(string);
                                    int statusCode = jsonObject.getInt("StatusCode");
                                    String statusMsg = jsonObject.getString("StatusMsg");
                                    switch (statusCode) {
                                        case 0:

                                            break;
                                        case 1:

                                            break;
                                        default:
//                                            Toast.makeText(application, statusMsg, Toast.LENGTH_SHORT).show();
                                            tv_prompt.setText(statusMsg);
                                            break;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
                break;
        }
//        map.clear();
    }

    @Override
    public void responseToken(TokenInfo.Token data) {
        // Log.e("App",data.getCardNo());
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
        // Log.e("aa",data.getPersonnelInfo().getPostId()+"");
        if (data.getPersonnelInfo().getPostId() == 1 ) {
            mPresenter.getPmUserInfo(data.getBaseinfo().getPhone(),1);
            PrefUtils.putIntValue(this, Constants.FLAG, data.getPersonnelInfo().getPostId());
        } else if (data.getPersonnelInfo().getPostId() == 20001|| data.getPersonnelInfo().getPostId() == 20002) {
            mPresenter.getPmUserInfo(data.getBaseinfo().getPhone(),2);
            PrefUtils.putIntValue(this, Constants.FLAG, data.getPersonnelInfo().getPostId());
        }else if (data.getPersonnelInfo().getPostId() == 4 ) {
            mPresenter.getLoginWorkerInfo(data.getBaseinfo().getPhone());
            PrefUtils.putIntValue(this, Constants.FLAG, data.getPersonnelInfo().getPostId());
        } else {
            Toast.makeText(this, data.getPersonnelInfo().getPostName() + "请登陆其他平台", Toast.LENGTH_SHORT).show();
//            tv_prompt.setText(data.getPersonnelInfo().getPostName() + "请登陆其他平台");
        }

    }

    @Override
    public void responseLoginError(String msg) {
//        showToast(msg);
        tv_prompt.setText(msg);
    }

    @Override
    public void responsePmUserInfo(PmUserInfo.BodyBean data) {

        App.pmUserInfo = data;
        //App.pmUserInfo.setUser_join_state(1);
        String account = etPhoneNum.getText().toString().trim();
        if (!mContains(account)) {
            accountList.add(new AccountInfo(account));
        } else {
            int index = getIndex(account);
            accountList.remove(index);
            accountList.add(0, new AccountInfo(account));
        }
        saveAccount();
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);

        //绑定推送别名
        mHandler.sendMessage(mHandler.obtainMessage(Constants.MSG_SET_ALIAS, App.baseInfo.getPhone()));
        Intent intent = new Intent(this, NjjActivity.class);
        intent.putExtra(TYPE, manager);
        startActivity(intent);
        finish();
    }

    @Override
    public void handlerMeaasg(Message msg) {
        super.handlerMeaasg(msg);
        JPushInterface.setAlias(getApplicationContext(),
                (String) msg.obj, mAliasCallback);
//        JPushInterface.setAliasAndTags(getApplicationContext(),
//                (String) msg.obj, null, mAliasCallback);
        Log.e(TAG, "设置别名成功" + (String) msg.obj);
    }

    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            switch (code) {
                case 0:
                    Log.e(TAG, "设置别名成功");
                    break;
                case 6002:
                    Log.e(TAG, "设置别名失败");
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(Constants.MSG_SET_ALIAS, alias), 1000 * 60);
                    break;
                default:
                    Log.e(TAG, "设置别名失败" + code);
                    break;
            }
        }
    };

    @Override
    public void responsePmUserInfoError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpdPwd(String msg) {
        showToast(msg);
        Intent intent = new Intent(this, ForgetPwdActivity.class);
        intent.putExtra(Constants.ACTION_TO_FORGET_PWD_TYPE, 1);
        startActivity(intent);
    }

    @Override
    public void intentWorker(int tag) {

    }

    @Override
    public void responseWorkerLogin(WorkerInfo.BodyBean data) {
        int workerId = data.getWorkerId();
        App.workerid = workerId;
        App.workerInfo = data;
//保存手机号
        String account = etPhoneNum.getText().toString().trim();
        PrefUtils.getValue(this, Constants.ACCOUNT_RECORD);
        if (!mContains(account)) {
            accountList.add(new AccountInfo(account));
        } else {
            int index = getIndex(account);
            accountList.remove(index);
            accountList.add(0, new AccountInfo(account));
        }
        saveAccount();
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);
        //绑定推送别名
        mHandler.sendMessage(mHandler.obtainMessage(Constants.MSG_SET_ALIAS, App.baseInfo.getPhone()));
        Intent intent = new Intent(this, NjjActivity.class);
        intent.putExtra(TYPE, worker);
        startActivity(intent);
        finish();
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.et_phone_num:
                    phonenum = etPhoneNum.getText().toString();
                    if (lengths == 11) {//11手机号位请求判断
                        String strthree = phonenum.substring(0, 3);
                        if (!strthree.equals("WTS")) {
                            if (StringUtils.isMobileNO(phonenum)) {
                                HashMap map = new HashMap<>();
                                map.put("Phone", phonenum);
                                map.put("AppId", "5");
                                OkhttpUtils.doGet(ApiEngine.LOGIN, map, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        Log.e("tag_登陆", e.getMessage().toString());
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                tv_prompt.setText("连接失败");
                                            }
                                        });
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String string = response.body().string();
                                        Log.e("tag_登陆", string);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                tv_prompt.setText("");
                                                try {
                                                    JSONObject jsonObject = new JSONObject(string);
                                                    int statusCode = jsonObject.getInt("StatusCode");
                                                    String statusMsg = jsonObject.getString("StatusMsg");
                                                    switch (statusCode) {
                                                        case 0:
                                                            rlPassword.setVisibility(View.VISIBLE);
                                                            btnLogin.setVisibility(View.VISIBLE);
                                                            tvForgetPassword.setVisibility(View.VISIBLE);
                                                            btnLogin.setText("登陆");
                                                            break;
                                                        case 1:
                                                            rlCode.setVisibility(View.VISIBLE);
                                                            btnLogin.setVisibility(View.VISIBLE);
                                                            rlPassword.setVisibility(View.VISIBLE);
                                                            btnLogin.setText("激活");
                                                            break;
                                                        default:
//                                                            Toast.makeText(application, statusMsg, Toast.LENGTH_SHORT).show();
                                                            tv_prompt.setText(statusMsg);
                                                            break;
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                });
                            } else {
//                                Toast.makeText(application, "请输入正确的手机号！", Toast.LENGTH_SHORT).show();
                                tv_prompt.setText("请输入正确的手机号！");
                            }
                        } else {
                        }
                    } else if (lengths == 8) {
                        String strthree = phonenum.substring(0, 3);
                        if (!strthree.equals("WTS")) {
                            int cardnum = 0;
                            try {
                                cardnum = Integer.parseInt(phonenum);
                                if (cardnum < 10000000) {
                                }
                            } catch (Exception e) {
                                showToast("请输入正确的账号！");
                            }
                        }

                    }else {
                        rlPassword.setVisibility(View.GONE);
                        btnLogin.setVisibility(View.GONE);
                        tvForgetPassword.setVisibility(View.GONE);
                        rlCode.setVisibility(View.GONE);
                        btnLogin.setVisibility(View.GONE);
                        tv_prompt.setText("");
                    }
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
        }
    }
}
