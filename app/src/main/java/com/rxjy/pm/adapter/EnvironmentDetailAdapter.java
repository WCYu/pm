package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.EnvironmentDetailInfo;
import com.rxjy.pm.mvp.contract.EnvironmentDetailContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/15.
 */

public class EnvironmentDetailAdapter extends SingleBaseAdapter<EnvironmentDetailInfo.EnvironmentDetail, EnvironmentDetailAdapter.ViewHolder> {

    private EnvironmentDetailContract.View listener;

    public EnvironmentDetailAdapter(Context context, EnvironmentDetailContract.View listener, List<EnvironmentDetailInfo.EnvironmentDetail> datas) {
        super(context, datas);
        this.listener = listener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_process_detail;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(final int position, final EnvironmentDetailInfo.EnvironmentDetail data, ViewHolder holder) {
        holder.tvStep.setText("" + (position + 1));
        holder.tvStepName.setText(data.getStepName());
        holder.tvStepDesc.setText(data.getStepDesc());

        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.placeholder_img);
        options.error(R.mipmap.default_img);

        Glide.with(context).load(data.getStepPhotoUrl()).apply(options).into(holder.ivStandardPhoto);

        Glide.with(context).load(data.getPhotoUrl()).apply(options).into(holder.ivUserPhoto);

        if (data.getPhotoUrl().length() == 0) {
            holder.ivUserPhoto.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            holder.ivUserPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        holder.ivUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getPhotoUrl().length() == 0) {
                    listener.subProcessPhoto(data, position);
                } else {
                    listener.largePhoto(data.getPhotoUrl());
                }
            }
        });

        holder.ivStandardPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getStepPhotoUrl() != null) {
                    listener.largePhoto(data.getStepPhotoUrl());
                }
            }
        });

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_process_detail_step)
        TextView tvStep;
        @Bind(R.id.tv_list_item_process_detail_step_name)
        TextView tvStepName;
        @Bind(R.id.tv_list_item_process_detail_step_desc)
        TextView tvStepDesc;
        @Bind(R.id.iv_list_item_process_detail_standard_photo)
        ImageView ivStandardPhoto;
        @Bind(R.id.iv_list_item_process_detail_user_photo)
        ImageView ivUserPhoto;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
