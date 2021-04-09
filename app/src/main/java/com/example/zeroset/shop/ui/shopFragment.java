package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.example.zeroset.shop.ui.adapter.LinearAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class shopFragment extends Fragment {

    private Button button;
    private ImageButton btn_re, btn_next1;  //recycle 뱃지로 가는 버튼, 카테고리 옆버튼들
    private TextView text1;

    private ArrayList<eventBanner> eventBanners;
    private ArrayList<Product> totalProducts;
    private ArrayList<Product> lifeProducts;
    private ArrayList<Product> bathProducts;

    private LinearAdapter linearAdapter;
    private EventBannerAdapter eventBannerAdapter;

    private TabLayout tabLayout;

    private RecyclerView eventBannerRecyclerView;
    private RecyclerView bestRecyclerView;
    private RecyclerView recycleRecyclerView;
    private RecyclerView socialRecyclerView;
    private RecyclerView ecoRecyclerView;

    private int MAX_ITEM_COUNT = 10; // 개수 제한

    public shopFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shop, container, false);

        setDummyData();

        // xml binding
        eventBannerRecyclerView = v.findViewById(R.id.eventBannerRecyclerView);
        bestRecyclerView = v.findViewById(R.id.bestRecyclerView);
        recycleRecyclerView = v.findViewById(R.id.recycleRecyclerView);
        socialRecyclerView = v.findViewById(R.id.socialRecyclerView);
        ecoRecyclerView = v.findViewById(R.id.ecoRecyclerView);
        tabLayout = v.findViewById(R.id.tab_layout);

        // 기획전
        eventBannerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)) ;
        eventBannerAdapter = new EventBannerAdapter(eventBanners, getContext());
        eventBannerRecyclerView.setAdapter(eventBannerAdapter);

        tabLayoutEvent();
        setRecyclerView(bestRecyclerView, totalProducts);
        setRecyclerView(recycleRecyclerView, totalProducts); // 리사이클러뷰 뱃지별로 product 교체
        setRecyclerView(socialRecyclerView, totalProducts);
        setRecyclerView(ecoRecyclerView, totalProducts);


        //생활 텍스트뷰 클릭
        text1 = v.findViewById(R.id.cate1);
       /* text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragment 간 이동
                ((MainActivity) getActivity()).replaceFragment(into_category1.newInstance());
            }
        });*/


        btn_re = (ImageButton) v.findViewById(R.id.re_next);
        btn_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(RecycleMainFragment.newInstance());
            }
        });

        return v;
    }


    public void setRecyclerView(RecyclerView recyclerView, ArrayList<Product> products) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        linearAdapter = new LinearAdapter(products);
        recyclerView.setAdapter(linearAdapter);
    }

    public void setDummyData() {
        eventBanners = new ArrayList<>();
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔2"));

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
    }

    public void tabLayoutEvent() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        bestRecyclerView.setAdapter(new GridAdapter(totalProducts));
                        break;
                    case 1:
                        bestRecyclerView.setAdapter(new GridAdapter(lifeProducts));
                        break;
                    case 2:
                        bestRecyclerView.setAdapter(new GridAdapter(bathProducts));
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
    }

}
