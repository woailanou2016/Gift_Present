package com.example.dllo.gift_present_0919.home.choose;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/23.
 */
public class MyListAdapter extends BaseAdapter {
    Context context;
    private ListBean listBean;

    public MyListAdapter(Context context) {
        this.context = context;
    }

    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }

    @Override
    public int getCount() {
        return listBean.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return listBean.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.choose_listview,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }



        Picasso.with(context).load(listBean.getData().getItems().get(i).getAuthor().getAvatar_url()).into(viewHolder.img_three);
        Picasso.with(context).load(listBean.getData().getItems().get(i+1).getCover_image_url()).into(viewHolder.img_two);
        viewHolder.tv_one.setText(listBean.getData().getItems().get(i).getAuthor().getNickname());
        viewHolder.tv_four.setText(listBean.getData().getItems().get(i+1).getTitle());

        return view;
    }

    private class ViewHolder {

        private final TextView tv_one;
        private final TextView tv_two;
//        private final ImageView img_one;
        private final TextView tv_three;
        private final ImageView img_two;
        private final TextView tv_four;
        private final ImageView img_three;
        private final TextView tv_five;

        public ViewHolder(View view) {
            tv_one = (TextView) view.findViewById(R.id.choose_list_one);
            tv_two = (TextView) view.findViewById(R.id.choose_list_two);
            tv_three = (TextView) view.findViewById(R.id.choose_list_four);
            tv_four = (TextView) view.findViewById(R.id.choose_list_six);
            tv_five = (TextView) view.findViewById(R.id.choose_list_eight);
            img_two = (ImageView) view.findViewById(R.id.choose_list_five);
//         img_one = (ImageView) view.findViewById(R.id.choose_list_three);
            img_three = (ImageView) view.findViewById(R.id.choose_list_seven);


        }
    }
}
