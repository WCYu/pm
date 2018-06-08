package com.rxjy.pm.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxjy.pm.R;
import com.rxjy.pm.activity.NewsDetailActivity;
import com.rxjy.pm.adapter.NewsListAdapter;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseFragment;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.NewsListInfo;
import com.rxjy.pm.mvp.contract.NewsListContract;
import com.rxjy.pm.mvp.presenter.NewsListPresenter;
import com.rxjy.pm.widget.xlistview.XListView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by AAA on 2017/7/26.
 */

public class FindFragment extends BaseFragment<NewsListPresenter> implements NewsListContract.View, AdapterView.OnItemClickListener, XListView.IXListViewListener {

    @Bind(R.id.xlv_find)
    XListView xlvFind;

    public static final String TITLE = "发现";

    private NewsListAdapter mAdapter;

    private List<NewsListInfo.BodyBean.ListBean> newsList;

    private List<NewsListInfo.BodyBean.TopListBean> bannerList;

    private int pageIndex = 0;

    private int pageSize = 10;

    private XBanner banner;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void FragmentInitData() {
        //initTitle();
        initNewsData();
        initBannerData();
    }

    private void initTitle() {

    }

    private void initNewsData() {

        newsList = new ArrayList<>();

        mAdapter = new NewsListAdapter(getActivity(), newsList);

        xlvFind.setAdapter(mAdapter);

        xlvFind.setPullLoadEnable(false);

        xlvFind.setXListViewListener(this);

        xlvFind.setOnItemClickListener(this);

        //获取新闻列表接口

        mPresenter.getNewsList(App.cardNo, pageIndex, pageSize);

    }

    private void initBannerData() {

        bannerList = new ArrayList<>();

    }

    @Override
    protected NewsListPresenter onCreatePresenter() {
        return new NewsListPresenter(this);
    }
    @Override
    public void responseNewsListData(List<NewsListInfo.BodyBean.ListBean> dataList) {
        onLoad();
        newsList.clear();
        newsList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
    }

    @Override
    public void responseNewsListDataError(String msg) {
        onLoad();
        showToast(msg);
    }
    @Override
    public void responseNewsListLoadMoreData(List<NewsListInfo.BodyBean.ListBean> dataList) {
        onLoad();
        newsList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
    }

    @Override
    public void responseNewsListLoadMoreDataError(String msg) {
        onLoad();
        showToast(msg);
    }
    @Override
    public void responseBannerData(List<NewsListInfo.BodyBean.TopListBean> dataList) {

        if (bannerList.size() == 0) {
            View view = View.inflate(getActivity(), R.layout.banner, null);

            AutoUtils.auto(view);

            banner = (XBanner) view.findViewById(R.id.banner);

            bannerList.addAll(dataList);
            final List<String> imgUrlList = new ArrayList<>();
            List<String> textList = new ArrayList<>();
            for (NewsListInfo.BodyBean.TopListBean info : bannerList) {
                imgUrlList.add(info.getCover());
                textList.add(info.getName());
            }
            //添加广告数据
            banner.setData(imgUrlList, textList);//第二个参数为提示文字资源集合
            banner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    if (imgUrlList != null)
                        Glide.with(getActivity()).load(imgUrlList.get(position)).into((ImageView) view);
                }
            });
            banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, int position) {
                    NewsListInfo.BodyBean.TopListBean info = bannerList.get(position);
                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                    intent.putExtra(Constants.ACTION_TO_NEWS_DETAIL_NEWS_ID, info.getId());
                    startActivity(intent);
                }
            });
            xlvFind.addHeaderView(view);
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsListInfo.BodyBean.ListBean info = newsList.get(position - 2);
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_NEWS_DETAIL_NEWS_ID, info.getId());
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        //获取新闻列表接口
        mPresenter.getNewsList(App.cardNo, pageIndex, pageSize);
//        mPresenter.getNewsList("00000010", pageIndex, pageSize);
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        //获取新闻列表接口
       mPresenter.getNewsListLoadMore(App.cardNo, pageIndex, pageSize);
       //mPresenter.getNewsList(App.cardNo, pageIndex, pageSize);
//      mPresenter.getNewsListLoadMore("00000010", pageIndex, pageSize);
    }
    //停止刷新
    private void onLoad() {
        xlvFind.stopRefresh();
        xlvFind.stopLoadMore();
        xlvFind.setRefreshTime("刚刚");
    }

    //是否显示加载更多
    private void isShowLoad(int size) {
        if (size < pageSize) {
            xlvFind.setPullLoadEnable(false);
        } else {
            xlvFind.setPullLoadEnable(true);
        }
    }

}
