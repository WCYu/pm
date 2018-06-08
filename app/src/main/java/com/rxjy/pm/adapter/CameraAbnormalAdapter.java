package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.CameraAbnormalInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/17.
 */

public class CameraAbnormalAdapter extends SingleBaseAdapter<CameraAbnormalInfo.CameraAbnormal, CameraAbnormalAdapter.ViewHolder> {

    public CameraAbnormalAdapter(Context context, List<CameraAbnormalInfo.CameraAbnormal> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_camera_abnormal;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, CameraAbnormalInfo.CameraAbnormal data, ViewHolder holder) {
        holder.tvContent.setText((position + 1) + ".记录" + (position + 1));
        holder.tvTime.setText(TimeUtil.getNormalTime(data.getEa_StartTime()));
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_camera_abnormal_content)
        TextView tvContent;
        @Bind(R.id.tv_list_item_camera_abnormal_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
