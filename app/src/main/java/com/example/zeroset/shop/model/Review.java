package com.example.zeroset.shop.model;

public class Review {

    Double rating;
    String contents;
    String date;
    String userId;

    public Review(Double rating, String contents, String date, String userId) {
        this.rating = rating;
        this.contents = contents;
        this.date = date;
        this.userId = userId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
}
