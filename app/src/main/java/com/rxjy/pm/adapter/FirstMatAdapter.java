package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.FirstMatInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/10.
 */

public class FirstMatAdapter extends SingleBaseAdapter<FirstMatInfo.FirstMat, FirstMatAdapter.ViewHolder> {

    public FirstMatAdapter(Context context, List<FirstMatInfo.FirstMat> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_first_mat;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, FirstMatInfo.FirstMat data, ViewHolder holder) {

        holder.tvName.setText(data.getTreeName());

        if (data.getIsChecked() == 0) {
            holder.tvName.setTextColor(context.getResources().getColor(R.color.colorBlackLight));
            holder.vLine.setVisibility(View.INVISIBLE);
        } else {
            holder.tvName.setTextColor(context.getResources().getColor(R.color.colorRedLight));
            holder.vLine.setVisibility(View.VISIBLE);
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_first_mat_name)
        TextView tvName;
        @Bind(R.id.v_list_item_first_mat_line)
        View vLine;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
