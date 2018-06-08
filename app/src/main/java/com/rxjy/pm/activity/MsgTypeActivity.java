package com.rxjy.pm.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.adapter.MsgTypeAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.MsgTypeInfo;
import com.rxjy.pm.mvp.contract.MsgTypeContract;
import com.rxjy.pm.mvp.presenter.MsgTypePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MsgTypeActivity extends BaseActivity<MsgTypePresenter> implements MsgTypeContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_msg_type)
    ListView lvMsgType;

    public static final String TITLE = "通知";

    private List<MsgTypeInfo.MsgType.MsgInfo> msgList;

    private MsgTypeAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_msg_type;
    }

    @Override
    public void initData() {
        initTitle();
        initMsg();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMsg() {

        msgList = new ArrayList<>();

        mAdapter = new MsgTypeAdapter(this, msgList);

        lvMsgType.setAdapter(mAdapter);

        lvMsgType.setOnItemClickListener(this);

    }

    @Override
    protected MsgTypePresenter onCreatePresenter() {
        return new MsgTypePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getMstType(App.pmUserInfo.getUid());
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MsgTypeInfo.MsgType.MsgInfo info = msgList.get(position);
        Intent intent = new Intent(this, MsgListActivity.class);
        intent.putExtra(Constants.ACTION_TO_MSG_LIST_TYPE_ID, info.getTs_msg_type());
        intent.putExtra(Constants.ACTION_TO_MSG_LIST_TITLE, info.getTs_msg_typename());
        startActivity(intent);
    }

    @Override
    public void responseMsgTypeData(List<MsgTypeInfo.MsgType.MsgInfo> dataList) {
        msgList.clear();
        msgList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMsgTypeDataError(String msg) {
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
