package com.example.zeroset.shop.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.shop.model.BestProduct;
import com.example.zeroset.shop.model.Product;

import java.util.ArrayList;

public class BestLinearAdapter  extends RecyclerView.Adapter<category_viewHolder> {

    private ArrayList<BestProduct> products;

    public BestLinearAdapter(ArrayList<BestProduct> products) {
        this.products = products;
    }

    @Override
    public category_viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 사용할 아이템의 뷰를 생성해준다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bestproduct, parent, false);

        category_viewHolder holder = new category_viewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull category_viewHolder holder, int position) {
        BestProduct product = products.get(position);

        holder.best.setText(product.getBest());
        holder.productName.setText(product.getProductName());
        holder.company.setText(product.getCompany());
        holder.price.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}

