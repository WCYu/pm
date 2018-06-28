package com.rxjy.pm.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.DisbursementStandardActivity;
import com.rxjy.pm.activity.MatActivity;
import com.rxjy.pm.activity.ProDetailActivity;
import com.rxjy.pm.activity.ProcessDetailActivity;
import com.rxjy.pm.activity.ReceiptActivity;
import com.rxjy.pm.activity.RoutingActivity;
import com.rxjy.pm.activity.UnderConstructionActivity;
import com.rxjy.pm.adapter.ProAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.HomeContract;
import com.rxjy.pm.mvp.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/7/26.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.lv_home)
    ListView lvHome;

    public static final String TITLE = "首页";
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_top)
    LinearLayout llTop;
    @Bind(R.id.Customer_telephone)
    ImageView CustomerTelephone;

    private List<ProjectInfo.Project> proList;

    private ProAdapter mAdapter;
    private AlertDialog dialog;
    private Intent intent;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }


    @Override
    protected void FragmentInitData() {
        if (App.pmUserInfo.getUser_join_state() > 0) {
            llTop.setVisibility(View.GONE);
        } else {
            llTop.setVisibility(View.VISIBLE);
        }
        initTitle();
        initProData();

    }

    private void initTitle() {
        createDialog();
        CustomerTelephone.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initProData() {

        proList = new ArrayList<>();

        mAdapter = new ProAdapter(getActivity(), proList);

        lvHome.setAdapter(mAdapter);

        lvHome.setOnItemClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getProList(App.pmUserInfo.getUid());

    }


    @Override
    protected HomePresenter onCreatePresenter() {
        return new HomePresenter(this);
    }


    @Override
    public void responseProListData(List<ProjectInfo.Project> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }
    @Override
    public void responseProListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void startToPrepare(ProjectInfo.Project data) {
        Intent intent = new Intent(getActivity(), UnderConstructionActivity.class);
        intent.putExtra(Constants.ACTION_TO_UNDER_CONSTRUCTION_PRO_INFO, data);
        startActivity(intent);
    }

    @Override
    public void startToRouting(ProjectInfo.Project data) {
        Intent intent = new Intent(getActivity(), RoutingActivity.class);
        intent.putExtra(Constants.ACTION_TO_ROUTING_PRO_INFO, data);
        startActivity(intent);
    }

    @Override
    public void startToDisbursement(ProjectInfo.Project data) {
        Intent intent = new Intent(getActivity(), DisbursementStandardActivity.class);
        intent.putExtra(Constants.ACTION_TO_DISBURSEMENT_STANDARD_PRO_INFO, data);
        startActivity(intent);
    }

    @Override
    public void startToMat(ProjectInfo.Project data) {
        Intent intent = new Intent(getActivity(), MatActivity.class);
        intent.putExtra(Constants.ACTION_TO_MAT_PRO_INFO, data);
        startActivity(intent);
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

        ProjectInfo.Project info = proList.get(position);
        int state = info.getState();
        int pushStatus = info.getPushStatus();

        if (state <= 4) {
           if(state==4&&pushStatus==5) {
               Toast.makeText(getContext(), "接单完成，工程部处理", Toast.LENGTH_SHORT).show();
           }else {
               intent = new Intent(getActivity(), ReceiptActivity.class);
               intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, info);
               startActivity(intent);
           }
        } else {
            intent = new Intent(getActivity(), ProDetailActivity.class);
            intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, info);
            startActivity(intent);
        }

    }

    @OnClick(R.id.Customer_telephone)
    public void onViewClicked() {
        dialog.show();
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer, null);
        builder.setView(inflate);
        TextView cancel = (TextView) inflate.findViewById(R.id.cancel);
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
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + "010-86666886"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog = builder.create();


    }

}
