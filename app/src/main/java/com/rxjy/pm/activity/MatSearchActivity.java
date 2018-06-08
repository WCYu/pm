package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.SearchAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.commons.utils.PrefUtils;
import com.rxjy.pm.entity.HotWordInfo;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.MatSearchContract;
import com.rxjy.pm.mvp.presenter.MatSearchPresenter;
import com.rxjy.pm.pop.FuzzyPop;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatSearchActivity extends BaseActivity<MatSearchPresenter> implements MatSearchContract.View, AdapterView.OnItemClickListener {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.gv_hot_word)
    GridView gvHotWord;
    @Bind(R.id.tv_del_record)
    TextView tvDelRecord;
    @Bind(R.id.gv_search_record)
    GridView gvSearchRecord;

    private List<HotWordInfo.HotWord> hotList;

    private SearchAdapter mHotAdapter;

    private List<HotWordInfo.HotWord> recordList;

    private SearchAdapter mRecordAdapter;

    private FuzzyPop fuzzyPop;

    private ProjectInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_mat_search;
    }

    @Override
    public void initData() {
        initIntent();
        initHotWord();
        initSearchRecord();
        initPop();
        initFuzzySearch();
    }

    private void initIntent() {
        proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_SEARCH_PRO_INFO);
    }

    private void initHotWord() {

        hotList = new ArrayList<>();

        mHotAdapter = new SearchAdapter(this, hotList);

        gvHotWord.setAdapter(mHotAdapter);

        gvHotWord.setOnItemClickListener(this);

        //获取热词
        mPresenter.getHotWord();

    }

    private void initSearchRecord() {

        String json = PrefUtils.getValue(this, Constants.FLAG_RECORD);

        Type type = new TypeToken<ArrayList<HotWordInfo.HotWord>>() {
        }.getType();

        List<HotWordInfo.HotWord> reList = JSONUtils.toList(json, type);

        recordList = new ArrayList<>();

        if (reList != null)
            recordList.addAll(reList);

        mRecordAdapter = new SearchAdapter(this, recordList);

        gvSearchRecord.setAdapter(mRecordAdapter);

        gvSearchRecord.setOnItemClickListener(this);

    }

    private void initPop() {

        fuzzyPop = new FuzzyPop(this, R.layout.pop_fuzzy_search, AutoUtils.getDisplayWidthValue(720), AutoUtils.getDisplayHeightValue(560));

        fuzzyPop.setOnPopItemClickListener(new FuzzyPop.OnPopItemClickListener() {
            @Override
            public void onItemClick(HotWordInfo.HotWord data) {
                saveSearchRecord(data.getTitle());
                startToSearchResult(data.getTitle());
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

    private void saveSearchRecord(String title) {

        HotWordInfo.HotWord info = new HotWordInfo.HotWord();

        info.setTitle(title);

        boolean flag = false;

        if (recordList.size() < 8) {
            for (HotWordInfo.HotWord data : recordList) {
                if (data.getTitle().equals(title)) {
                    flag = true;
                }
            }
            if (!flag) {
                recordList.add(info);
            }
        } else {
            for (HotWordInfo.HotWord data : recordList) {
                if (data.getTitle().equals(title)) {
                    flag = true;
                }
            }
            if (!flag) {
                recordList.remove(7);
                recordList.add(0, info);
            }
        }
        String recordJson = JSONUtils.toString(recordList);
        PrefUtils.putValue(this, Constants.FLAG_RECORD, recordJson);
    }

    private void startToSearchResult(String content) {
        etContent.setText(content);
        Intent intent = new Intent(this, MatSearchResultActivity.class);
        intent.putExtra(Constants.ACTION_TO_MAT_SEARCH_RESULT_PRO_INFO, proInfo);
        intent.putExtra(Constants.ACTION_TO_MAT_SEARCH_RESULT_CONTENT, content);
        startActivity(intent);
    }

    @Override
    protected MatSearchPresenter onCreatePresenter() {
        return new MatSearchPresenter(this);
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
        String json = PrefUtils.getValue(this, Constants.FLAG_RECORD);

        Type type = new TypeToken<ArrayList<HotWordInfo.HotWord>>() {
        }.getType();

        List<HotWordInfo.HotWord> reList = JSONUtils.toList(json, type);

        if (reList != null && recordList != null){
            recordList.clear();
            recordList.addAll(reList);
        }
        if (mRecordAdapter != null)
            mRecordAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_back, R.id.iv_search, R.id.tv_del_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_search:
                break;
            case R.id.tv_del_record:
                recordList.clear();
                String recordJson = JSONUtils.toString(recordList);
                PrefUtils.putValue(this, Constants.FLAG_RECORD, recordJson);
                mRecordAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void responseHotWordData(List<HotWordInfo.HotWord> dataList) {
        hotList.clear();
        hotList.addAll(dataList);
        mHotAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseHotWordDataError(String msg) {
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
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.gv_hot_word:
                HotWordInfo.HotWord hotInfo = hotList.get(position);
                saveSearchRecord(hotInfo.getTitle());
                startToSearchResult(hotInfo.getTitle());
                break;
            case R.id.gv_search_record:
                HotWordInfo.HotWord reInfo = recordList.get(position);
                startToSearchResult(reInfo.getTitle());
                break;
        }
    }
}
