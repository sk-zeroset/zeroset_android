package com.example.zeroset.shop.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zeroset.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shopFragment extends Fragment {

    Button button;

    public shopFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static shopFragment newInstance(String param1, String param2) {
        shopFragment fragment = new shopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detailActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }


}