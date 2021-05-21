package com.example.zeroset.home.model;

public class Content {
    private String title;
    private String imgURL;
    private String maintext;
    private int type;

    public Content(String title, String imgURL, String maintext, int type) {
        this.title = title;
        this.imgURL = imgURL;
        this.maintext = maintext;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }
}
