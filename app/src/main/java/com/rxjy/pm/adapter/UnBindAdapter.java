package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.NewCameraListInfo;
import com.rxjy.pm.entity.UnbindCameraListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/9.
 */

public class UnBindAdapter extends SingleBaseAdapter<NewCameraListInfo.BodyBean, UnBindAdapter.ViewHolder> {

    List<NewCameraListInfo.BodyBean> body;
    Context mContext;

    public UnBindAdapter(Context mContext, List<NewCameraListInfo.BodyBean> body) {
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
    public void onBindView(int position, NewCameraListInfo.BodyBean data, ViewHolder holder) {
        holder.tvCamera.setText(data.getCamerano());
        holder.ivCamera.setImageResource(R.mipmap.camera_unbind_bg_icon);
        holder.ivLineStatus.setVisibility(View.INVISIBLE);
        holder.ivStatus.setVisibility(View.INVISIBLE);
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
