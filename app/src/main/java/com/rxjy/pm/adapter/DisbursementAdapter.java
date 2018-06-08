package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.DisbursementListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/25.
 */

public class DisbursementAdapter extends SingleBaseAdapter<DisbursementListInfo.DisbursementList, DisbursementAdapter.ViewHolder> {

    public DisbursementAdapter(Context context, List<DisbursementListInfo.DisbursementList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_disbursement;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, DisbursementListInfo.DisbursementList data, ViewHolder holder) {
        if (data.getBranch_state() == 0) {
            holder.tvStatus.setText("处理中");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorOrange));
        } else if (data.getBranch_state() == 1) {
            holder.tvStatus.setText("已批款");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        } else if (data.getBranch_state() == 2) {
            holder.tvStatus.setText("驳回");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        }
        holder.tvMoney.setText("¥ " + data.getMoney());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_disbursement_type)
        TextView tvType;
        @Bind(R.id.tv_list_item_disbursement_status)
        TextView tvStatus;
        @Bind(R.id.tv_list_item_disbursement_time)
        TextView tvTime;
        @Bind(R.id.tv_list_item_disbursement_money)
        TextView tvMoney;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
