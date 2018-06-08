package com.rxjy.pm.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.GridViewAddImgesAdpter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.BarcGaningContract;
import com.rxjy.pm.mvp.presenter.BarcGaningPresenter;
import com.rxjy.pm.widget.CustomeGridView;
import com.rxjy.pm.widget.GlideRoundTransform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/16.
 */

public class BarGainingActivity extends BaseActivity<BarcGaningPresenter>  implements BarcGaningContract.View{

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.gw)
    CustomeGridView gw;
    @Bind(R.id.reason_)
    EditText reason;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.submit)
    Button submit;
    private int CAMERA_INFO_IDENTIFICATION_PHOTO = 1000;
    private List<Map<String, Object>> datas;
    private GridViewAddImgesAdpter gridViewAddImgesAdpter;
    private ProjectInfo.Project proInfo;
    @Override
    public int getLayout() {
        return R.layout.bargaining_activity;
    }

    @Override
    public void initData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        datas=new ArrayList<>();
        gridViewAddImgesAdpter = new GridViewAddImgesAdpter(datas,this);
        gw.setAdapter(gridViewAddImgesAdpter);
        tvTitle.setText("议价");
        options = new RequestOptions();
        options.centerCrop().transform(new GlideRoundTransform(this, 6));
        gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PictureSelector.create(BarGainingActivity.this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .maxSelectNum(20)// 最大图片选择数量 int
                        .minSelectNum(1)// 最小选择数量 int
                        .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .compress(true)// 是否压缩 true or fals
                        .isCamera(true)// 是否显示拍照按钮 true or false
                        .forResult(CAMERA_INFO_IDENTIFICATION_PHOTO);//结果回调onActivityResult code 
            }
        });
    }

    @Override
    protected BarcGaningPresenter onCreatePresenter() {
        return new BarcGaningPresenter(this);
    }

    RequestOptions options;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_INFO_IDENTIFICATION_PHOTO) {

            //icCardUpUrl = localMedias.get(0).getPath();
            if (data != null) {
                // 得到图片的全路径
             //   Uri uri = data.getData();
                List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                for (int i = 0; i <localMedias.size() ; i++) {
                    photoPath(localMedias.get(i).getCompressPath());
                }

                //uploadImage(path);
            }
        }

    }

    @OnClick({R.id.iv_back, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.submit:
                closeKeyboard();
                String content = reason.getText().toString();
                List<String> list=new ArrayList();
                for (int i = 0; i <datas.size() ; i++) {
                    Map<String, Object> map = datas.get(i);
                    Set<String> strings = map.keySet();
                    for (String key:strings) {
                        list.add(map.get(key)+"");
                    }
                }
                if(!content.equals("")&&datas.size()!=0){
                    mPresenter.getProjectManager(proInfo.getOrderNo(), App.pmUserInfo.getUid(), 3,content,list );
            }
        }
    }
    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void photoPath(String path) {
        Map<String,Object> map=new HashMap<>();
        map.put("path",path);
        datas.add(map);
        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    @Override
    public void showDialog() {
      showLoading();
    }

    @Override
    public void hideDialog() {
  dismissLoading();
    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }

    @Override
    public void getSuccessfulOperation() {
     finish();
    }
}
