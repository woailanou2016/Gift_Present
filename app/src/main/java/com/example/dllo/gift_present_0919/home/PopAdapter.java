package com.example.dllo.gift_present_0919.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/12.
 */
public class PopAdapter extends BaseAdapter{
    Context context;
    ArrayList<MyHomeBean> myHomeBeanArrayList;

    public void setMyHomeBeanArrayList(ArrayList<MyHomeBean> myHomeBeanArrayList) {
        this.myHomeBeanArrayList = myHomeBeanArrayList;
    }

    public PopAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return myHomeBeanArrayList.get(0).getData().getChannels().size();
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
            view = LayoutInflater.from(context).inflate(R.layout.pop_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_pop.setText(myHomeBeanArrayList.get(0).getData().getChannels().get(i).getName());
        return view;
    }

    private class ViewHolder {

        private final TextView tv_pop;

        public ViewHolder(View view) {

            tv_pop = (TextView) view.findViewById(R.id.tv_pop);

        }
    }
}
