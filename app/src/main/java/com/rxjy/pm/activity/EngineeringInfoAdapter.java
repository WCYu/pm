package com.rxjy.pm.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.entity.ProListBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/4/27.
 */

public class EngineeringInfoAdapter extends BaseAdapter {
    private List<ProListBean> mlist;
    private Context context;

    public EngineeringInfoAdapter(List<ProListBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
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
        ViewHolder viewHoider = null;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.project_list_item, null);
            viewHoider = new ViewHolder(convertView);

            convertView.setTag(viewHoider);
        } else {
            viewHoider = (ViewHolder) convertView.getTag();
        }
        viewHoider.engineeringtype.setText(mlist.get(position).getAqi_ItemName());
     //   viewHoider.EngineeringBrief.setText(mlist.get(position).getAqi_);
        viewHoider.UnitQuantity.setText(mlist.get(position).getAqi_ItemUnit());
        viewHoider.quantityEngineering.setText(mlist.get(position).getAqi_QuantityNew() + "");
        viewHoider.UnitPrice.setText(mlist.get(position).getAqi_CostPrice()+"");
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.engineeringtype)
        TextView engineeringtype;
        @Bind(R.id.Engineering_brief)
        TextView EngineeringBrief;
        @Bind(R.id.Unit_quantity)
        TextView UnitQuantity;
        @Bind(R.id.quantity_Engineering)
        TextView quantityEngineering;
        @Bind(R.id.UnitPrice)
        TextView UnitPrice;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
