package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.RoutingBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.rxjy.pm.R.id.tv_list_iteM_routing_state;

/**
 * Created by AAA on 2017/8/28.
 */

public class RoutingAdapter extends SingleBaseAdapter<RoutingBean.BodyBean, RoutingAdapter.ViewHolder> {


    public RoutingAdapter(Context context, List<RoutingBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_routing;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, RoutingBean.BodyBean data, ViewHolder holder) {

        // holder.tvCount.setText("" + (position + 1));

//        if (data.getXj_type() == 11) {
//            holder.tvType.setText("项目进度");
//        } else if (data.getXj_type() == 12) {
//            holder.tvType.setText("项目环境");
//        }
        if (data.getXj_state() == 1) {
            holder.tvState.setText("完成");
            holder.tvTime.setText(data.getXj_finishtime().substring(5));
            holder.tvState.setTextColor(context.getResources().getColor(R.color.colorGreen));
            //String xj_finishtime = data.getXj_finishtime();

        } else if (data.getXj_state() == 0) {
            holder.tvState.setText("未完成");
            holder.tvState.setTextColor(context.getResources().getColor(R.color.colorRed));
            holder.tvTime.setText(" -");
        }
        if(data.getXj_type()==11) {

            holder.tvPeriod.setText("进度巡检 " + data.getXj_starttime().substring(5) + " - " + data.getXj_endtime().substring(5));
        }else {
            holder.tvPeriod.setText("环境巡检 " + data.getXj_starttime().substring(5) + " - " + data.getXj_endtime().substring(5));
        }
        //if(data.getXj_finishtime().contains())

        //holder.tvState.setText("完成");
        // holder.tvState.setText(data.get);
        // holder.tvPeriod.setText("进度巡检  "+TimeUtil.getNormalTime(data.getXj_time()) + " — " + TimeUtil.getNormalTime(data.getXj_shouldfinishtime()));
        //holder.tvTime.setText(TimeUtil.getNormalTime(data.getXj_time()));

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_routing_count)
        TextView tvCount;
        @Bind(R.id.tv_list_item_routing_type)
        TextView tvType;
        @Bind(tv_list_iteM_routing_state)
        TextView tvState;
        @Bind(R.id.tv_list_item_routing_period)
        TextView tvPeriod;
        @Bind(R.id.tv_list_item_routing_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this,v);
        }
    }
}
