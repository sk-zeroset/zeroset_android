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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.home.model.Content;
import com.example.zeroset.home.ui.adapter.ContentBannerAdapter;
import com.example.zeroset.login.ui.registerActivity;
import com.example.zeroset.search.model.Shop;
import com.example.zeroset.search.ui.adapter.ShopAdapter;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.search.ui.adapter.LinearAdapter;
import com.example.zeroset.shop.ui.shopDetailFragment;

import java.util.ArrayList;

public class searchResulttotalFragment extends Fragment {
    private RecyclerView productrecycler, contentrecycler1, contentrecycler2, shoprecycler;
    private LinearAdapter linearAdapter;
    private ArrayList<Product> Products, Productstotal;
    private ArrayList<Content> Contents, Contents2, Contentstotal, Contents2total;
    private ContentBannerAdapter contentAdapter;
    private ImageButton btn_content, btn_shop, btn_product;
    private TextView product, shop, content;
    private ArrayList<Shop> Shops, Shopstotal;
    int type;
    private ShopAdapter shopAdapter;


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
        shoprecycler = v.findViewById(R.id.shoprecycler);
        btn_content = v.findViewById(R.id.btn_rightpoint_content);
        btn_shop = v.findViewById(R.id.btn_rightpoint_shop);
        btn_product = v.findViewById(R.id.btn_rightpoint_product);
        product = v.findViewById(R.id.productsize); // 상품 아이템 총 개수 부분
        shop = v.findViewById(R.id.shopsize); // 관련된 샵 아이템 총 개수 부분
        content = v.findViewById(R.id.contentsize); // 관련된 컨텐츠 아이템 총 개수 부분

        btn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((searchActivity) getActivity()).viewPager.setCurrentItem(3);

            }
        });
        btn_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ((searchActivity) getActivity()).viewPager.setCurrentItem(1);


            }
        });
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((searchActivity) getActivity()).viewPager.setCurrentItem(2);

            }
        });

        Contentstotal = ((searchActivity)getActivity()).Contents;
        Contents = new ArrayList<>();
        Contents.addAll(Contentstotal.subList(0,5));

        Contents2total = ((searchActivity)getActivity()).Contents2;
        Contents2 = new ArrayList<>();
        Contents2.addAll(Contents2total.subList(0,5));

        Productstotal = ((searchActivity)getActivity()).Products;
        Products = new ArrayList<>();
        Products.addAll(Productstotal.subList(0,10));

        Shopstotal = ((searchActivity)getActivity()).Shops;
        Shops =  new ArrayList<>();
        Shops.addAll(Shopstotal.subList(0,5)); //3개로 아이템 개수 제한


        product.setText("("+String.valueOf(Productstotal.size())+")"); //(상품개수) 부분 출력
        content.setText("("+String.valueOf(Contentstotal.size()+Contents2total.size())+")");
        shop.setText("("+String.valueOf(Shopstotal.size())+")");

        productrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        linearAdapter = new LinearAdapter(Products);
        productrecycler.setAdapter(linearAdapter);
        setRecyclerView(contentrecycler1,Contents,2);
        setRecyclerView(contentrecycler2,Contents2,1);
        shoprecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        shopAdapter = new ShopAdapter(Shops);
        shoprecycler.setAdapter(shopAdapter);


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


}
