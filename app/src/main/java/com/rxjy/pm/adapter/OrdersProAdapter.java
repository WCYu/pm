package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.OrdersProInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersProAdapter extends SingleBaseAdapter<OrdersProInfo.OrdersPro, OrdersProAdapter.ViewHolder> {

    public OrdersProAdapter(Context context, List<OrdersProInfo.OrdersPro> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_orders_pro;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, OrdersProInfo.OrdersPro data, ViewHolder holder) {

        holder.tvName.setText(data.getProName());
        if (data.getCount() != 0) {
            holder.tvCount.setVisibility(View.VISIBLE);
            holder.tvCount.setText(data.getCount() + "");
        } else {
            holder.tvCount.setVisibility(View.GONE);
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_orders_pro_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_orders_pro_count)
        TextView tvCount;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
