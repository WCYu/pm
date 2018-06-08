package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.PhotoShowAdapter;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.mvp.contract.ResultChatContract;
import com.rxjy.pm.mvp.presenter.ResultChatPresenter;
import com.rxjy.pm.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/28.
 */

public class ResultChatActivity extends BaseActivity<ResultChatPresenter> implements ResultChatContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_reason)
    TextView tvReason;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.mgv_gridview)
    MyGridView mgvGridview;

    private ArrayList<String> imgs;


    @Override
    public int getLayout() {

        return R.layout.activity_chatresult;
    }


    String orderid, state;

    @Override
    public void initData() {
        tvTitle.setText("洽谈结果");
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        orderid = intent.getStringExtra("orderid");
        state = intent.getStringExtra("state");
        switch (type) {
            case "no":
                tvReason.setText("未签原因");
                editText.setHint("请输入未签原因...");
                break;
            case "yes":
                tvReason.setText("已签原因");
                editText.setHint("请输入已签原因...");
                break;
        }
        imgs = new ArrayList<>();
        getimgs = new ArrayList<>();
        imgs.add("");
        ShowPhoto();
    }

    @Override
    protected ResultChatPresenter onCreatePresenter() {
        return new ResultChatPresenter(this);
    }

    PhotoShowAdapter adapter;

    private void ShowPhoto() {
        adapter = new PhotoShowAdapter(this, imgs);
        mgvGridview.setAdapter(adapter);
        mgvGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (imgs.get(position).equals("")) {
                    //选择图片
                    PictureSelector.create(ResultChatActivity.this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(9)// 最大图片选择数量 int
                            .minSelectNum(0)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(99);//结果回调onActivityResult code 
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                //请求数据提交
                String txt = editText.getText().toString();
                if (txt.isEmpty() || txt.length() < 5) {
                    showToast("请输入原因，不少于五个字符！");
                } else {
                    mPresenter.postData(orderid, txt, state, getimgs);
                }
                break;
        }
    }


    private ArrayList<String> getimgs;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            switch (requestCode) {
                case 99:
                    getimgs.clear();
                    for (int i = 0; i < localMedias.size(); i++) {
                        getimgs.add(localMedias.get(i).getCompressPath());
                    }
                    imgs.clear();
                    imgs.add("");
                    imgs.addAll(getimgs);
                    Log.e("imgs", imgs.toString());
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @Override
    public void responsepostData() {
        showToast("上传成功！");
        finish();

        ProjectDetailsActivity.instance.finish();


    }

    @Override
    public void responsepostDataError(String msg) {
        showToast("msg");
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