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

public class OrdersSubjoinAdapter extends SingleBaseAdapter<OrdersDetailInfo.OrdersDetail.ListMoneyBean, OrdersSubjoinAdapter.ViewHolder> {

    public OrdersSubjoinAdapter(Context context, List<OrdersDetailInfo.OrdersDetail.ListMoneyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_orders_detail_subjoin;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, OrdersDetailInfo.OrdersDetail.ListMoneyBean data, ViewHolder holder) {
        holder.tvName.setText(data.getTitle());
        holder.tvPrice.setText("¥" + data.getOtherMoney());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_orders_detail_subjoin_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_orders_detail_subjoin_price)
        TextView tvPrice;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
