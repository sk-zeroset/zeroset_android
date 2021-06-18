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
        internalContents.setText("[서울=뉴시스] 임재희 구무서 기자 = 오는 24일부터 식당에 5인 이상 예약과 입장이 금지된다. 겨울철 이용이 급증할 것으로 예상되는 스키장과 눈썰매장도 집합금지 대상에 포함된다.\n" +
                "\n" +
                "윤태호 중앙사고수습본부(중수본) 방역총괄반장은 22일 오전 정부세종청사에서 코로나19 정례브리핑을 열고 이 같은 내용을 담은 연말연시 특별방역대책을 발표했다.\n" +
                "\n" +
                "윤 방역총괄반장은 \"지난 1주간 전국 일 평균 900명 이상의 환자가 발생하는 등 코로나19 확산이 지속되는 상황에서 요양병원, 요양시설, 종교시설 등 고위험시설에서의 집단감염이 끊이지 않고 있으며 성탄절과 연말연시 연휴를 전후로 모임·여행이 증가할 것으로 예상되는 등 감염 확산의 위험이 큰 상황\"이라며 특별방역대책 도입 배경을 밝혔다.\n" +
                "\n" +
                "앞서 서울과 경기, 인천 등 수도권에서는 오는 23일부터 5인 이상 집합을 금지하는 방안을 발표한 바 있다. ");
        writeComment =  findViewById(R.id.btn_write_comment);
        writeComment.setPaintFlags(writeComment.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // underline

        // 댓글리스트
        overridePendingTransition(R.anim.horizon_enter, R.anim.none);

        commentCount = findViewById(R.id.tv_comment_count);

        comments = new ArrayList<>();
         /*comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개","답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개","답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개","답글1개"));

        commentCount.setText("(" + comments.size() +")");

        commentRecyclerView = findViewById(R.id.recyclerView_comment);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)) ;
        commentListAdapter = new CommentListAdapter(comments);
        commentRecyclerView.setAdapter(commentListAdapter);
*/
        commentRecyclerView = findViewById(R.id.recyclerView_comment);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        comments = new ArrayList<>();

        comments.add(new Comment(CommentReplyListAdapter.HEADER, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));

        comments.add(new Comment(CommentReplyListAdapter.HEADER, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment(CommentReplyListAdapter.CHILD, "생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));

        commentRecyclerView.setAdapter(new CommentReplyListAdapter(comments));

        // 전체 댓글 보기
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
