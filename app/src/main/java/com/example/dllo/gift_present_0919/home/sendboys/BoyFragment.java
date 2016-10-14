package com.example.dllo.gift_present_0919.home.sendboys;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.home.choose.ChooseActivity;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/1.
 */
public class BoyFragment extends BaseFragment {

    private ListView boy_listview;
    private ArrayList<BoyBean> arraylist;
    private String urlList;
    private PullToRefreshListView pullrefresh;

    @Override
    protected int setLayout() {
        return R.layout.boy_listview;
    }

    @Override
    protected void initView() {



        pullrefresh = bindView(R.id.Refresh_boy);



        boy_listview = bindView(R.id.girl_listview);

        Bundle args = getArguments();
        String num = args.getString("url");
        urlList = "http://api.liwushuo.com/v2/channels/" + num + "/items_v2?limit=20&ad=2&gender=2&offset=0&generation=2%20HTTP/1.1";


        boy_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ChooseActivity.class);
                getContext().startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
        initBoyRefresh();
        BoyJump();
        arraylist = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(urlList, new Response.Listener<String>() {

            private BoyAdapter adapter;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BoyBean bean = gson.fromJson(response, BoyBean.class);
                adapter = new BoyAdapter(getContext());
                adapter.setGrilBean(bean);

                pullrefresh.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }

    private void initBoyRefresh() {

        pullrefresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new AsyncTask<Void,Void,Void>(){

                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);


                       pullrefresh.onRefreshComplete();


                    }
                }.execute();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {



            }
        });
    }


    private void BoyJump() {
        pullrefresh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BoyBean.DataBean.ItemsBean bean = (BoyBean.DataBean.ItemsBean) adapterView.getItemAtPosition(i);
                if (bean.getUrl() != null) {
                    Intent intent = new Intent(getContext(), ChooseActivity.class);
                    intent.putExtra("url", bean.getUrl());
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(mContext, "没有接口", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}