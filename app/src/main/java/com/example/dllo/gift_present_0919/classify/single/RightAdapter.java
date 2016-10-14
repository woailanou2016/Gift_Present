package com.example.dllo.gift_present_0919.classify.single;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/29.
 */
public class RightAdapter extends BaseAdapter {
    Context context;
    private SingleBean rightbean;

    public void setRightbean(SingleBean rightbean) {
        this.rightbean = rightbean;
    }

    public RightAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return rightbean.getData().getCategories().size();

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
        ViewHolder viewHolder =null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.right_listview,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(rightbean.getData().getCategories().get(i).getName());
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(0).getIcon_url()).into(viewHolder.img_one);
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(1).getIcon_url()).into(viewHolder.img_two);
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(2).getIcon_url()).into(viewHolder.img_three);
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(3).getIcon_url()).into(viewHolder.img_four);
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(4).getIcon_url()).into(viewHolder.img_five);
        Picasso.with(context).load(rightbean.getData().getCategories().get(i).getSubcategories().get(5).getIcon_url()).into(viewHolder.img_six);

        viewHolder.tv_one.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(0).getName());
        viewHolder.tv_two.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(1).getName());
        viewHolder.tv_three.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(2).getName());
        viewHolder.tv_four.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(3).getName());
        viewHolder.tv_five.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(4).getName());
        viewHolder.tv_six.setText(rightbean.getData().getCategories().get(i).getSubcategories().get(5).getName());


        return view;
    }

    private class ViewHolder {

        private final TextView title;
        private final ImageView img_one;
        private final ImageView img_two;
        private final ImageView img_three;
        private final ImageView img_four;
        private final ImageView img_five;
        private final ImageView img_six;
        private final TextView tv_one;
        private final TextView tv_two;
        private final TextView tv_three;
        private final TextView tv_four;
        private final TextView tv_five;
        private final TextView tv_six;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.tv_one);

            img_one = (ImageView) view.findViewById(R.id.right_img_one);
            img_two = (ImageView) view.findViewById(R.id.right_img_two);
            img_three = (ImageView) view.findViewById(R.id.right_img_three);
            img_four = (ImageView) view.findViewById(R.id.right_img_four);
            img_five = (ImageView) view.findViewById(R.id.right_img_five);
            img_six = (ImageView) view.findViewById(R.id.right_img_six);

            tv_one = (TextView) view.findViewById(R.id.right_text_one);
            tv_two = (TextView) view.findViewById(R.id.right_text_two);
            tv_three = (TextView) view.findViewById(R.id.right_text_three);
            tv_four = (TextView) view.findViewById(R.id.right_text_four);
            tv_five = (TextView) view.findViewById(R.id.right_text_five);
            tv_six = (TextView) view.findViewById(R.id.right_text_six);


        }
    }
}
