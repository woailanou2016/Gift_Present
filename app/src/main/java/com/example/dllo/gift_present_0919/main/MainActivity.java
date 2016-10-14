package com.example.dllo.gift_present_0919.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.dllo.gift_present_0919.baseaty.BaseAty;
import com.example.dllo.gift_present_0919.classify.ClassFragment;
import com.example.dllo.gift_present_0919.home.HomeFragment;
import com.example.dllo.gift_present_0919.list.ListFragment;
import com.example.dllo.gift_present_0919.mine.MineFragment;
import com.example.dllo.gift_present_0919.R;

public  class MainActivity extends BaseAty implements View.OnClickListener {


    private RadioButton button_home;
    private RadioButton button_list;
    private RadioButton button_class;
    private RadioButton button_mine;
    private FrameLayout frame_main;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        frame_main = bindView(R.id.frame_main);
        button_home = bindView(R.id.button_home);
        button_list = bindView(R.id.button_list);
        button_class = bindView(R.id.button_class);
        button_mine = bindView(R.id.button_mine);

        button_home.setOnClickListener(this);
        button_list.setOnClickListener(this);
        button_class.setOnClickListener(this);
        button_mine.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_main,new HomeFragment());
        button_home.setChecked(true);
        transaction.commit();

    }

    @Override
    public void onClick(View view) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (view.getId()){
            case R.id.button_home:
                transaction.replace(R.id.frame_main,new HomeFragment());
                break;
            case R.id.button_list:
                transaction.replace(R.id.frame_main,new ListFragment());
                break;
            case R.id.button_class:
                transaction.replace(R.id.frame_main,new ClassFragment());
                break;
            case R.id.button_mine:
                transaction.replace(R.id.frame_main,new MineFragment());
                break;
        }
        transaction.commit();
    }
}
