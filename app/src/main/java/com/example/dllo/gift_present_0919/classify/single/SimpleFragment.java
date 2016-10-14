package com.example.dllo.gift_present_0919.classify.single;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
public class SimpleFragment extends BaseFragment {

    private ListView lv_left;
    private ListView lv_right;

    @Override
    protected int setLayout() {
        return R.layout.simple_fragment;
    }

    @Override
    protected void initView() {
        lv_left = bindView(R.id.left_listview);
        lv_right = bindView(R.id.right_listview);

    }

    @Override
    protected void initData() {
        initRight();

        StringRequest stringRequest = new StringRequest(StringUrl.single, new Response.Listener<String>() {

            private LeftAdapter adapter;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SingleBean bean = gson.fromJson(response, SingleBean.class);
                adapter = new LeftAdapter(getContext());
                adapter.setSingleBean(bean);
                lv_left.setAdapter(adapter);

                lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        lv_right.setSelection(i * 10);
                    }
                });
                lv_right.setOnScrollListener(new AbsListView.OnScrollListener() {
                    boolean is = false;
                    @Override
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                        if (i == SCROLL_STATE_IDLE){
                            is = false;
                        }else{
                            is = true;
                        }

                    }

                    @Override
                    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                        if (is){
                            lv_left.setSelection(i/10);
                        }

                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }

    private void initRight() {
        StringRequest stringRequest1 = new StringRequest(StringUrl.single, new Response.Listener<String>() {

            private RightAdapter righadapter;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SingleBean bean1 = gson.fromJson(response, SingleBean.class);
                righadapter = new RightAdapter(getContext());
                righadapter.setRightbean(bean1);
                lv_right.setAdapter(righadapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest1);


        }


    }

