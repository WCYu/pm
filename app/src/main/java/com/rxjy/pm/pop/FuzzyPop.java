package com.rxjy.pm.pop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.HotWordInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称：项目经理
 * 类描述：模糊搜索弹出框
 * 创建人：雷明辉
 * 创建时间：17-10-11 下午3:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class FuzzyPop extends PopupWindow {

    public interface OnPopItemClickListener {

        void onItemClick(HotWordInfo.HotWord data);

    }

    private View mView;
    private Context context;
    public OnPopItemClickListener mListener;

    private List<HotWordInfo.HotWord> fuzzyList;

    private FuzzyAdapter mAdapter;

    private ListView lv;

    private View v;

    public FuzzyPop(Context context, int layoutId, int with, int height) {
        this.context = context;
        mView = LayoutInflater.from(context).inflate(layoutId, null);

        AutoUtils.auto(mView);

        setContentView(mView);
        //设置宽度
        setWidth(with);
        //设置高度
        setHeight(height);
        //设置背景透明
        setBackgroundDrawable(new ColorDrawable(80));

        lv = (ListView) mView.findViewById(R.id.lv_fuzzy_search);

        v = mView.findViewById(R.id.v_fuzzy_search);

        fuzzyList = new ArrayList<>();

        mAdapter = new FuzzyAdapter(context, fuzzyList);

        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                if (mListener != null)
                    mListener.onItemClick(fuzzyList.get(position));
            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void setOnPopItemClickListener(OnPopItemClickListener mListener) {
        this.mListener = mListener;
    }

    public void setFuzzyList(List<HotWordInfo.HotWord> dataList) {
        this.fuzzyList.clear();
        this.fuzzyList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    class FuzzyAdapter extends SingleBaseAdapter<HotWordInfo.HotWord, FuzzyAdapter.ViewHolder> {

        public FuzzyAdapter(Context context, List<HotWordInfo.HotWord> datas) {
            super(context, datas);
        }

        @Override
        public int getLayoutRes() {
            return R.layout.list_item_pop_fuzzy_search;
        }

        @Override
        public ViewHolder initViewHolder() {
            return new ViewHolder();
        }

        @Override
        public void onBindView(int position, HotWordInfo.HotWord data, ViewHolder holder) {

            holder.tvTitle.setText(data.getTitle());

        }

        class ViewHolder implements SingleViewHolder {
            @Bind(R.id.tv_list_item_fuzzy_search_title)
            TextView tvTitle;

            @Override
            public void onInFlate(View v) {
                ButterKnife.bind(this, v);
            }
        }
    }

}
