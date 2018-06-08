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
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.ImageShowActivity;
import com.rxjy.pm.activity.ResultChatActivity;
import com.rxjy.pm.adapter.XiaLaAdapter;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.entity.RuZhiInfoBean;
import com.rxjy.pm.entity.YinHangBean;
import com.rxjy.pm.utils.ToastUtil;
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

public class RuZhiActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.img_xingxiang)
    ImageView imgXingxiang;
    @Bind(R.id.img_zhengjian)
    ImageView imgZhengjian;
    @Bind(R.id.img_gongren)
    ImageView imgGongren;
    @Bind(R.id.tv_gongren)
    TextView tvGongren;
    @Bind(R.id.img_shenfen_zheng)
    ImageView imgShenfenZheng;
    @Bind(R.id.img_shenfen_fan)
    ImageView imgShenfenFan;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.img_yinhang)
    ImageView imgYinhang;
    @Bind(R.id.tv_yinhang)
    TextView tvYinhang;
    @Bind(R.id.img_yinhang_code)
    ImageView imgYinhangCode;
    @Bind(R.id.et_yinhang_code)
    EditText etYinhangCode;
    @Bind(R.id.et_yinhang_name)
    EditText etYinhangName;
    @Bind(R.id.img_tijian)
    ImageView imgTijian;
    @Bind(R.id.tv_tijian)
    TextView tvTijian;
    @Bind(R.id.img_tijian_code)
    ImageView imgTijianCode;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.tv_yinhang_title)
    TextView tvYinhangTitle;
    private String path;
    private String imgUrl;
    private String imgName;
    private RuZhiInfoBean.BodyBean.PhotosBean photos;
    private ArrayList<String> yinHangList;
    private ArrayAdapter<String> arr_adapter;
    private List<YinHangBean.BodyBean> body;

    String typeString;
    String yinHangName;

    @Override
    public int getLayout() {
        return R.layout.activity_ru_zhi;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        getYinHang();
        yinHangList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLoading();
        getRuZhiData();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick({R.id.img_xingxiang, R.id.img_zhengjian, R.id.img_shenfen_zheng, R.id.img_shenfen_fan, R.id.img_yinhang_code, R.id.img_tijian_code, R.id.btn_commit, R.id.iv_back})
    public void onViewClicked(View view) {
        String url;
        String status;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.img_xingxiang://形象照
//                setImg(101);
                url = photos.getVisualize().getUrl();
                status = photos.getVisualize().getStatus();
                startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("status",status).putExtra("title", "形象照").putExtra("type", 101));
                break;
            case R.id.img_zhengjian://证件照
                if (photos != null) {
                    status = photos.getIDCardFace().getStatus();
                    url = photos.getIDCardFace().getUrl();
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("status",status).putExtra("title", "证件照").putExtra("type", 102));
                }
                break;
            case R.id.img_shenfen_zheng://身份证正面
                if (photos != null) {
                    status = photos.getIDCardFace().getStatus();
                    url = photos.getIDCardFace().getUrl();
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("status",status).putExtra("title", "身份证正面").putExtra("type", 103));
                }
                break;
            case R.id.img_shenfen_fan://身份证反面
                if (photos != null) {
                    status = photos.getIDCardIdentity().getStatus();
                    url = photos.getIDCardIdentity().getUrl();
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("status",status).putExtra("title", "身份证反面").putExtra("type", 104));
                }
                break;
            case R.id.img_yinhang_code://银行
                status = photos.getBankCardFace().getStatus();
                url = photos.getBankCardFace().getUrl();
                startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("status",status).putExtra("title", "银行卡照").putExtra("type", 105));
                break;
            case R.id.img_tijian_code://体检证明
                if (photos != null) {
                    status = photos.getExamination().getStatus();
                    url = photos.getExamination().getUrl();
                    String arrInfoid = photos.getExamination().getArrInfoid();
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("image", url).putExtra("arrInfoid",arrInfoid).putExtra("status",status).putExtra("title", "体检证明").putExtra("type", 106));
                }
                break;
            case R.id.btn_commit:
                Map<String, Object> map = new HashMap();
                if (TextUtils.isEmpty(etYinhangCode.getText().toString())) {
                    Toast.makeText(application, "请输入银行卡号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etYinhangName.getText().toString())) {
                    Toast.makeText(application, "请输入开户行", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    Toast.makeText(application, "请输入电话", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    Toast.makeText(application, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                map.put("backCardNo", etYinhangCode.getText().toString());
                map.put("bankOfDeposit", typeString);
                map.put("idCard", etPhone.getText().toString());
                map.put("name", etName.getText().toString());
                map.put("uid", App.pmUserInfo.getUid());
                OkhttpUtils.doPost(ApiEngine.RUZHIADDURL, map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag_入职上传_失败", e.getMessage().toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.e("tag_入职上传_成功", string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(string);
                                    int statusCode = jsonObject.getInt("statusCode");
                                    if (statusCode == 1) {
                                        ToastUtil.getInstance().toastCentent("修改成功：" + body);
                                        finish();
                                    } else {
                                        String body = jsonObject.getString("body");
                                        Toast.makeText(application, body, Toast.LENGTH_SHORT).show();
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            switch (requestCode) {
                case 101:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgXingxiang);
                    setImgUrl(path, "40");
                    break;
                case 102:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgZhengjian);
                    setImgUrl(path, "4");
                    break;
                case 103:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgShenfenZheng);
                    setImgUrl(path, "4");
                    break;
                case 104:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgShenfenFan);
                    setImgUrl(path, "8");
                    break;
                case 105:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgYinhangCode);
                    setImgUrl(path, "9");
                    break;
                case 106:
                    // 图片选择结果回调
                    path = localMedias.get(localMedias.size() - 1).getCompressPath();
                    Log.e("lag_图片上传", path);
                    Glide.with(this).load(path).into(imgTijianCode);
                    for (int i = 0; i < localMedias.size(); i++) {
                        setImgUrl(localMedias.get(i).getCompressPath(), "19");
                    }
                    break;
            }
        }
    }

    private void setImg(int code) {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .enableCrop(true)// 是否裁剪 true or false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                .forResult(code);//结果回调onActivityResult code 

        if (code == 106) {
            PictureSelector.create(this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .imageSpanCount(3)// 每行显示个数 int
                    .maxSelectNum(9)// 最大图片选择数量 int
                    .minSelectNum(0)// 最小选择数量 int
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .compress(true)// 是否压缩 true or fals
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .forResult(code);//结果回调onActivityResult code 
        }
    }

    public void setImgUrl(String path, final String type) {
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
                            setRuZhiImg(imgUrl, imgName, type);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void setRuZhiImg(String imgUrl, String imgName, String type) {
        Map map = new HashMap();
        map.put("uid", App.pmUserInfo.getUid());
        map.put("attrModelid", type);
        map.put("BaseURL", imgUrl);
        map.put("FileName", imgName);
        OkhttpUtils.doPost(ApiEngine.RUZHIADDIMGURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_入职图片", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_入职图片", string);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    //获取的入职信息
    public void getRuZhiData() {

        Map map = new HashMap();
        map.put("uid", App.pmUserInfo.getUid());
        OkhttpUtils.doGet(ApiEngine.RUZHIURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_入职资料", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_入职资料", string);
                Gson gson = new Gson();
                RuZhiInfoBean ruZhiInfoBean = gson.fromJson(string, RuZhiInfoBean.class);
                int statusCode = ruZhiInfoBean.getStatusCode();
                RuZhiInfoBean.BodyBean body = ruZhiInfoBean.getBody();
                final RuZhiInfoBean.BodyBean.UserInfoBean userInfo = body.getUserInfo();
                photos = body.getPhotos();
                if (statusCode == 1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (userInfo.getUserName() != null) {
                                etName.setText(userInfo.getUserName());
                            } else {
                                etName.setEnabled(true);
                            }

                            if (userInfo.getUserName() != null) {
                                etPhone.setText(userInfo.getIdcard());
                            } else {
                                etPhone.setEnabled(true);
                            }
                            etYinhangCode.setText(userInfo.getBankAccount());
                            etYinhangName.setText(userInfo.getBankName());
                            tvYinhangTitle.setText(userInfo.getBankName());
                            yinHangName = userInfo.getBankName();
                            Glide.with(RuZhiActivity.this).load(photos.getVisualize().getUrl()).into(imgXingxiang);
                            Glide.with(RuZhiActivity.this).load(photos.getIDCardFace().getUrl()).into(imgZhengjian);
                            Glide.with(RuZhiActivity.this).load(photos.getIDCardFace().getUrl()).into(imgShenfenZheng);
                            Glide.with(RuZhiActivity.this).load(photos.getIDCardIdentity().getUrl()).into(imgShenfenFan);
                            Glide.with(RuZhiActivity.this).load(photos.getBankCardFace().getUrl()).into(imgYinhangCode);
                            String url = photos.getExamination().getUrl();
                            String[] split = url.split(";");
                            Glide.with(RuZhiActivity.this).load(split[split.length - 1]).into(imgTijianCode);
                            dismissLoading();
                        }
                    });
                } else {
                    Toast.makeText(application, ruZhiInfoBean.getStatusMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        setProgressDialog(3000);
    }

    public void getYinHang() {
        OkhttpUtils.doGet("http://wrapi.lm.rx/api/APPPM/GetBankType", null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_银行", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_银行", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        YinHangBean yinHangBean = gson.fromJson(string, YinHangBean.class);
                        body = yinHangBean.getBody();
                        for (int i = 0; i < body.size(); i++) {
                            yinHangList.add(body.get(i).getKey());
//                            arr_adapter = new ArrayAdapter<String>(RuZhiActivity.this, android.R.layout.simple_spinner_item, yinHangList);
//                            //设置样式
//                            arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        }
                        if (body != null) {
                            XiaLaAdapter xiaLaAdapter = new XiaLaAdapter((ArrayList<YinHangBean.BodyBean>) body, RuZhiActivity.this);
                            //加载适配器
                            spinner.setAdapter(xiaLaAdapter);

                            if (yinHangName != null) {
                                xiaLaAdapter.setYinHangName(yinHangName);
                                xiaLaAdapter.notifyDataSetChanged();
                            }
                            spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    typeString = body.get(position).getValue();
                                    tvYinhangTitle.setText(body.get(position).getKey());
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                    }
                });

            }
        });
    }

}
