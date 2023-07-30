package com.example.nishit_patel_project2.DataClass;

public class ProductData {
    int image;
    String name;
    String price;
    String rating;
    String review;
    String dicountrate;

    ProductData(){

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDicountrate() {
        return dicountrate;
    }

    public void setDicountrate(String dicountrate) {
        this.dicountrate = dicountrate;
    }

    public ProductData(int image, String name, String price, String rating, String review, String dicountrate) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.review = review;
        this.dicountrate = dicountrate;
    }
}
