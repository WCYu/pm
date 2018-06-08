package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.ProcessDetailInfo;
import com.rxjy.pm.mvp.contract.ProcessDetailContract;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class ProcessDetailAdapter extends SingleBaseAdapter<ProcessDetailInfo.ProcessDetail, ProcessDetailAdapter.ViewHolder> {

    private ProcessDetailContract.View listener;

    public ProcessDetailAdapter(Context context, ProcessDetailContract.View listener, List<ProcessDetailInfo.ProcessDetail> datas) {
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
    public void onBindView(final int position, final ProcessDetailInfo.ProcessDetail data, ViewHolder holder) {

        holder.tvStep.setText("" + (position + 1));
        holder.tvName.setText(data.getStepName());
        holder.tvDesc.setText(data.getStepDesc());
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.placeholder_img);
        options.error(R.mipmap.default_img);
        Glide.with(context).load(data.getStepPhotoUrl()).apply(options).into(holder.ivStandard);

        Glide.with(context).load(data.getPhotoUrl()).apply(options).into(holder.ivUser);

        if (data.getPhotoUrl().length() == 0) {
            holder.ivUser.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            holder.ivUser.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        holder.ivStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getStepPhotoUrl() != null) {
                    listener.largePhoto(data.getStepPhotoUrl());
                }
            }
        });

        holder.ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getPhotoUrl().length() == 0) {
                    listener.subProcessPhoto(data);
                } else {
                    listener.largePhoto(data.getPhotoUrl());
                }
            }
        });

//        if (data.getStepName().equals("摄像头安装")) {
//            if (data.getPhotoUrlForCarmea() != null)
//                holder.tvPhotoCount.setText(data.getPhotoUrlForCarmea().size() + "");
//            else
//                holder.tvPhotoCount.setText(0 + "");
//            holder.rlPhotoView.setVisibility(View.VISIBLE);
//            holder.ivUser.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (data.getPhotoUrl().length() == 0) {
//                        listener.subProcessPhoto(data);
//                    } else {
//                        listener.subProcessCameraPhoto(data);
//                    }
//                }
//            });
//            holder.rlPhotoView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.hasUploadPhotoView(data.getPhotoUrlForCarmea());
//                }
//            });
//        } else {
//            holder.rlPhotoView.setVisibility(View.GONE);
//            holder.ivUser.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (data.getPhotoUrl().length() == 0) {
//                        listener.subProcessPhoto(data);
//                    } else {
//                        listener.largePhoto(data.getPhotoUrl());
//                    }
//                }
//            });
//        }

    }

    class ViewHolder implements SingleViewHolder {

        TextView tvStep;
        TextView tvName;
        TextView tvDesc;
        ImageView ivStandard;
        ImageView ivUser;
        RelativeLayout rlPhotoView;
        TextView tvPhotoCount;

        @Override
        public void onInFlate(View v) {
            tvStep = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step);
            tvName = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step_name);
            tvDesc = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step_desc);
            ivStandard = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_standard_photo);
            ivUser = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_user_photo);
            rlPhotoView = (RelativeLayout) v.findViewById(R.id.rl_list_item_process_detail_photo_view);
            tvPhotoCount = (TextView) v.findViewById(R.id.tv_list_item_process_detail_photo_count);
        }
    }
}
