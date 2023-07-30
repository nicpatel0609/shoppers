package com.example.nishit_patel_project2.DataClass;

public class CartData {
    int image;
    String name;
    String price;
    String Discount;

    public CartData(int image, String name, String price, String discount) {
        this.image = image;
        this.name = name;
        this.price = price;
        Discount = discount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
