package com.rxjy.pm.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.CheckPermissionsUitl;
import com.rxjy.pm.commons.utils.DownLoadApk;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.entity.IconInfo;
import com.rxjy.pm.entity.VersionInfo;
import com.rxjy.pm.fragment.FindFragment;
import com.rxjy.pm.fragment.HomeFragment;
import com.rxjy.pm.fragment.HomeFragmentNew;
import com.rxjy.pm.fragment.MineFragment;
import com.rxjy.pm.fragment.MoreFragment;
import com.rxjy.pm.fragment.WorkerHomeFragment;
import com.rxjy.pm.fragment.WorkerMinFragment;
import com.rxjy.pm.fragment.WorkerMoreFragment;
import com.rxjy.pm.mvp.contract.MainContract;
import com.rxjy.pm.mvp.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class NjjActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.iv_tab_home)
    ImageView ivTabHome;
    @Bind(R.id.tv_tab_home)
    TextView tvTabHome;
    @Bind(R.id.rl_tab_home)
    RelativeLayout rlTabHome;
    @Bind(R.id.iv_tab_wallet)
    ImageView ivTabWallet;
    @Bind(R.id.tv_tab_wallet)
    TextView tvTabWallet;
    @Bind(R.id.rl_tab_wallet)
    RelativeLayout rlTabWallet;
    @Bind(R.id.iv_tab_find)
    ImageView ivTabFind;
    @Bind(R.id.tv_tab_find)
    TextView tvTabFind;
    @Bind(R.id.rl_tab_find)
    RelativeLayout rlTabFind;
    @Bind(R.id.iv_tab_mine)
    ImageView ivTabMine;
    @Bind(R.id.tv_tab_mine)
    TextView tvTabMine;
    @Bind(R.id.rl_tab_mine)
    RelativeLayout rlTabMine;
    //工人标记
    private final int Worker_Sign=4;
    //经理标记
    private final int Manager_Sign=1;
    private Fragment currentFragment;

    private int[] iconNormal = new int[]{
            R.mipmap.home_normal,
            R.mipmap.more_normal,
            R.mipmap.find_normal,
            R.mipmap.mine_normal
    };

    private int[] iconPressed = new int[]{
            R.mipmap.home_pressed,
            R.mipmap.more_pressed,
            R.mipmap.find_pressed,
            R.mipmap.mine_pressed
    };

    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int MORE_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;

    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;

    private HomeFragmentNew homeFragmentnew;
    private HomeFragment homeFragment;
    private MoreFragment moreFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;

    private WorkerHomeFragment workerHomeFragment;
    private WorkerMoreFragment workerMoreFragment;
    private WorkerMinFragment workerMinFragment;
    //检测权限列表
    private String[] requestPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE
    };

    @Override
    public int getLayout() {
        return R.layout.activity_njj;
    }

    @Override
    public void initData() {
        initIcon();
        initFragment();
        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
        //权限检测
        CheckPermissionsUitl.checkPermissions(this, requestPermissions);
        Log.e("hjhces","测试");
        mPresenter.getVersionInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initFragment() {
        //判断是工人还是经理模块

        //int type = intent.getIntExtra("type", 0);
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();

        if (findFragment == null)
            findFragment = new FindFragment();

        if(PrefUtils.getIntFlag(this, Constants.FLAG)==Manager_Sign||PrefUtils.getIntFlag(this, Constants.FLAG)==20001||PrefUtils.getIntFlag(this, Constants.FLAG)==20002){
            //初始化碎片
            if(App.pmUserInfo.getUser_join_state()>0){
                if (homeFragmentnew == null)
                    homeFragmentnew = new HomeFragmentNew();
            }else{
                if (homeFragment == null)
                    homeFragment = new HomeFragment();
            }
            if (moreFragment == null)
                moreFragment = new MoreFragment();
            if (mineFragment == null)
                mineFragment = new MineFragment();

            //将碎片添加到集合中
            if(App.pmUserInfo.getUser_join_state()>0){
                fragmentList.add(homeFragmentnew);
            }else{
                fragmentList.add(homeFragment);
            }

            fragmentList.add(moreFragment);
            fragmentList.add(findFragment);
            fragmentList.add(mineFragment);

        }else if(PrefUtils.getIntFlag(this, Constants.FLAG)==Worker_Sign){
            if(workerHomeFragment==null){
                workerHomeFragment=new WorkerHomeFragment();
            }
            if(workerMoreFragment==null){
                workerMoreFragment=new WorkerMoreFragment();
            }
            if(workerMinFragment==null){
                workerMinFragment=new WorkerMinFragment();
            }
            //将碎片添加到集合中

            fragmentList.add(workerHomeFragment);
            fragmentList.add(workerMoreFragment);
            fragmentList.add(findFragment);
            fragmentList.add(workerMinFragment);

        }

    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(ivTabHome, tvTabHome));
        iconList.add(new IconInfo(ivTabWallet, tvTabWallet));
        iconList.add(new IconInfo(ivTabFind, tvTabFind ));
        iconList.add(new IconInfo(ivTabMine, tvTabMine ));
    }

    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);
        setIcon(position);
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_main, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
    }

    /**
     * 设置图标点击效果
     *
     * @param position
     */
    private void setIcon(int position) {
        for (int i = 0; i < iconList.size(); i++) {
            iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.colorGrayDark));
        }
        iconList.get(position).getImageView().setImageResource(iconPressed[position]);
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.colorPrimary));
    }


    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }


    @OnClick({R.id.rl_tab_home, R.id.rl_tab_wallet, R.id.rl_tab_find, R.id.rl_tab_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_tab_home:
                showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
                break;
            case R.id.rl_tab_wallet:
                showFragment(fragmentList.get(MORE_FRAGMENT), MORE_FRAGMENT);
                break;
            case R.id.rl_tab_find:
                showFragment(fragmentList.get(FIND_FRAGMENT), FIND_FRAGMENT);
                break;
            case R.id.rl_tab_mine:
                showFragment(fragmentList.get(MINE_FRAGMENT), MINE_FRAGMENT);
                break;
        }
    }

    @Override
    public void responseVersionData(final VersionInfo.Version data) {

        if (data.getVersionNo() > Integer.parseInt(App.getVersionCode())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("版本升级");
            builder.setCancelable(false);// 设置点击屏幕Dialog不消失
            builder.setMessage(data.getContent());
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownLoadApk downLoadApk = new DownLoadApk(NjjActivity.this);
                    downLoadApk.downLoadApk(data);
                }
            });
            builder.setNegativeButton("取消", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void responseVersionDataError(String msg) {
        showToast(msg);
    }
}
