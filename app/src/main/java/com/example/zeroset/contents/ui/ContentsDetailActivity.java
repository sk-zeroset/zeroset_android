package com.example.zeroset.contents.ui;

import com.example.zeroset.R;
import com.example.zeroset.contents.model.Comment;
import com.example.zeroset.contents.ui.adapter.CommentListAdapter;
import com.example.zeroset.contents.ui.adapter.CommentReplyListAdapter;
import com.example.zeroset.contents.ui.adapter.ImageSliderAdapter;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class ContentsDetailActivity extends AppCompatActivity {

    private ViewPager2 silderImageViewPager;
    private LinearLayout layoutIndicator;
    TextView internalContents;
    Button writeComment;

    TextView commentCount;
    RecyclerView commentRecyclerView;
    CommentListAdapter commentListAdapter;
    ArrayList<Comment> comments;

    Button allComment;

    private String[] images = new String[] {
            "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg",
            "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents_detail);

        silderImageViewPager = findViewById(R.id.silder_image_view_page);
        layoutIndicator = findViewById(R.id.layout_indicators);

        silderImageViewPager.setOffscreenPageLimit(1);
        silderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));

        silderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);

        internalContents = findViewById(R.id.internal_contents);
        internalContents.setText("[??????=?????????] ????????? ????????? ?????? = ?????? 24????????? ????????? 5??? ?????? ????????? ????????? ????????????. ????????? ????????? ????????? ????????? ???????????? ???????????? ??????????????? ???????????? ????????? ????????????.\n" +
                "\n" +
                "????????? ????????????????????????(?????????) ????????????????????? 22??? ?????? ???????????????????????? ?????????19 ?????????????????? ?????? ??? ?????? ????????? ?????? ???????????? ????????????????????? ????????????.\n" +
                "\n" +
                "??? ????????????????????? \"?????? 1?????? ?????? ??? ?????? 900??? ????????? ????????? ???????????? ??? ?????????19 ????????? ???????????? ???????????? ????????????, ????????????, ???????????? ??? ???????????????????????? ??????????????? ????????? ?????? ????????? ???????????? ???????????? ????????? ????????? ????????????????? ????????? ????????? ???????????? ??? ?????? ????????? ????????? ??? ??????\"????????? ?????????????????? ?????? ????????? ?????????.\n" +
                "\n" +
                "?????? ????????? ??????, ?????? ??? ?????????????????? ?????? 23????????? 5??? ?????? ????????? ???????????? ????????? ????????? ??? ??????. ");
        writeComment =  findViewById(R.id.btn_write_comment);
        writeComment.setPaintFlags(writeComment.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // underline

        // ???????????????
        overridePendingTransition(R.anim.horizon_enter, R.anim.none);

        commentCount = findViewById(R.id.tv_comment_count);

        comments = new ArrayList<>();
         /*comments.add(new Comment("???????????? ???????????? ?????? ???????????? ????????? :)???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment("???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment("???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???","??????1???"));
        comments.add(new Comment("???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???","??????1???"));
        comments.add(new Comment("???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???","??????1???"));

        commentCount.setText("(" + comments.size() +")");

        commentRecyclerView = findViewById(R.id.recyclerView_comment);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)) ;
        commentListAdapter = new CommentListAdapter(comments);
        commentRecyclerView.setAdapter(commentListAdapter);
*/
        commentRecyclerView = findViewById(R.id.recyclerView_comment);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        comments = new ArrayList<>();

        comments.add(new Comment(CommentReplyListAdapter.HEADER, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));

        comments.add(new Comment(CommentReplyListAdapter.HEADER, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "???????????? ???????????? ?????? ???????????? ????????? :)", "2021.02.05", "yeonhee", "?????????1???", "??????1???"));

        commentRecyclerView.setAdapter(new CommentReplyListAdapter(comments));

        // ?????? ?????? ??????
        allComment = findViewById(R.id.btn_all_comment);
        allComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ContentsCommentsActivity.class));
            }
        });

    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}
