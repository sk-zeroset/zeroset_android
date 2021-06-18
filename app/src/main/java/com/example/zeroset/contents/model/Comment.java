package com.example.zeroset.contents.model;

import java.util.List;

public class Comment {
    public int type;
    public List<Comment> invisibleChildren;
    String contents;
    String date;
    String userId;
    String writeLike;
    String writeAnswer;

    public Comment(int type, String contents, String date, String userId, String writeLike, String writeAnswer) {
        this.type = type;
        this.contents = contents;
        this.date = date;
        this.userId = userId;
        this.writeLike = writeLike;
        this.writeAnswer = writeAnswer;
    }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWriteLike() {
        return writeLike;
    }

    public void setWriteLike(String writeLike) {
        this.writeLike = writeLike;
    }

    public String getWriteAnswer() {
        return writeAnswer;
    }

    public void setWriteAnswer(String writeAnswer) {
        this.writeAnswer = writeAnswer;
    }


}
