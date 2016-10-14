package com.example.dllo.gift_present_0919.classify;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/21.
 */
public class ClassAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String>  classtitle = new ArrayList<>();
    public ClassAdapter(FragmentManager fm) {
        super(fm);
    }

    public ClassAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        classtitle.add("攻略");
        classtitle.add("单品");
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
        return classtitle.get(position);
    }
}
