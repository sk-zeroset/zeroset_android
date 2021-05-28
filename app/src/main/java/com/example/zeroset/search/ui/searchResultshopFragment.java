package com.example.zeroset.search.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.search.model.Shop;
import com.example.zeroset.search.ui.adapter.ShopAdapter;
import com.example.zeroset.search.ui.adapter.ShopDetailAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class searchResultshopFragment extends Fragment {

    private RecyclerView shoprecycler;
    private ArrayList<Shop> Shops;
    private ShopDetailAdapter shopDetailAdapter;
    private TextView shopsize;

    public searchResultshopFragment(){
        // Required empty public constructor
    }

    public static searchResultshopFragment newInstance(){
        searchResultshopFragment fragment = new searchResultshopFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_search_result_shop,
                container, false);

        initUI(v);
        shoprecycler = v.findViewById(R.id.shoprecycler);
        shopsize = v.findViewById(R.id.shopsize);

        Shops = ((searchActivity)getActivity()).Shops;

        shopsize.setText(String.valueOf(Shops.size())+"개");
        shoprecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        shopDetailAdapter = new ShopDetailAdapter(Shops);
        shoprecycler.setAdapter(shopDetailAdapter);


        return v;
    }

    private void initUI(ViewGroup rootView){
    }
}
