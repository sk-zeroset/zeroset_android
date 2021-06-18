package com.example.zeroset.contents.ui.adapter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.contents.model.Comment;

import java.util.List;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder> {

    private final List<Comment> commentList;
    private TextView contents;
    private TextView date;
    private TextView userId;
    private TextView writeLike;
    private Button btnCommentAnswer,btnWriteAnswer;
    private ImageButton btnCommentLike;


    public CommentListAdapter(List<Comment> comments) {
        this.commentList = comments;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            contents = itemView.findViewById(R.id.tv_contents);
            date = itemView.findViewById(R.id.tv_write_date);
            userId = itemView.findViewById(R.id.tv_user_id);
            writeLike = itemView.findViewById(R.id.tv_write_like);
            btnWriteAnswer = itemView.findViewById(R.id.btn_write_answer);
            btnCommentAnswer = itemView.findViewById(R.id.btn_comment_answer);
            btnCommentLike = itemView.findViewById(R.id.btn_comment_like);

            btnWriteAnswer.setPaintFlags(btnWriteAnswer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // underline
        }
    }

    //  아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_comment, null);
        return new ViewHolder(v);
    }

    //  position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(CommentListAdapter.ViewHolder holder, int position){
        contents.setText(commentList.get(position).getContents());
        date.setText(commentList.get(position).getDate());
        userId.setText(commentList.get(position).getUserId());
        writeLike.setText(commentList.get(position).getWriteLike());
        btnWriteAnswer.setText(commentList.get(position).getWriteAnswer());
    }

    // 전체 데이터 갯수 리턴
    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
