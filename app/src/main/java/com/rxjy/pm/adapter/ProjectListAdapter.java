package com.rxjy.pm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.entity.ProjectInfo;
import com.rxjy.pm.mvp.contract.HomeContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/11.
 */

public class ProjectListAdapter extends SingleBaseAdapter<ProjectInfo.Project, ProjectListAdapter.ViewHolder> {

    private HomeContract.View listener;

    public ProjectListAdapter(Context context, HomeContract.View listener, List<ProjectInfo.Project> datas) {
        super(context, datas);
        this.listener = listener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_home;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final ProjectInfo.Project data, ViewHolder holder) {

        holder.tvProjectName.setText(data.getProName());
        holder.tvProjectTime.setText(data.getBeginTime().substring(2, data.getBeginTime().indexOf("T")) + "至" + data.getEndTime().substring(2, data.getEndTime().indexOf("T")));
        switch (data.getState()) {
            case 6:
                holder.tvProjectState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_project_state_wait));
                holder.tvProjectState.setText("待工");
                break;
            case 7:
                holder.tvProjectState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_project_state_start));
                holder.tvProjectState.setText("施工");
                break;
            case 8:
                holder.tvProjectState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_project_state_finish));
                holder.tvProjectState.setText("竣工");
                break;
            case 71:
                holder.tvProjectState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_project_state_finish));
                holder.tvProjectState.setText("竣工");
                break;
        }

        holder.rlPrepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.startToPrepare(data);
            }
        });

        holder.rlRouting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.startToRouting(data);
            }
        });

        holder.rlDisbursement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.startToDisbursement(data);
            }
        });

        holder.rlMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.startToMat(data);
            }
        });

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_project_name)
        TextView tvProjectName;
        @Bind(R.id.tv_list_item_project_state)
        TextView tvProjectState;
        @Bind(R.id.tv_list_item_project_time)
        TextView tvProjectTime;
        @Bind(R.id.rl_list_item_prepare)
        RelativeLayout rlPrepare;
        @Bind(R.id.rl_list_item_routing)
        RelativeLayout rlRouting;
        @Bind(R.id.rl_list_item_disbursement)
        RelativeLayout rlDisbursement;
        @Bind(R.id.rl_list_item_material)
        RelativeLayout rlMaterial;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
