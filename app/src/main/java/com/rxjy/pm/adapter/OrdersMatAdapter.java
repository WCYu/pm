package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.OrdersDetailInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/20.
 */

public class OrdersMatAdapter extends SingleBaseAdapter<OrdersDetailInfo.OrdersDetail.ListMatBean, OrdersMatAdapter.ViewHolder> {

    public OrdersMatAdapter(Context context, List<OrdersDetailInfo.OrdersDetail.ListMatBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_orders_detail_mat;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, OrdersDetailInfo.OrdersDetail.ListMatBean data, ViewHolder holder) {
        holder.tvCount.setText((position + 1) + ".");
        holder.tvName.setText(data.getMatName());
        holder.tvSpec.setText(data.getMatSpec());
        holder.tvBrand.setText(data.getBrandName());
        holder.tvNum.setText(data.getAlreadyCount() + data.getUnitName());
        holder.tvPrice.setText("¥" + data.getMatPrice());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_orders_detail_mat_count)
        TextView tvCount;
        @Bind(R.id.tv_list_item_orders_detail_mat_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_orders_detail_mat_spec)
        TextView tvSpec;
        @Bind(R.id.tv_list_item_orders_detail_mat_brand)
        TextView tvBrand;
        @Bind(R.id.tv_list_item_orders_detail_mat_count_num)
        TextView tvNum;
        @Bind(R.id.tv_list_item_orders_detail_mat_price)
        TextView tvPrice;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
