package com.example.zeroset.search.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.home.model.Content;
import com.example.zeroset.home.ui.adapter.ContentBannerAdapter;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.search.ui.adapter.LinearAdapter;

import java.util.ArrayList;

public class searchResulttotalFragment extends Fragment {
    private RecyclerView productrecycler, contentrecycler1, contentrecycler2;
    private LinearAdapter linearAdapter;
    private ArrayList<Product> Products1;
    private ArrayList<Content> Contents;
    private ContentBannerAdapter contentAdapter;
    private ImageButton btn_content;
    int type;

    public searchResulttotalFragment(){
        // Required empty public constructor
    }

    public static searchResulttotalFragment newInstance(){
        searchResulttotalFragment fragment = new searchResulttotalFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_search_result_total,
                container, false);
        productrecycler = v.findViewById(R.id.productrecycler);
        contentrecycler1 = v.findViewById(R.id.contentrecycler);
        contentrecycler2 = v.findViewById(R.id.contentrecycler2);
        btn_content = v.findViewById(R.id.btn_rightpoint_content);

        btn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ((searchActivity) getActivity()).replaceFragment(shopDetailFragment.newInstance());

            }
        });

        setDummyData();

        productrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        linearAdapter = new LinearAdapter(Products1);
        productrecycler.setAdapter(linearAdapter);

        setRecyclerView(contentrecycler1,Contents,2);
        setRecyclerView(contentrecycler2,Contents,1);

        initUI(v);


        return v;
    }

    private void initUI(ViewGroup rootView){
    }

    public void setRecyclerView(RecyclerView recyclerView, ArrayList<Content> contents, int type) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        contentAdapter = new ContentBannerAdapter(contents, type);
        recyclerView.setAdapter(contentAdapter);
    }

    public void setDummyData() {

        Products1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Products1.add(new Product("공집합", "원주대나무", "20,000"));
        }

        Contents = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Contents.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", 1));
        }

    }
}
