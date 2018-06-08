package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.VisitProListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/26.
 */

public class VisitProListAdapter extends SingleBaseAdapter<VisitProListInfo.VisitProList, VisitProListAdapter.ViewHolder> {

    public VisitProListAdapter(Context context, List<VisitProListInfo.VisitProList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_visit_pro_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, VisitProListInfo.VisitProList data, ViewHolder holder) {
        holder.tvTitle.setText(data.getProname());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_visit_pro_list_title)
        TextView tvTitle;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
