package com.rxjy.pm.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.DoubleUtils;
import com.rxjy.pm.commons.utils.Utility;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.mvp.contract.ShopCartContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/17.
 */

public class ShopMerchantAdapter extends SingleBaseAdapter<ShopCartInfo.ShopCart.Merchant, ShopMerchantAdapter.ViewHolder> {

    private boolean editFlag = false;

    public ShopCartContract.View mListener;

    public ShopMerchantAdapter(Context context, List<ShopCartInfo.ShopCart.Merchant> datas) {
        super(context, datas);
    }

    public void setListener(ShopCartContract.View mListener) {
        this.mListener = mListener;
    }

    public void setEditFlag(boolean flag) {
        editFlag = flag;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_shop_cart_merchant;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final ShopCartInfo.ShopCart.Merchant data, ViewHolder holder) {

        holder.tvCount.setText("" + (position + 1));
        holder.tMerchantName.setText(data.getUserName());
        holder.tvFPrice.setText(data.getFPrice().equals("0.00") ? "配送费-¥" : data.getFPrice());
        holder.tvPPrice.setText(data.getPPrice().equals("0.00") ? "加工费-¥" : data.getPPrice());
        holder.tvAPrice.setText(data.getAPrice().equals("0.00") ? "辅料费-¥" : data.getAPrice());
        holder.tvTime.setText(data.getOTime().equals("") ? "请选择日期" : data.getOTime());
        holder.tvContent.setText(data.getRemark() == null ? "备注：请填写材料相关属性，物业要求如电线颜色，道路限高等。" : data.getRemark());
        holder.tvTotal.setText("合计：" + getTotal(data));
        if (data.getRemark() == null) {
            holder.tvLength.setText("限制字数0/70");
        } else {
            holder.tvLength.setText("限制字数" + data.getRemark().length() + "/70");
        }
        if (data.getChecked() == 2) {
            holder.ivChecked.setImageResource(R.mipmap.checked_box_pressed_icon);
        } else {
            holder.ivChecked.setImageResource(R.mipmap.checked_box_normal_icon);
        }
        if (data.getChecked() == 0) {
            holder.linMat.setVisibility(View.GONE);
        } else {
            holder.linMat.setVisibility(View.VISIBLE);
        }

        holder.ivChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getChecked() == 2) {
                    if (mListener != null)
                        mListener.isCheckedMerchantAll(data, 0);
                } else {
                    if (mListener != null)
                        mListener.isCheckedMerchantAll(data, 1);
                }
            }
        });

        holder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data.getUserPhone()));
                context.startActivity(intent);
            }
        });

        holder.tvFPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updSubjoin(data, 0);
            }
        });

        holder.tvPPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updSubjoin(data, 1);
            }
        });

        holder.tvAPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updSubjoin(data, 2);
            }
        });

        holder.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updSubjoin(data, 3);
            }
        });

        holder.rlRemark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updSubjoin(data, 4);
            }
        });

        ShopMatAdapter mAdapter = new ShopMatAdapter(context, data.getItems());
        holder.lvMat.setAdapter(mAdapter);
        Utility.setListViewHeightBasedOnChildren(holder.lvMat);
        mAdapter.setEditFlag(editFlag);
        if (mListener != null)
            mAdapter.setListener(mListener);

    }

    private double getTotal(ShopCartInfo.ShopCart.Merchant data) {
        double sum = 0;
        if (data.getChecked() != 0) {
            Double aPrice = Double.parseDouble(data.getAPrice().equals("") ? 0 + "" : data.getAPrice());
            Double pPrice = Double.parseDouble(data.getPPrice().equals("") ? 0 + "" : data.getPPrice());
            Double fPrice = Double.parseDouble(data.getFPrice().equals("") ? 0 + "" : data.getFPrice());
            sum = sum + aPrice + pPrice + fPrice;
        }
        for (ShopCartInfo.ShopCart.Merchant.Mat mat : data.getItems()) {
            if (mat.getIsChecked() == 0) {
                continue;
            } else {
                Double count = Double.parseDouble(mat.getBuyCount().equals("") ? 0 + "" : mat.getBuyCount());
                Double price = Double.parseDouble(mat.getMatPrice().equals("") ? 0 + "" : mat.getMatPrice());
                sum = sum + DoubleUtils.mul(count, price);
            }
        }
        return sum;
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_shop_cart_checked)
        ImageView ivChecked;
        @Bind(R.id.tv_list_item_shop_cart_count)
        TextView tvCount;
        @Bind(R.id.iv_list_item_shop_cart_call)
        ImageView ivCall;
        @Bind(R.id.tv_list_item_shop_cart_merchant_name)
        TextView tMerchantName;
        @Bind(R.id.tv_list_item_shop_cart_f_price)
        TextView tvFPrice;
        @Bind(R.id.tv_list_item_shop_cart_p_price)
        TextView tvPPrice;
        @Bind(R.id.tv_list_item_shop_cart_a_price)
        TextView tvAPrice;
        @Bind(R.id.lv_list_item_shop_cart_mat)
        ListView lvMat;
        @Bind(R.id.iv_list_item_shop_cart_time)
        ImageView ivTime;
        @Bind(R.id.tv_list_item_shop_cart_time)
        TextView tvTime;
        @Bind(R.id.tv_list_item_shop_cart_total)
        TextView tvTotal;
        @Bind(R.id.tv_list_item_shop_cart_content)
        TextView tvContent;
        @Bind(R.id.tv_list_item_shop_cart_length)
        TextView tvLength;
        @Bind(R.id.rl_list_item_shop_cart_remark)
        RelativeLayout rlRemark;
        @Bind(R.id.lin_list_item_shop_cart_mat)
        LinearLayout linMat;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
