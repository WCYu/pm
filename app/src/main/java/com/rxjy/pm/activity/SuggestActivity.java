package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.SuggestAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.mvp.contract.SuggestContract;
import com.rxjy.pm.mvp.presenter.SuggestPresenter;
import com.rxjy.pm.pop.SuggestPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuggestActivity extends BaseActivity<SuggestPresenter> implements AdapterView.OnItemClickListener, SuggestContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_suggest)
    EditText etSuggest;
    @Bind(R.id.gv_suggest)
    GridView gvSuggest;
    @Bind(R.id.iv_arrow)
    ImageView ivArrow;

    private List<LocalMedia> imgList;

    private SuggestAdapter mAdapter;

    private SuggestPop popSuggest;

    private int type = 1;

    @Override
    public int getLayout() {
        return R.layout.activity_suggest;
    }

    @Override
    public void initData() {
        initTitle();
        initPop();
        initPicture();
    }

    private void initTitle() {
        tvTitle.setText("投诉");
    }

    private void initPop() {

        popSuggest = new SuggestPop(this, R.layout.pop_suggest, AutoUtils.getDisplayWidthValue(120), AutoUtils.getDisplayHeightValue(160));

        popSuggest.setOnSuggestClickListener(new SuggestPop.OnSuggestClickListener() {
            @Override
            public void complain() {
                tvTitle.setText("投诉");
                type = 1;
            }

            @Override
            public void suggest() {
                tvTitle.setText("建议");
                type = 2;
            }

        });

    }

    private void initPicture() {

        imgList = new ArrayList<>();

        mAdapter = new SuggestAdapter(this, imgList);

        gvSuggest.setAdapter(mAdapter);

        gvSuggest.setOnItemClickListener(this);

    }

    @Override
    protected SuggestPresenter onCreatePresenter() {
        return new SuggestPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (imgList != null) {
            if (imgList.size() > 0) {
                if (!(imgList.get(imgList.size() - 1).getCompressPath() == null)) {
                    imgList.add(new LocalMedia());
                }
            } else {
                imgList.add(new LocalMedia());
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    imgList.clear();
                    imgList.addAll(localMedias);
                    imgList.add(new LocalMedia());
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.btn_submit, R.id.iv_arrow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                String content = etSuggest.getText().toString().trim();
                if (content.equals("")) {
                    showToast("请输入投诉内容");
                    return;
                }
                imgList.remove(imgList.size() - 1);
                mPresenter.subSuggestInfo(App.pmUserInfo.getUid(), type, content, imgList);
                break;
            case R.id.iv_arrow:
                popSuggest.showPop(ivArrow);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == imgList.size() - 1) {
            if (imgList.size() != 0) {
                imgList.remove(imgList.size() - 1);
            }
            // 进入相册 以下是例子：用不到的api可以不写
            PictureSelector.create(this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .imageSpanCount(3)// 每行显示个数 int
                    .maxSelectNum(5)// 最大图片选择数量 int
                    .minSelectNum(1)// 最小选择数量 int
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .compress(true)// 是否压缩 true or fals
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .selectionMedia(imgList)
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
        } else {
            imgList.remove(imgList.size() - 1);
            PictureSelector.create(this).externalPicturePreview(position, imgList);
        }
    }

    @Override
    public void responseSuggestData() {
        showToast("提交成功");
        finish();
    }

    @Override
    public void responseSuggestDataError(String msg) {
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
}
