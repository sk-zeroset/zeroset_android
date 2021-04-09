package com.example.zeroset.shop.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zeroset.R;
import com.example.zeroset.shop.model.eventBanner;

import java.util.ArrayList;

public class EventBannerAdapter extends RecyclerView.Adapter<EventBannerAdapter.ViewHolder> {

    private ArrayList<eventBanner> items;
    private TextView textView;
    private ImageView imageView;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }

    public EventBannerAdapter(ArrayList<eventBanner> list, Context context) {
        this.context = context;
        this.items = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_banner, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        textView.setText(items.get(position).getTitle());
        Glide.with(context).load(items.get(position).getThumbnail()).into(imageView);
        System.out.printf(items.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return items.size() ;
    }

}