package com.rxjy.pm.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.FreeJoinActivity;
import com.rxjy.pm.activity.OrdersProActivity;
import com.rxjy.pm.activity.ProMoneyActivity;
import com.rxjy.pm.activity.ShopCartProActivity;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/8/25.
 */

public class MoreFragment extends BaseFragment {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    public static final String TITLE = "更多";

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_more;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_mat_merchant_join, R.id.rl_task, R.id.rl_mat, R.id.rl_pro_money, R.id.rl_shop_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_mat_merchant_join:
                startActivity(new Intent(getActivity(), FreeJoinActivity.class));
                break;
            case R.id.rl_task:
                break;
            case R.id.rl_mat:
                startActivity(new Intent(getActivity(), OrdersProActivity.class));
                break;
            case R.id.rl_pro_money:
                startActivity(new Intent(getActivity(), ProMoneyActivity.class));
                break;
            case R.id.rl_shop_cart:
                startActivity(new Intent(getActivity(), ShopCartProActivity.class));
                break;
        }
    }
}
