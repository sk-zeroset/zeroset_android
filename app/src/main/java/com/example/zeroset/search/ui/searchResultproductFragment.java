package com.example.zeroset.search.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.search.ui.adapter.LinearAdapter;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.ui.adapter.GridAdapter;

import java.util.ArrayList;

public class searchResultproductFragment extends Fragment {

    private RecyclerView productrecycler;
    private TextView productsize;
    private GridAdapter gridAdapter;
    private ArrayList<Product> Products;

    public searchResultproductFragment(){
        // Required empty public constructor
    }

    public static searchResultproductFragment newInstance(){
        searchResultproductFragment fragment = new searchResultproductFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_search_result_product,
                container, false);

        productrecycler = v.findViewById(R.id.productrecycler);
        productsize = v.findViewById(R.id.productsize);

        Products = ((searchActivity)getActivity()).Products;
        productsize.setText(String.valueOf(Products.size())+"개");
        productrecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        gridAdapter = new GridAdapter(Products);
        productrecycler.setAdapter(gridAdapter);
        productrecycler.setNestedScrollingEnabled(false);

        initUI(v);

        return v;
    }

    private void initUI(ViewGroup rootView){
    }
}
