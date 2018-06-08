package com.rxjy.pm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.SettingActivity;
import com.rxjy.pm.activity.WorkerPersondataActivity;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.widget.RoundAngleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/23.
 */

public class MineWorkerFragment extends BaseFragment {
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

    public static final String TITLE = "我的";
    @Bind(R.id.rl_user_info)
    RelativeLayout rlUserInfo;
    @Bind(R.id.rl_msg)
    RelativeLayout rlMsg;
    @Bind(R.id.rl_help_center)
    RelativeLayout rlHelpCenter;
    @Bind(R.id.rl_visit)
    RelativeLayout rlVisit;
    @Bind(R.id.rl_reward_punish_record)
    RelativeLayout rlRewardPunishRecord;
    @Bind(R.id.rl_suggest)
    RelativeLayout rlSuggest;

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
        rlMsg.setVisibility(View.GONE);
        rlHelpCenter.setVisibility(View.GONE);
        rlVisit.setVisibility(View.GONE);
        rlRewardPunishRecord.setVisibility(View.GONE);
        rlSuggest.setVisibility(View.GONE);
    }

    private void initUserData() {
        tvMineName.setText(App.baseInfo.getNickName() == null ? "昵称" : App.baseInfo.getNickName());
        tvMineCard.setText("账号：" + App.cardNo);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.head_portrait_icon);
        options.error(R.mipmap.head_portrait_icon);
        Glide.with(getActivity()).load(App.baseInfo.getImage()).apply(options).into(rivMine);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        initUserData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

//    @OnClick({R.id.rl_user_info, R.id.rl_help_center, R.id.rl_visit, R.id.rl_reward_punish_record, R.id.rl_msg, R.id.rl_settings, R.id.rl_suggest})
    @OnClick({R.id.rl_user_info,R.id.rl_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:
                startActivity(new Intent(getActivity(), WorkerPersondataActivity.class));
//                startActivity(new Intent(getActivity(), UserInfoActivity.class));
//                startActivity(new Intent(getActivity(), UploadInfoActivity.class));
                break;
//            case R.id.rl_help_center:
//                Intent intent = new Intent(getActivity(), WebActivity.class);
//                intent.putExtra(Constants.ACTION_TO_WEB_TITLE, "使用说明");
//                intent.putExtra(Constants.ACTION_TO_WEB_URL, "http://api.gc.rxjy.com/doc/Personnel_Instructions.html");
//                startActivity(intent);
//                break;
//            case R.id.rl_visit:
//                startActivity(new Intent(getActivity(), VisitProListActivity.class));
//                break;
//            case R.id.rl_reward_punish_record:
//                startActivity(new Intent(getActivity(), PunishRecordActivity.class));
//                break;
//            case R.id.rl_msg:
//                startActivity(new Intent(getActivity(), MsgTypeActivity.class));
//                break;
//            case R.id.rl_suggest:
//                startActivity(new Intent(getActivity(), SuggestActivity.class));
//                break;
            case R.id.rl_settings:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }
}
