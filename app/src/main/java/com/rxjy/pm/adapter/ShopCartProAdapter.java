package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.ShopCartProInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/13.
 */

public class ShopCartProAdapter extends SingleBaseAdapter<ShopCartProInfo.ShopCartPro, ShopCartProAdapter.ViewHolder> {

    public ShopCartProAdapter(Context context, List<ShopCartProInfo.ShopCartPro> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_shop_cart_pro;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ShopCartProInfo.ShopCartPro data, ViewHolder holder) {

        holder.tvName.setText(data.getProName());
        holder.tvCount.setText(data.getMatCount() + "种");
        holder.tvPrice.setText("¥" + data.getTotalMoney());

        switch (data.getProType()) {
            case 1:
                holder.ivType.setImageResource(R.mipmap.work_icon);
                break;
            case 2:
                holder.ivType.setImageResource(R.mipmap.catering_icon);
                break;
            case 3:
                holder.ivType.setImageResource(R.mipmap.business_icon);
                break;
            case 4:
                holder.ivType.setImageResource(R.mipmap.hotel_icon);
                break;
            default:
                holder.ivType.setImageResource(R.mipmap.other_icon);
                break;
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_shop_cart_pro_type)
        ImageView ivType;
        @Bind(R.id.tv_list_item_shop_cart_pro_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_shop_cart_pro_count)
        TextView tvCount;
        @Bind(R.id.tv_list_item_shop_cart_pro_price)
        TextView tvPrice;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
