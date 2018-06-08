package com.rxjy.pm.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.FefundContract;
import com.rxjy.pm.mvp.presenter.FefundPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/26.
 */

public class FefundActivity extends BaseActivity<FefundPresenter> implements FefundContract.View {
    @Bind(R.id.refusal_message)
    EditText refusalMessage;
    @Bind(R.id.btn_quit)
    Button btnQuit;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    private ProjectInfo.Project proInfo;
    private boolean booleanExtra;

    @Override
    public int getLayout() {
        return R.layout.activity_refund;
    }

    @Override
    public void initData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        booleanExtra = getIntent().getBooleanExtra(Constants.ORDERREJECTION, false);
        if (booleanExtra) {
            tvTitle.setText("退单");
        } else {
            tvTitle.setText("拒单");
        }
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected FefundPresenter onCreatePresenter() {
        return new FefundPresenter(this);
    }

    @OnClick(R.id.btn_quit)
    public void onViewClicked() {
        String text = refusalMessage.getText().toString();
        if(!text.equals("")) {
            closeKeyboard();
            if (booleanExtra) {
                Toast.makeText(this, "退单", Toast.LENGTH_SHORT).show();
                mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 4, refusalMessage.getText().toString());
            } else {
                Toast.makeText(this, "拒单", Toast.LENGTH_SHORT).show();
                mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 1, refusalMessage.getText().toString());
            }
        }else {
            Toast.makeText(this, "退单原因说明", Toast.LENGTH_SHORT).show();
        }
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
    public void toIntent() {
        startActivity(new Intent(this,NjjActivity.class));
        App.getApp().finishSingleActivity(ReceiptActivity.class);
        finish();
    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
