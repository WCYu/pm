package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.MsgDetailActivity;
import com.rxjy.pm.adapter.MsgListAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.MsgListInfo;
import com.rxjy.pm.mvp.contract.MsgListContract;
import com.rxjy.pm.mvp.presenter.MsgListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MsgListActivity extends BaseActivity<MsgListPresenter> implements MsgListContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_msg_list)
    ListView lvMsgList;

    private List<MsgListInfo.MsgList> msgList;

    private MsgListAdapter mAdapter;

    private int typeID;

    private String title;

    @Override
    public int getLayout() {
        return R.layout.activity_msg_list;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMsgList();
    }

    private void initIntent() {
        typeID = getIntent().getIntExtra(Constants.ACTION_TO_MSG_LIST_TYPE_ID, 0);
        title = getIntent().getStringExtra(Constants.ACTION_TO_MSG_LIST_TITLE);
    }

    private void initTitle() {
        tvTitle.setText(title);
    }

    private void initMsgList() {

        msgList = new ArrayList<>();

        mAdapter = new MsgListAdapter(this, msgList);

        lvMsgList.setAdapter(mAdapter);

        lvMsgList.setOnItemClickListener(this);

    }

    @Override
    protected MsgListPresenter onCreatePresenter() {
        return new MsgListPresenter(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getMsgList(App.pmUserInfo.getUid(), typeID);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MsgListInfo.MsgList info = this.msgList.get(position);
        Intent intent = new Intent(this, MsgDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_MSG_DETAIL_TS_ID, info.getTs_id());
        startActivity(intent);
    }

    @Override
    public void responseMsgListData(List<MsgListInfo.MsgList> dataList) {
        msgList.clear();
        msgList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMsgListDataError(String msg) {
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
