package com.example.shopingmodel;

public class MobileDataModel {

    String name,brand,price,year,location,category;
    String image2;

    public String getImage2() {
        return image2;
    }

    public MobileDataModel(String name, String brand, String price, String year, String location, String category, String image2) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.year = year;
        this.location = location;
        this.category = category;
        this.image2=image2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
