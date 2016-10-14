package com.example.dllo.gift_present_0919.list.fragments.list_top;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.list.fragments.list_day.*;
import com.example.dllo.gift_present_0919.list.fragments.list_day.OnListViewItemClick;
import com.example.dllo.gift_present_0919.list.fragments.list_day.OnListViewItemRightClick;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/10/3.
 */
public class ListTopAdapter extends BaseAdapter {
    Context context;
    private MyTopBean myTopBean;
    OnListViewItemClick onListViewItemClick;
    OnListViewItemRightClick onListViewItemRightClick;

    public void setOnListViewItemClick(OnListViewItemClick onListViewItemClick) {
        this.onListViewItemClick = onListViewItemClick;
    }

    public void setOnListViewItemRightClick(OnListViewItemRightClick onListViewItemRightClick) {
        this.onListViewItemRightClick = onListViewItemRightClick;
    }

    public void setMyTopBean(MyTopBean myTopBean) {
        this.myTopBean = myTopBean;
    }

    public ListTopAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return myTopBean.getData().getItems().size() / 2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_top_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        i = i + i;
        final  int finalI = i;
        viewHolder.img_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = finalI;
                onListViewItemClick.click(itemPosition);
            }
        });
        final int finalI1 = i;
        viewHolder.img_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rightPosition = finalI1;
                onListViewItemRightClick.rightClick(rightPosition);
            }
        });


        Picasso.with(context).load(myTopBean.getData().getItems().get(i).getCover_webp_url()).into(viewHolder.img_one);
        viewHolder.tv_one.setText(myTopBean.getData().getItems().get(i).getShort_description());
        viewHolder.tv_two.setText(myTopBean.getData().getItems().get(i).getName());
        viewHolder.tv_three.setText(myTopBean.getData().getItems().get(i).getPrice());
        Picasso.with(context).load(myTopBean.getData().getItems().get(i+1).getCover_image_url()).into(viewHolder.img_two);
        viewHolder.tv_four.setText(myTopBean.getData().getItems().get(i+1).getShort_description());
        viewHolder.tv_five.setText(myTopBean.getData().getItems().get(i+1).getName());
        viewHolder.tv_six.setText(myTopBean.getData().getItems().get(i+1).getPrice());
        return view;
    }

    private class ViewHolder {
        private final ImageView img_one;
        private final TextView tv_one;
        private final TextView tv_two;
        private final TextView tv_three;
        private final ImageView img_two;
        private final TextView tv_four;
        private final TextView tv_five;
        private final TextView tv_six;
        public ViewHolder(View view) {
            img_one = (ImageView) view.findViewById(R.id.day_picture_one);
            tv_one = (TextView) view.findViewById(R.id.day_text_one);
            tv_two = (TextView) view.findViewById(R.id.day_name_two);
            tv_three = (TextView) view.findViewById(R.id.day_price_one);

            img_two = (ImageView) view.findViewById(R.id.day_picture_two);
            tv_four = (TextView) view.findViewById(R.id.day_text_two);
            tv_five = (TextView) view.findViewById(R.id.day_name_two);
            tv_six = (TextView) view.findViewById(R.id.day_price_two);



        }
    }
}
