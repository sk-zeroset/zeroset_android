package com.example.zeroset.shop.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.shop.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    private final List<Review> reviewList;
    private TextView contents;
    private TextView date;
    private TextView userId;

    public ReviewListAdapter(List<Review> reviews) {
        this.reviewList = reviews;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            contents = itemView.findViewById(R.id.contents);
            date = itemView.findViewById(R.id.write_date);
            userId = itemView.findViewById(R.id.user_id);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_review, null);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        contents.setText(reviewList.get(position).getContents());
        date.setText(reviewList.get(position).getDate());
        userId.setText(reviewList.get(position).getUserId());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }
}
