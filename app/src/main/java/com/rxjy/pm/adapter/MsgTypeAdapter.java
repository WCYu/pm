package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.MsgTypeInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgTypeAdapter extends SingleBaseAdapter<MsgTypeInfo.MsgType.MsgInfo, MsgTypeAdapter.ViewHolder> {

    public MsgTypeAdapter(Context context, List<MsgTypeInfo.MsgType.MsgInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_msg_type;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MsgTypeInfo.MsgType.MsgInfo data, ViewHolder holder) {
        holder.tvTitle.setText(data.getTs_msg_typename());
       // holder.tvTime.setText(data.getPostLastTime().substring(5));
        if(data.getPostLastTime().length()==18){
            holder.tvTime.setText(data.getPostLastTime().substring(5,9));
        }else if(data.getPostLastTime().length()==19){
            holder.tvTime.setText(data.getPostLastTime().substring(5,10));
        }
        if (data.getLookNoCount() > 0) {
            holder.tvState.setVisibility(View.VISIBLE);
        } else {
            holder.tvState.setVisibility(View.INVISIBLE);
        }
        switch (data.getTs_msg_type()) {
            case 1:
                holder.ivType.setImageResource(R.mipmap.msg_incident_icon);
                break;
            case 2:
                holder.ivType.setImageResource(R.mipmap.msg_train_icon);
                break;
            case 3:
                holder.ivType.setImageResource(R.mipmap.msg_festival_icon);
                break;
            case 4:
                holder.ivType.setImageResource(R.mipmap.msg_activity_icon);
                break;
            case 5:
                holder.ivType.setImageResource(R.mipmap.msg_other_icon);
                break;
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_msg_type_type)
        ImageView ivType;
        @Bind(R.id.tv_list_item_msg_type_title)
        TextView tvTitle;
        @Bind(R.id.tv_list_item_msg_type_time)
        TextView tvTime;
        @Bind(R.id.tv_list_item_msg_type_state)
        TextView tvState;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
