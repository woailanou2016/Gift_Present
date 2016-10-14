package com.example.dllo.gift_present_0919.ad;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.baseaty.BaseAty;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.main.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class AdActivity extends BaseAty{
   private TextView textView;

    Timer timer = new Timer();
    private int recLen = 2;


    @Override
    protected int setLayout() {
        return R.layout.activity_ad;
    }

    @Override
    protected void initView() {
        textView =  bindView(R.id.tv_time);

    }

    @Override
    protected void initData() {

        timer.schedule(task,1000,1000);


    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
           runOnUiThread(new Runnable() {
               @Override
               public void run() {
                   recLen--;
                   textView.setText("跳过"+""+recLen);
                   if (recLen < 0){
                       timer.cancel();
                       textView.setVisibility(View.GONE);
                       Intent intent1 = new Intent(AdActivity.this,MainActivity.class);
                       startActivity(intent1);
                       finish();
                   }
               }
           });
        }
    };


    }


