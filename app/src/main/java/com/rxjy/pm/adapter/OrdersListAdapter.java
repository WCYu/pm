package com.rxjy.pm.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.OrdersListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/19.
 */

public class OrdersListAdapter extends SingleBaseAdapter<OrdersListInfo.OrdersList, OrdersListAdapter.ViewHolder> {

    public OrdersListAdapter(Context context, List<OrdersListInfo.OrdersList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_orders_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final OrdersListInfo.OrdersList data, ViewHolder holder) {

        RequestOptions options = new RequestOptions();
        options.error(R.mipmap.circle_header_icon);
        options.placeholder(R.mipmap.circle_header_icon);
        Glide.with(context).load(data.getUserPhoto()).apply(options).into(holder.ivHeader);

        holder.tvName.setText(data.getUserName());
        holder.tvTime.setText(data.getOrderTime());
        holder.tvTotal.setText("¥" + data.getTotalMoney());
//        1-待接单 2-备货中 3-配送中 4-待确认 16-待收款 32-待收款 64-已收款
        if (data.getOrderState() == 1) {
            holder.tvStatus.setText("待接单");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else if (data.getOrderState() == 2 || data.getOrderState() == 3 || data.getOrderState() == 4) {
            holder.tvStatus.setText("配送中");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorOrange));
        } else if (data.getOrderState() == 8) {
            holder.tvStatus.setText("待收货");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else if (data.getOrderState() == 16 || data.getOrderState() == 62) {
            holder.tvStatus.setText("待付款");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else if (data.getOrderState() == 64) {
            holder.tvStatus.setText("已收款");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }
        holder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data.getUserPhone()));
                context.startActivity(intent);
            }
        });

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_orders_list_header)
        ImageView ivHeader;
        @Bind(R.id.tv_list_item_orders_list_name)
        TextView tvName;
        @Bind(R.id.iv_list_item_orders_list_call)
        ImageView ivCall;
        @Bind(R.id.tv_list_item_orders_list_status)
        TextView tvStatus;
        @Bind(R.id.tv_list_item_orders_list_time)
        TextView tvTime;
        @Bind(R.id.tv_list_item_orders_list_total)
        TextView tvTotal;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
