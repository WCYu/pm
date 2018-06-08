package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.EvaluateMarkInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/26.
 */

public class MarkAdapter extends SingleBaseAdapter<EvaluateMarkInfo.StarInfo.MarkInfo, MarkAdapter.ViewHolder> {

    public MarkAdapter(Context context, List<EvaluateMarkInfo.StarInfo.MarkInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_evaluate_mark;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, EvaluateMarkInfo.StarInfo.MarkInfo data, ViewHolder holder) {

        holder.tvMark.setText(data.getMarkTitle());

        if (data.getIsChecked() == 0){
            holder.tvMark.setTextColor(context.getResources().getColor(R.color.colorGrayDark));
            holder.tvMark.setBackgroundResource(R.drawable.shape_circular_rectangle_red);
        }else {
            holder.tvMark.setTextColor(context.getResources().getColor(R.color.colorWhite));
            holder.tvMark.setBackgroundResource(R.drawable.shape_circular_rectangle_red_solid);
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_mark)
        TextView tvMark;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
