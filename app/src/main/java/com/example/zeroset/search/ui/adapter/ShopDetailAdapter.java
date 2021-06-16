package com.example.zeroset.search.ui.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.search.model.Shop;

import java.util.ArrayList;

public class ShopDetailAdapter extends RecyclerView.Adapter<ShopDetailAdapter.ViewHolder>{
    private ArrayList<Shop> shops;
    private Context context;
    @NonNull
    @Override
    public ShopDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_shop_detail, viewGroup, false);

        ShopDetailAdapter.ViewHolder holder = new ShopDetailAdapter.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopDetailAdapter.ViewHolder holder, int position) {
        Shop shop = shops.get(position);

        holder.shoploc.setText(shop.getShoploc());
        holder.shopname.setText(shop.getShopname());
        holder.shopproductrecycler.setAdapter(new LinearAdapter(shop.Products));
        holder.shopproductrecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.shopproductrecycler.setNestedScrollingEnabled(false);
        holder.shopproductrecycler.setHasFixedSize(true);

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView shopname, shoploc;
        public RecyclerView shopproductrecycler;
        public ViewHolder(@NonNull View view) {
            super(view);
            icon = view.findViewById(R.id.icon);
            shopname = view.findViewById(R.id.name);
            shoploc = view.findViewById(R.id.loc);
            shopproductrecycler = view.findViewById(R.id.shopproduct);
        }
    }

    public ShopDetailAdapter(ArrayList<Shop> shops) {
        this.shops = shops;

    }
}
