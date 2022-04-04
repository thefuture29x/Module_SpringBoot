package com.example.module_javaspringboot_day5_02.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table(value = "product")
public class ProductDTO {
    @Id
    private int id;
    private String name;
    private String image;
    private String price;
    private int amount;
    private int status;
    private int type;
    @Column(value = "createTime")
    private LocalDate createTime;
    @Column(value = "createBy")
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

    public ProductDTO(int id, String name, String image, String price, int amount, int status, int type, LocalDate createTime, String createBy) {
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

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
