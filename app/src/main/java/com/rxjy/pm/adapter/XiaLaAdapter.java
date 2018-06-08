package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.entity.YinHangBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/7.
 */

public class XiaLaAdapter extends BaseAdapter {
    ArrayList<YinHangBean.BodyBean> arrayList;
    Context context;

    String yinHangName;

    public XiaLaAdapter(ArrayList<YinHangBean.BodyBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setYinHangName(String yinHangName){
        this.yinHangName = yinHangName;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_xiala, null);

        ViewHolder viewHolder = new ViewHolder(convertView);
        if(yinHangName!=null){
            viewHolder.tv_title.setText(yinHangName);
        }
        viewHolder.tv_title.setText(arrayList.get(position).getKey());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
}
