package com.example.dllo.gift_present_0919.home.choose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.BaseAty;
import com.example.dllo.gift_present_0919.baseaty.StringUrl;
import com.example.dllo.gift_present_0919.volley.VolleySingleton;
import com.google.gson.Gson;

public class ChooseActivity extends BaseAty {


    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_choose;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.choose_webview);


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


    }
}
