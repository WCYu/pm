package com.rxjy.pm.fragment;

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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.ScanActivity;
import com.rxjy.pm.activity.WorkProDetailActivity;
import com.rxjy.pm.adapter.WorkerHomeAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.WorklistBean;
import com.rxjy.pm.mvp.contract.WorkHomedataContract;
import com.rxjy.pm.mvp.presenter.WorkerHomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2018/3/13.
 */

public class WorkerHomeFragment extends BaseFragment<WorkerHomePresenter> implements WorkHomedataContract.View {
    @Bind(R.id.Customer_service)
    ImageView CustomerService;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;
    @Bind(R.id.scanning)
    ImageView scanning;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.Work_lv_home)
    ListView WorkLvHome;
    List<WorklistBean.BodyBean> mlist;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.Customer_telephone)
    ImageView CustomerTelephone;
    @Bind(R.id.show_popup)
    RelativeLayout showPopup;
    private WorkerHomeAdapter mAdapter;
    private AlertDialog dialog;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_workerhome;
    }

    @Override
    protected void FragmentInitData() {
        ivBack.setVisibility(View.INVISIBLE);
        CustomerTelephone.setVisibility(View.VISIBLE);
        tvTitle.setText("项目");
        createDialog();
        scanning.setVisibility(View.VISIBLE);
        initlistData();

        WorkLvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WorklistBean.BodyBean info = mlist.get(position);
                Intent intent = new Intent(getActivity(), WorkProDetailActivity.class);
                intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, info);
                startActivity(intent);
            }
        });
        // mPresenter.getData(ScanResult);


    }

    @Override
    public void onResume() {
        super.onResume();
       mPresenter.getData(App.workerid + "");
        Log.e("worrker",App.workerid +"");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden) {
            //相当于Fragment的onPause
            //System.out.println("界面不可见");
            // Toast.makeText(getContext(), "页面不可见", Toast.LENGTH_SHORT).show();
        } else {
            // 相当于Fragment的onResume
            // System.out.println("界面可见");
            //  Toast.makeText(getContext(), "页面可见", Toast.LENGTH_SHORT).show();
//            mPresenter.getData(App.workerid + "");
//            Log.e("workerid",App.workerid +"");
        }
    }

    private void initlistData() {
        mlist = new ArrayList<>();

        mAdapter = new WorkerHomeAdapter(getActivity(), mlist);

        WorkLvHome.setAdapter(mAdapter);
    }

    @Override
    protected WorkerHomePresenter onCreatePresenter() {
        return new WorkerHomePresenter(this);
    }


    @OnClick({R.id.Customer_service, R.id.tv_staterd, R.id.scanning})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Customer_service:
                break;
            case R.id.tv_staterd:
                break;
            case R.id.scanning:
                //ZxingUtils.createBitmap()
                IntentIntegrator.forSupportFragment(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
                        .initiateScan(); // 初始化扫描
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        Log.e("tagg", "bingding");
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                // Toast.makeText(getContext(), "内容为空", LENGTH_LONG).show();

            } else {
                String ScanResult = intentResult.getContents();
                String[] split = ScanResult.split(":");

                Log.e("bingding", split[0] + split[1]);
                if (ScanResult != null) {
                    mPresenter.getBinDing(App.workerid + "", split[0], split[1] + "");
                    Log.e( "aa",    App.workerid +"   "  + split[0] +" " +split[1]);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void responsegetData(List<WorklistBean.BodyBean> Body) {


//        if(mlist.toString().contains(Body.toString())){
//      Log.e("cc",11+"");
//        }else {
//            Log.e("cc",22+"");
            mlist.clear();
            mlist.addAll(Body);
            mAdapter.notifyDataSetChanged();




    }

    @Override
    public void responsegetDataError(String msg) {
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
    public void responseBinDing() {

      //  mPresenter.getData(App.workerid + "");
        Log.e("workerid",App.workerid+"");
    }





    @OnClick(R.id.Customer_telephone)
    public void onViewClicked() {
        dialog.show();
    }
    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer, null);
        builder.setView(inflate);
        TextView cancel= (TextView) inflate.findViewById(R.id.cancel);
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
                Intent intent=new Intent("android.intent.action.CALL",Uri.parse("tel:"+"010-86666886"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog = builder.create();


    }
}
