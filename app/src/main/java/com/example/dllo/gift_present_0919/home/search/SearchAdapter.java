package com.example.dllo.gift_present_0919.home.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/13.
 */
public class SearchAdapter extends BaseAdapter{
    Context context;

    public SearchAdapter(ArrayList<SearchBean> arrayList) {
        this.arrayList = arrayList;
    }

    ArrayList<SearchBean> arrayList;



    public SearchAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
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
            view = LayoutInflater.from(context).inflate(R.layout.search_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.img_one.setImageResource(arrayList.get(i).getPic());
        viewHolder.tv.setText(arrayList.get(i).getName());
        viewHolder.img_two.setImageResource(arrayList.get(i).getImage());


        return view;
    }

    private class ViewHolder {

        private final TextView tv;
        private final ImageView img_one;
        private final ImageView img_two;

        public ViewHolder(View view) {
            img_one = (ImageView) view.findViewById(R.id.search_image_one);
            tv = (TextView) view.findViewById(R.id.search_tv);
            img_two = (ImageView) view.findViewById(R.id.search_image_two);

        }
    }
}
