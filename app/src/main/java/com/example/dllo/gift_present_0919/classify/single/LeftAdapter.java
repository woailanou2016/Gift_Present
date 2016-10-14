package com.example.dllo.gift_present_0919.classify.single;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;

/**
 * Created by dllo on 16/9/29.
 */
public class LeftAdapter extends BaseAdapter {
    Context context;
    private SingleBean singleBean;

    public void setSingleBean(SingleBean singleBean) {
        this.singleBean = singleBean;
    }

    public LeftAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return singleBean.getData().getCategories().size();
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
        ViewHolder  viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.left_listview,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
       viewHolder.left_tv.setText(singleBean.getData().getCategories().get(i).getName());
        return view;
    }

    private class ViewHolder {

        private final TextView left_tv;


        public ViewHolder(View view) {
            left_tv = (TextView) view.findViewById(R.id.left_tv);


        }
    }
}
