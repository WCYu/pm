package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.TimeUtil;
import com.rxjy.pm.entity.PunishRecordInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/28.
 */

public class PunishRecordAdapter extends SingleBaseAdapter<PunishRecordInfo.PunishRecord, PunishRecordAdapter.ViewHolder> {

    public PunishRecordAdapter(Context context, List<PunishRecordInfo.PunishRecord> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_punish_record;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, PunishRecordInfo.PunishRecord data, ViewHolder holder) {
        holder.tvOrderNo.setText(data.getProName());
        holder.tvContent.setText(data.getFineRemark());
        holder.tvMoney.setText("¥" + (int) data.getFineMoney());
        holder.tvTime.setText(TimeUtil.getNormalTime(data.getFineTime()));
        double findMoney = data.getFineMoney();

        if (findMoney >= 0) {
            holder.tvMoney.setTextColor(context.getResources().getColor(R.color.colorGreen));
            holder.ivState.setImageResource(R.mipmap.state_award_icon);
        } else {
            holder.ivState.setImageResource(R.mipmap.state_punish_icon);
            holder.tvMoney.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_punish_record_order_no)
        TextView tvOrderNo;
        @Bind(R.id.tv_list_item_punish_record_money)
        TextView tvMoney;
        @Bind(R.id.tv_list_item_punish_record_content)
        TextView tvContent;
        @Bind(R.id.iv_list_item_punish_state)
        ImageView ivState;
        @Bind(R.id.tv_list_item_punish_record_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
