package com.example.dllo.gift_present_0919.classify.srtategy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/27.
 */
public class StraRecylerAdapter extends RecyclerView.Adapter<StraRecylerAdapter.MyViewHolder> {
    Context context;

    public void setStraRecylerBean(StraRecylerBean straRecylerBean) {
        this.straRecylerBean = straRecylerBean;
    }

    private  StraRecylerBean straRecylerBean;
    public StraRecylerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public StraRecylerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stra_recyler_view,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StraRecylerAdapter.MyViewHolder holder, int position) {
        Picasso.with(context).load(straRecylerBean.getData().getColumns().get(position).getCover_image_url()).into(holder.stra_img);
        holder.tv_one.setText(straRecylerBean.getData().getColumns().get(position).getTitle());
        holder.tv_two.setText(straRecylerBean.getData().getColumns().get(position).getAuthor());
        holder.tv_three.setText(straRecylerBean.getData().getColumns().get(position).getSubtitle());

    }

    @Override
    public int getItemCount() {
        return straRecylerBean.getData().getColumns().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView stra_img;
        private final TextView tv_one;
        private final TextView tv_two;
        private final TextView tv_three;

        public MyViewHolder(View itemView) {
            super(itemView);
            stra_img = (ImageView) itemView.findViewById(R.id.stra_recyler_img);
            tv_one = (TextView) itemView.findViewById(R.id.stra_text1);
            tv_two = (TextView) itemView.findViewById(R.id.stra_text1);
            tv_three = (TextView) itemView.findViewById(R.id.stra_text3);

        }
    }
}
