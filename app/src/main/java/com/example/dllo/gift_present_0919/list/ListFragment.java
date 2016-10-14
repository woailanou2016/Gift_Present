package com.example.dllo.gift_present_0919.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.list.fragments.list_top.TopFragment;
import com.example.dllo.gift_present_0919.list.fragments.list_day.DayFragment;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/19.
 */
public class ListFragment extends BaseFragment{


    private ViewPager list_pager;
    private TabLayout list_tab;

    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private ImageView list_title;
    private String url;


    @Override
    protected int setLayout() {
        return R.layout.list_fragment;
    }

    @Override
    protected void initView() {

        url = "http://api.liwushuo.com/v2/ranks_v2/ranks/1?limit=20&offset=0HTTP/1.1";

        list_pager = bindView(R.id.list_viewpager);
        list_tab = bindView(R.id.list_tablayout);
        fragments = new ArrayList<>();



        title = new ArrayList<>();




        list_title = bindView(R.id.list_title_image);
        list_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),List_Share_Activity.class);
                getContext().startActivity(intent);
            }
        });


    }


    @Override
    protected void initData() {
//        initListener();

        StringRequest stringRequest = new StringRequest(StringUrl.hottitle, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ListTitleBean bean = gson.fromJson(response, ListTitleBean.class);
                for (int i = 0; i < bean.getData().getRanks().size(); i++) {
                    title.add(bean.getData().getRanks().get(i).getName());
                    Log.d("ListFragment", "bean.getData().getRanks().get(i).getName");
                }
                for (int i = 0; i < title.size(); i++) {
                    if (i == 0) {
                        fragments.add(new DayFragment());
                   } else {

                        TopFragment  f = new TopFragment();
                        Bundle args = new Bundle();
                        args.putString("url",String.valueOf(bean.getData().getRanks().get(i).getId()));
                        f.setArguments(args);
                        fragments.add(f);

                    }
                }

                LstAdapter adapter = new LstAdapter(getChildFragmentManager());
                adapter.setFragments(fragments);
                 adapter.setListtitle(title);

                 list_pager.setAdapter(adapter);
                 list_tab.setupWithViewPager(list_pager);
//               list_tab.setTabMode(TabLayout.MODE_SCROLLABLE);




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }


}
