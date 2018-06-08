package com.rxjy.pm.adapter.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.entity.XiangMuInfoBean;
import com.rxjy.pm.utils.GlideUtil;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/4.
 */

public class GongRenAdapter extends BaseAdapter {

    Context context;
    ArrayList<XiangMuInfoBean.BodyBean.UserinfoProjectMsgBean> arrayList;

    public GongRenAdapter(Context context, ArrayList<XiangMuInfoBean.BodyBean.UserinfoProjectMsgBean> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_gongren, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.tv_name.setText(arrayList.get(position).getWorkerName());
        viewHolder.tv_phone.setText(arrayList.get(position).getPmWorkerobile());
        viewHolder.tv_zhiwu.setText(arrayList.get(position).getDicname());
        GlideUtil.getInstance().loadRound(arrayList.get(position).getRealUrl(),viewHolder.img_icon,context);
//        Glide.with(context).load(arrayList.get(position).getRealUrl()).apply(RequestOptions.circleCropTransform()).into(viewHolder.img_icon);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_icon;
        public TextView tv_name;
        public TextView tv_phone;
        public TextView tv_zhiwu;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_icon = (ImageView) rootView.findViewById(R.id.img_icon);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
            this.tv_zhiwu = (TextView) rootView.findViewById(R.id.tv_zhiwu);
        }

    }
}
