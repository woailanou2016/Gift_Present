package com.example.dllo.gift_present_0919.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.BaseAty;

public class IdentityActivity extends BaseAty {


    private Button identity_next;

    @Override
    protected int setLayout() {
        return R.layout.activity_identity;
    }

    @Override
    protected void initView() {
        identity_next = bindView(R.id.identity_next);

    }

    @Override
    protected void initData() {
        identity_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdentityActivity.this,IdentityNextActivity.class);
                startActivity(intent);
            }
        });

    }
}
