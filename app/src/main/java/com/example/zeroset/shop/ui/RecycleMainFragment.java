package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleMainFragment extends Fragment {

    TextView recycle_des; // 리사이클 뱃지 설명
    ImageButton btn_back;

    ArrayList<Product> totalProducts;
    ArrayList<Product> lifeProducts;
    ArrayList<Product> kitchenProducts;
    ArrayList<Product> beautyProducts;
    ArrayList<Product> interiorProducts;
    ArrayList<Product> bathProducts;
    ArrayList<Product> fashionProducts;
    ArrayList<Product> bookProducts;
    ArrayList<Product> etcProducts;

    RecyclerView recylce_Recylcerview;

    GridAdapter gridAdapter;

    TabLayout tabLayout;

    public static RecycleMainFragment newInstance() {
        RecycleMainFragment fragment = new RecycleMainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycle_main, container, false);

        recycle_des = v.findViewById(R.id.recycle_des);
        recycle_des.setText("3개월간 제자리걸음을 걷고 있는 르노삼성차 노사는 내년1\n월에 본교섭을 재개할 예정이어서 새해에도 당분간 진통을 \n겪을 것으로 보인다.");

        totalProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            totalProducts.add(new Product("전체", "전체 상품", "20,000"));
        }

        lifeProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lifeProducts.add(new Product("원주 생활용품", "원주 생활용품", "20,000"));
        }

        kitchenProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            kitchenProducts.add(new Product("원주 칫솔회사", "원주 대나무 칫솔", "20,000"));
        }

        beautyProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beautyProducts.add(new Product("원주 화장품", "원주 대나무 파우더", "20,000"));
        }

        interiorProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            interiorProducts.add(new Product("원주 페인트 회사", "원주 저자극 페인트", "20,000"));
        }

        bathProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bathProducts.add(new Product("원주 비누 회사", "원주 나무 비누", "20,000"));
        }

        fashionProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fashionProducts.add(new Product("원주 소재", "원주 천연 소재", "20,000"));
        }

        bookProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bookProducts.add(new Product("원주 볼펜 회사", "원주 대나무 펜", "20,000"));
        }

        etcProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            etcProducts.add(new Product("원주 기타", "원주 기타", "20,000"));
        }

        for(Product p: lifeProducts){
            System.out.println(p.getProductName());
        }


        recylce_Recylcerview = v.findViewById(R.id.reycleRecylcerView);
        recylce_Recylcerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridAdapter = new GridAdapter(totalProducts);
        recylce_Recylcerview.setAdapter(gridAdapter);
        recylce_Recylcerview.setNestedScrollingEnabled(false);

        tabLayout = v.findViewById(R.id.recycle_tablayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        recylce_Recylcerview.setAdapter(new GridAdapter(totalProducts));
                        break;
                    case 1:
                        recylce_Recylcerview.setAdapter(new GridAdapter(lifeProducts));
                        break;
                    case 2:
                        recylce_Recylcerview.setAdapter(new GridAdapter(kitchenProducts));
                        break;
                    case 3:
                        recylce_Recylcerview.setAdapter(new GridAdapter(beautyProducts));
                        break;
                    case 4:
                        recylce_Recylcerview.setAdapter(new GridAdapter(interiorProducts));
                        break;
                    case 5:
                        recylce_Recylcerview.setAdapter(new GridAdapter(bathProducts));
                        break;
                    case 6:
                        recylce_Recylcerview.setAdapter(new GridAdapter(fashionProducts));
                        break;
                    case 7:
                        recylce_Recylcerview.setAdapter(new GridAdapter(bookProducts));
                        break;
                    case 8:
                        recylce_Recylcerview.setAdapter(new GridAdapter(etcProducts));
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

        btn_back = v.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(ShopFragment.newInstance());
            }
        });
        return v;
    }
}