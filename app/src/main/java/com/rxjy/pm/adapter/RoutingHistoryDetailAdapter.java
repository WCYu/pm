package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/14.
 */

public class RoutingHistoryDetailAdapter extends BaseAdapter {

    private Context context;
    private List<String> dataList;

    public RoutingHistoryDetailAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String url = dataList.get(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_routing_sub, null);
            AutoUtils.auto(convertView);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvCount.setVisibility(View.INVISIBLE);
        Glide.with(context).load(url).into(holder.ivRoutingSub);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_list_item_routing_sub)
        ImageView ivRoutingSub;
        @Bind(R.id.tv_list_item_routing_sub_count)
        TextView tvCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
