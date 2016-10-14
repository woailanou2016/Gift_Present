package com.example.dllo.gift_present_0919.volley;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dllo on 16/9/20.
 */
//懒汉
public class VolleySingleton {
    private  static VolleySingleton mVolleySingleton;
//    把 请求队列 放到单利类里边,这样整个项目只有一个requestQueeue
    private RequestQueue mRequestQueue;


    private VolleySingleton(){
      mRequestQueue = Volley.newRequestQueue(MyApp.getContext());


    }


    public static VolleySingleton  getInstance(){

        if (mVolleySingleton == null){

            synchronized (VolleySingleton.class){
                if (mVolleySingleton == null){
                    mVolleySingleton = new VolleySingleton();
                }
            }
        }
        return  new VolleySingleton();
    }
    public static VolleySingleton getmVolleySingleton() {
        return mVolleySingleton;
    }
    public void addRequest(Request request){
        mRequestQueue.add(request);


    }
}
