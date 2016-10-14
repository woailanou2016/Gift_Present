package com.example.dllo.gift_present_0919.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.BaseAty;
import com.example.dllo.gift_present_0919.main.MainActivity;

public class Title_Home_Login_Activity extends BaseAty {


    private Button home_login;

    @Override
    protected int setLayout() {
        return R.layout.title_home_login;
    }

    @Override
    protected void initView() {
        home_login = bindView(R.id.home_login);
        home_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Title_Home_Login_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void initData() {

    }
}
