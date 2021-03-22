package com.simplilearn.shoestore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shoes")
public class Product {

    @Id
    Integer id;

    @Column(name="shoe_name")
    String shoe_name;

    @Column(name="season")
    String season;

    @Column(name="category")
    String category;

    @Column(name="price")
    double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Column(name="brand")
    String brand;

    @Column(name="color")
    String color;

    @Column(name="lastupdated")
    Date lastupdated;

    public void setShoe_name(String shoe_name) {
        this.shoe_name = shoe_name;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShoe_name() {
        return shoe_name;
    }

    public String getSeason() {
        return season;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getColor() {
        return color;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
