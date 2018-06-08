package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.EngineeringInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/8.
 */

public class ProListAdapter extends SingleBaseAdapter<EngineeringInfo, ProListAdapter.ViewHoider> {


    public ProListAdapter(Context context, List<EngineeringInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_pro_list_item;
    }

    @Override
    public ViewHoider initViewHolder() {
        return new ViewHoider();
    }

    @Override
    public void onBindView(int position, EngineeringInfo data, ViewHoider holder) {
        holder.proListItem.setText(data.getF_AREA_NAME()+"");
    }

    public class ViewHoider implements SingleViewHolder {
        @Bind(R.id.pro_list_item)
        TextView proListItem;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
