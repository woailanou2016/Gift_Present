package com.example.dllo.gift_present_0919.list.fragments.list_day;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gift_present_0919.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/25.
 */
public class ListDayAdapter extends BaseAdapter {
    Context context;
    OnListViewItemClick onListViewItemClick;
    OnListViewItemRightClick onListViewItemRightClick;

    public void setOnListViewItemRightClick(OnListViewItemRightClick onListViewItemRightClick) {
        this.onListViewItemRightClick = onListViewItemRightClick;
    }

    public void setOnListViewItemClick(OnListViewItemClick onListViewItemClick) {
        this.onListViewItemClick = onListViewItemClick;
    }

    public void setMyListBean(MyListBean myListBean) {
        this.myListBean = myListBean;
    }

    private MyListBean myListBean;

    public ListDayAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return myListBean.getData().getItems().size() / 2;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_day_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();


        }


        i = i + i;
        final int finalI = i;
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
                int rightPosition = finalI1 + 1;
                onListViewItemRightClick.rightClick(rightPosition);

            }
        });
//后加的


        Picasso.with(context).load(myListBean.getData().getItems().get(i).getCover_image_url()).into(viewHolder.img_one);
        viewHolder.tv_one.setText(myListBean.getData().getItems().get(i).getShort_description());
        viewHolder.tv_two.setText(myListBean.getData().getItems().get(i).getName());
        viewHolder.tv_three.setText(myListBean.getData().getItems().get(i).getPrice());
        Picasso.with(context).load(myListBean.getData().getItems().get(i + 1).getCover_image_url()).into(viewHolder.img_two);
        viewHolder.tv_four.setText(myListBean.getData().getItems().get(i + 1).getShort_description());
        viewHolder.tv_five.setText(myListBean.getData().getItems().get(i + 1).getName());
        viewHolder.tv_six.setText(myListBean.getData().getItems().get(i + 1).getPrice());

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

