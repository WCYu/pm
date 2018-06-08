package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.BankCardInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/19.
 */

public class BankCardAdapter extends SingleBaseAdapter<BankCardInfo, BankCardAdapter.ViewHolder> {

    public BankCardAdapter(Context context, List<BankCardInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_bank_card;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, BankCardInfo data, ViewHolder holder) {
        String bankCard = data.getBankCard().replace(" ", "");
        holder.tvCardNum.setText(bankCard.substring((bankCard.length() - 4), bankCard.length()));
        String bankName = data.getBankName();
        switch (bankName.trim()) {
            case "工商银行":
                holder.rlCard.setBackgroundResource(R.mipmap.icbc);
                break;
            case "建设银行":
                holder.rlCard.setBackgroundResource(R.mipmap.ccb);
                break;
            case "农业银行":
                holder.rlCard.setBackgroundResource(R.mipmap.abc);
                break;
            case "招商银行":
                holder.rlCard.setBackgroundResource(R.mipmap.cmb);
                break;
            case "中国银行":
                holder.rlCard.setBackgroundResource(R.mipmap.boc);
                break;
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_bank_card_num)
        TextView tvCardNum;
        @Bind(R.id.rl_bank_card)
        RelativeLayout rlCard;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
