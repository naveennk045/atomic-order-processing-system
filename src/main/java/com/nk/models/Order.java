package com.nk.models;

import com.nk.models.enums.OrderStatus;

public class Order {

    private static long orderCount = 0;
    private final long id;
    private long userId;
    private long productId;
    private int quantity;
    private double amount;
    private OrderStatus status;

    public Order(long userId, long productId, int quantity, double amount, OrderStatus status) {
        this.id = ++orderCount;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}