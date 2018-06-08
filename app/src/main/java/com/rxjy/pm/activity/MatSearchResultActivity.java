package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.SearchMatAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.entity.HotWordInfo;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.entity.UpdMatInfo;
import com.rxjy.pm.mvp.contract.SearchMatContract;
import com.rxjy.pm.mvp.presenter.SearchMatPresenter;
import com.rxjy.pm.pop.FuzzyPop;
import com.rxjy.pm.widget.CountDialog;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatSearchResultActivity extends BaseActivity<SearchMatPresenter> implements SearchMatContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.lv_search_result_mat)
    ListView lvSearchResultMat;

    private List<MatInfo.Mat> matList;

    private SearchMatAdapter mAdapter;

    private FuzzyPop fuzzyPop;

    private CountDialog countDialog;

    private ProjectInfo.Project proInfo;

    private String content;

    @Override
    public int getLayout() {
        return R.layout.activity_mat_search_result;
    }

    @Override
    public void initData() {
        initIntent();
        initMat();
        initPop();
        initFuzzySearch();
        initCountDialog();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_SEARCH_RESULT_PRO_INFO);
        content = getIntent().getStringExtra(Constants.ACTION_TO_MAT_SEARCH_RESULT_CONTENT);
    }

    private void initMat() {

        etContent.setText(content);

        matList = new ArrayList<>();

        mAdapter = new SearchMatAdapter(this, this, matList);

        lvSearchResultMat.setAdapter(mAdapter);

    }

    private void initPop() {

        fuzzyPop = new FuzzyPop(this, R.layout.pop_fuzzy_search, AutoUtils.getDisplayWidthValue(720), AutoUtils.getDisplayHeightValue(560));

        fuzzyPop.setOnPopItemClickListener(new FuzzyPop.OnPopItemClickListener() {
            @Override
            public void onItemClick(HotWordInfo.HotWord data) {
                content = data.getTitle();
                saveSearchRecord(data.getTitle());
                mPresenter.getMatList(proInfo.getOrderNo(), data.getTitle());
            }
        });

    }

    private void initFuzzySearch() {

        etContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以某个控件的x和y的偏移量位置开始显示窗口
                fuzzyPop.showAsDropDown(ivBack, 0, 0);
                //如果窗口存在，则更新
                fuzzyPop.update();
            }
        });

        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.equals(""))
                    mPresenter.getFuzzyInfo(proInfo.getOrderNo(), s.toString());
            }
        });

    }

    private void initCountDialog() {

        countDialog = new CountDialog(this);

        countDialog.setOnNoOnClickListener("取消", null);

        countDialog.setOnYesOnClickListener("确认", new CountDialog.OnYesOnClickListener() {
            @Override
            public void onYes(double count, MatInfo.Mat data) {
                mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), count, 1);
            }
        });

    }

    private void saveSearchRecord(String title) {

        String json = PrefUtils.getValue(this, Constants.FLAG_RECORD);

        Type type = new TypeToken<ArrayList<HotWordInfo.HotWord>>() {
        }.getType();

        List<HotWordInfo.HotWord> reList = JSONUtils.toList(json, type);

        HotWordInfo.HotWord info = new HotWordInfo.HotWord();

        info.setTitle(title);

        boolean flag = false;

        if (reList.size() < 8) {
            for (HotWordInfo.HotWord data : reList) {
                if (data.getTitle().equals(title)) {
                    flag = true;
                }
            }
            if (!flag) {
                reList.add(info);
            }
        } else {
            for (HotWordInfo.HotWord data : reList) {
                if (data.getTitle().equals(title)) {
                    flag = true;
                }
            }
            if (!flag) {
                reList.remove(7);
                reList.add(0, info);
            }
        }
        String recordJson = JSONUtils.toString(reList);
        PrefUtils.putValue(this, Constants.FLAG_RECORD, recordJson);
    }

    @Override
    protected SearchMatPresenter onCreatePresenter() {
        return new SearchMatPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getMatList(proInfo.getOrderNo(), content);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseMatData(List<MatInfo.Mat> dataList) {
        matList.clear();
        matList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMatDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpdMatInfo(UpdMatInfo.UpdMat data) {
        mPresenter.getMatList(proInfo.getOrderNo(), content);
    }

    @Override
    public void responseUpdMatInfoError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseFuzzyData(List<HotWordInfo.HotWord> dataList) {
        fuzzyPop.setFuzzyList(dataList);
    }

    @Override
    public void responseFuzzyDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void updMatCount(MatInfo.Mat data, int type) {
        //type 1-新增 2-减少 3-修改
        switch (type) {
            case 0:
                mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (data.getBuyCount() + 1), 1);
                break;
            case 1:
                if (data.getBuyCount() < 1)
                    mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (0), 1);
                else
                    mPresenter.updMat(proInfo.getOrderNo(), data.getMatID(), data.getUserID(), (data.getBuyCount() - 1), 1);
                break;
            case 2:
                countDialog.show();
                countDialog.setCount(data.getBuyCount(), data);
                break;
        }
    }

    @Override
    public void updMatMerchant(MatInfo.Mat data) {
        if (data.getBuyCount() != 0) {
            Intent intent = new Intent(this, UpdMatMerchantActivity.class);
            intent.putExtra(Constants.ACTION_TO_MAT_MERCHANT_MAT_INFO, data);
            intent.putExtra(Constants.ACTION_TO_MAT_MERCHANT_PRO_INFO, proInfo);
            startActivity(intent);
        } else {
            showToast("未选择材料无法更改材料商");
        }
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
