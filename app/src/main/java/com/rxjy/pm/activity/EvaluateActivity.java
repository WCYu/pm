package com.rxjy.pm.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.adapter.MarkAdapter;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.EvaluateMarkInfo;
import com.rxjy.pm.mvp.contract.EvaluateContract;
import com.rxjy.pm.mvp.presenter.EvaluatePresenter;
import com.rxjy.pm.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EvaluateActivity extends BaseActivity<EvaluatePresenter> implements EvaluateContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.civ_mat_merchant)
    CircleImageView civMatMerchant;
    @Bind(R.id.tv_evaluate_name)
    TextView tvEvaluateName;
    @Bind(R.id.tv_evaluate_info)
    TextView tvEvaluateInfo;
    @Bind(R.id.iv_star_one)
    ImageView ivStarOne;
    @Bind(R.id.iv_star_two)
    ImageView ivStarTwo;
    @Bind(R.id.iv_star_three)
    ImageView ivStarThree;
    @Bind(R.id.iv_star_four)
    ImageView ivStarFour;
    @Bind(R.id.iv_star_five)
    ImageView ivStarFive;
    @Bind(R.id.gv_evaluate)
    GridView gvEvaluate;
    @Bind(R.id.et_evaluate_remark)
    EditText etEvaluateRemark;
    @Bind(R.id.tv_evaluate_remark_count)
    TextView tvEvaluateRemarkCount;
    @Bind(R.id.btn_evaluate_sub)
    Button btnEvaluateSub;
    @Bind(R.id.iv_evaluate_call)
    ImageView ivCall;

    public static final String TITLE = "评价";

    private List<EvaluateMarkInfo.StarInfo> starList;

    private List<EvaluateMarkInfo.StarInfo.MarkInfo> markList;

    private List<Integer> mList;

    private MarkAdapter mAdapter;

    private int starLevel = 0;

    private String orderID;

    private int userID;

    private String userName;

    private String userPhoto;

    private String userPhone;

    private boolean isCall = false;

    @Override
    public int getLayout() {
        return R.layout.activity_evaluate;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMatMerchant();
        initEvaluateMark();
        initET();
    }

    private void initIntent() {
        orderID = getIntent().getStringExtra(Constants.ACTION_TO_EVALUATE_ORDER_ID);
        userID = getIntent().getIntExtra(Constants.ACTION_TO_EVALUATE_USER_ID, 0);
        userName = getIntent().getStringExtra(Constants.ACTION_TO_EVALUATE_USER_NAME);
        userPhoto = getIntent().getStringExtra(Constants.ACTION_TO_EVALUATE_USER_PHOTO);
        userPhone = getIntent().getStringExtra(Constants.ACTION_TO_EVALUATE_USER_PHONE);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMatMerchant() {
        tvEvaluateName.setText(userName);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.head_portrait_icon);
        options.error(R.mipmap.head_portrait_icon);
        Glide.with(this).load(userPhoto).apply(options).into(civMatMerchant);
    }

    private void initEvaluateMark() {

        starList = new ArrayList<>();

        markList = new ArrayList<>();

        mList = new ArrayList<>();

        mAdapter = new MarkAdapter(this, markList);

        gvEvaluate.setAdapter(mAdapter);

        gvEvaluate.setOnItemClickListener(this);

        mPresenter.getEvaluateMarks(1);

        ivCall.setTranslationX(AutoUtils.getDisplayWidthValue(84));
    }

    private void initET() {

        tvEvaluateRemarkCount.setText("限制字数" + 0 + "/70");

        etEvaluateRemark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvEvaluateRemarkCount.setText("限制字数" + s.toString().length() + "/70");
            }
        });

    }

    private void startAnim() {

        isCall = true;

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(ivCall, "translationX", AutoUtils.getDisplayWidthValue(84), 0)
        );
        set.setDuration(1 * 400).start();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        }, 2 * 1000);

    }

    private void endAnim() {

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(ivCall, "translationX", 0, AutoUtils.getDisplayWidthValue(84))
        );

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isCall = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        set.setDuration(1 * 400).start();

    }

    @Override
    public void handlerMeaasg(Message msg) {
        endAnim();
    }

    /**
     * 评价星级
     *
     * @param starCount
     */
    private void showStarCount(int starCount) {
        switch (starCount) {
            case 0:
                ivStarOne.setImageResource(R.mipmap.star_normal_icon);
                ivStarTwo.setImageResource(R.mipmap.star_normal_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 1:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_normal_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 2:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_normal_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 3:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_normal_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 4:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_checked_icon);
                ivStarFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 5:
                ivStarOne.setImageResource(R.mipmap.star_checked_icon);
                ivStarTwo.setImageResource(R.mipmap.star_checked_icon);
                ivStarThree.setImageResource(R.mipmap.star_checked_icon);
                ivStarFour.setImageResource(R.mipmap.star_checked_icon);
                ivStarFive.setImageResource(R.mipmap.star_checked_icon);
                break;
        }
        starLevel = starCount;
        markList.clear();
        markList.addAll(starList.get((starCount - 1)).getItems());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected EvaluatePresenter onCreatePresenter() {
        return new EvaluatePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.iv_star_one, R.id.iv_star_two, R.id.iv_star_three, R.id.iv_star_four, R.id.iv_star_five, R.id.iv_evaluate_call, R.id.btn_evaluate_sub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_star_one:
                showStarCount(1);
                break;
            case R.id.iv_star_two:
                showStarCount(2);
                break;
            case R.id.iv_star_three:
                showStarCount(3);
                break;
            case R.id.iv_star_four:
                showStarCount(4);
                break;
            case R.id.iv_star_five:
                showStarCount(5);
                break;
            case R.id.iv_evaluate_call:
                if (isCall) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + userPhone));
                    startActivity(intent);
                } else {
                    startAnim();
                }
                break;
            case R.id.btn_evaluate_sub:
                mList.clear();
                final String evaluate = etEvaluateRemark.getText().toString().trim();
                for (EvaluateMarkInfo.StarInfo.MarkInfo info : markList) {
                    if (info.getIsChecked() == 1)
                        mList.add(info.getMarkID());
                }
                if (starLevel == 0) {
                    showToast("请选择星级");
                    return;
                }
                if (mList.size() == 0) {
                    showToast("请选择评价标签");
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确认评价");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.subEvaluate(orderID, starLevel, evaluate, userID, mList);
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EvaluateMarkInfo.StarInfo.MarkInfo info = markList.get(position);
        if (info.getIsChecked() == 0) {
            info.setIsChecked(1);
        } else {
            info.setIsChecked(0);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseEvaluateData(List<EvaluateMarkInfo.StarInfo> dataList) {
        starList.addAll(dataList);
    }

    @Override
    public void responseEvaluateDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseEvaluateMatMerchant() {
        showToast("评价成功");
        finish();
    }

    @Override
    public void responseEvaluateMatMerchantError(String msg) {
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
