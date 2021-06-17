package com.example.zeroset.shop.ui;

import android.os.Bundle;

//data binding import
import androidx.databinding.DataBindingUtil;

import com.example.zeroset.databinding.FragmentShopBinding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.model.BestProduct;
import com.example.zeroset.shop.ui.adapter.BestLinearAdapter;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;
import com.example.zeroset.shop.ui.adapter.LinearAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ShopFragment extends Fragment {

    //binding
    FragmentShopBinding binding;

    private ArrayList<eventBanner> eventBanners;
    private ArrayList<Product> badgeProduct;
    private ArrayList<BestProduct> totalProducts;
    private ArrayList<BestProduct> lifeProducts;
    private ArrayList<BestProduct> bathProducts;

    private BestLinearAdapter bestLinearAdapter;
    private LinearAdapter linearAdapter;
    private EventBannerAdapter eventBannerAdapter;

    public ShopFragment() {
    }

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // setContetView로 하면 안된다. 프래그먼트는!
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);
        binding.setActivity(this);

        setDummyData();

        binding.eventBannerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        eventBannerAdapter = new EventBannerAdapter(eventBanners, getContext());
        binding.eventBannerRecyclerView.setAdapter(eventBannerAdapter);

        tabLayoutEvent();

        setBestRecyclerView(binding.bestRecyclerView, totalProducts);

        setBadgeRecyclerView(binding.recycleRecyclerView, badgeProduct); // 리사이클러뷰 뱃지별로 product 교체
        setBadgeRecyclerView(binding.socialRecyclerView, badgeProduct);
        setBadgeRecyclerView(binding.ecoRecyclerView, badgeProduct);

        //생활 텍스트뷰 클릭
        binding.cate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate1.getText().toString();

                switchFragment(category);
            }
        });

        //주방 텍스트뷰 클릭
        binding.cate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate2.getText().toString();

                switchFragment(category);
            }
        });

        //문구/도서 텍스트뷰 클릭
        binding.cate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate3.getText().toString();

                switchFragment(category);
            }
        });

        //욕실 텍스트뷰 클릭
        binding.cate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate4.getText().toString();

                switchFragment(category);
            }
        });

        //패션/뷰티 텍스트뷰 클릭
        binding.cate5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate5.getText().toString();

                switchFragment(category);
            }
        });

        //기타 텍스트뷰 클릭
        binding.cate6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = binding.cate6.getText().toString();

                switchFragment(category);
            }
        });

        binding.reNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(RecycleMainFragment.newInstance());
            }
        });

        return binding.getRoot();
    }

    public void switchFragment(String category){
        //fragment 간 이동 + 값 전달
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        IntoCategoryFragment intoCategoryFragment = new IntoCategoryFragment();
        Bundle bundle = new Bundle();

        bundle.putString("category", category);
        intoCategoryFragment.setArguments(bundle);
        transaction.replace(R.id.container, intoCategoryFragment);
        transaction.commit();
    }

    public void setBestRecyclerView(RecyclerView recyclerView, ArrayList<BestProduct> products) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bestLinearAdapter = new BestLinearAdapter(products);
        recyclerView.setAdapter(bestLinearAdapter);
    }

    public void setBadgeRecyclerView(RecyclerView recyclerView, ArrayList<Product> products) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        linearAdapter = new LinearAdapter(products);
        recyclerView.setAdapter(linearAdapter);
    }

    public void setDummyData() {
        eventBanners = new ArrayList<>();
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔2"));

        badgeProduct = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            badgeProduct.add(new Product("뱃지", "전체 상품", "20,000"));
        }

        totalProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            totalProducts.add(new BestProduct("1위", "생활", "생활 상품", "20,000"));
        }

        lifeProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lifeProducts.add(new BestProduct("1위", "원주 주방용품", "원주 주방용품", "20,000"));
        }

        bathProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bathProducts.add(new BestProduct("1위", "원주 칫솔회사", "원주 대나무 칫솔", "20,000"));
        }
    }

    public void tabLayoutEvent() {
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        binding.bestRecyclerView.setAdapter(new BestLinearAdapter(totalProducts));
                        break;
                    case 1:
                        binding.bestRecyclerView.setAdapter(new BestLinearAdapter(lifeProducts));
                        break;
                    case 2:
                        binding.bestRecyclerView.setAdapter(new BestLinearAdapter(bathProducts));
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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
    }
}
