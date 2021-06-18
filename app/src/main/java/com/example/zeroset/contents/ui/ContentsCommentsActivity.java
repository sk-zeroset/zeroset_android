package com.example.zeroset.contents.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zeroset.R;
import com.example.zeroset.contents.model.Comment;
import com.example.zeroset.contents.ui.adapter.CommentListAdapter;
import com.example.zeroset.contents.ui.adapter.CommentReplyListAdapter;

import java.util.ArrayList;

public class ContentsCommentsActivity extends AppCompatActivity {

    TextView commentCount;
    Button writeComment, writeAnswer;
    ImageView btnBack;

    RecyclerView commentRecyclerView;
    CommentListAdapter commentListAdapter;
    ArrayList<Comment> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents_comments);

        writeComment = findViewById(R.id.btn_write_comment);
        //writeAnswer = findViewById(R.id.btn_write_answer);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ContentsDetailActivity.class));
            }
        });

        writeComment.setPaintFlags(writeComment.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // underline



        // 댓글 리스트
        commentCount = findViewById(R.id.tv_comment_count);

        comments = new ArrayList<>();
     /* comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개", "답글1개"));
        comments.add(new Comment("생각했던 사용감과 같이 부드럽고 좋아요 :)", "2021.02.05", "yeonhee", "좋아요1개","답글1개"));
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

    }
}