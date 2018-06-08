package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.RoutingHistoryInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/18.
 */

public class RoutingHistoryAdapter extends SingleBaseAdapter<RoutingHistoryInfo.RoutingHistory, RoutingHistoryAdapter.ViewHolder> {

    public RoutingHistoryAdapter(Context context, List<RoutingHistoryInfo.RoutingHistory> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_routing_history;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, RoutingHistoryInfo.RoutingHistory data, ViewHolder holder) {
        holder.tvCount.setText("" + (position + 1));
        holder.tvTime.setText(data.getXj_finishtime());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_routing_history_count)
        TextView tvCount;
        @Bind(R.id.tv_list_item_routing_history_type)
        TextView tvType;
        @Bind(R.id.tv_list_item_routing_history_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
