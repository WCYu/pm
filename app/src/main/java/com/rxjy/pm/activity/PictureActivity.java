package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.PictrueAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.PictureContract;
import com.rxjy.pm.mvp.presenter.PicturePresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/26.
 */

public class PictureActivity extends BaseActivity<PicturePresenter> implements PictureContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.picture_list)
    GridView pictureList;
    private ProjectInfo.Project proInfo;
    private ArrayList<String> mlist;
    private PictrueAdapter pictrueAdapter;
    private String stringExtra;

    @Override
    public int getLayout() {
        return R.layout.activity_picture;
    }

    @Override
    public void initData() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
        mlist=new ArrayList<>();
        pictrueAdapter = new PictrueAdapter(this, mlist);

        pictureList.setAdapter(pictrueAdapter);
        stringExtra = getIntent().getStringExtra(Constants.TITLE);
        tvTitle.setText(stringExtra);
        boolean booleanExtra = getIntent().getBooleanExtra(Constants.PICTUREMARK, false);
        if(booleanExtra){
            mPresenter.getConstructionPicture(proInfo.getOrderNo());
        }else {
            mPresenter.getEffectPicture(proInfo.getOrderNo());
        }
        pictureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(PictureActivity.this, PhotoImageActivity.class);
                intent.putExtra(Constants.INDEXES,position);
                intent.putExtra(Constants.TITLE,stringExtra);
                intent.putStringArrayListExtra(Constants.JUMPLIST,mlist);
                startActivity(intent);
            }
        });



    }

    @Override
    protected PicturePresenter onCreatePresenter() {
        return new PicturePresenter(this);
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
    public void responseEffect(List<String> data) {
        mlist.clear();
        mlist.addAll(data);
        pictrueAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseConstruction(List<String> data) {

        mlist.clear();
        mlist.addAll(data);
        pictrueAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
