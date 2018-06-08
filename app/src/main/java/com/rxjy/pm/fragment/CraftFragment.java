package com.rxjy.pm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.CraftDetailActivity;
import com.rxjy.pm.adapter.CraftAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.CraftInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.CraftContract;
import com.rxjy.pm.mvp.presenter.CraftPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/24.
 */

public class CraftFragment extends BaseFragment<CraftPresenter> implements CraftContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.lv_craft)
    ListView lvCraft;

    private List<CraftInfo.Craft> craftList;

    private CraftAdapter mAdapter;

    private ProjectInfo.Project proInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_craft;
    }

    @Override
    protected void FragmentInitData() {
        initCraftData();
    }

    private void initCraftData() {

        craftList = new ArrayList<>();

        mAdapter = new CraftAdapter(getActivity(), craftList);

        lvCraft.setAdapter(mAdapter);

        lvCraft.setOnItemClickListener(this);

    }

    public void setProInfo(ProjectInfo.Project data) {
        proInfo = data;
    }

    @Override
    protected CraftPresenter onCreatePresenter() {
        return new CraftPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取工艺列表接口
        mPresenter.getCraftList(proInfo.getOrderNo());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responseCraftListData(List<CraftInfo.Craft> dataList) {
        craftList.clear();
        craftList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseCraftListDataError(String msg) {
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CraftInfo.Craft info = craftList.get(position);
        Intent intent = new Intent(getActivity(), CraftDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_CRAFT_DETAIL_CRAFT_ID, info.getCraft_id());
        startActivity(intent);

    }

}
