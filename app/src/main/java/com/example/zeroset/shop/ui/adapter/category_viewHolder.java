package com.example.zeroset.shop.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;

public class category_viewHolder extends RecyclerView.ViewHolder {

    public TextView best;
    public ImageView img;
    public TextView company;
    public TextView productName;
    public TextView price;

    public category_viewHolder(View itemView) {
        super(itemView);

        best = itemView.findViewById(R.id.best_text);
        img = itemView.findViewById(R.id.productImage);
        company = itemView.findViewById(R.id.company);
        productName = itemView.findViewById(R.id.productName);
        price = itemView.findViewById(R.id.price);

    }
}