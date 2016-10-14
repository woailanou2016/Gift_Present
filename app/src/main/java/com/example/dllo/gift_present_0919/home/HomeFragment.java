package com.example.dllo.gift_present_0919.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.home.choose.ChooseFragment;
import com.example.dllo.gift_present_0919.home.search.SearchActivity;
import com.example.dllo.gift_present_0919.home.sendboys.BoyFragment;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/19.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private MyHomeBean bean;
    private ViewPager vp;
    private TabLayout tb;
    private ImageView imageView;
    private ArrayList<String> title;
    private ArrayList<Fragment> fragments;
    private String url;
    private PopupWindow popupWindow;
    private ImageView imghomepop;
    private TextView home_search;

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;


    }




    @Override
    protected void initView() {
        url = "http://api.liwushuo.com/v2/channels/104/items_v2?limit=20&ad=2&gender=2&offset=0&generation=2%20HTTP/1.1";

        vp = bindView(R.id.home_viewpager);

        tb = bindView(R.id.home_tablayout);

        imageView = bindView(R.id.title_image);

        home_search = bindView(R.id.home_search);

        title = new ArrayList<>();

        fragments = new ArrayList<>();

        imghomepop = bindView(R.id.img_home_pop);

        imghomepop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow == null || popupWindow.isShowing());
                initPop();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);
            }
        });
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                startActivity(intent);
            }
        });


    }




    @Override
    protected void initData() {


        StringRequest stringRequest = new StringRequest(StringUrl.hometitle, new Response.Listener<String>() {



            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, MyHomeBean.class);
                for (int i = 0; i < bean.getData().getChannels().size(); i++) {
                    title.add(bean.getData().getChannels().get(i).getName());
                    Log.d("HomeFragment", bean.getData().getChannels().get(i).getName());
                }
                for (int i = 0; i < title.size(); i++) {
                    if (i == 0) {
                        fragments.add(new ChooseFragment());
                    } else {

                        BoyFragment f  = new BoyFragment();
                        Bundle args = new Bundle();
                        args.putString("url",String.valueOf(bean.getData().getChannels().get(i).getId()));
                        f.setArguments(args);
                        fragments.add(f);



                    }
                }
                HomeAdapter adapter = new HomeAdapter(getChildFragmentManager());
                adapter.setFragments(fragments);
                adapter.setTitle(title);
                vp.setAdapter(adapter);
                tb.setupWithViewPager(vp);
                tb.setTabMode(TabLayout.MODE_SCROLLABLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);

    }

    private void initPop() {
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        给popwindow设置一个view
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pop,null);
        ImageView imagebtnPop = (ImageView) view.findViewById(R.id.imgbtn_popb);
        imagebtnPop.setOnClickListener(this);
        GridView gridView = (GridView) view.findViewById(R.id.gridView_pop);
        ArrayList<MyHomeBean> myHomeBeen = new ArrayList<>();
        myHomeBeen.add(bean);
        PopAdapter  popAdapter = new PopAdapter(getContext());
        popAdapter.setMyHomeBeanArrayList(myHomeBeen);
        gridView.setAdapter(popAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                vp.setCurrentItem(i);
                popupWindow.dismiss();
            }
        });
        popupWindow.setContentView(view);

        popupWindow.showAsDropDown(imghomepop,-15,-50);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgbtn_popb:
                popupWindow.dismiss();
                break;
        }
    }
}








