package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.MatInfo;
import com.rxjy.pm.mvp.contract.SearchMatContract;
import com.rxjy.pm.widget.RoundAngleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/11.
 */

public class SearchMatAdapter extends SingleBaseAdapter<MatInfo.Mat, SearchMatAdapter.ViewHolder> {

    private SearchMatContract.View mListener;

    public SearchMatAdapter(Context context, SearchMatContract.View mListener, List<MatInfo.Mat> datas) {
        super(context, datas);
        this.mListener = mListener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_mat;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final MatInfo.Mat data, ViewHolder holder) {

        Glide.with(context).load(data.getPhotoUrl()).into(holder.rivMat);
        holder.tvName.setText(data.getMatName());
        holder.tvSpec.setText(data.getMatSpec());
        holder.tvMatMerchant.setText(data.getUserName() + " - ¥" + data.getMatPrice() + "/" + data.getUnitName());
        holder.tvMatBrand.setText(data.getBrandName());
        holder.tvSumCount.setText("总量：" + data.getTotal());
        holder.tvBuyCount.setText("已送：" + data.getAlready());
        holder.tvMatCount.setText(data.getBuyCount() + "");

        holder.ivMatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.updMatCount(data, 0);
            }
        });

        holder.ivMatRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.updMatCount(data, 1);
            }
        });

        holder.tvMatCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.updMatCount(data, 2);
            }
        });

        holder.tvMatMerchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.updMatMerchant(data);
            }
        });

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.riv_list_item_mat)
        RoundAngleImageView rivMat;
        @Bind(R.id.tv_list_item_mat_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_mat_spec)
        TextView tvSpec;
        @Bind(R.id.tv_list_item_mat_merchant)
        TextView tvMatMerchant;
        @Bind(R.id.tv_list_item_mat_brand)
        TextView tvMatBrand;
        @Bind(R.id.tv_list_item_sum_count)
        TextView tvSumCount;
        @Bind(R.id.tv_list_item_buy_count)
        TextView tvBuyCount;
        @Bind(R.id.iv_list_item_mat_add)
        ImageView ivMatAdd;
        @Bind(R.id.tv_list_item_mat_count)
        TextView tvMatCount;
        @Bind(R.id.iv_list_item_mat_remove)
        ImageView ivMatRemove;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
