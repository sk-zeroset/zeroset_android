package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link intoCategory1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class intoCategory1Fragment extends Fragment {

    ImageButton btn_back;
    ArrayList<eventBanner> eventBanners;
    ArrayList<Product> totalProducts;
    ArrayList<Product> lifeProducts;
    ArrayList<Product> bathProducts;

    RecyclerView cate1RankBanner;
    RecyclerView cate1Recyclerview;

    GridAdapter gridAdapter;
    EventBannerAdapter eventBannerAdapter;

    public intoCategory1Fragment() {
        // Required empty public constructor
    }

    public static intoCategory1Fragment newInstance() {
        intoCategory1Fragment fragment = new intoCategory1Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_into_category1, container, false);

        eventBanners = new ArrayList<>();
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔2"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔3"));

        cate1RankBanner = view.findViewById(R.id.cate1RankRecyclerview);
        cate1RankBanner.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)) ;
        eventBannerAdapter = new EventBannerAdapter(eventBanners, getContext());
        cate1RankBanner.setAdapter(eventBannerAdapter);

        totalProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            totalProducts.add(new Product("전체", "전체 상품", "20,000"));
        }

        lifeProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lifeProducts.add(new Product("원주 생활용품", "원주 생활용품", "20,000"));
        }

        bathProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bathProducts.add(new Product("원주 칫솔회사", "원주 대나무 칫솔", "20,000"));
        }

        cate1Recyclerview = view.findViewById(R.id.cate1Recyclerview);
        cate1Recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridAdapter = new GridAdapter(totalProducts);
        cate1Recyclerview.setAdapter(gridAdapter);
        cate1Recyclerview.setNestedScrollingEnabled(false);

        btn_back = view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(shopFragment.newInstance());
            }
        });

        return view;
    }
}