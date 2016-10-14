package com.example.dllo.gift_present_0919.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/20.
 */
public class MyApp extends Application{
//    写完application类之后  一定要注册
    private  static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public static Context getContext() {
        return mContext;
    }
}
