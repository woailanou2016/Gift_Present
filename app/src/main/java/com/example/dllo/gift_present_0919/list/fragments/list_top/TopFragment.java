package com.example.dllo.gift_present_0919.list.fragments.list_top;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.list.List_Jump_Activity;
import com.example.dllo.gift_present_0919.list.fragments.list_day.*;
import com.example.dllo.gift_present_0919.list.fragments.list_day.OnListViewItemClick;
import com.example.dllo.gift_present_0919.list.fragments.list_day.OnListViewItemRightClick;
import com.example.dllo.gift_present_0919.list.fragments.list_top.ListTopAdapter;
import com.example.dllo.gift_present_0919.list.fragments.list_top.MyTopBean;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/20.
 */
public class TopFragment extends BaseFragment {


    private ListView top_listview;
    private ArrayList<MyTopBean> arrayList;
    private ImageView top_header_image;
    private String urlList;
    private PullToRefreshListView pullToRefreshListView;


    @Override
    protected int setLayout() {
        return R.layout.top_fragment;
    }

    @Override
    protected void initView() {


        pullToRefreshListView = bindView(R.id.Refresh_top);



        top_listview = bindView(R.id.top_listview);
        arrayList = new ArrayList<>();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.top_header,null);

        top_listview = pullToRefreshListView.getRefreshableView();

        top_header_image = (ImageView) view.findViewById(R.id.top_header_image);

        top_listview.addHeaderView(view);

        Bundle args = getArguments();
        String num = args.getString("url");
        urlList = "http://api.liwushuo.com/v2/ranks_v2/ranks/"+ num +"?limit=20&offset=0HTTP/1.1";

    }

    @Override
    protected void initData() {

        initTopRefresh();

        StringRequest stringRequest  = new StringRequest(urlList, new Response.Listener<String>() {

            private ListTopAdapter adapter;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final MyTopBean bean = gson.fromJson(response, MyTopBean.class);
                Picasso.with(getContext()).load(bean.getData().getCover_image()).into(top_header_image);
                adapter = new ListTopAdapter(getContext());
                adapter.setMyTopBean(bean);
                top_listview.setAdapter(adapter);

                adapter.setOnListViewItemClick(new OnListViewItemClick() {
                    @Override
                    public void click(int itemPosition) {
                        Intent intent = new Intent(getContext(), List_Jump_Activity.class);
                        String url1 = bean.getData().getItems().get(itemPosition).getUrl();
                        String url2 = url1.replace("hawaii","www");
                        intent.putExtra("url",url2);
                        startActivity(intent);
                    }
                });
                adapter.setOnListViewItemRightClick(new OnListViewItemRightClick() {
                    @Override
                    public void rightClick(int rightPosition) {
                        Intent intent = new Intent(getContext(),List_Jump_Activity.class);
                        String url1 = bean.getData().getItems().get(rightPosition).getUrl();
                        String url2 = url1.replace("hawaii","www");
                        intent.putExtra("url",url2);
                        startActivity(intent);

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

    private void initTopRefresh() {
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new AsyncTask<Void, Void, Void>() {
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
                        pullToRefreshListView.onRefreshComplete();
                    }
                }.execute();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }


}
