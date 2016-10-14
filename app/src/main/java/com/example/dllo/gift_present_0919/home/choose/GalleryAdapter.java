package com.example.dllo.gift_present_0919.home.choose;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/23.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    Context context;
    private GalleryBean galleryBean;

    public GalleryAdapter(Context context) {
        this.context = context;
    }


    public void setGalleryBean(GalleryBean galleryBean) {
        this.galleryBean = galleryBean;
    }

    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.choose_gallery, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.MyViewHolder holder, int position) {
        Picasso.with(context).load(galleryBean.getData()
                .getSecondary_banners().get(position).getImage_url()).into(holder.iv);

    }
    @Override
    public int getItemCount() {
        return galleryBean.getData().getSecondary_banners().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.gallery_image);

        }
    }
}
