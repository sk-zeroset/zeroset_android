package com.example.zeroset.home.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zeroset.R;
import com.example.zeroset.home.model.Content;

import java.util.ArrayList;

public class ContentBannerAdapter extends RecyclerView.Adapter<ContentBannerAdapter.viewHolder>{

    private ArrayList<Content> contents;
    private int type;


    public ContentBannerAdapter(ArrayList<Content> contents, int type ) {
        this.contents = contents;
        this.type = type;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content, parent, false);

        ContentBannerAdapter.viewHolder holder = new ContentBannerAdapter.viewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Content content = contents.get(position);
        holder.title.setText(content.getTitle());
        if(type==2){
            holder.img.setVisibility(View.GONE);
            holder.img2.setVisibility(View.VISIBLE);
            holder.title.setVisibility(View.GONE);
            holder.title2.setVisibility(View.VISIBLE);
            holder.title2.setText(content.getTitle());
        }

        if(content.isEco()==false){
            holder.eco.setVisibility(View.GONE);
        }
        if(content.isSocial()==false){
            holder.social.setVisibility(View.GONE);
        }
        if(content.isRecycle()==false){
            holder.recycle.setVisibility(View.GONE);
        }

        Glide.with(holder.itemView.getContext()).load(content.getImgURL()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return contents.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        public ImageView img, img2;
        public TextView title, title2;
        public ImageView social, eco, recycle;

        public viewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.contentimage);
            img2 = itemView.findViewById(R.id.contentimage2);
            title = itemView.findViewById(R.id.title);
            title2 = itemView.findViewById(R.id.title2);
            social = itemView.findViewById(R.id.social);
            eco = itemView.findViewById(R.id.eco);
            recycle = itemView.findViewById(R.id.recycle);


        }

    }
}