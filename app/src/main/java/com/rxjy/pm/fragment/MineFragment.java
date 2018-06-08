package com.rxjy.pm.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.MsgTypeActivity;
import com.rxjy.pm.activity.PunishRecordActivity;
import com.rxjy.pm.activity.SettingActivity;
import com.rxjy.pm.activity.SuggestActivity;
import com.rxjy.pm.activity.UploadInfoActivity;
import com.rxjy.pm.activity.UserActivity;
import com.rxjy.pm.activity.VisitProListActivity;
import com.rxjy.pm.activity.WebActivity;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.mvp.contract.MinContract;
import com.rxjy.pm.mvp.presenter.MinPresenter;
import com.rxjy.pm.widget.RoundAngleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/7/26.
 */

public class MineFragment extends BaseFragment<MinPresenter> implements MinContract.View{
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_mine_name)
    TextView tvMineName;
    @Bind(R.id.tv_mine_card)
    TextView tvMineCard;
    @Bind(R.id.riv_mine)
    RoundAngleImageView rivMine;

    public static final String TITLE = "我";

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initUserData() {

        tvMineName.setText(App.baseInfo.getNickName() == null ? "昵称" : App.baseInfo.getNickName());
        tvMineCard.setText(App.baseInfo.getPhone()+"");
        mPresenter.loadPhotoImage(App.pmUserInfo.getUid());

    }

    @Override
    protected MinPresenter onCreatePresenter() {
        return new MinPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        initUserData();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_user_info, R.id.rl_help_center, R.id.rl_visit, R.id.rl_reward_punish_record, R.id.rl_msg, R.id.rl_settings, R.id.rl_suggest, R.id.tv_staterd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:
//                startActivity(new Intent(getActivity(), UserInfoActivity.class));
//                startActivity(new Intent(getActivity(), UploadInfoActivity.class));
                startActivity(new Intent(getActivity(), UserActivity.class));
                break;
            case R.id.rl_help_center:
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra(Constants.ACTION_TO_WEB_TITLE, "使用说明");
                intent.putExtra(Constants.ACTION_TO_WEB_URL, "http://api.gc.rxjy.com/doc/Personnel_Instructions.html");
                startActivity(intent);
                break;
            case R.id.rl_visit:
                startActivity(new Intent(getActivity(), VisitProListActivity.class));
                break;
            case R.id.rl_reward_punish_record:
                startActivity(new Intent(getActivity(), PunishRecordActivity.class));
                break;
            case R.id.rl_msg:
                startActivity(new Intent(getActivity(), MsgTypeActivity.class));
                break;
            case R.id.rl_settings:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.rl_suggest:
                startActivity(new Intent(getActivity(), SuggestActivity.class));
                break;
            case R.id.tv_staterd:

                break;
        }
    }

    @Override
    public void loadPhotoImage(String image) {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.head_portrait_icon);
        options.error(R.mipmap.head_portrait_icon);
        Glide.with(getActivity()).load(image).apply(options).into(rivMine);
       // Glide.with(getActivity()).load(image).into();
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
    public void showMessage(String message) {
        showToast(message);
    }
}
