package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.BackInfo;
import com.rxjy.pm.entity.RegionIdInfo;
import com.rxjy.pm.entity.WorkerInfo;
import com.rxjy.pm.entity.WorkerPhotoInfo;
import com.rxjy.pm.entity.WorkerTypeInfo;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by asus on 2018/6/22.
 */

public class WorkerInfoDataActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
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
    @Bind(R.id.et_Account_name)
    EditText etAccountName;
    @Bind(R.id.tv_yinhang_title)
    TextView tvYinhangTitle;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.et_yinhang_name)
    EditText etYinhangName;
    @Bind(R.id.img_tijian)
    ImageView imgTijian;
    @Bind(R.id.tv_tijian)
    TextView tvTijian;
    @Bind(R.id.et_Referee)
    EditText etReferee;
    @Bind(R.id.et_Type_work)
    TextView etTypeWork;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    @Bind(R.id.et_region)
    TextView etRegion;
    private List<WorkerTypeInfo.BodyBean> body;

    private List<String> wokerTypeList;
    private List<BackInfo.BodyBean> bankDataList;
    private List<String> bankList;

    private String workerzg;

    private String workerType;

    private String bankName = "";

    private String bankType;
    //银行卡选择器
    private OptionsPickerView bankPicker;
    // 工种选择器
    private OptionsPickerView workPicker;
    //地区选择器
    private OptionsPickerView regionPicker;

    private List<String> regionmlist;
    private int regionId;
    private List<RegionIdInfo.BodyBean> body1;
    private String regionName;

    @Override
    public int getLayout() {
        return R.layout.workerinfo_activity;
    }


    private void initBankPicker() {

        bankList = new ArrayList<>();

        bankDataList = new ArrayList<>();

        bankPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                bankName = bankList.get(options1);
                bankType = bankDataList.get(options1).getDiccode();
                tvYinhangTitle.setText(bankName);
            }
        }).build();


    }

    @Override
    public void initData() {


        getWorkerInfo();
        getWorkerPhotoInfo();
        getWorkerType();
        getBankCard();
        onChilker();
        initBankPicker();
        getRegionPicker();
        initWorkerType();
        getRegionId();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWorkerInfo();
    }

    private void initWorkerType() {
        wokerTypeList = new ArrayList<>();

        body = new ArrayList<>();

        workPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                workerzg = wokerTypeList.get(options1);
                workerType = body.get(options1).getMajorJob();
                tvYinhangTitle.setText(workerzg);
            }
        }).build();

    }

    private void onChilker() {
        tvYinhangTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankPicker.show();
            }
        });
        etTypeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workPicker.show();
            }
        });
        imgXingxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("点击了");
                Log.e("tag_image", idPhoto);
                startActivity(new Intent(WorkerInfoDataActivity.this, ImageShowActivity.class).putExtra("image", idPhoto).putExtra("status", idzhengjianzhao).putExtra("title", "证件照").putExtra("type", 36).putExtra("attrInfoid", idthere));

            }
        });
        imgZhengjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkerInfoDataActivity.this, ImageShowActivity.class).putExtra("image", idzizhi).putExtra("status", certificate).putExtra("title", "资质证书").putExtra("type", 14).putExtra("attrInfoid", idfour));
            }
        });
        imgShenfenZheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkerInfoDataActivity.this, ImageShowActivity.class).putExtra("image", positiveId).putExtra("status", idzheng).putExtra("title", "身份证正面").putExtra("type", 4).putExtra("attrInfoid", idone));
            }
        });
        imgShenfenFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkerInfoDataActivity.this, ImageShowActivity.class).putExtra("image", sideId).putExtra("status", idfan).putExtra("title", "身份证反面").putExtra("type", 8).putExtra("attrInfoid", idtwo));
            }
        });
        imgYinhangCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                                                                                                                                                                                             //idfive
                startActivity(new Intent(WorkerInfoDataActivity.this, ImageShowActivity.class).putExtra("image", banckpositive).putExtra("status", idyinghan).putExtra("title", "银行卡正面").putExtra("type", 9).putExtra("attrInfoid", idfive));
            }
        });
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etYinhangCode.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请输入银行卡号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请输入身份证号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etTypeWork.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请选择工种", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etRegion.getText().toString())) {
                    Toast.makeText(WorkerInfoDataActivity.this, "请选择地区", Toast.LENGTH_SHORT).show();
                    return;
                }
                JSONObject map = new JSONObject();


                try {
                    map.put("bankAccount", etYinhangCode.getText().toString());
                    map.put("bankAccountName", etAccountName.getText().toString());
                    map.put("bankType", bankType);
                    map.put("idcard", etPhone.getText().toString());
                    map.put("majorJob", workerType);
                    map.put("mobile", mobile);
                    map.put("sex", sex);
                    map.put("inductionArea", regionId);
                    map.put("workerName", App.workerInfo.getWorkerName());
                    map.put("workerid", App.workerInfo.getWorkerId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getUpadteWorInfo(map.toString());
            }
        });
        etRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionPicker.show();
            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    public void getWorkerType() {
        //http://192.168.1.170:8580/cs/a/wokersApp/selectPmWokerMajorJobs
        OkhttpUtils.doGet(ApiEngine.GONRENTYPE, null, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("bug", e.getMessage());
                        showToast(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WorkerTypeInfo workerTypeInfo = JSONUtils.toObject(string, WorkerTypeInfo.class);
                        if (workerTypeInfo.getStatusCode() == 1) {
                            List<WorkerTypeInfo.BodyBean> workerTypeInfoBody = workerTypeInfo.getBody();

                            wokerTypeList.clear();
                            body.clear();
                            for (WorkerTypeInfo.BodyBean info : workerTypeInfoBody) {
                                wokerTypeList.add(info.getMajorJobName());
                                body.add(info);
                            }
                            workPicker.setPicker(wokerTypeList);

                        } else {
                            showToast(workerTypeInfo.getStatusMsg());
                        }

                    }
                });
            }
        });
    }

    public void getBankCard() {
        OkhttpUtils.doGet(ApiEngine.WORKERBankCard, null, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("tag", e.getMessage());
                        showToast(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        BackInfo workerTypeInfo = JSONUtils.toObject(string, BackInfo.class);
                        if (workerTypeInfo.getStatusCode() == 1) {
                            List<BackInfo.BodyBean> body = workerTypeInfo.getBody();
                            bankList.clear();
                            bankDataList.clear();
                            for (BackInfo.BodyBean info : body) {
                                bankList.add(info.getDicname());
                                bankDataList.add(info);
                            }
                            bankPicker.setPicker(bankList);
                        } else {
                            showToast(workerTypeInfo.getStatusMsg());
                        }

                    }
                });
            }
        });
    }

    String sex, mobile, lutime;

    public void getWorkerInfo() {
        Map<String, Object> map = new HashMap<>();

        map.put("workerId", App.workerInfo.getWorkerId());
        OkhttpUtils.doPost(ApiEngine.WORKERSINFORMATION, map, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_info", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WorkerInfo workerInfo = JSONUtils.toObject(string, WorkerInfo.class);
                        if (workerInfo.getStatusCode() == 1) {
                            List<WorkerInfo.BodyBean> body = workerInfo.getBody();
                            String name = body.get(4).getValue();
                            String verifyState = body.get(4).getVerifyState();
                            if ("1".equals(verifyState)) {
                                etName.setEnabled(false);
                            }
                            etName.setText(name);
                            String phone = body.get(1).getValue();
                            if ("1".equals(body.get(1).getVerifyState())) {
                                etPhone.setEnabled(false);
                            }
                            etPhone.setText(phone);
                            String bankAccount = body.get(2).getValue();
                            if ("1".equals(body.get(2).getVerifyState())) {
                                etYinhangCode.setEnabled(false);
                            }
                            etYinhangCode.setText(bankAccount);
                            String openName = body.get(0).getValue();
                            if ("1".equals(body.get(0).getVerifyState())) {
                                etAccountName.setEnabled(false);
                            }
                            etAccountName.setText(openName);
                            String openbank = body.get(3).getValue();
                            tvYinhangTitle.setText(openbank);
                            if ("1".equals(body.get(3).getVerifyState())) {
                                tvYinhangTitle.setEnabled(false);
                            }
                            String typeWork = body.get(6).getValue();
                            etTypeWork.setText(typeWork);
                            if ("1".equals(body.get(6).getVerifyState())) {
                                etTypeWork.setEnabled(false);
                            }
                            for (WorkerInfo.BodyBean mlist : body) {
                                if (mlist.getName().equals("性别")) {
                                    sex = mlist.getValue();

                                }
                                if (mlist.getName().equals("电话")) {
                                    mobile = mlist.getValue();
                                }
                                if (mlist.getName().equals("录入时间")) {
                                    lutime = mlist.getValue();
                                }
                                if (mlist.getName().equals("地区")) {
                                    regionName = mlist.getValue();

                                }
                                etRegion.setText(regionName);
                            }
                        } else {
                            showToast(workerInfo.getStatusMsg());
                        }
                    }
                });
            }
        });
    }

    String idzheng, idfan, idyinghan, idzizhi, idzhengjianzhao;
    String positiveId, sideId, idPhoto = "", certificate, banckpositive;
    String idone, idtwo, idthere, idfour, idfive;

    public void getWorkerPhotoInfo() {
        Map<String, Object> hsahMap = new HashMap<>();
        hsahMap.put("workerId", App.workerInfo.getWorkerId());
        OkhttpUtils.doPost(ApiEngine.WORKERPHOTO, hsahMap, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException

            {

                final String string = response.body().string();
                Log.e("tag", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WorkerPhotoInfo photoInfo = JSONUtils.toObject(string, WorkerPhotoInfo.class);
                        int statusCode = photoInfo.getStatusCode();
                        if (statusCode == 1) {
                            List<WorkerPhotoInfo.BodyBean> body = photoInfo.getBody();
                            for (WorkerPhotoInfo.BodyBean mlist : body) {
                                String photoname = mlist.getPhotoname();
                                switch (photoname) {
                                    case "身份证正面":
                                        idzheng = mlist.getState();
                                        positiveId = mlist.getRealLocation();
                                        idone = mlist.getPhotoId();
                                        Glide.with(WorkerInfoDataActivity.this).load(positiveId).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).into(imgShenfenZheng);
                                        break;
                                    case "身份证反面":
                                        idfan = mlist.getState();
                                        sideId = mlist.getRealLocation();
                                        idtwo = mlist.getPhotoId();
                                        Glide.with(WorkerInfoDataActivity.this).load(sideId).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).into(imgShenfenFan);
                                        //img_shenfen_fan
                                        break;
                                    case "证件照":
                                        idzhengjianzhao = mlist.getState();
                                        idthere = mlist.getPhotoId();
                                        Log.e("tag_image", mlist.getRealLocation());
                                        idPhoto = mlist.getRealLocation();
                                        Glide.with(WorkerInfoDataActivity.this).load(idPhoto).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).into(imgXingxiang);
                                        break;
                                    case "资质证书":
                                        idfour = mlist.getPhotoId();
                                        idzizhi = mlist.getState();
                                        certificate = mlist.getRealLocation();
                                        Glide.with(WorkerInfoDataActivity.this).load(certificate).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).into(imgZhengjian);
                                        break;
                                    case "银行卡正面":
                                        idfive = mlist.getPhotoId();
                                        idyinghan = mlist.getState();
                                        banckpositive = mlist.getRealLocation();
                                        Glide.with(WorkerInfoDataActivity.this).load(banckpositive).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).into(imgYinhangCode);
                                        break;
                                    default:
                                        break;

                                }
                            }
                        } else {
                            showToast(photoInfo.getStatusMsg());
                        }
                    }
                });
            }
        });

    }

    public void getRegionId() {
        OkhttpUtils.doGet("https://api.dcwzg.com:9191/actionapi/apphome/GetRegionList", null, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RegionIdInfo regionIdInfo = JSONUtils.toObject(string, RegionIdInfo.class);
                        int statusCode = regionIdInfo.getStatusCode();
                        if (statusCode == 0) {
                            List<RegionIdInfo.BodyBean> body = regionIdInfo.getBody();
                            regionmlist.clear();
                            body1.clear();
                            for (RegionIdInfo.BodyBean info : body) {
                                regionmlist.add(info.getRegionName());
                                body1.add(info);
                            }
                            regionPicker.setPicker(regionmlist);
                            for (RegionIdInfo.BodyBean mlist : body1) {
                                if (mlist.getLargeAreaName().equals(App.workerInfo.getArea())) {
                                    regionId = mlist.getRegionId();
                                    break;
                                }

                            }

                        } else {
                            showToast(regionIdInfo.getStatusMsg());
                        }
                    }
                });
            }
        });
    }

    public void getUpadteWorInfo(String josn) {
        OkhttpUtils.post(ApiEngine.WORKERINFO, josn, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("tag", string);
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("statusCode");
                            if (statusCode == 1) {
                                showToast("修改成功");
                                finish();
                            } else {
                                showToast(jsonObject.getString("statusMsg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

    }

    public void getRegionPicker() {
        regionmlist = new ArrayList<>();
        body1 = new ArrayList<>();

        regionPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                regionName = regionmlist.get(options1);
                regionId = body1.get(options1).getRegionId();
                etRegion.setText(regionName);
            }
        }).build();
    }


}
