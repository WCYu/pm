package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.api.ApiEngine;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.StringUtils;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.mvp.contract.ImageShowContract;
import com.rxjy.pm.mvp.presenter.ImageShowPresenter;
import com.rxjy.pm.widget.OkhttpUtils;
import com.rxjy.pm.widget.PinchImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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

/**
 * Created by hjh on 2018/2/24.
 */

public class ImageShowActivity extends BaseActivity<ImageShowPresenter> implements ImageShowContract.View {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_text)
    TextView tvText;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.vp_imgs)
    ViewPager vpImgs;

    private String aid, uid, mid;
    private String[] split;
    private String path;
    private String imgUrl;
    private String imgName;
    private StringBuffer urlBuffer;
    private StringBuffer imgBuffer;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_imgshow;
    }

    private ArrayList<UploadInfo.Upload.PhotoInfo> imglists;

    String title;

    @Override
    public void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tvTitle.setText(title);
        urlBuffer = new StringBuffer();
        imgBuffer = new StringBuffer();
        tvText.setText("替换图片");
        String image = getIntent().getStringExtra("image");
        Log.e("image",image);
        split = image.split(";");
//        imglists = (ArrayList<UploadInfo.Upload.PhotoInfo>) intent.getSerializableExtra("images");
//        Log.e("传过来的数据是：", imglists.toString());
        views = new ArrayList<>();
        initVpData(0, imglists);
        type = getIntent().getIntExtra("type", 0);
        if (type == 106) {
            String arrInfoid = getIntent().getStringExtra("arrInfoid");
//            getIntent()
        }
        String status = getIntent().getStringExtra("status");
        if (status.equals("1")) {
            tvText.setVisibility(View.GONE);
        } else {
            tvText.setVisibility(View.VISIBLE);
        }
    }


    int positions = 0;

    private void initVpData(int nowitem, final ArrayList<UploadInfo.Upload.PhotoInfo> imglist) {
        tvTitle.setText(title + "(" + (nowitem + 1) + "/" + split.length + ")");
        views.clear();

//        for (int i = 0; i < imglist.size(); i++) {
//            if (!StringUtils.isEmpty(imglist.get(i).getPhotoUrl())) {
        for (int i = 0; i < split.length; i++) {
            PinchImageView piv = new PinchImageView(this);
//                piv.setScaleType(ImageView.ScaleType.CENTER);
            piv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(this).load(split[i]).into(piv);
            views.add(piv);
        }
        if (App.pmUserInfo == null) {

        } else {
            this.uid = App.pmUserInfo.getUid() + "";
        }


        myPagerAdapter = new MyPagerAdapter(views);
        vpImgs.setAdapter(myPagerAdapter);

        vpImgs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvTitle.setText(title + "(" + (position + 1) + "/" + split.length + ")");
                positions = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    protected ImageShowPresenter onCreatePresenter() {
        return new ImageShowPresenter(this);
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

    MyPagerAdapter myPagerAdapter;
    ArrayList<View> views = new ArrayList<>();


    @OnClick({R.id.iv_back, R.id.tv_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_text:
                setImg(getIntent().getIntExtra("type", 0));
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            switch (requestCode) {
                case 4:
                    path = localMedias.get(0).getCutPath();
                    setWorkerImgUrl(path, type + "");
                    break;
                case 8:
                    path = localMedias.get(0).getCutPath();
                    setWorkerImgUrl(path, type + "");
                    break;
                case 9:
                    path = localMedias.get(0).getCutPath();
                    setWorkerImgUrl(path, type + "");
                    break;
                case 36:
                    path = localMedias.get(0).getCutPath();
                    setWorkerImgUrl(path, type + "");
                    break;
                case 14:
                    path = localMedias.get(0).getCutPath();
                    setWorkerImgUrl(path, type + "");
                    break;
                case 101:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    setImgUrl(path, "40", 0, 0);
                    break;
                case 102:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    setImgUrl(path, "4", 0, 0);
                    break;
                case 103:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    setImgUrl(path, "4", 0, 0);
                    break;
                case 104:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    setImgUrl(path, "8", 0, 0);
                    break;
                case 105:
                    // 图片选择结果回调
                    path = localMedias.get(0).getCutPath();
                    Log.e("lag_图片上传", path);
                    setImgUrl(path, "9", 0, 0);
                    break;
                case 106:
                    // 图片选择结果回调
                    path = localMedias.get(localMedias.size() - 1).getCompressPath();
                    Log.e("lag_图片上传", path);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < localMedias.size(); i++) {
                        setImgUrl(localMedias.get(i).getCompressPath(), "19", i, localMedias.size() - 1);
                        if (i == localMedias.size() - 1) {
                            stringBuffer.append(localMedias.get(i).getCompressPath());
                        } else {
                            stringBuffer.append(localMedias.get(i).getCompressPath() + ";");
                        }
                    }

                    path = stringBuffer.toString();
                    showDialog();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            setAllImg();
                        }
                    }, 3000);// 设定指定的时间time,此处为2000毫秒
                    setProgressDialog(3000);
                    break;
            }
            split = path.split(";");
            views.clear();
            Log.e("tag_图片数量", split.length + "");
            for (int i = 0; i < split.length; i++) {
                PinchImageView piv = new PinchImageView(this);
//                piv.setScaleType(ImageView.ScaleType.CENTER);
                piv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Glide.with(this).load(split[i]).into(piv);
                views.add(piv);
                Log.e("tag---ImageShow", split[i]);
            }
            tvTitle.setText(title + "(" + (0 + 1) + "/" + split.length + ")");
            vpImgs.setAdapter(new MyPagerAdapter(views));

        }
    }

    public void setImgUrl(String path, final String type, final int i, final int code) {
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

                            if (106 == getIntent().getIntExtra("type", 0)) {
                                Log.e("tag_图片上传", "106入职资料");
                                urlBuffer.append(imgUrl + ";");
                                imgBuffer.append(imgName + ";");
                                Log.e("tag_图片上传", urlBuffer.toString());
                            } else {
                                setRuZhiImg(imgUrl, imgName, type);
                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void setWorkerImgUrl(String path, final String type) {
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
                            setWorkerRuZhiImg(imgUrl, imgName, type);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void setAllImg() {
        if (urlBuffer.toString() != null) {
            Log.e("tag_体检图片", "开始");
            Map map = new HashMap();
            map.put("uid", App.pmUserInfo.getUid());
            map.put("attrModelid", "19");
            map.put("userType", "1");
            String[] strings = urlBuffer.toString().split(";");
            for (int i = 0; i < strings.length; i++) {
                Log.e("tag_体检图片", strings[i]);
            }
            map.put("attrServerUrl", urlBuffer.toString());
            Log.e("tag_体检图片", urlBuffer.toString() + "");
            map.put("attrFileUrl", imgBuffer.toString());
            Log.e("tag_体检图片", imgBuffer.toString());
            OkhttpUtils.doGet(ApiEngine.ALLIMGURL, map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("tag_体检图片", e.getMessage().toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.e("tag_体检图片", string);
                }
            });
            Log.e("tag_体检图片", "结束");
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

    private void setWorkerRuZhiImg(String imgUrl, String imgName, String type) {

        String attrInfoid = getIntent().getStringExtra("attrInfoid");
        JSONObject jsonObject = new JSONObject();
        Log.e("tag666", type + "");
        try {
            jsonObject.put("uid", App.workerInfo.getWorkerId());
            jsonObject.put("attrModelid", type);
            jsonObject.put("attrServerUrl", imgUrl);
            jsonObject.put("attrFileUrl", imgName);
            jsonObject.put("attrInfoid", attrInfoid);
            jsonObject.put("usertype", 5);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        OkhttpUtils.post(ApiEngine.WORKERUPDATEPHOTO, jsonObject.toString(), new Callback() {
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
    public void responseupdateiconData(String url) {
        showToast("上传成功！");
        //改变状态
        UploadInfoActivity.absuld.picupdate = "1";
        imglists.get(positions).setPhotoUrl(url);
//        initVpData(positions,imglists);
//        finish();
    }

    @Override
    public void responseupdateiconDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }


    private class MyPagerAdapter extends PagerAdapter {

        private ArrayList<View> viewslists;

        private int size;

        public MyPagerAdapter(ArrayList<View> viewslists) {
            this.viewslists = viewslists;
            size = viewslists == null ? 0 : viewslists.size();
        }

        public void setViewslists(ArrayList<View> viewslists) {
            this.viewslists = viewslists;
            size = viewslists == null ? 0 : viewslists.size();
        }

        public void finishUpdate(View arg0) {
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewslists.get(position % size));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewslists.get(position % size), 0);
            return viewslists.get(position % size);
        }
    }
}
