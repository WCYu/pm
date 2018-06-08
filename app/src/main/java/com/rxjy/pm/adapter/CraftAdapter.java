package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.CraftInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/12.
 */

public class CraftAdapter extends SingleBaseAdapter<CraftInfo.Craft, CraftAdapter.ViewHolder> {

    public CraftAdapter(Context context, List<CraftInfo.Craft> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_craft;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, CraftInfo.Craft data, ViewHolder holder) {

        if (data.getNoCount() == 0) {
            holder.tvCount.setVisibility(View.INVISIBLE);
        } else {
            holder.tvCount.setVisibility(View.VISIBLE);
            holder.tvCount.setText(data.getNoCount() + "");
        }

        if (data.getStatus() == 0) {
            holder.tvState.setText("未完成");
            holder.tvState.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else {
            holder.tvState.setText("已完成");
            holder.tvState.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

        holder.tvName.setText(data.getCraft_name());

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_craft_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_craft_state)
        TextView tvState;
        @Bind(R.id.tv_list_item_craft_count)
        TextView tvCount;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
