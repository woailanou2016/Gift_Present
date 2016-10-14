package com.example.dllo.gift_present_0919.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.basefragment.BaseFragment;
import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.home.Title_Home_Login_Activity;

/**
 * Created by dllo on 16/9/19.
 */
public class MineFragment extends BaseFragment {


    private Button btn_setup;
    private ImageView mine_message;
    private ImageView mine_boy;
    private TextView mine_login;
    private RadioButton button_cart;
    private RadioButton button_order;
    private RadioButton button_coupon;
    private RadioButton button_follow;
    private RadioButton button_service;

    @Override
    protected int setLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView() {
        mine_message = bindView(R.id.mine_message);
        mine_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);
            }
        });
        mine_boy = bindView(R.id.mine_boy);
        mine_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);
            }
        });
        mine_login = bindView(R.id.mine_login);
        mine_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });
        button_cart = bindView(R.id.button_cart);
        button_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });
        button_order = bindView(R.id.button_order);
        button_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });
        button_coupon = bindView(R.id.button_coupon);
        button_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });
        button_follow = bindView(R.id.button_follow);
        button_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });
        button_service = bindView(R.id.button_service);
        button_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Title_Home_Login_Activity.class);
                getContext().startActivity(intent);

            }
        });



        btn_setup = bindView(R.id.mine_button_set);
        btn_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Mine_Set_Up_Activity.class);
                getContext().startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {

    }
}
