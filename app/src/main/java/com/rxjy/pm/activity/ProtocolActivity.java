package com.rxjy.pm.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProtocolActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.wv_protocol)
    WebView wvProtocol;

    public static final String TITLE = "用户协议";

    @Override
    public int getLayout() {
        return R.layout.activity_protocol;
    }

    @Override
    public void initData() {
        initTitle();
        initProtocol();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initProtocol() {

        String url = "file:///android_asset/registration_protocol.html";

        wvProtocol.loadUrl(url);

        wvProtocol.setInitialScale(50);

        wvProtocol.getSettings().setJavaScriptEnabled(true);
        // 为图片添加放大缩小功能
        wvProtocol.getSettings().setUseWideViewPort(true);

        wvProtocol.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
