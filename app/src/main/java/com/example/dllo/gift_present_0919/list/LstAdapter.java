package com.example.dllo.gift_present_0919.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/20.
 */
public class LstAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> fragments ;

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    ArrayList<String>  listtitle;

    public void setListtitle(ArrayList<String> listtitle) {
        this.listtitle = listtitle;
    }
    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public LstAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
