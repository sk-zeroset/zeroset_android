package com.example.zeroset.home.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.zeroset.R;
import com.example.zeroset.search.ui.searchBarActivity;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.ui.adapter.GridAdapter;

import java.util.ArrayList;

public class eventBannerDetailActivity extends AppCompatActivity {

    private ArrayList<Product> Products;
    private GridAdapter gridAdapter;
    private RecyclerView productrecycler;
    private ImageButton btn_back, btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_banner_detail);

        setDummyData();

        productrecycler = findViewById(R.id.product);
        productrecycler.setLayoutManager(new GridLayoutManager(this, 2));
        gridAdapter = new GridAdapter(Products);
        productrecycler.setAdapter(gridAdapter);
        productrecycler.setNestedScrollingEnabled(false);
        btn_back = findViewById(R.id.btn_back);
        btn_search = findViewById(R.id.btn_search);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),
                        searchBarActivity.class);
                startActivity(i);
            }
        });


    }

    public void setDummyData() {

        Products = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Products.add(new Product("공집합", "원주대나무", "20,000"));
        }
    }
}