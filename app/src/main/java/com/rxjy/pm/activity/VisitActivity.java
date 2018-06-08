package com.rxjy.pm.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.VisitAdapter;
import com.rxjy.pm.entity.VisitListInfo;
import com.rxjy.pm.mvp.contract.VisitContract;
import com.rxjy.pm.mvp.presenter.VisitPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VisitActivity extends BaseActivity<VisitPresenter> implements VisitContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_visit_pro_name)
    TextView tvVisitProName;
    @Bind(R.id.lv_visit)
    ListView lvVisit;
    @Bind(R.id.et_visit_content)
    EditText etVisitContent;
    @Bind(R.id.btn_visit_send)
    Button btnVisitSend;

    public static final String TITLE = "项目回访";
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;
    @Bind(R.id.tv_old_password_line)
    TextView tvOldPasswordLine;

    private List<VisitListInfo.VisitInfo> visitList;

    private VisitAdapter mAdapter;

    private String orderNo;

    private String proName;

    @Override
    public int getLayout() {
        return R.layout.activity_visit;
    }

    @Override
    public void initData() {
        initLine();
        initIntent();
        initTitle();
        initVisit();
    }

    private void initLine() {
        etVisitContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvStaterd.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvStaterd.setEnabled(false);
                }
            }
        });
    }

    private void initIntent() {
        orderNo = getIntent().getStringExtra(Constants.ACTION_TO_VISIT_ORDER_NO);
        proName = getIntent().getStringExtra(Constants.ACTION_TO_VISIT_PRO_NAME);
        tvVisitProName.setText(proName);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initVisit() {

        visitList = new ArrayList<>();

        mAdapter = new VisitAdapter(this, visitList);

        lvVisit.setAdapter(mAdapter);

        mPresenter.getVisit(orderNo);

    }

    @Override
    protected VisitPresenter onCreatePresenter() {
        return new VisitPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_visit_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_visit_send:
                String content = etVisitContent.getText().toString().trim();
                etVisitContent.setText("");
                if (!content.equals("")) {
                    //收起软键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    mPresenter.subVisit(orderNo, content);
                } else {
                    showToast("请输入回访内容");
                }
                break;
        }
    }

    @Override
    public void responseVisitData(List<VisitListInfo.VisitInfo> dataList) {
        visitList.clear();
        visitList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        if (visitList.size() != 0)
            lvVisit.setSelection(visitList.size() - 1);
    }

    @Override
    public void responseVisitDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseVisitSubData() {
        mPresenter.getVisit(orderNo);
    }

    @Override
    public void responseVisitSubDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
