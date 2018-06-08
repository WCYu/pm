package com.rxjy.pm.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.Pickers;
import com.rxjy.pm.mvp.contract.AddNewProjectContract;
import com.rxjy.pm.mvp.presenter.AddNewProjectPresenter;
import com.rxjy.pm.widget.PickerScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/28.
 */

public class AddActivity extends BaseActivity<AddNewProjectPresenter> implements AddNewProjectContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_companyname)
    EditText etCompanyname;
    @Bind(R.id.et_mianji)
    EditText etMianji;
    @Bind(R.id.et_type)
    TextView etType;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.rl_type)
    RelativeLayout rlType;
    @Bind(R.id.scrollView)
    PickerScrollView scrollView;
    @Bind(R.id.pick_rlv)
    RelativeLayout pickRlv;
    private List<Pickers> pickList;
    private String type="1";
    private String typeName="办公";

    @Override
    public int getLayout() {
        return R.layout.activity_add;
    }

    @Override
    public void initData() {
        Log.e("tag",App.personnelInfo.toString());
        tvTitle.setText("新增");
        pickList = new ArrayList();
        pickList.add(new Pickers("办公", 1));
        pickList.add(new Pickers("餐饮", 2));
        pickList.add(new Pickers("商业", 3));
        pickList.add(new Pickers("酒店", 4));
        pickList.add(new Pickers("其他", 5));
        scrollView.setData(pickList);
        scrollView.setSelected(0);

        scrollView.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(Pickers pickers) {
                typeName=pickers.getShowContent();
                type = pickers.getId() + "";
            }
        });

    }

    @Override
    protected AddNewProjectPresenter onCreatePresenter() {
        return new AddNewProjectPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.rl_type,R.id.pick_cancle,R.id.pick_selected})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pick_cancle:
                type = null;
                pickRlv.setVisibility(View.GONE);
                break;
            case R.id.pick_selected:
                etType.setText(typeName);
                pickRlv.setVisibility(View.GONE);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                String clientName = etName.getText().toString();
                String clientPhone = etPhone.getText().toString();
                String projectName = etCompanyname.getText().toString();
                String mianji = etMianji.getText().toString();
                if (TextUtils.isEmpty(clientName)||TextUtils.isEmpty(clientPhone)||TextUtils.isEmpty(projectName)||TextUtils.isEmpty(mianji)) {
                  showToast("请完善信息");
                    return;
                }
             //   Log.e("bug",App.baseInfo.toString());

//                Log.e("tag",type+"");
               Log.e("bug",App.pmUserInfo.getInduction_area()+"");
               //  Log.e("====",Double.valueOf(mianji)+"==============="+Integer.valueOf(type));
                    mPresenter.addNewProject(clientName, clientPhone, projectName, Double.valueOf(mianji), Integer.valueOf(type), 2, App.pmUserInfo.getInduction_area(), App.pmUserInfo.getUid(),App.pmUserInfo.getUser_name());


                break;
            case R.id.rl_type:
                  pickRlv.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void AddSuccess(String msg) {
        showToast("添加成功");
        finish();
    }

    @Override
    public void AddFail(String msg) {
        showToast("添加失败");
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
