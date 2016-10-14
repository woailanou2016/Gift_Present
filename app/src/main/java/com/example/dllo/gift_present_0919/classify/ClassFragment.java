package com.example.dllo.gift_present_0919.classify;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.classify.single.SimpleFragment;
import com.example.dllo.gift_present_0919.classify.srtategy.StrategyFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/19.
 */
public class ClassFragment extends BaseFragment {


    private ViewPager class_vp;
    private TabLayout class_tb;

    @Override
    protected int setLayout() {
        return R.layout.class_fragment;
    }

    @Override
    protected void initView() {
        class_vp = bindView(R.id.class_viewpager);
        class_tb = bindView(R.id.class_tablayout);

    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new StrategyFragment());
        fragments.add(new SimpleFragment());

        ClassAdapter adapter = new ClassAdapter(getChildFragmentManager(),fragments);
        class_vp.setAdapter(adapter);
        class_tb.setupWithViewPager(class_vp);

    }
}
