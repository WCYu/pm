package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.ProMoneyInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/25.
 */

public class ProMoneyAdapter extends SingleBaseAdapter<ProMoneyInfo.ProMoney, ProMoneyAdapter.ViewHolder> {

    public ProMoneyAdapter(Context context, List<ProMoneyInfo.ProMoney> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_pro_money;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ProMoneyInfo.ProMoney data, ViewHolder holder) {
        holder.tvName.setText(data.getProname());
        holder.tvPlanMoney.setText("¥" + data.getActual_publish_money());
        holder.tvUsableMoney.setText("¥" + data.getRenGongMoney());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_pro_money_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_pro_money_status)
        TextView tvStatus;
        @Bind(R.id.tv_list_item_pro_money_plan_money)
        TextView tvPlanMoney;
        @Bind(R.id.tv_list_item_pro_money_usable_money)
        TextView tvUsableMoney;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
