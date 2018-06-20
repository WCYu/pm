package com.rxjy.pm.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rxjy.pm.R;
import com.rxjy.pm.activity.ProjectDetailsActivity;
import com.rxjy.pm.adapter.CustomerAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.entity.CustomerListBean;
import com.rxjy.pm.mvp.contract.CustomerContract;
import com.rxjy.pm.mvp.presenter.CustomerPresenter;

import butterknife.Bind;

/**
 * Created by hjh on 2018/2/27.
 */

public class CustomerFragment extends BaseFragment<CustomerPresenter> implements CustomerContract.View{
    @Bind(R.id.ll_customer)
    ListView llCustomer;


    CustomerAdapter customerAdapter;

    int shuaxin=0;

    public int getShuaxin() {
        return shuaxin;
    }

    public void setShuaxin(int shuaxin) {
        this.shuaxin = shuaxin;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.activity_customer;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
        }else{
            mPresenter.getCustomerList(App.pmUserInfo.getUid()+"",App.cardNo,"1,2");
        }
    }


    public void Refreshs(){
        if(mPresenter!=null) {
            mPresenter.getCustomerList(App.pmUserInfo.getUid()+"",App.cardNo,"1,2");
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if(mPresenter!=null)
            mPresenter.getCustomerList(App.pmUserInfo.getUid()+"",App.cardNo,"1,2");
    }

    @Override
    protected void FragmentInitData() {

    }



    @Override
    protected CustomerPresenter onCreatePresenter() {
        return new CustomerPresenter(this);
    }


    @Override
    public void responseCustomer(final CustomerListBean info) {

        customerAdapter=new CustomerAdapter(getActivity(),info.getBody());
        llCustomer.setAdapter(customerAdapter);
        llCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (info.getBody().get(position).getPi_Type()){
                    case 3:

                        startActivity(new Intent(getActivity(), ProjectDetailsActivity.class).putExtra("type","customer").putExtra("rid",info.getBody().get(position).getPi_OrderId()).putExtra("state",info.getBody().get(position).getPi_State()+"").putExtra("type_stat",info.getBody().get(position).getPi_Type()));
                        break;
                    default:
                        startActivity(new Intent(getActivity(), ProjectDetailsActivity.class).putExtra("type","company").putExtra("rid",info.getBody().get(position).getPi_OrderId()).putExtra("state",info.getBody().get(position).getPi_State()+"").putExtra("type_stat",info.getBody().get(position).getPi_Type()));
                        break;
                }
            }
        });
    }

    private void ShowData(CustomerListBean info){


    }


    @Override
    public void responseCustomerError(String msg) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }


}