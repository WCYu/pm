package com.rxjy.pm.activity.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.XiangMuInfoBean;
import com.rxjy.pm.utils.ToastUtil;
import com.rxjy.pm.utils.ZJson;
import com.rxjy.pm.widget.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XiangMuInfoActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_gcid)
    EditText etGcid;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.et_mianji)
    EditText etMianji;
    @Bind(R.id.et_hetong)
    EditText etHetong;
    @Bind(R.id.et_kehu)
    EditText etKehu;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_zhengming)
    EditText etZhengming;
    @Bind(R.id.et_zhengming_phone)
    EditText etZhengmingPhone;
    @Bind(R.id.btn_commit)
    Button btnCommit;

    @Override
    public int getLayout() {
        return R.layout.activity_xiang_mu_info;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        String type = getIntent().getStringExtra("type");
        switch (type) {
            case "add":

                break;
            case "info":
                XiangMuInfoBean.BodyBean.UserinfoProjectBean bean = (XiangMuInfoBean.BodyBean.UserinfoProjectBean) getIntent().getSerializableExtra("bean");
                btnCommit.setVisibility(View.GONE);
                tvTitle.setText("项目详情");
                etGcid.setEnabled(false);
                etGcid.setText(bean.getCompany());
                etName.setEnabled(false);
                etName.setText(bean.getName());
                etAddress.setEnabled(false);
                etAddress.setText(bean.getAddress());
                etMianji.setEnabled(false);
                etMianji.setText(bean.getArea());
                etHetong.setEnabled(false);
                etHetong.setText(bean.getProMoney());
                etKehu.setEnabled(false);
                etKehu.setText(bean.getCustomerName());
                etPhone.setEnabled(false);
                etPhone.setText(bean.getPhone());
                etZhengming.setEnabled(false);
                etZhengming.setText(bean.getWitnessName());
                etZhengmingPhone.setEnabled(false);
                etZhengmingPhone.setText(bean.getWitnessPhone());

                break;
            default:
                break;
        }
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_commit:
                setXiangMuData();
//                finish();
                break;
        }
    }

    public void setXiangMuData() {
        if (TextUtils.isEmpty(etName.getText().toString())) {
            Toast.makeText(application, "请输入项目名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etAddress.getText().toString())) {
            Toast.makeText(application, "请输入项目地址", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etHetong.getText().toString())) {
            Toast.makeText(application, "请输入合同额", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString())) {
            Toast.makeText(application, "请输入电话", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etKehu.getText().toString())) {
            Toast.makeText(application, "请输入客户姓名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etMianji.getText().toString())) {
            Toast.makeText(application, "请输入面积", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etGcid.getText().toString())) {
            Toast.makeText(application, "请输入装饰公司", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etZhengming.getText().toString())) {
            Toast.makeText(application, "请输入证明人", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etZhengmingPhone.getText().toString())) {
            Toast.makeText(application, "请输入证明人电话", Toast.LENGTH_SHORT).show();
            return;
        }
        Map map = new HashMap();
        map.put("name", etName.getText().toString());
        map.put("address", etAddress.getText().toString());
        map.put("proMoney", etHetong.getText().toString());
        map.put("phone", etPhone.getText().toString());
        map.put("customerName", etKehu.getText().toString());
        map.put("uId", App.pmUserInfo.getUid());
        map.put("area", etMianji.getText().toString());
        map.put("company", etGcid.getText().toString());
        map.put("witnessName", etZhengming.getText().toString());
        map.put("witnessPhone", etZhengmingPhone.getText().toString());

        String pmProjectInfos = ZJson.toJSONMap("PmProjectInfos", map);
        Log.e("tag_项目上传", pmProjectInfos);

        OkhttpUtils.doPost(ApiEngine.XIANGMUURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_上传项目", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_上传项目", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("statusCode");

                            switch (statusCode) {
                                case 1:
                                    ToastUtil.getInstance().toastCentent("上传成功");
                                    finish();
                                    break;
                                case 2:

                                default:
                                    String body = jsonObject.getString("body");
                                    ToastUtil.getInstance().toastCentent("上传失败：" + body);
                                    finish();
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
