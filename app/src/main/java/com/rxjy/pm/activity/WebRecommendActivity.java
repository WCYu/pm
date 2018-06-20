package com.rxjy.pm.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus on 2018/6/12.
 */

public class WebRecommendActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivback;
    @Bind(R.id.wv_join)
    WebView wbRxsongs;
    String url;

    @Override
    public int getLayout() {
        return R.layout.activity_free_join;
    }

    @Override
    public void initData() {
        tvTitle.setText("加盟推荐");
        wbRxsongs.getSettings().setJavaScriptEnabled(true);

        wbRxsongs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wbRxsongs.getSettings().setDomStorageEnabled(true);
        //   wbRxsongs.getSettings().setMediaPlaybackRequiresUserGesture(false);
        wbRxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });

        url = "http://api.gc.rxjy.com:9101/app/h/recommendNXEAPP.html?CardNo" + App.cardNo;
        wbRxsongs.loadUrl(url);
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
