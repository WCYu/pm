package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.ShopCartInfo;
import com.rxjy.pm.mvp.contract.ShopCartContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/17.
 */

public class ShopMatAdapter extends SingleBaseAdapter<ShopCartInfo.ShopCart.Merchant.Mat, ShopMatAdapter.ViewHolder> {

    private boolean editFlag = false;

    public ShopCartContract.View mListener;

    public ShopMatAdapter(Context context, List<ShopCartInfo.ShopCart.Merchant.Mat> datas) {
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
        return R.layout.list_item_shop_cart_mat;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final ShopCartInfo.ShopCart.Merchant.Mat data, ViewHolder holder) {

        holder.tvName.setText(data.getMatName());
        holder.tvSpec.setText(data.getMatSpec());
        holder.tvBrand.setText(data.getBrandName());
        holder.tvPrice.setText("¥" + data.getMatPrice() + "/" + data.getUnitName());
        holder.tvCount.setText("X" + data.getBuyCount());
        holder.etCount.setText(data.getBuyCount());

        if (data.getIsChecked() == 0) {
            holder.ivChecked.setImageResource(R.mipmap.checked_box_normal_icon);
        } else {
            holder.ivChecked.setImageResource(R.mipmap.checked_box_pressed_icon);
        }

        if (editFlag){
            holder.rlDetail.setVisibility(View.GONE);
            holder.rlEdit.setVisibility(View.VISIBLE);
        }else {
            holder.rlDetail.setVisibility(View.VISIBLE);
            holder.rlEdit.setVisibility(View.GONE);
        }

        holder.ivChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getIsChecked() == 0) {
                    if (mListener != null)
                        mListener.isCheckedMat(data, 1);
                } else {
                    if (mListener != null)
                        mListener.isCheckedMat(data, 0);
                }
            }
        });

        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updMatCount(data,0);
            }
        });

        holder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updMatCount(data,1);
            }
        });

        holder.etCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updMatCount(data,2);
            }
        });

        holder.tvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.updMatCount(data,3);
            }
        });

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_shop_cart_mat_checked)
        ImageView ivChecked;
        @Bind(R.id.tv_list_item_shop_cart_mat_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_shop_cart_mat_brand)
        TextView tvBrand;
        @Bind(R.id.tv_list_item_shop_cart_mat_spec)
        TextView tvSpec;
        @Bind(R.id.tv_list_item_shop_cart_mat_price)
        TextView tvPrice;
        @Bind(R.id.tv_list_item_shop_cart_mat_count)
        TextView tvCount;
        @Bind(R.id.rl_list_item_shop_cart_mat_detail)
        RelativeLayout rlDetail;
        @Bind(R.id.tv_list_item_shop_cart_mat_del)
        TextView tvDel;
        @Bind(R.id.iv_list_item_shop_cart_mat_remove)
        ImageView ivRemove;
        @Bind(R.id.et_list_item_shop_cart_mat_count)
        TextView etCount;
        @Bind(R.id.iv_list_item_shop_cart_mat_add)
        ImageView ivAdd;
        @Bind(R.id.rl_list_item_shop_cart_mat_edit)
        RelativeLayout rlEdit;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
