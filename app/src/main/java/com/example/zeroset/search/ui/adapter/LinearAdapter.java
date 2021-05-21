package com.example.zeroset.search.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.shop.model.Product;

import java.util.ArrayList;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.viewHolder> {

    private ArrayList<Product> products;

    public LinearAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        viewHolder holder = new viewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Product product = products.get(position);

        holder.productName.setText(product.getProductName());
        holder.company.setText(product.getCompany());
        holder.price.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView company;
        public TextView productName;
        public TextView price;

        public viewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.productImage);
            company = itemView.findViewById(R.id.company);
            productName = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.price);

        }

    }
}
