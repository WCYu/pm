package com.rxjy.pm.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.rxjy.pm.R;
import com.rxjy.pm.adapter.MyViewPagerAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/20.
 */

public class PhotoImageActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.imgs_viewpager)
    ViewPager imgsViewpager;
    @Bind(R.id.img_browse_back)
    ImageView imgBrowseBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;


    @Override
    public int getLayout() {
        return R.layout.photo_item;
    }

    @Override
    public void initData() {
        ivBack.setVisibility(View.VISIBLE);
        List<String> imagee = getIntent().getStringArrayListExtra(Constants.JUMPLIST);
        int intExtra = getIntent().getIntExtra(Constants.INDEXES, 0);
        String stringExtra = getIntent().getStringExtra(Constants.TITLE);
        tvTitle.setText(stringExtra);
        imgsViewpager = (ViewPager) this.findViewById(R.id.imgs_viewpager);
        imgsViewpager.setOffscreenPageLimit(2);
        PagerAdapter adapter = new MyViewPagerAdapter(this, imagee);
        imgsViewpager.setAdapter(adapter);
        imgsViewpager.setCurrentItem(intExtra);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

}
