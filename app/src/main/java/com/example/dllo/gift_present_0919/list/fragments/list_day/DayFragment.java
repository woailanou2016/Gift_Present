package com.example.dllo.gift_present_0919.list.fragments.list_day;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.list.List_Jump_Activity;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/20.
 */
public class DayFragment extends BaseFragment {


    private ListView day_list;

    private ArrayList<MyListBean> arrayList;

    private ImageView header_image;
    private PullToRefreshListView pullToRefreshListView;


    @Override
    protected int setLayout() {
        return R.layout.day_fragment;
    }

    @Override
    protected void initView() {


        pullToRefreshListView = bindView(R.id.Refresh_day);


        day_list = bindView(R.id.day_listview);

        arrayList = new ArrayList<>();

        day_list = pullToRefreshListView.getRefreshableView();

        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.list_day_header, null);

        header_image = (ImageView) view1.findViewById(R.id.day_header_image);

        day_list.addHeaderView(view1);


    }

    @Override
    protected void initData() {
        initDayRefresh();


        StringRequest stringRequest = new StringRequest(StringUrl.dayhead, new Response.Listener<String>() {

            private ListDayAdapter adapter;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final MyListBean bean = gson.fromJson(response, MyListBean.class);
                Picasso.with(getContext()).load(bean.getData().getCover_image()).into(header_image);


                adapter = new ListDayAdapter(getContext());
                adapter.setMyListBean(bean);
                pullToRefreshListView.setAdapter(adapter);

                adapter.setOnListViewItemClick(new OnListViewItemClick() {
                    @Override
                    public void click(int itemPosition) {
                        Intent intent = new Intent(getContext(), List_Jump_Activity.class);
                        String url1 = bean.getData().getItems().get(itemPosition).getUrl();
                        String url2 = url1.replace("hawaii", "www");
                        intent.putExtra("url", url2);

                        startActivity(intent);
                    }
                });
                adapter.setOnListViewItemRightClick(new OnListViewItemRightClick() {
                    @Override
                    public void rightClick(int rightPosition) {
                        Intent intent = new Intent(getContext(), List_Jump_Activity.class);
                        String url1 = bean.getData().getItems().get(rightPosition).getUrl();
                        String url2 = url1.replace("hawaii", "www");
                        intent.putExtra("url", url2);
                        startActivity(intent);
                    }
                });


//                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "网络获取失败", Toast.LENGTH_SHORT).show();

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }

    private void initDayRefresh() {

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

}

