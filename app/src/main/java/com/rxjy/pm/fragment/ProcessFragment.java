package com.rxjy.pm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.ProcessDetailActivity;
import com.rxjy.pm.adapter.ProcessAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.ProcessInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.ProcessContract;
import com.rxjy.pm.mvp.presenter.ProcessPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/24.
 */

public class ProcessFragment extends BaseFragment<ProcessPresenter> implements ProcessContract.View, ExpandableListView.OnChildClickListener {

    @Bind(R.id.elv_process)
    ExpandableListView elvProcess;

    private List<ProcessInfo.ProcessGroup> processList;

    private ProcessAdapter mAdapter;

    private ProjectInfo.Project proInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_process;
    }

    @Override
    protected void FragmentInitData() {
        initProcessData();
    }

    private void initProcessData() {

        processList = new ArrayList<>();

        mAdapter = new ProcessAdapter(getActivity(), processList);

        elvProcess.setAdapter(mAdapter);

        elvProcess.setOnChildClickListener(this);

    }

    public void setProInfo(ProjectInfo.Project data) {
        proInfo = data;
    }

    @Override
    protected ProcessPresenter onCreatePresenter() {
        return new ProcessPresenter(this);
    }

    @Override
    public void responseProcessListData(List<ProcessInfo.ProcessGroup> dataList) {
        processList.clear();
        processList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProcessListDataError(String msg) {
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
    public void onResume() {
        super.onResume();
        //获取工序列表
        mPresenter.getProcessList(proInfo.getOrderNo(), 1);
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
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        ProcessInfo.ProcessGroup.ProcessChild info = processList.get(groupPosition).getList().get(childPosition);
        Intent intent = new Intent(getActivity(), ProcessDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PROCESS_DETAIL_PROCESS_ID, info.getProcess_id());
        startActivity(intent);
        return false;
    }
}
