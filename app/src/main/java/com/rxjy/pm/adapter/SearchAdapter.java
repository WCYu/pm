package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.HotWordInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/10/12.
 */

public class SearchAdapter extends SingleBaseAdapter<HotWordInfo.HotWord, SearchAdapter.ViewHolder> {

    public SearchAdapter(Context context, List<HotWordInfo.HotWord> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_second_mat;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, HotWordInfo.HotWord data, ViewHolder holder) {

        holder.tvMatName.setText(data.getTitle());

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_second_mat_name)
        TextView tvMatName;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
