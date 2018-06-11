package com.rxjy.pm.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.utils.ToastUtil;
import com.rxjy.pm.widget.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class IsRuZhiActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.web_dianpu)
    WebView webDianpu;
    public static String url = ApiEngine.RUZHIZILIAOURL+"?pmUid="+App.pmUserInfo.getUid();
    @Bind(R.id.btn_agree)
    Button btnAgree;

    @Override
    public int getLayout() {
        return R.layout.activity_is_ru_zhi;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        webDianpu.loadUrl(url);
        webDianpu.getSettings().setJavaScriptEnabled(true);
        // 为图片添加放大缩小功能
        webDianpu.getSettings().setUseWideViewPort(true);
        webDianpu.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        webDianpu.destroy();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.btn_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_agree:
                Map map = new HashMap();
                map.put("uid", App.pmUserInfo.getUid());
                map.put("intentionStatus","1");
                OkhttpUtils.doGet(ApiEngine.ADDISRUZHIURL, map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag_同意",e.getMessage().toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Log.e("tag_同意",string);
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("statusCode");
                            String body = jsonObject.getString("body");
                            if(statusCode == 1){
                                finish();
                            }else {
                                ToastUtil.getInstance().toastCentent(body,IsRuZhiActivity.this);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
                break;
        }
    }
}
