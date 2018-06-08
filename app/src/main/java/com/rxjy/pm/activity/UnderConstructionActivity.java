package com.rxjy.pm.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.UnderConstructionPagerAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.fragment.CraftFragment;
import com.rxjy.pm.fragment.PrepareFragment;
import com.rxjy.pm.fragment.ProcessFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class UnderConstructionActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rb_under_construction_prepare)
    RadioButton rbPrepare;
    @Bind(R.id.rb_under_construction_craft)
    RadioButton rbCraft;
    @Bind(R.id.rb_under_construction_process)
    RadioButton rbProcess;
    @Bind(R.id.rg_under_construction)
    RadioGroup rgUnderConstruction;
    @Bind(R.id.iv_under_construction_prepare)
    ImageView ivUnderConstructionPrepare;
    @Bind(R.id.iv_under_construction_craft)
    ImageView ivUnderConstructionCraft;
    @Bind(R.id.iv_under_construction_process)
    ImageView ivUnderConstructionProcess;
    @Bind(R.id.vp_under_construction)
    ViewPager vpUnderConstruction;
    @Bind(R.id.tv_under_construction_pro_name)
    TextView tvUnderConstructionProName;
    @Bind(R.id.tv_under_construction_address)
    TextView tvUnderConstructionAddress;
    @Bind(R.id.tv_under_construction_time)
    TextView tvUnderConstructionTime;
    @Bind(R.id.tv_under_construction_tip)
    TextView tvUnderConstructionTip;
    @Bind(R.id.lin_under_construction_tip)
    LinearLayout linUnderConstructionTip;

    public static final String TITLE = "开工准备";

    private List<Fragment> listFragment;

    private PrepareFragment prepareFragment;
    private CraftFragment craftFragment;
    private ProcessFragment processFragment;

    /**
     * 标题名集合
     */
    private RadioButton[] titleText = null;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_under_construction;
    }

    @Override
    public void initData() {
        initTip();
        initIntent();
        initTitle();
        initPro();
        initFragmentData();
    }

    private void initTip() {
        tvUnderConstructionTip.setText("开工一周内完成开工准备工作，如未按时间和要求完成，将无法申请款项。");
        tvUnderConstructionTip.setSelected(true);
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_UNDER_CONSTRUCTION_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPro() {
        tvUnderConstructionProName.setText(proInfo.getProName());
        tvUnderConstructionAddress.setText(proInfo.getProAddr());
        String startTime = "";
        String endTime = "";
        if (!TimeUtil.getNormalTime(proInfo.getBeginTime()).equals(""))
            startTime = TimeUtil.getNormalTime(proInfo.getBeginTime()).substring(5, 10);
        if (!TimeUtil.getNormalTime(proInfo.getBeginFinishTime()).equals(""))
            endTime = TimeUtil.getNormalTime(proInfo.getBeginFinishTime()).substring(5, 10);
        tvUnderConstructionTime.setText(startTime + " — " + endTime);
    }

    private void initFragmentData() {

        listFragment = new ArrayList<>();

        prepareFragment = new PrepareFragment();
        processFragment = new ProcessFragment();
        craftFragment = new CraftFragment();

        listFragment.add(prepareFragment);
        listFragment.add(processFragment);
        listFragment.add(craftFragment);

        prepareFragment.setProInfo(proInfo);
        processFragment.setProInfo(proInfo);
        craftFragment.setProInfo(proInfo);

        titleText = new RadioButton[]{rbPrepare, rbProcess, rbCraft};

        FragmentManager fm = getSupportFragmentManager();
        UnderConstructionPagerAdapter fragmentPagerAdapter = new UnderConstructionPagerAdapter(fm, listFragment);
        vpUnderConstruction.setAdapter(fragmentPagerAdapter);
        //设置页面切换监听
        vpUnderConstruction.setOnPageChangeListener(this);
        //设置维护两页
        vpUnderConstruction.setOffscreenPageLimit(2);
        //设置初始化选中状态
        rbPrepare.setChecked(true);
        //设置监听事件
        rgUnderConstruction.setOnCheckedChangeListener(this);

    }

    /**
     * 切换更换下划线状态
     *
     * @param position
     */
    private void setVisible(int position) {
        switch (position) {
            case 0:
                ivUnderConstructionPrepare.setImageResource(R.mipmap.prepare_pressed_icon);
                ivUnderConstructionProcess.setImageResource(R.mipmap.process_normal_icon);
                ivUnderConstructionCraft.setImageResource(R.mipmap.craft_normal_icon);
                break;
            case 1:
                ivUnderConstructionPrepare.setImageResource(R.mipmap.prepare_normal_icon);
                ivUnderConstructionProcess.setImageResource(R.mipmap.process_pressed_icon);
                ivUnderConstructionCraft.setImageResource(R.mipmap.craft_normal_icon);
                break;
            case 2:
                ivUnderConstructionPrepare.setImageResource(R.mipmap.prepare_normal_icon);
                ivUnderConstructionProcess.setImageResource(R.mipmap.process_normal_icon);
                ivUnderConstructionCraft.setImageResource(R.mipmap.craft_pressed_icon);
                break;
        }
    }

    /**
     * 设置选中图标的文字颜色与
     * 下划线可见
     *
     * @param index
     */
    private void changeIndexView(int index) {
        for (int i = 0; i < titleText.length; i++) {
            titleText[i].setChecked(false);
        }
        if (index < titleText.length) {
            titleText[index].setChecked(true);
        }

    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeIndexView(position);
        setVisible(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_under_construction_prepare:
                vpUnderConstruction.setCurrentItem(0);
                break;
            case R.id.rb_under_construction_process:
                vpUnderConstruction.setCurrentItem(1);
                break;
            case R.id.rb_under_construction_craft:
                vpUnderConstruction.setCurrentItem(2);
                break;
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_under_construction_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_under_construction_cancel:
                linUnderConstructionTip.setVisibility(View.GONE);
                break;
        }
    }
}
