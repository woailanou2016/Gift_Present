package com.example.dllo.gift_present_0919.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dllo on 16/9/19.
 */
public abstract class  BaseFragment extends Fragment {
 protected  Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(setLayout(),container,false);
    }
    protected  abstract  int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();

    }
    protected abstract void initView();

    protected abstract void initData();
    protected <T extends View> T bindView(int id){
        return (T) getView().findViewById(id);
    }
    protected  <T  extends  View> T bindView(int id,View view){
        return  (T) view.findViewById(id);

    }
}


