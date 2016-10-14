package com.example.dllo.gift_present_0919.classify.srtategy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/9/21.
 */
public class StrategyFragment extends BaseFragment {

    private ListView stra_listview;
    private RecyclerView stra_recyle;
    private StraAdapter adapter;
    private StraRecylerAdapter recyleradapter;

    @Override
    protected int setLayout() {
        return R.layout.strategy_fragment;
    }

    @Override
    protected void initView() {

        stra_listview =bindView(R.id.strategy_listview);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.class_stra_head,null);
        stra_recyle = (RecyclerView) view.findViewById(R.id.stra_recycle);
        stra_listview.addHeaderView(view);

        initRecyler();
    }

    @Override
    protected void initData() {

        StringRequest stringRequest = new StringRequest(StringUrl.stralist, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                StraBean bean = gson.fromJson(response, StraBean.class);
                adapter = new StraAdapter(getContext());
                adapter.setStraBean(bean);
                stra_listview.setAdapter(adapter);
                LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
                manager1.setOrientation(LinearLayoutManager.VERTICAL);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
         VolleySingleton.getInstance().addRequest(stringRequest);


    }


    private void initRecyler() {
        StringRequest stringRequest1 = new StringRequest(StringUrl.strarecyler, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson1 = new Gson();
                StraRecylerBean bean1 = gson1.fromJson(response, StraRecylerBean.class);
                recyleradapter = new StraRecylerAdapter(getContext());
                recyleradapter.setStraRecylerBean(bean1);
                stra_recyle.setAdapter(recyleradapter);

                GridLayoutManager manager = new GridLayoutManager(getContext(),3,LinearLayoutManager.HORIZONTAL,false);

                stra_recyle.setLayoutManager(manager);

//                LinearLayoutManager manager = new LinearLayoutManager(getContext());
//                manager.setOrientation(LinearLayoutManager.HORIZONTAL);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest1);

    }
}
