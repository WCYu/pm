package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.ProjectInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/9.
 */

public class ProAdapter extends SingleBaseAdapter<ProjectInfo.Project, ProAdapter.ViewHolder> {

    public ProAdapter(Context context, List<ProjectInfo.Project> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_project;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ProjectInfo.Project data, ViewHolder holder) {

//        ProType：1办公，2餐饮，3商业，4酒店，5其他
        holder.tvName.setText(data.getProName());
        holder.tvAddress.setText(data.getProAddr());
        holder.tvTime.setText((TimeUtil.getNormalTime(data.getBeginTime()) + " - " + (TimeUtil.getNormalTime(data.getEndTime()))));
        switch (data.getProType()) {
            case 1:
                holder.ivMark.setImageResource(R.mipmap.mark_work_icon);
                break;
            case 2:
                holder.ivMark.setImageResource(R.mipmap.mark_repast_icon);
                break;
            case 3:
                holder.ivMark.setImageResource(R.mipmap.mark_business_icon);
                break;
            case 4:
                holder.ivMark.setImageResource(R.mipmap.mark_hotel_icon);
                break;
            case 5:
                holder.ivMark.setImageResource(R.mipmap.mark_other_icon);
                break;
        }
        switch (data.getState()) {
            case 0:
                holder.ivState.setImageResource(R.mipmap.connected);
                break;
            case 1:
                holder.ivState.setImageResource(R.mipmap.connected);
                break;
            case 2:
                holder.ivState.setImageResource(R.mipmap.connected);
                break;
            case 3:
                holder.ivState.setImageResource(R.mipmap.connected);
                break;
            case 4:
                holder.ivState.setImageResource(R.mipmap.connected);
                break;
            case 6:
                holder.ivState.setImageResource(R.mipmap.pro_state_wait_icon);
                break;
            case 7:
                holder.ivState.setImageResource(R.mipmap.pro_state_start_icon);
                break;
            case 71:
                holder.ivState.setImageResource(R.mipmap.pro_state_before_finish_icon);
                break;
            case 8:
                holder.ivState.setImageResource(R.mipmap.pro_state_finish_icon);
                break;
        }
        if(data.getState()==4&&data.getPushStatus()==5){
            holder.ivState.setImageResource(R.mipmap.finish);
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_pro_mark)
        ImageView ivMark;
        @Bind(R.id.tv_list_item_pro_name)
        TextView tvName;
        @Bind(R.id.iv_list_item_pro_state)
        ImageView ivState;
        @Bind(R.id.tv_list_item_pro_address)
        TextView tvAddress;
        @Bind(R.id.tv_list_item_pro_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
