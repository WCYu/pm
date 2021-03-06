package com.rxjy.pm.entity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.commons.utils.TimeUtil;

import java.util.List;

/**
 * Created by AAA on 2017/10/27.
 */

public class VisitAdapter extends BaseAdapter {

    public final int LEFT = 0;
    public final int RIGHT = 1;

    private Context mContext;
    private List<VisitListInfo.VisitInfo> dataList;

    public VisitAdapter(Context context, List<VisitListInfo.VisitInfo> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VisitListInfo.VisitInfo info = dataList.get(position);

        LeftViewHolder leftHolder = null;
        RightViewHolder rightHolder = null;

        //获取当前item类型
        int type = getItemViewType(position);
        // 2判断是否有缓存，以及获取缓存的类型 如果item布局类型循环展示，不用走第2步直接走第4步
        int temp = -1;
        if (convertView != null) {
            if (convertView.getTag() instanceof LeftViewHolder) {
                temp = LEFT;
            } else if (convertView.getTag() instanceof RightViewHolder) {
                temp = RIGHT;
            }
            // 3判断缓存的类型是否是当前item要显示的类型？是，可复用；不是，设置convertView为空重新加载。
            if (temp != temp) {
                convertView = null;
            }
        }
        // 4 判断convertView是否为空？是，复用；不是，重新加载。
        if (convertView == null) {
            // 5.1根据类型 加载当前item要显示的布局，并让convertView setTag当前布局的holder
            switch (type) {
                case LEFT:
                    convertView = View.inflate(mContext, R.layout.list_item_visit_left, null);
                    AutoUtils.auto(convertView);
                    leftHolder = new LeftViewHolder();
                    leftHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_list_item_left_time);
                    leftHolder.tvName = (TextView) convertView.findViewById(R.id.tv_visit_left_name);
                    leftHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_visit_left_content);
                    convertView.setTag(leftHolder);
                    break;
                case RIGHT:
                    convertView = View.inflate(mContext, R.layout.list_item_visit_right, null);
                    AutoUtils.auto(convertView);
                    rightHolder = new RightViewHolder();
                    rightHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_list_item_right_time);
                    rightHolder.tvName = (TextView) convertView.findViewById(R.id.tv_visit_right_name);
                    rightHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_visit_right_content);
                    convertView.setTag(rightHolder);
                    break;
            }
        } else {
            // 5.2根据类型 复用convertView getTag获取当前布局的holder
            switch (type) {
                case LEFT:
                    leftHolder = (LeftViewHolder) convertView.getTag();
                    break;
                case RIGHT:
                    rightHolder = (RightViewHolder) convertView.getTag();
                    break;
            }
        }
        switch (type) {
            case LEFT:
                leftHolder.tvTime.setText(TimeUtil.getNormalTime(info.getCreatetime()));
                leftHolder.tvName.setText("项目人事");
                leftHolder.tvContent.setText(info.getLogcontent());
                break;
            case RIGHT:
                rightHolder.tvTime.setText(TimeUtil.getNormalTime(info.getCreatetime()));
                rightHolder.tvName.setText("项目经理");
                rightHolder.tvContent.setText(info.getLogcontent());
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        VisitListInfo.VisitInfo info = dataList.get(position);
        if (info.getLogtype() == 14) {
            return RIGHT;
        } else {
            return LEFT;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    class RightViewHolder {
        private TextView tvName;
        private TextView tvTime;
        private TextView tvContent;
    }

    class LeftViewHolder {
        private TextView tvName;
        private TextView tvTime;
        private TextView tvContent;
    }

}
