package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zeroset.R;
import com.example.zeroset.shop.model.Review;
import com.example.zeroset.shop.ui.adapter.ReviewListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {

    TextView reviewCount;

    RecyclerView reviewRecyclerView;
    ReviewListAdapter reviewListAdapter;
    ArrayList<Review> reviews;


    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_review, container, false);

        reviewCount = v.findViewById(R.id.review_count);

        reviews = new ArrayList<>();
        reviews.add(new Review(4.5, "어쩌구저쩌구저쩌구", "2021/2/5", "yun72027"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yoon_yee"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));

        reviewCount.setText("(" + reviews.size() +")");

        reviewRecyclerView = v.findViewById(R.id.recyclerView_review);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)) ;
        reviewListAdapter = new ReviewListAdapter(reviews);
        reviewRecyclerView.setAdapter(reviewListAdapter);
        return v;
    }
}