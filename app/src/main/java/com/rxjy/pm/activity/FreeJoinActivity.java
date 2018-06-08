package com.rxjy.pm.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FreeJoinActivity extends BaseActivity {

    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.wv_join)
    WebView wvJoin;

    public static final String TITLE = "材料商入驻";

    private String url = "http://api.gc.rxjy.com/doc/Materialflow.html";

    @Override
    public int getLayout() {
        return R.layout.activity_free_join;
    }

    @Override
    public void initData() {
        initTitle();
        initWV();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initWV() {

        wvJoin.loadUrl(url);

        wvJoin.getSettings().setJavaScriptEnabled(true);
        // 为图片添加放大缩小功能
        wvJoin.getSettings().setUseWideViewPort(true);

        wvJoin.setWebViewClient(new WebViewClient() {
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


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
