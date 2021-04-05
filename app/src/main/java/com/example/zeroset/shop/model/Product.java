package com.example.zeroset.shop.model;

import java.util.ArrayList;

public class Product {

    private String company;
    private String productName;
    private String price;
    private ArrayList<Review> reviews;

    public Product(String company, String productName, String price) {
        this.company = company;
        this.productName = productName;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
