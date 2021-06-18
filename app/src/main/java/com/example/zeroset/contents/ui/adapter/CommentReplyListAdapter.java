package com.example.zeroset.contents.ui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.util.SparseBooleanArray;
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

import java.util.ArrayList;
import java.util.List;

public class CommentReplyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0; // 댓글
    public static final int CHILD = 1; // 답글

    private final List<Comment> commentList;

    public CommentReplyListAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }

    //  아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        Context context = parent.getContext();
        switch (viewType) {
            case HEADER:
                LayoutInflater inflaterHeader = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterHeader.inflate(R.layout.item_comment, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflaterChild = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterChild.inflate(R.layout.item_comment_reply, parent, false);
                ListChildViewHolder child = new ListChildViewHolder(view);
                return child;

        }
        return null;
    }

    //  position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        final Comment item = commentList.get(position);

        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemHeaderController = (ListHeaderViewHolder) holder;

                itemHeaderController.refferalItem = item;
                itemHeaderController.contents.setText(commentList.get(position).getContents());
                itemHeaderController.date.setText(commentList.get(position).getDate());
                itemHeaderController.userId.setText(commentList.get(position).getUserId());
                itemHeaderController.writeLike.setText(commentList.get(position).getWriteLike());
                itemHeaderController.btnWriteAnswer.setText(commentList.get(position).getWriteAnswer());


                if (item.invisibleChildren == null) { // 답글 버튼 눌렸을 때
                    itemHeaderController.btnWriteAnswer.setText("답글 접기");
                } else { // 답글 버튼 안눌렸을 때
                    itemHeaderController.btnWriteAnswer.setText(commentList.get(position).getWriteAnswer());
                }

                itemHeaderController.btnWriteAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Comment>();
                            int count = 0;
                            int pos = commentList.indexOf(itemHeaderController.refferalItem);
                            while (commentList.size() > pos + 1 && commentList.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(commentList.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemHeaderController.btnWriteAnswer.setText(commentList.get(position).getWriteAnswer());
                        } else {
                            int pos = commentList.indexOf(itemHeaderController.refferalItem);
                            int index = pos + 1;
                            for (Comment i : item.invisibleChildren) {
                                commentList.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemHeaderController.btnWriteAnswer.setText("답글 접기");
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                final ListChildViewHolder itemChildController = (ListChildViewHolder) holder;
                itemChildController.refferalItem = item;
                itemChildController.replyContents.setText(commentList.get(position).getContents());
                itemChildController.replyDate.setText(commentList.get(position).getDate());
                itemChildController.replyUserId.setText(commentList.get(position).getUserId());
                itemChildController.replyWriteLike.setText(commentList.get(position).getWriteLike());
                break;
        }
    }

    // 전체 데이터 갯수 리턴
    @Override
    public int getItemCount() {
        return commentList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return commentList.get(position).type;
    }


    // 댓글
    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public Comment refferalItem;
        private TextView contents;
        private TextView date;
        private TextView userId;
        private TextView writeLike;
        private Button btnCommentAnswer,btnWriteAnswer;
        private ImageButton btnCommentLike;

        public ListHeaderViewHolder(View itemView) {
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

    // 답글
    private static class ListChildViewHolder extends RecyclerView.ViewHolder {
        private Comment refferalItem;
        private TextView replyContents;
        private TextView replyDate;
        private TextView replyUserId;
        private TextView replyWriteLike;
        private ImageButton btnReplyCommentLike;

        public ListChildViewHolder(View itemView) {
            super(itemView);
            replyContents = itemView.findViewById(R.id.reply_contents);
            replyDate = itemView.findViewById(R.id.reply_write_date);
            replyUserId = itemView.findViewById(R.id.reply_user_id);
            replyWriteLike = itemView.findViewById(R.id.reply_write_like);
            btnReplyCommentLike = itemView.findViewById(R.id.btn_reply_comment_like);

        }
    }

}
