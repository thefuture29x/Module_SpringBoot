package com.example.module_javaspringboot_day4.dto;

import java.sql.Date;

public class ProductDTO {
    private int id;
    private String name;
    private String image;
    private String price;
    private int amount;
    private int status;
    private int type;
    private String createTime;
    private String createBy;
    private int cart_amount = 1;

    public int getCart_amount() {
        return cart_amount;
    }

    public void setCart_amount(int cart_amount) {
        this.cart_amount = cart_amount;
    }

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String image, String price, int amount, int status, int type, String createTime, String createBy) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.amount = amount;
        this.status = status;
        this.type = type;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", type=" + type +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
