package com.rxjy.pm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class UnderConstructionPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> listFragment;
    private FragmentManager fm;

    public UnderConstructionPagerAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        this.fm = fm;
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
