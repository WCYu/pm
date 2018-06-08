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
import com.rxjy.pm.entity.CraftDetailInfo;
import com.rxjy.pm.mvp.contract.CraftDetailContract;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public class CraftDetailAdapter extends SingleBaseAdapter<CraftDetailInfo.CraftDetail, CraftDetailAdapter.ViewHolder> {


    private CraftDetailContract.View listener;

    public CraftDetailAdapter(Context context, CraftDetailContract.View listener, List<CraftDetailInfo.CraftDetail> datas) {
        super(context, datas);
        this.listener = listener;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.list_item_craft_detail;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(final int position, final CraftDetailInfo.CraftDetail data, ViewHolder holder) {

        holder.tvStep.setText("" + (position + 1));
        holder.tvName.setText(data.getCraft_name());

        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.placeholder_img);
        options.error(R.mipmap.default_img);

        Glide.with(context).load(data.getStandard_url()).apply(options).into(holder.ivStandardPhoto);

        Glide.with(context).load(data.getUrl()).apply(options).into(holder.ivUserPhoto);

        if (data.getUrl().length() == 0) {
            holder.ivUserPhoto.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            holder.ivUserPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        holder.ivUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getUrl().length() == 0) {
                    listener.subCraftPhoto(data, position);
                } else {
                    listener.largePhoto(data.getUrl());
                }
            }
        });

        holder.ivStandardPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getStandard_url() != null) {
                    listener.largePhoto(data.getStandard_url());
                }
            }
        });

    }

    class ViewHolder implements SingleViewHolder {

        private TextView tvStep;
        private TextView tvName;
        private ImageView ivStandardPhoto;
        private ImageView ivUserPhoto;

        @Override
        public void onInFlate(View v) {
            tvStep = (TextView) v.findViewById(R.id.tv_list_item_craft_detail_step);
            tvName = (TextView) v.findViewById(R.id.tv_list_item_craft_detail_name);
            ivStandardPhoto = (ImageView) v.findViewById(R.id.iv_list_item_craft_detail_standard_photo);
            ivUserPhoto = (ImageView) v.findViewById(R.id.iv_list_item_craft_detail_user_photo);
        }
    }

}
