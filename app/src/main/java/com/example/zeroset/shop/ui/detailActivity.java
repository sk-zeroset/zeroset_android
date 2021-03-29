package com.example.zeroset.shop.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.zeroset.R;
import com.example.zeroset.shop.model.Review;
import com.example.zeroset.shop.ui.adapter.ReviewListAdapter;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity {

    TextView reviewCount;

    RecyclerView reviewRecyclerView;
    ReviewListAdapter reviewListAdapter;
    ArrayList<Review> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        overridePendingTransition(R.anim.horizon_enter, R.anim.none);

        reviewCount = findViewById(R.id.review_count);

        reviews = new ArrayList<>();
        reviews.add(new Review(4.5, "어쩌구저쩌구저쩌구", "2021/2/5", "yun72027"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yoon_yee"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));
        reviews.add(new Review(4.5, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021/2/5", "yeji_yun"));

        reviewCount.setText("(" + reviews.size() +")");

        reviewRecyclerView = findViewById(R.id.recyclerView_review);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)) ;
        reviewListAdapter = new ReviewListAdapter(reviews.subList(0, 3));
        reviewRecyclerView.setAdapter(reviewListAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.none, R.anim.horizon_exit);
    }
}