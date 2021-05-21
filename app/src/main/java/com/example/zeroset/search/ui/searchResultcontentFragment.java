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

public class searchResultcontentFragment extends Fragment {

    public searchResultcontentFragment(){
        // Required empty public constructor
    }

    public static searchResultcontentFragment newInstance(){
        searchResultcontentFragment fragment = new searchResultcontentFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search_result_content,
                container, false);

        initUI(rootView);

        ImageButton btn_back;


        return rootView;
    }

    private void initUI(ViewGroup rootView){
    }

}
