package com.rxjy.pm.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.RoutingHistoryDetailAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.RoutingBean;
import com.rxjy.pm.entity.RoutingHistoryInfo;
import com.rxjy.pm.mvp.contract.RoutingHistoryContract;
import com.rxjy.pm.mvp.presenter.RoutingHistoryPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

import static com.rxjy.pm.R.id.tv_routing_history_detail_address;

public class RoutingHistoryDetailActivity extends BaseActivity<RoutingHistoryPresenter> implements RoutingHistoryContract.View, AdapterView.OnItemClickListener{

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_routing_history_detail)
    EditText etRoutingHistoryDetail;
    @Bind(tv_routing_history_detail_address)
    TextView tvAddress;
    @Bind(R.id.et_routing_history_detail_count)
    TextView etCount;
    @Bind(R.id.gv_routing_history_detail)
    GridView gvRoutingHistoryDetail;
    @Bind(R.id.tv_routing_history_detail_name)
    TextView tvName;
    @Bind(R.id.tv_routing_history_detail_time)
    TextView tvTime;

    public static final String TITLE = "进度巡检";

    private List<LocalMedia> photoList;

    private List<String> imgList;

    private RoutingHistoryDetailAdapter mAdapter;

    private RoutingHistoryInfo.RoutingHistory rouInfo;
    private RoutingBean.BodyBean bodyBean;
    private Map<String, String> stringStringMap;

    @Override
    public int getLayout() {
        return R.layout.activity_routing_history_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRoutingHistoryDetail();
    }

    @Override
    protected RoutingHistoryPresenter onCreatePresenter() {
        return new RoutingHistoryPresenter(this);
    }

    private void initIntent() {
        //proInfo = (ProjectInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_INFO);
        //rouInfo = (RoutingHistoryInfo.RoutingHistory) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_INFO);
        bodyBean= (RoutingBean.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_INFO);
        stringStringMap = (Map<String, String>) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_HISTORY_PRO_PICTURE_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRoutingHistoryDetail() {
        etRoutingHistoryDetail.setEnabled(false);
        imgList = new ArrayList<>();
        photoList = new ArrayList<>();
        tvTime.setText(bodyBean.getXj_finishtime());
        etRoutingHistoryDetail.setText(bodyBean.getXj_content()+"");

        Set<String> strings = stringStringMap.keySet();
        for (String key:strings){
            imgList.add(key);
            tvAddress.setText(stringStringMap.get(key));
        }
        mAdapter = new RoutingHistoryDetailAdapter(this, imgList);
        gvRoutingHistoryDetail.setAdapter(mAdapter);

        gvRoutingHistoryDetail.setOnItemClickListener(this);

        for (String url : imgList ) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(url);
            photoList.add(localMedia);
        }

    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PictureSelector.create(this).externalPicturePreview(position, photoList);
    }

    @Override
    protected void onResume() {
        super.onResume();
       // mPresenter.getRoutingHistoryList(proInfo.getOrderNo());
    }

    @Override
    public void responseRoutingHistoryListData(List<RoutingHistoryInfo.RoutingHistory> dataList) {
        rouInfo = dataList.get(1);
        etRoutingHistoryDetail.setEnabled(false);
        tvName.setText("进度巡检");
        tvTime.setText(rouInfo.getXj_finishtime());
        etRoutingHistoryDetail.setText(rouInfo.getXj_content());

        imgList = new ArrayList<>();
        photoList = new ArrayList<>();

        imgList.addAll(rouInfo.getXj_photo());
        mAdapter = new RoutingHistoryDetailAdapter(this, imgList);
        gvRoutingHistoryDetail.setAdapter(mAdapter);

        gvRoutingHistoryDetail.setOnItemClickListener(this);

        for (String url : imgList ) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(url);
            photoList.add(localMedia);
        }
    }

    @Override
    public void responseRoutingHistoryListDataError(String msg) {
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
