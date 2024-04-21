package com.carservices.finalproject.model;

import jakarta.persistence.*;

@Entity
public class AiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String brand;
    private String year;
    private String mileage;
    private String specialAddition;
    private String price;
    private String response;
    public AiModel() {
    }

    public AiModel(String type, String brand, String year, String mileage, String specialAddition, String price ,String response) {
        this.type = type;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.specialAddition = specialAddition;
        this.price = price;
        this.response=response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getSpecialAddition() {
        return specialAddition;
    }

    public void setSpecialAddition(String specialAddition) {
        this.specialAddition = specialAddition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
