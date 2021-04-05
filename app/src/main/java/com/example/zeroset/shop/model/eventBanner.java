package com.example.zeroset.shop.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

public class eventBanner {

    String thumbnail;
    String detailImage;
    String title;

    public eventBanner(String thumbnail, String detailImage, String title) {
        this.thumbnail = thumbnail;
        this.detailImage = detailImage;
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
