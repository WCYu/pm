package com.rxjy.pm.pop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.base.SingleBaseAdapter;
import com.rxjy.pm.commons.base.SingleViewHolder;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.AccountInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by AAA on 2017/9/1.
 */

public class AccountPop extends PopupWindow {

    public interface OnAccountPopClickListener {

        void userAccountChoice(AccountInfo data);

        void userAccountDel(AccountInfo data, int position);

    }

    private View mView;
    private Context context;
    private OnAccountPopClickListener mListener;

    private List<AccountInfo> accountList;

    private final AccountAdapter mAdapter;

    private final ListView lvAccount;

    public AccountPop(Context context, int layoutId, int with, int height) {
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

        lvAccount = (ListView) mView.findViewById(R.id.lv_pop_account);

        accountList = new ArrayList<>();

        mAdapter = new AccountAdapter(context, accountList);

        lvAccount.setAdapter(mAdapter);

        lvAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                if (mListener != null)
                    mListener.userAccountChoice(accountList.get(position));
            }
        });

    }

    public void setOnAccountPopClickListener(OnAccountPopClickListener mListener) {
        this.mListener = mListener;
    }

    public void setAccountList(List<AccountInfo> accountList) {
        this.accountList.clear();
        this.accountList.addAll(accountList);
        mAdapter.notifyDataSetChanged();
    }

    class AccountAdapter extends SingleBaseAdapter<AccountInfo, AccountAdapter.ViewHolder> {

        public AccountAdapter(Context context, List<AccountInfo> datas) {
            super(context, datas);
        }

        @Override
        public int getLayoutRes() {
            return R.layout.list_item_pop_account;
        }

        @Override
        public ViewHolder initViewHolder() {
            return new ViewHolder();
        }

        @Override
        public void onBindView(final int position, final AccountInfo data, ViewHolder holder) {
            holder.tvAccount.setText(data.getAccount());
            holder.ivDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (mListener != null)
                        mListener.userAccountDel(data, position);
                }
            });
        }

        class ViewHolder implements SingleViewHolder {
            @Bind(R.id.tv_list_item_pop_account)
            TextView tvAccount;
            @Bind(R.id.iv_list_item_pop_account_del)
            ImageView ivDel;

            @Override
            public void onInFlate(View v) {
                ButterKnife.bind(this, v);
            }
        }
    }


}
