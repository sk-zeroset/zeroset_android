package com.example.zeroset.search.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.search.model.Shop;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private ArrayList<Shop> shops;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView shopname, shoploc;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            icon = view.findViewById(R.id.icon);
            shopname = view.findViewById(R.id.name);
            shoploc = view.findViewById(R.id.loc);

        }

    }


    public ShopAdapter(ArrayList<Shop> shops) {
        this.shops = shops;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_shop, viewGroup, false);

        ShopAdapter.ViewHolder holder = new ShopAdapter.ViewHolder(view);

        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Shop shop = shops.get(position);

        viewHolder.shoploc.setText(shop.getShoploc());
        viewHolder.shopname.setText(shop.getShopname());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shops.size();
    }
}
