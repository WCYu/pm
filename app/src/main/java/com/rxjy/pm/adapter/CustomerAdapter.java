package com.rxjy.pm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.CustomerListBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/2/28.
 */

public class CustomerAdapter extends SingleBaseAdapter<CustomerListBean.BodyBean, CustomerAdapter.ViewHolder> {


    public CustomerAdapter(Context context, List<CustomerListBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_customer;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }


    @Override
    public void onBindView(int position, CustomerListBean.BodyBean data, ViewHolder holder) {

//1是商务 2主案 3：自带
        switch (data.getPi_Type()) {
            case 3:
                holder.tvTip.setText("自带");
                holder.tvTip.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                break;
            default:
                holder.tvTip.setText("分配");
                holder.tvTip.setBackgroundColor(context.getResources().getColor(R.color.colorOrange));
                break;
        }
        holder.tvTitle.setText(data.getPi_Name());
        Log.e("bg",data.getPi_State()+"");
        switch (data.getPi_State()) {
            case 1:
                holder.tvType.setText("接单");
                holder.tvType.setTextColor(context.getResources().getColor(R.color.colorOrange));
                break;
            case 2:
                holder.tvType.setText("在谈");
                holder.tvType.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                break;
            case 3:
                holder.tvType.setText("在谈");
                holder.tvType.setTextColor(context.getResources().getColor(R.color.colorGreen));
                break;
            case 4:
                holder.tvType.setText("在谈");
                holder.tvType.setTextColor(context.getResources().getColor(R.color.colorGrayDark));
                break;
            case 5:
                holder.tvType.setText("未签");
                break;
            case 6:
                holder.tvType.setText("已签");
                break;
            case 7:
                holder.tvType.setText("打回");
        }

        String time = "";
//        if(data.getPi_UpdateTime()!=null){
//            time=data.getPi_UpdateTime();
//            if(data.getPi_UpdateTime().length()>=10){
//                time=time.substring(0,9);
//            }
//        }else
        if (data.getPi_CreateTime() != null) {
            time = data.getPi_CreateTime();
            if (data.getPi_CreateTime().length() >= 11) {
                time = time.substring(0, 10);
            }
        }
        holder.tvTime.setText(time);

    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.tv_tip)
        TextView tvTip;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_type)
        TextView tvType;
        @Bind(R.id.tv_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
