package com.rxjy.pm.adapter.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.entity.XiangMuInfoBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/4.
 */

public class XiangMuAdaptr extends BaseAdapter {

    Context context;
    ArrayList<XiangMuInfoBean.BodyBean.UserinfoProjectBean> arrayList;

    public XiangMuAdaptr(Context context, ArrayList<XiangMuInfoBean.BodyBean.UserinfoProjectBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_xiangmu_list, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.tv_name.setText(arrayList.get(position).getCustomerName());
        viewHolder.tv_address.setText(arrayList.get(position).getAddress());
        viewHolder.tv_pic.setText("¥"+arrayList.get(position).getProMoney());
        viewHolder.tv_gcid.setText(arrayList.get(position).getCompany());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_name;
        public TextView tv_name;
        public TextView tv_pic;
        public ImageView img_address;
        public TextView tv_address;
        public TextView tv_gcid;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_name = (ImageView) rootView.findViewById(R.id.img_name);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_pic = (TextView) rootView.findViewById(R.id.tv_pic);
            this.img_address = (ImageView) rootView.findViewById(R.id.img_address);
            this.tv_address = (TextView) rootView.findViewById(R.id.tv_address);
            this.tv_gcid = (TextView) rootView.findViewById(R.id.tv_gcid);
        }

    }
}
