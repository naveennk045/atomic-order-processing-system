package com.nk.models;

public class Product {

    private static long productCount = 0;
    private final long id;
    private String name;
    private String description;
    private double price;
    private int stocks;

    public Product(String name, String description, double price, int stocks) {
        this.id = ++productCount;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stocks = stocks;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}