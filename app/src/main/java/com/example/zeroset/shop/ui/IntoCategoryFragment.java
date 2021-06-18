package com.example.zeroset.shop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;

//data binding import
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.example.zeroset.databinding.FragmentIntoCategoryBinding;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.databinding.FragmentIntoCategoryBinding;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;

import java.util.ArrayList;

public class IntoCategoryFragment extends Fragment {

    //binding
    public FragmentIntoCategoryBinding binding;

    ArrayList<eventBanner> eventBanners;
    ArrayList<Product> totalProducts;
    ArrayList<Product> lifeProducts;
    ArrayList<Product> bathProducts;

    GridAdapter gridAdapter;
    EventBannerAdapter eventBannerAdapter;

    static public boolean count = true;
    boolean focus = false;
    public IntoCategoryFragment() {
        // Required empty public constructor```````````
    }

    public static IntoCategoryFragment newInstance() {
        IntoCategoryFragment fragment = new IntoCategoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_into_category, container, false);
        binding.setActivity(this);
        Log.d("0617:",binding.toString());

        Bundle bundle = getArguments();  //번들 받기. getArguments() 메소드로 받음.
        if (bundle != null) {
            String category = bundle.getString("category"); //count 받기
            binding.cateText1.setText(category);
            binding.total.setText(category + " 전체 상품");
        }

        eventBanners = new ArrayList<>();
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔2"));
        eventBanners.add(new eventBanner("이미지url", "이미지url", "코가 뚫리는 박하향이 나는 대나무칫솔3"));

        binding.cate1RankRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)) ;
        eventBannerAdapter = new EventBannerAdapter(eventBanners, getContext(), this);
        binding.cate1RankRecyclerview.setAdapter(eventBannerAdapter);

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

        binding.cate1Recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridAdapter = new GridAdapter(totalProducts);
        binding.cate1Recyclerview.setAdapter(gridAdapter);
        binding.cate1Recyclerview.setNestedScrollingEnabled(false);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(ShopFragment.newInstance());
            }
        });

        focus = binding.spin1.isFocusableInTouchMode();
        Log.d("focus0", String.valueOf(focus));

        if(focus){
            Log.d("focus3", "폴슈");
            binding.btnAddNext.setImageResource(R.drawable.btn_arrow_down);
            binding.spin1.setVisibility(View.GONE);
            count = false;
        }

        binding.btnAddNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count){ // 생활, 욕심, 주방, 패션/뷰티 ... 접기
                    //binding.spin1.setFocusableInTouchMode(false);
                    Log.d("focus1", String.valueOf(binding.spin1.isFocusableInTouchMode()));
                    binding.btnAddNext.setImageResource(R.drawable.btn_arrow_down);
                    binding.spin1.setVisibility(View.GONE);
                    count = false;
                    binding.spin1.setFocusable(false);

                }
                else{ // 생활, 욕심, 주방, 패션/뷰티 ... 펼치기
                    //binding.spin1.setFocusableInTouchMode(true);
                    Log.d("focus2", String.valueOf(binding.spin1.isFocusableInTouchMode()));
                    binding.btnAddNext.setImageResource(R.drawable.btn_arrow_up);
                    binding.spin1.setVisibility(View.VISIBLE);
                    count = true;
                    binding.spin1.setFocusable(true);
                }
            }
        });

        binding.const1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count){ // 생활, 욕심, 주방, 패션/뷰티 ... 접기
                    //binding.spin1.setFocusableInTouchMode(false);
                    Log.d("focus1", String.valueOf(binding.spin1.isFocusableInTouchMode()));
                    binding.btnAddNext.setImageResource(R.drawable.btn_arrow_down);
                    binding.spin1.setVisibility(View.GONE);
                    count = false;
                    binding.spin1.setFocusable(false);
                }
            }
        });

        return binding.getRoot();
    }

}


class Custom extends LinearLayout {
    public Custom(Context context) {
        super(context);
    }

    public Custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Custom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
    Boolean scroll = true;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(scroll)
            return super.onInterceptTouchEvent(ev);
        else
            return false;
    }


}