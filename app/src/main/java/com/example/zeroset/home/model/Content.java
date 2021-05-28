package com.example.zeroset.home.model;

public class Content {
    private String title;
    private String imgURL;
    private String maintext;
    private boolean recycle, social, eco;
    public Content(String title, String imgURL, String maintext, boolean recycle, boolean social, boolean eco) {
        this.title = title;
        this.imgURL = imgURL;
        this.maintext = maintext;
        this.recycle = recycle;
        this.social = social;
        this.eco = eco;
    }

    public boolean isRecycle() {
        return recycle;
    }

    public void setRecycle(boolean recycle) {
        this.recycle = recycle;
    }

    public boolean isSocial() {
        return social;
    }

    public void setSocial(boolean social) {
        this.social = social;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
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
