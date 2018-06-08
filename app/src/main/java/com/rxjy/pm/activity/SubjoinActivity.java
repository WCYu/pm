package com.rxjy.pm.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.mvp.contract.SubjoinContract;
import com.rxjy.pm.mvp.presenter.SubjoinPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubjoinActivity extends BaseActivity<SubjoinPresenter> implements SubjoinContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_subjoin)
    EditText etSubjoin;
    @Bind(R.id.tv_subjoin_count)
    TextView tvSubjoinCount;

    public static final String TITLE = "备注";

    private ShopCartInfo.ShopCart.Merchant merInfo;

    private String orderNo;

    @Override
    public int getLayout() {
        return R.layout.activity_subjoin;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initEdit();
    }

    private void initIntent() {
        merInfo = (ShopCartInfo.ShopCart.Merchant) getIntent().getSerializableExtra(Constants.ACTION_TO_SUBJOIN_MERCHANT_INFO);
        orderNo = getIntent().getStringExtra(Constants.ACTION_TO_SUBJOIN_ORDER_NO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        btnSubmit.setText("确定");
    }

    private void initEdit() {

        tvSubjoinCount.setText("限制字数" + 0 + "/70");

        etSubjoin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvSubjoinCount.setText("限制字数" + s.toString().length() + "/70");
            }
        });

    }

    @Override
    protected SubjoinPresenter onCreatePresenter() {
        return new SubjoinPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                String content = etSubjoin.getText().toString().trim();
                if (content.equals(""))
                    showToast("请输入备注内容");
                else
                    mPresenter.updSubjoin(orderNo, merInfo.getUserID(), content);
                break;
        }
    }

    @Override
    public void responseSubjoinData() {
        finish();
    }

    @Override
    public void responseSubJoinDataError(String msg) {
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
