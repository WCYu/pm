package com.rxjy.pm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/2/28.
 */

public class PhotoShowAdapter extends SingleBaseAdapter<String, PhotoShowAdapter.ViewHolder> {


    public PhotoShowAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_photo;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, String data, ViewHolder holder) {
        Log.e("走不走", "走走走" + position);
        if (data.equals("")) {
            Log.e("fsdfsdfs", "sfsdf");
            holder.ivTip.setVisibility(View.VISIBLE);
            holder.tvTip.setVisibility(View.VISIBLE);
//            holder.ivPhoto.setImageResource(R.mipmap.ic_photode);
        } else {
            Log.e("fsdfsdfs111", "sfsdf  " + position);
            holder.ivTip.setVisibility(View.GONE);
            holder.tvTip.setVisibility(View.GONE);
            Glide.with(context).load(data).into(holder.ivPhoto);
        }
    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.iv_photo)
        ImageView ivPhoto;
        @Bind(R.id.iv_tip)
        ImageView ivTip;
        @Bind(R.id.tv_tip)
        TextView tvTip;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}