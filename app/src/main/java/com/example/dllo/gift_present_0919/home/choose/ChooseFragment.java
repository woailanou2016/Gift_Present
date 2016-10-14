package com.example.dllo.gift_present_0919.home.choose;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;

/**
 * Created by dllo on 16/9/20.
 */
public class ChooseFragment extends BaseFragment {

    private ArrayList<String> images;
    private Banner banner;

    private GalleryAdapter adapter;
    private ListView lv;
    private MyListAdapter listAdapter;
    private RecyclerView rv_gallery;
    private PullToRefreshListView pullToRefreshListView;


    @Override
    protected int setLayout() {

        return R.layout.choose_fragment;

    }


    @Override
    protected void initView() {

        pullToRefreshListView = bindView(R.id.Refresh_listview);


        images = new ArrayList<>();
        lv = bindView(R.id.choose_myListView);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.choose_banner, null);
        lv = pullToRefreshListView.getRefreshableView();
        lv.addHeaderView(view);
        banner = (Banner) view.findViewById(R.id.choose_banner);

        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.choose_picture, null);
        rv_gallery = (RecyclerView) view1.findViewById(R.id.choose_gallery);
        lv.addHeaderView(view1);


    }

    @Override
    protected void initData() {

        initRefresh();
        initGallery();
        initListView();
        initJump();


        StringRequest stringRequest = new StringRequest(StringUrl.lunbo, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                LunBean bean = gson.fromJson(response, LunBean.class);
                for (int i = 0; i < bean.getData().getBanners().size(); i++) {
                    images.add(bean.getData().getBanners().get(i).getImage_url());
                    Log.d("ChooseFragment", bean.getData().getBanners().get(i).getImage_url());
                    banner.setImages(images);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }


    private void initGallery() {
        StringRequest stringRequest = new StringRequest(StringUrl.gallery, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GalleryBean bean = gson.fromJson(response, GalleryBean.class);
                adapter.setGalleryBean(bean);
                rv_gallery.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

        adapter = new GalleryAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(HORIZONTAL);
        rv_gallery.setLayoutManager(manager);

    }
    private void initListView() {

        StringRequest stringrequest_list = new StringRequest(StringUrl.listview, new Listener<String>() {

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ListBean bean = gson.fromJson(response, ListBean.class);

                listAdapter = new MyListAdapter(getContext());
                listAdapter.setListBean(bean);
                lv.setAdapter(listAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringrequest_list);
    }





    private void initRefresh() {

       pullToRefreshListView.setAdapter(listAdapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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


                        pullToRefreshListView.onRefreshComplete();

                    }
                }.execute();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {



            }
        });
    }


    private void initJump() {
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListBean.DataBean.ItemsBean bean = (ListBean.DataBean.ItemsBean) adapterView.getItemAtPosition(i);
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
