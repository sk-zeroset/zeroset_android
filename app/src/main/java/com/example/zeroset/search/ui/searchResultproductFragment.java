package com.example.zeroset.search.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroset.R;

public class searchResultproductFragment extends Fragment {

    public searchResultproductFragment(){
        // Required empty public constructor
    }

    public static searchResultproductFragment newInstance(){
        searchResultproductFragment fragment = new searchResultproductFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search_result_product,
                container, false);

        initUI(rootView);

        ImageButton btn_back;
        btn_back = rootView.findViewById(R.id.btn_back);

        return rootView;
    }

    private void initUI(ViewGroup rootView){
    }
}
