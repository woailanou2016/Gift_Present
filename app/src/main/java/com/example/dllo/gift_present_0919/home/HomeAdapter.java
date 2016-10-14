package com.example.dllo.gift_present_0919.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/20.
 */
public class HomeAdapter  extends FragmentPagerAdapter {


    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }


    ArrayList<Fragment> fragments;

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    ArrayList<String> title;


    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }


}
