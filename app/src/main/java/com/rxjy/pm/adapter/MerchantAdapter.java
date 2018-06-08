package com.rxjy.pm.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.MerChantInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/13.
 */

public class MerchantAdapter extends SingleBaseAdapter<MerChantInfo.Merchant, MerchantAdapter.ViewHolder> {

    public MerchantAdapter(Context context, List<MerChantInfo.Merchant> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_merchant;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final MerChantInfo.Merchant data, ViewHolder holder) {

        holder.tvName.setText(data.getUserName());
        holder.tvWorkYear.setText(data.getWorkTime());
        holder.tvMatPrice.setText("¥" + data.getMatPrice());
        setStarCount(data.getEvaluateStar(), holder.ivStarOne, holder.ivStarTwo, holder.ivStarThree, holder.ivStarFour, holder.ivStarFive);
        if (data.getIsChecked() == 0) {
            holder.ivRadio.setImageResource(R.mipmap.radio_normal_icon);
        } else {
            holder.ivRadio.setImageResource(R.mipmap.radio_checked_icon);
        }

        holder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data.getUserPhone()));
                context.startActivity(intent);
            }
        });

    }

    private void setStarCount(int count, ImageView ivOne, ImageView ivTwo, ImageView ivThree, ImageView ivFour, ImageView ivFive) {
        switch (count) {
            case 0:
                ivOne.setImageResource(R.mipmap.star_normal_icon);
                ivTwo.setImageResource(R.mipmap.star_normal_icon);
                ivThree.setImageResource(R.mipmap.star_normal_icon);
                ivFour.setImageResource(R.mipmap.star_normal_icon);
                ivFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 1:
                ivOne.setImageResource(R.mipmap.star_checked_icon);
                ivTwo.setImageResource(R.mipmap.star_normal_icon);
                ivThree.setImageResource(R.mipmap.star_normal_icon);
                ivFour.setImageResource(R.mipmap.star_normal_icon);
                ivFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 2:
                ivOne.setImageResource(R.mipmap.star_checked_icon);
                ivTwo.setImageResource(R.mipmap.star_checked_icon);
                ivThree.setImageResource(R.mipmap.star_normal_icon);
                ivFour.setImageResource(R.mipmap.star_normal_icon);
                ivFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 3:
                ivOne.setImageResource(R.mipmap.star_checked_icon);
                ivTwo.setImageResource(R.mipmap.star_checked_icon);
                ivThree.setImageResource(R.mipmap.star_checked_icon);
                ivFour.setImageResource(R.mipmap.star_normal_icon);
                ivFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 4:
                ivOne.setImageResource(R.mipmap.star_checked_icon);
                ivTwo.setImageResource(R.mipmap.star_checked_icon);
                ivThree.setImageResource(R.mipmap.star_checked_icon);
                ivFour.setImageResource(R.mipmap.star_checked_icon);
                ivFive.setImageResource(R.mipmap.star_normal_icon);
                break;
            case 5:
                ivOne.setImageResource(R.mipmap.star_checked_icon);
                ivTwo.setImageResource(R.mipmap.star_checked_icon);
                ivThree.setImageResource(R.mipmap.star_checked_icon);
                ivFour.setImageResource(R.mipmap.star_checked_icon);
                ivFive.setImageResource(R.mipmap.star_checked_icon);
                break;
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_merchant_radio)
        ImageView ivRadio;
        @Bind(R.id.tv_merchant_mat_price)
        TextView tvMatPrice;
        @Bind(R.id.iv_merchant_call)
        ImageView ivCall;
        @Bind(R.id.iv_star_five)
        ImageView ivStarFive;
        @Bind(R.id.iv_star_four)
        ImageView ivStarFour;
        @Bind(R.id.iv_star_three)
        ImageView ivStarThree;
        @Bind(R.id.iv_star_two)
        ImageView ivStarTwo;
        @Bind(R.id.iv_star_one)
        ImageView ivStarOne;
        @Bind(R.id.tv_merchant_work_year)
        TextView tvWorkYear;
        @Bind(R.id.tv_merchant_name)
        TextView tvName;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
