package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.MsgListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/26.
 */

public class MsgListAdapter extends SingleBaseAdapter<MsgListInfo.MsgList, MsgListAdapter.ViewHolder> {

    public MsgListAdapter(Context context, List<MsgListInfo.MsgList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_msg_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MsgListInfo.MsgList data, ViewHolder holder) {
        holder.tvTitle.setText(data.getTs_msg_title());
        if(data.getTs_post_time().length()==18){
            holder.tvTime.setText(data.getTs_post_time().substring(5,9));
        }else if(data.getTs_post_time().length()==19){
            holder.tvTime.setText(data.getTs_post_time().substring(5,10));
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_msg_list_title)
        TextView tvTitle;
        @Bind(R.id.iv_list_item_msg_list_arrow)
        ImageView ivArrow;
        @Bind(R.id.tv_list_item_msg_list_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
