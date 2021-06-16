package com.example.zeroset.search.model;

import com.example.zeroset.shop.model.Product;

import java.util.ArrayList;

public class Shop {
    private String shopname;
    private String shoploc;
    private String iconURL;
    public ArrayList<Product> Products;

    public Shop(String shopname, String shoploc, String iconURL,  ArrayList<Product> Products) {
        this.shopname = shopname;
        this.shoploc = shoploc;
        this.iconURL = iconURL;
        this.Products = Products;
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Product> products) {
        Products = products;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShoploc() {
        return shoploc;
    }

    public void setShoploc(String shoploc) {
        this.shoploc = shoploc;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
