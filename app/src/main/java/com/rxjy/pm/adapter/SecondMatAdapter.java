package com.rxjy.pm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.SecondMatInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/10.
 */

public class SecondMatAdapter extends BaseAdapter {

    private Context mContext;
    private List<SecondMatInfo.SecondMat> dataList;

    private boolean isShowAll = false;

    public SecondMatAdapter(Context mContext, List<SecondMatInfo.SecondMat> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    public void setShowStatus(boolean flag) {
        isShowAll = flag;
        notifyDataSetChanged();
    }

    public boolean getShowStatus(){
        return isShowAll;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SecondMatInfo.SecondMat info = dataList.get(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_second_mat, null);
            AutoUtils.auto(convertView);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(info.getTreeName());

        if (isShowAll) {
            holder.iv.setVisibility(View.GONE);
            if (info.getIsChecked() == 0) {
                holder.lin.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_circular_white));
                holder.tvName.setTextColor(mContext.getResources().getColor(R.color.colorGrayDark));
            } else {
                holder.lin.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_circular_red));
                holder.tvName.setTextColor(mContext.getResources().getColor(R.color.colorRedLight));
            }
        } else {
            if (position == 3){
                holder.iv.setVisibility(View.VISIBLE);
                holder.lin.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_circular_white));
                holder.tvName.setTextColor(mContext.getResources().getColor(R.color.colorGrayDark));
            }else {
                holder.iv.setVisibility(View.GONE);
                if (info.getIsChecked() == 0) {
                    holder.lin.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_circular_white));
                    holder.tvName.setTextColor(mContext.getResources().getColor(R.color.colorGrayDark));
                } else {
                    holder.lin.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_circular_red));
                    holder.tvName.setTextColor(mContext.getResources().getColor(R.color.colorRedLight));
                }
            }
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_list_item_second_mat_name)
        TextView tvName;
        @Bind(R.id.lin_list_item_second_mat)
        LinearLayout lin;
        @Bind(R.id.iv_list_item_second_mat)
        ImageView iv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
