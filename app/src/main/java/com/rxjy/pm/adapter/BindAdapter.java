package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.NewCameraListInfo;
import com.rxjy.pm.entity.NewUnBindCameraInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/9.
 */

public class BindAdapter extends SingleBaseAdapter<NewUnBindCameraInfo.BodyBean, BindAdapter.ViewHolder> {


    List<NewUnBindCameraInfo.BodyBean> body;
    Context mContext;

    public BindAdapter(Context mContext, List<NewUnBindCameraInfo.BodyBean> body) {
        super(mContext, body);
        this.body = body;
        this.mContext = mContext;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_camera;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, NewUnBindCameraInfo.BodyBean data, ViewHolder holder) {
        holder.tvCamera.setText(data.getPosition());
        holder.ivCamera.setImageResource(R.mipmap.camera_bind_bg_icon);
        if (data.getStatus() == 1) {
            holder.ivStatus.setImageResource(R.mipmap.status_camera_normal_icon);
        } else {
            holder.ivStatus.setImageResource(R.mipmap.status_camera_abnormal_icon);
        }
        if (data.getUploadsstatus() == 0) {
            holder.ivLineStatus.setImageResource(R.mipmap.status_off_line_icon);
        } else if (data.getUploadsstatus() == 1) {
            holder.ivLineStatus.setImageResource(R.mipmap.status_on_line_icon);
        } else {
            holder.ivLineStatus.setVisibility(View.INVISIBLE);
        }
    }


    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_camera)
        ImageView ivCamera;
        @Bind(R.id.iv_list_item_camera_line_status)
        ImageView ivLineStatus;
        @Bind(R.id.iv_list_item_camera_status)
        ImageView ivStatus;
        @Bind(R.id.tv_list_item_camera)
        TextView tvCamera;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
