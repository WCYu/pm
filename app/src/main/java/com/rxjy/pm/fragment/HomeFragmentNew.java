package com.rxjy.pm.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.AddActivity;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.commons.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.rxjy.pm.R.id.iv_add;

/**
 * Created by hjh on 2018/2/27.
 */

public class HomeFragmentNew extends BaseFragment {

    @Bind(iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_project)
    TextView tvProject;
    @Bind(R.id.tv_customer)
    TextView tvCustomer;
    @Bind(R.id.fl_mains)
    FrameLayout flMain;
    @Bind(R.id.ll_top)
    LinearLayout llTop;
    @Bind(R.id.Customer_telephone)
    ImageView CustomerTelephone;

    private Fragment currentFragment;

    private final int Home_Fragment = 0;
    private final int Customer_Fragment = 1;

    //碎片的集合
    private List<Fragment> fragmentList;

    private HomeFragment homeFragment;
    private CustomerFragment customerFragment;
    private AlertDialog dialog;
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_homenew;
    }


    @Override
    protected void FragmentInitData() {
        Log.e("新的", "新的fragment");
        initFragment();
        int departId = App.personnelInfo.getDepartId();
        createDialog();
        showFragment(fragmentList.get(Home_Fragment), Home_Fragment);
    }


    private void initFragment() {
        //初始化碎片
        if (homeFragment == null)
            homeFragment = new HomeFragment();
        if (customerFragment == null)
            customerFragment = new CustomerFragment();

        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(homeFragment);
        fragmentList.add(customerFragment);
//

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {

        } else {
            customerFragment.Refreshs();
        }
    }

    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        ShowTop(position);
        JumpFragment(fragment);
    }

    private void ShowTop(int position) {
        switch (position) {
            case Home_Fragment:
                llTop.setBackgroundResource(R.mipmap.choosebg_left);
                tvProject.setTextColor(this.getResources().getColor(R.color.colorWhite));
                tvCustomer.setTextColor(this.getResources().getColor(R.color.colorPrimary));
                ivAdd.setVisibility(View.GONE);
                CustomerTelephone.setVisibility(View.VISIBLE);
                break;
            case Customer_Fragment:
                llTop.setBackgroundResource(R.mipmap.choosebg_right);
                tvProject.setTextColor(this.getResources().getColor(R.color.colorPrimary));
                tvCustomer.setTextColor(this.getResources().getColor(R.color.colorWhite));
                ivAdd.setVisibility(View.VISIBLE);
                CustomerTelephone.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_mains, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({iv_add, R.id.tv_project, R.id.tv_customer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case iv_add:
                startActivity(new Intent(getActivity(), AddActivity.class));
                break;
            case R.id.tv_project:
                showFragment(fragmentList.get(Home_Fragment), Home_Fragment);
                ivAdd.setVisibility(View.GONE);
                CustomerTelephone.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_customer:
                showFragment(fragmentList.get(Customer_Fragment), Customer_Fragment);
                ivAdd.setVisibility(View.VISIBLE);
                CustomerTelephone.setVisibility(View.GONE);
                break;
        }
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer, null);
        builder.setView(inflate);
        TextView cancel= (TextView) inflate.findViewById(R.id.cancel);
        TextView Determine = (TextView) inflate.findViewById(R.id.Determine);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.intent.action.CALL", Uri.parse("tel:"+"010-86666886"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog = builder.create();


    }

    @OnClick(R.id.Customer_telephone)
    public void onViewClicked() {
        dialog.show();
    }
}