package com.javalj.androidapp4demo.main.ui.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lijie on 2016/2/18.
 */
public class FragmentViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mList;

    public FragmentViewPageAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment fragment = ViewPagerFragment.newInstance(mList.get(position));
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
