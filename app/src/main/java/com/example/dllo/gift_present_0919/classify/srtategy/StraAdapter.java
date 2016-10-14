package com.example.dllo.gift_present_0919.classify.srtategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.classify.srtategy.StraBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/27.
 */
public class StraAdapter extends BaseAdapter{
    Context context;

    public void setStraBean(StraBean straBean) {
        this.straBean = straBean;
    }

    private  StraBean straBean;


    public StraAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return straBean.getData().getChannel_groups().size() ;
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
            view = LayoutInflater.from(context).inflate(R.layout.class_stra_list,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }
        viewHolder.stra_tv_one.setText(straBean.getData().getChannel_groups().get(i).getName());
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(0).getCover_image_url()).into(viewHolder.img_one);
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(1).getCover_image_url()).into(viewHolder.img_two);
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(2).getCover_image_url()).into(viewHolder.img_three);
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(3).getCover_image_url()).into(viewHolder.img_four);
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(4).getCover_image_url()).into(viewHolder.img_five);
        Picasso.with(context).load(straBean.getData().getChannel_groups().get(i).getChannels().get(5).getCover_image_url()).into(viewHolder.img_six);

        return view;
    }

    private class ViewHolder {

        private final TextView stra_tv_one;
        private final TextView stra_tv_two;
        private final ImageView img_one;
        private final ImageView img_two;
        private final ImageView img_three;
        private final ImageView img_four;
        private final ImageView img_five;
        private final ImageView img_six;


        public ViewHolder(View view) {
            stra_tv_one = (TextView) view.findViewById(R.id.stra_class);
            stra_tv_two = (TextView) view.findViewById(R.id.stra_all);
            img_one = (ImageView) view.findViewById(R.id.stra_img_one);
            img_two = (ImageView) view.findViewById(R.id.stra_img_two);
            img_three = (ImageView) view.findViewById(R.id.stra_img_three);
            img_four = (ImageView) view.findViewById(R.id.stra_img_four);
            img_five = (ImageView) view.findViewById(R.id.stra_img_five);
            img_six = (ImageView) view.findViewById(R.id.stra_img_six);

        }
    }
}
