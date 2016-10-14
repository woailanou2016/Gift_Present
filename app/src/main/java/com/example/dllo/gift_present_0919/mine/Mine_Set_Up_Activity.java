package com.example.dllo.gift_present_0919.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.BaseAty;

public class Mine_Set_Up_Activity extends BaseAty {


    private ImageView identity_image;
    private ImageView invite_image;
    private ImageView score_image;
    private ImageView idea_image;
    private ImageView relative_image;


    @Override
    protected int setLayout() {
        return R.layout.mine_set_up;
    }

    @Override
    protected void initView() {
        identity_image = bindView(R.id.identity_image);
        invite_image = bindView(R.id.invite_image);
        score_image = bindView(R.id.score_image);
        idea_image = bindView(R.id.idea_image);
        relative_image = bindView(R.id.relative_image);


        identity_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mine_Set_Up_Activity.this,IdentityActivity.class);
                startActivity(intent);
            }
        });
        invite_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Mine_Set_Up_Activity.this,InviteActivity.class);
                startActivity(intent1);
            }
        });
        score_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Mine_Set_Up_Activity.this,ScoreActivity.class);
                startActivity(intent2);

            }
        });
        idea_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Mine_Set_Up_Activity.this,IdealActivity.class);
                startActivity(intent3);

            }
        });
        relative_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Mine_Set_Up_Activity.this,RelativeGiftActivity.class);
                startActivity(intent4);

            }
        });


    }

    @Override
    protected void initData() {

    }
}
