package com.rxjy.pm.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

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

/**
 * Created by AAA on 2017/8/24.
 */

public class PrepareFragment extends BaseFragment<ProcessPresenter> implements ProcessContract.View, ExpandableListView.OnChildClickListener {

    @Bind(R.id.tv_prepare_tip)
    TextView tvTip;
    @Bind(R.id.elv_prepare)
    ExpandableListView elvPrepare;

    private List<ProcessInfo.ProcessGroup> processList;

    private ProcessAdapter mAdapter;

    private ProjectInfo.Project proInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_prepare;
    }

    @Override
    protected void FragmentInitData() {
        initTip();
        initPrepareData();
    }

    private void initTip() {

    }

    private void initPrepareData() {

        processList = new ArrayList<>();

        mAdapter = new ProcessAdapter(getActivity(), processList);

        elvPrepare.setAdapter(mAdapter);

        elvPrepare.setOnChildClickListener(this);
        //设置只能打开一个分组
//        elvPrepare.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                int count = elvPrepare.getExpandableListAdapter().getGroupCount();
//                for(int j = 0; j < count; j++){
//                    if(j != groupPosition){
//                        elvPrepare.collapseGroup(j);
//                    }
//                }
//            }
//        });

    }

    public void setProInfo(ProjectInfo.Project data) {
        proInfo = data;
    }

    @Override
    protected ProcessPresenter onCreatePresenter() {
        return new ProcessPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取准备列表
        mPresenter.getProcessList(proInfo.getOrderNo(), 0);
    }



    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        ProcessInfo.ProcessGroup.ProcessChild info = processList.get(groupPosition).getList().get(childPosition);
        Intent intent = new Intent(getActivity(), ProcessDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PROCESS_DETAIL_PROCESS_ID, info.getProcess_id());
        startActivity(intent);
        return false;
    }

    @Override
    public void responseProcessListData(List<ProcessInfo.ProcessGroup> dataList) {
        processList.clear();
        processList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        elvPrepare.expandGroup(0);
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
}
