package com.rxjy.pm.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.my.XiangMuAdaptr;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.XiangMuInfoBean;
import com.rxjy.pm.widget.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XiangMuActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_add)
    TextView tvAdd;
    @Bind(R.id.list_xiangmu)
    ListView listXiangmu;
    private ArrayList<XiangMuInfoBean.BodyBean.UserinfoProjectBean> arrayList;
    private XiangMuAdaptr xiangMuAdaptr;

    @Override
    public int getLayout() {
        return R.layout.activity_xing_mu;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        arrayList = new ArrayList<>();
        showLoading();
        initAdapter();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayList.clear();
        getListData();
    }

    private void initListener() {
        listXiangmu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(XiangMuActivity.this,XiangMuInfoActivity.class);
                intent.putExtra("type","info");
                intent.putExtra("bean",arrayList.get(position));
                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        xiangMuAdaptr = new XiangMuAdaptr(this,arrayList);
        listXiangmu.setAdapter(xiangMuAdaptr);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_add:
                Intent intent = new Intent(XiangMuActivity.this,XiangMuInfoActivity.class);
                intent.putExtra("type","add");
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void getListData() {
        Map map = new HashMap();
        map.put("uid", App.pmUserInfo.getUid());
        OkhttpUtils.doGet(ApiEngine.RENZHENGURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_项目列表",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_项目列表",string);
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONObject body = jsonObject.getJSONObject("body");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                XiangMuInfoBean xiangMuInfoBean = gson.fromJson(string, XiangMuInfoBean.class);
                XiangMuInfoBean.BodyBean body = xiangMuInfoBean.getBody();
                arrayList.addAll(body.getUserinfoProject());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        xiangMuAdaptr.notifyDataSetChanged();
                        dismissLoading();
                    }
                });
            }
        });
        setProgressDialog(3000);
    }
}
