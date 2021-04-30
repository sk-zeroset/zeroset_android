package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeroset.R;
import com.example.zeroset.home.ui.homeFragment;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shopDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shopDetailFragment extends Fragment {

    ArrayList<eventBanner> eventBanners;
    ArrayList<Product> totalProducts;
    ArrayList<Product> lifeProducts;
    ArrayList<Product> bathProducts;

    RecyclerView eventRecyclerView;
    RecyclerView productRecyclerView;

    GridAdapter gridAdapter;
    EventBannerAdapter eventBannerAdapter;

    TabLayout tabLayout;

    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        eventBanners = new ArrayList<>();
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔2"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔3"));

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


        eventRecyclerView = v.findViewById(R.id.recyclerView);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)) ;
        eventBannerAdapter = new EventBannerAdapter(eventBanners, getContext());
        eventRecyclerView.setAdapter(eventBannerAdapter);

        for(Product p: lifeProducts){
            System.out.println(p.getProductName());
        }


        productRecyclerView = v.findViewById(R.id.total_goods);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridAdapter = new GridAdapter(totalProducts);
        productRecyclerView.setAdapter(gridAdapter);
        productRecyclerView.setNestedScrollingEnabled(false);

        tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        productRecyclerView.setAdapter(new GridAdapter(totalProducts));
                        break;
                    case 1:
                        productRecyclerView.setAdapter(new GridAdapter(lifeProducts));
                        break;
                    case 2:
                        productRecyclerView.setAdapter(new GridAdapter(bathProducts));
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }
}