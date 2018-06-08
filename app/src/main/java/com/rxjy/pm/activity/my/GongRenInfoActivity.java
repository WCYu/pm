package com.rxjy.pm.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.XiangMuInfoBean;
import com.rxjy.pm.widget.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GongRenInfoActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.img_icon)
    ImageView imgIcon;
    @Bind(R.id.img_gongren)
    ImageView imgGongren;
    @Bind(R.id.tv_gongren)
    TextView tvGongren;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.et_type)
    EditText etType;
    private String path;

    String imgUrl = "";
    String imgName = "";
    String type = "";
    private ArrayList<String> gongReanList;
    private ArrayAdapter<String> arr_adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_gong_ren_info;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("type");
        switch (type) {
            // 1瓦工；2木工；3油工；4电工；7壮工；15水工
            case "add":
                gongReanList = new ArrayList();
                gongReanList.add("瓦工");
                gongReanList.add("木工");
                gongReanList.add("油工");
                gongReanList.add("电工");
                gongReanList.add("壮工");
                gongReanList.add("水工");
                //适配器
                arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gongReanList);
                //设置样式
                arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //加载适配器
                spinner.setAdapter(arr_adapter);
                break;

            case "info":
                XiangMuInfoBean.BodyBean.UserinfoProjectMsgBean bean = (XiangMuInfoBean.BodyBean.UserinfoProjectMsgBean) getIntent().getSerializableExtra("bean");
                btnCommit.setVisibility(View.GONE);
                tvTitle.setText("工人详情");
                etName.setText(bean.getWorkerName());
                etName.setEnabled(false);
                etPhone.setText(bean.getPmWorkerobile());
                etPhone.setEnabled(false);
                Glide.with(this).load(bean.getRealUrl()).into(imgIcon);
                //bean.getDicname()
                etType.setVisibility(View.VISIBLE);
                etType.setText(bean.getDicname());
                etType.setEnabled(false);
                break;
            default:
                break;
        }
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = gongReanList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.img_icon, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.img_icon:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
                break;
            case R.id.btn_commit:
//                finish();
                Log.e("tag_工人",type);
                if(getIntent().getStringExtra("type").equals("add")){
                    addGongRen();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                Glide.with(this).load(path).into(imgIcon);
                    setImg(path);
                    break;
            }
        }
    }

    public void setImg(String path) {
        if (path != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            File file = new File(path);
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("facefile", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
            RequestBody body = builder.build();
            Request request = new Request.Builder().url("http://img9.rxjy.com:9192/api/upload?action=uploadimage").addHeader("Referer", "iPanda.Android")
                    .addHeader("User-Agent", "CNTV_APP_CLIENT_CBOX_MOBILE")
                    .post(body).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.e("tag_图片上传", string);
                    try {
                        JSONObject jsonObject = new JSONObject(string);
                        String state = jsonObject.getString("State");
                        if (state.equals("SUCCESS")) {
                            imgUrl = jsonObject.getString("BaseUrl");
                            imgName = jsonObject.getString("FileName");
                            Log.e("tag_图片上传", string);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void addGongRen() {

        if (TextUtils.isEmpty(imgUrl)) {
            Toast.makeText(application, "请选择上传图片", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(etName.getText().toString())) {
            Toast.makeText(application, "请填写工人姓名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString())) {
            Toast.makeText(application, "请填写工人电话", Toast.LENGTH_SHORT).show();
            return;
        }
        Map map = new HashMap();
        map.put("workerName", etName.getText().toString());
        map.put("mobile", etPhone.getText().toString());
        // 1瓦工；2木工；3油工；4电工；7壮工；15水工
        switch (type){
            case "瓦工":
                map.put("majorJob", "1");
                break;
            case "木工":
                map.put("majorJob", "2");
                break;
            case "油工":
                map.put("majorJob", "3");
                break;
            case "电工":
                map.put("majorJob", "4");
                break;
            case "壮工":
                map.put("majorJob", "7");
                break;
            case "水工":
                map.put("majorJob", "15");
                break;
        }
        map.put("pmUserId", App.pmUserInfo.getUid());
        map.put("attr_server_url", imgUrl);
        map.put("attr_file_url", imgName);

        OkhttpUtils.doPost(ApiEngine.GONGRANURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_工人上传", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_工人上传", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("statusCode");

                            switch (statusCode) {
                                case 1:
                                    Toast.makeText(application, "上传成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                    break;
                                case 2:

                                default:
                                    String body = jsonObject.getString("body");
                                    Toast.makeText(application, "上传失败：" + body, Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
